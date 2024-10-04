package net.franzka.myband.profile.service.impl;

import lombok.AllArgsConstructor;
import net.franzka.myband.profile.domain.Event;
import net.franzka.myband.profile.exception.EventNotFoundException;
import net.franzka.myband.profile.repository.EventRepository;
import net.franzka.myband.profile.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EventServiceImpl implements EventService {
    
    private final EventRepository eventRepository;
    
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event getEventById(String id) throws EventNotFoundException {
        return eventRepository.findById(id).orElseThrow(EventNotFoundException::new);
    }

    public List<Event> getEventsByProfileId(String profileId) {
        return eventRepository.findByProfileId(profileId);
    }

    public Event updateEvent(Event event) throws EventNotFoundException {
        if (eventRepository.existsById(event.getId())) {
            return eventRepository.save(event);
        } else {
            throw new EventNotFoundException();
        }
    }

    public void deleteEvent(String id) {
        eventRepository.deleteById(id);
    }
}
