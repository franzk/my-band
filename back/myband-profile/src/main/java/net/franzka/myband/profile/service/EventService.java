package net.franzka.myband.profile.service;

import net.franzka.myband.profile.domain.Event;
import net.franzka.myband.profile.exception.EventNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {

    Event createEvent(Event event);

    Event getEventById(String id) throws EventNotFoundException;

    List<Event> getEventsByProfileId(String profileId);

    Event updateEvent(Event event) throws EventNotFoundException;

    void deleteEvent(String id);

}
