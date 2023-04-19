package com.capgeticketevents.service;

import com.capgeticketevents.converter.EventConverter;
import com.capgeticketevents.errorcontrol.NullRequest;
import com.capgeticketevents.model.Event;
import com.capgeticketevents.repository.EventRepository;
import com.capgeticketevents.response.EventResponse;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventConverter converter;

    /**
     * Metodo que usa EventRepository save para sumar el objeto Event a la base de datos
     */
    @Override
    public EventResponse addEvent(Event event) {
        return converter.of(eventRepository.save(event));
    }

    @Override
    public List<EventResponse> listEvent() {

        if (eventRepository.findAll().isEmpty()) {
            throw new NullRequest();
        }
        return converter.of(eventRepository.findAll());
    }

    @Override
    public Optional<EventResponse> getById(Long id) {
        return eventRepository.findById(id)
                .map(event -> converter.of(event));
    }

    @Override
    public boolean deleteEvent(Long id) {
        if (id == null) {
            return false;
        }
        eventRepository.deleteById(id);
        return true;
    }

    @Override
    public EventResponse modifyEvent(Event event) {
        return eventRepository.existsById(event.getId()) ? converter.of(eventRepository.save(event)) : null;
    }
}
