package net.franz.myband.profile.service;

import net.bytebuddy.utility.RandomString;
import net.franz.myband.profile.domain.Event;
import net.franz.myband.profile.exception.EventNotFoundException;
import net.franz.myband.profile.repository.EventRepository;
import net.franz.myband.profile.service.impl.EventServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EventServiceImplTest {

    @InjectMocks
    private EventServiceImpl serviceUnderTest;

    @Mock
    private EventRepository eventRepository;

    @Test
    void createEventTest() {
        // Arrange
        Event event = new Event();
        // Act
        serviceUnderTest.createEvent(event);
        // Assert
        verify(eventRepository).save(event);
    }

    @Test
    void getEventByIdTest() throws EventNotFoundException {
        // Arrange
        String id = RandomString.make(64);
        when(eventRepository.findById(id)).thenReturn(java.util.Optional.of(new Event()));
        // Act
        serviceUnderTest.getEventById(id);
        // Assert
        verify(eventRepository).findById(id);
    }

    @Test
    void getEventByIdWithExceptionTest() {
        // Arrange
        String id = RandomString.make(64);
        // Act + Assert
        assertThrows(EventNotFoundException.class, () ->  serviceUnderTest.getEventById(id));
    }

    @Test
    void getEventsByProfileIdTest() {
        // Arrange
        String profileId = RandomString.make(64);
        // Act
        serviceUnderTest.getEventsByProfileId(profileId);
        // Assert
        verify(eventRepository).findByProfileId(profileId);
    }

    @Test
    void updateEventTest() throws EventNotFoundException {
        // Arrange
        Event event = new Event();
        when(eventRepository.existsById(event.getId())).thenReturn(true);

        // Act
        serviceUnderTest.updateEvent(event);

        // Assert
        verify(eventRepository).save(event);
    }

    @Test
    void updateEventWithExceptionTest() {
        // Arrange
        Event event = new Event();
        // Act + Assert
        assertThrows(EventNotFoundException.class, () ->  serviceUnderTest.updateEvent(event));
    }

    @Test
    void deleteEventTest() {
        // Arrange
        String id = RandomString.make(64);
        // Act
        serviceUnderTest.deleteEvent(id);
        // Assert
        verify(eventRepository).deleteById(id);
    }

}
