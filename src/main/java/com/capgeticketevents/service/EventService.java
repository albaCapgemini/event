package com.capgeticketevents.service;

import com.capgeticketevents.model.Event;
import com.capgeticketevents.response.EventResponse;
import java.util.List;
import java.util.Optional;

public interface EventService {

    EventResponse addEvent(Event event);

    List<EventResponse> listEvent();

    Optional<EventResponse> getById(Long id);

    boolean deleteEvent(Long id);

    EventResponse modifyEvent(Event event);
}
