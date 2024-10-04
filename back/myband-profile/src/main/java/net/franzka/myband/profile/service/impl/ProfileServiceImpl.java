package net.franzka.myband.profile.service.impl;

import lombok.AllArgsConstructor;
import net.franzka.myband.profile.domain.Profile;
import net.franzka.myband.profile.exception.ProfileNotFoundException;
import net.franzka.myband.profile.repository.ProfileRepository;
import net.franzka.myband.profile.service.ProfileService;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Profile getProfileByUsername(String username) throws ProfileNotFoundException {
        return profileRepository.findByUsername(username).orElseThrow(ProfileNotFoundException::new);
    }

    public Profile updateProfile(Profile profile) throws ProfileNotFoundException {
        if (profileRepository.existsById(profile.getId())) {
            return profileRepository.save(profile);
        } else {
            throw new ProfileNotFoundException();
        }
    }

    public void deleteProfile(String profileId) {
        profileRepository.deleteById(profileId);
    }
}
