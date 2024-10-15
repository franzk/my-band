package net.franzka.myband.profile.service.impl;

import lombok.AllArgsConstructor;
import net.franzka.myband.profile.domain.Profile;
import net.franzka.myband.profile.exception.ProfileNotFoundException;
import net.franzka.myband.profile.repository.ProfileRepository;
import net.franzka.myband.profile.service.ProfileService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public Profile createProfile(Profile profile) {
        profile.setCreated(LocalDateTime.now());
        return profileRepository.save(profile);
    }

    @Override
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    public Profile getProfileByUsername(String username) throws ProfileNotFoundException {
        return profileRepository.findByUsername(username).orElseThrow(ProfileNotFoundException::new);
    }

    public Profile updateProfile(Profile profile) throws ProfileNotFoundException {
        if (profileRepository.existsById(profile.getId())) {
            profile.setUpdated(LocalDateTime.now());
            return profileRepository.save(profile);
        } else {
            throw new ProfileNotFoundException();
        }
    }

    public void deleteProfile(String profileId) {
        profileRepository.deleteById(profileId);
    }
}
