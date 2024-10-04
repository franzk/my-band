package net.franzka.myband.profile.controller;

import net.bytebuddy.utility.RandomString;
import net.franzka.myband.profile.domain.Event;
import net.franzka.myband.profile.exception.EventNotFoundException;
import net.franzka.myband.profile.service.EventService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EventControllerTest {

    @InjectMocks
    private EventController controllerUnderTest;

    @Mock
    private EventService eventService;

    @Test
    void createEventTest() {
        // Arrange
        Event event = new Event();
        // Act
        ResponseEntity<Event> result = controllerUnderTest.createEvent(event);
        // Assert
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(eventService).createEvent(event);
    }

    @Test
    void getEventTest() throws EventNotFoundException {
        // Arrange
        String eventId = RandomString.make(64);
        when(eventService.getEventById(eventId)).thenReturn(new Event());
        // Act
        ResponseEntity<Event> result = controllerUnderTest.getEventById(eventId);
        // Assert
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(eventService).getEventById(eventId);
    }

    @Test
    void getEvenTestWithException() throws EventNotFoundException {
        // Arrange
        String eventId = RandomString.make(64);
        when(eventService.getEventById(eventId)).thenThrow(new EventNotFoundException());
        // Act + Assert
        assertThrows(EventNotFoundException.class, () -> controllerUnderTest.getEventById(eventId));
    }

    @Test
    void getEventsByProfileIdTest() {
        // Arrange
        String profileId = RandomString.make(64);
        // Act
        ResponseEntity<List<Event>> result = controllerUnderTest.getEventsByProfileId(profileId);
        // Assert
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(eventService).getEventsByProfileId(profileId);
    }

    @Test
    void updateEventTest() throws EventNotFoundException {
        // Arrange
        Event event = new Event();
        // Act
        ResponseEntity<Event> result = controllerUnderTest.updateEvent(event);
        // Assert
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(eventService).updateEvent(event);
    }

    @Test
    void updateEventTestWithException() throws EventNotFoundException {
        // Arrange
        Event event = new Event();
        when(eventService.updateEvent(event)).thenThrow(new EventNotFoundException());
        // Act + Assert
        assertThrows(EventNotFoundException.class, () -> controllerUnderTest.updateEvent(event));
    }

    @Test
    void deleteEventTest() {
        // Arrange
        String eventId = RandomString.make(64);
        // Act
        ResponseEntity<String> result = controllerUnderTest.deleteEvent(eventId);
        // Assert
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(eventService).deleteEvent(eventId);
    }

}
