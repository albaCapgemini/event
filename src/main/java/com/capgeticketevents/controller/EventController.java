package com.capgeticketevents.controller;

import com.capgeticketevents.converter.EventConverter;
import com.capgeticketevents.errorcontrol.NullRequest;
import com.capgeticketevents.model.Event;
import com.capgeticketevents.response.EventResponse;
import com.capgeticketevents.service.EventService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService service;

    @Autowired
    private EventConverter converter;

    @PostMapping
    public ResponseEntity<EventResponse> addEvent(@Valid @RequestBody Event event) {
        return ResponseEntity.ok(service.addEvent(event));
    }

    @GetMapping
    public ResponseEntity<List<EventResponse>> listEvent() {
        List<EventResponse> event = service.listEvent();
        if (event == null || event.isEmpty()) {
            throw new NullRequest();
        }
        return ResponseEntity.ok(event);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventResponse> getById(@PathVariable("eventId") String id) {
        var response = service.getById(Long.valueOf(id));
        return response.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping({"/{eventId}"})
    public ResponseEntity<String> deleteEvent(@PathVariable("eventId") String id) {
        var response = service.deleteEvent(Long.valueOf(id));
        return response ? ResponseEntity.ok("Se ha eliminado correctamente") : ResponseEntity.badRequest().build();
    }
}
