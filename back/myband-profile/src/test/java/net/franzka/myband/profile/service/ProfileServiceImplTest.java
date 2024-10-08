package net.franzka.myband.profile.service;

import net.bytebuddy.utility.RandomString;
import net.franzka.myband.profile.domain.Profile;
import net.franzka.myband.profile.exception.ProfileNotFoundException;
import net.franzka.myband.profile.repository.ProfileRepository;
import net.franzka.myband.profile.service.impl.ProfileServiceImpl;
import net.franzka.myband.profile.utils.TestProfile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProfileServiceImplTest {

    @InjectMocks
    private ProfileServiceImpl serviceUnderTest;

    @Mock
    private ProfileRepository profileRepository;

    @Test
    void createProfileTest() {
        // Act
        Profile profile = TestProfile.create();
        // Arrange
        serviceUnderTest.createProfile(profile);
        // Assert
        verify(profileRepository).save(profile);
    }

    @Test
    void getProfileByUsernameTest() throws ProfileNotFoundException {
        // Act
        String username = RandomString.make(64);
        when(profileRepository.findByUsername(username)).thenReturn(java.util.Optional.of(TestProfile.create()));
        // Arrange
        serviceUnderTest.getProfileByUsername(username);
        // Assert
        verify(profileRepository).findByUsername(username);
    }

    @Test
    void getProfileByUsernameWithExceptionTest() {
        // Act
        String username = RandomString.make(64);
        // Arrange + Assert
        assertThrows(ProfileNotFoundException.class, () ->  serviceUnderTest.getProfileByUsername(username));
    }

    @Test
    void updateProfileTest() throws ProfileNotFoundException {
        // Act
        Profile profile = TestProfile.create();
        when(profileRepository.existsById(profile.getId())).thenReturn(true);
        // Arrange
        serviceUnderTest.updateProfile(profile);
        // Assert
        verify(profileRepository).save(profile);
    }

    @Test
    void updateProfileWithExceptionTest() {
        // Act
        Profile profile = TestProfile.create();
        when(profileRepository.existsById(profile.getId())).thenReturn(false);
        // Arrange + Assert
        assertThrows(ProfileNotFoundException.class, () -> serviceUnderTest.updateProfile(profile));
    }

    @Test
    void deleteProfileTest() {
        // Act
        String profileId = RandomString.make(64);
        // Arrange
        serviceUnderTest.deleteProfile(profileId);
        // Assert
        verify(profileRepository).deleteById(profileId);
    }

}
