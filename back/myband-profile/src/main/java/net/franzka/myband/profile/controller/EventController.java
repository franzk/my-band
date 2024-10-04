package net.franzka.myband.profile.controller;

import lombok.AllArgsConstructor;
import net.franzka.myband.profile.domain.Event;
import net.franzka.myband.profile.exception.EventNotFoundException;
import net.franzka.myband.profile.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/events")
public class EventController {

    private final EventService eventService;

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        return ResponseEntity.ok(eventService.createEvent(event));
    }

    @GetMapping
    public ResponseEntity<Event> getEventById(@RequestParam String id) throws EventNotFoundException {
        return ResponseEntity.ok(eventService.getEventById(id));
    }

    @GetMapping("/profile")
    public ResponseEntity<List<Event>> getEventsByProfileId(@RequestParam String profileId) {
        return ResponseEntity.ok(eventService.getEventsByProfileId(profileId));
    }

    @PutMapping
    public ResponseEntity<Event> updateEvent(@RequestBody Event event) throws EventNotFoundException {
        return ResponseEntity.ok(eventService.updateEvent(event));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteEvent(@RequestParam String id) {
        eventService.deleteEvent(id);
        return ResponseEntity.ok("Event deleted");
    }

}
