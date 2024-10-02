package net.franz.myband.profile.controller;

import net.bytebuddy.utility.RandomString;
import net.franz.myband.profile.domain.Profile;
import net.franz.myband.profile.exception.ProfileNotFoundException;
import net.franz.myband.profile.service.ProfileService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProfileControllerTest {

    @InjectMocks
    ProfileController controllerUnderTest;

    @Mock
    ProfileService profileService;

    @Test
    void getProfileTest() throws ProfileNotFoundException {
        // Arrange
        String testUsername = RandomString.make(64);
        when(profileService.getProfileByUsername(testUsername)).thenReturn(new Profile());

        // Act
        ResponseEntity<Profile> result = controllerUnderTest.getProfile(testUsername);

        // Assert
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(profileService).getProfileByUsername(testUsername);
    }

    @Test
    void createProfileTest() {
        // Arrange
        Profile testProfile = new Profile();
        when(profileService.createProfile(testProfile)).thenReturn(testProfile);

        // Act
        ResponseEntity<Profile> result = controllerUnderTest.createProfile(testProfile);

        // Assert
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        verify(profileService).createProfile(testProfile);
    }

}
