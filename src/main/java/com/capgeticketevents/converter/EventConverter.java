package com.capgeticketevents.converter;

import com.capgeticketevents.model.Event;
import com.capgeticketevents.response.EventResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class EventConverter {

    public EventResponse of(Event event) {
        return EventResponse.builder()
                .id(event.getId())
                .name(event.getName())
                .type(event.getType())
                .date(event.getDate())
                .time(event.getTime())
                .location(event.getLocation())
                .build();
    }

    public List<EventResponse> of(List<Event> events) {
        return events.stream()
                .map(this::of)
                .collect(Collectors.toList());
    }
}
