package net.franzka.myband.profile.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.franzka.myband.profile.domain.Profile;
import net.franzka.myband.profile.exception.ProfileNotFoundException;
import net.franzka.myband.profile.repository.ProfileRepository;
import net.franzka.myband.profile.utils.TestProfile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class ProfileTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ProfileRepository profileRepository;

    @BeforeEach
    void setUp() {
       profileRepository.deleteAll();
    }

    @AfterEach
    void tearDown() {
       profileRepository.deleteAll();
    }

    @Test
    void createProfileTestIT() throws Exception {
        // Arrange
        Profile testProfile = TestProfile.create();
        String testUsername = testProfile.getUsername();
        // Act
        mockMvc.perform(post("/api/v1/profile")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(testProfile)))
                .andExpect(status().isOk());
        // Assert
        Profile result = profileRepository.findByUsername(testUsername).orElseThrow(ProfileNotFoundException::new);
        assertThat(result.getUsername()).isEqualTo(testUsername);
    }

    @Test
    void createProfileTestWithExceptionIT() throws Exception {
        // Arrange
        Profile testProfile = TestProfile.create();
        // Act + Assert
        mockMvc.perform(post("/api/v1/profile")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(testProfile)))
                .andExpect(status().isOk());
        mockMvc.perform(post("/api/v1/profile")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(testProfile)))
                .andExpect(status().isConflict());
    }

    @Test
    void getProfileByUsernameTestIT() throws Exception {
        // Arrange
        Profile testProfile = TestProfile.create();
        profileRepository.save(testProfile);
        // Act
        String result = mockMvc.perform(post("/api/v1/profile")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(testProfile)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        // Assert
        Profile profile = objectMapper.readValue(result, Profile.class);
        assertThat(profile).isEqualTo(testProfile);
    }

}
