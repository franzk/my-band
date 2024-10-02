package net.franz.myband.profile.service.impl;

import lombok.AllArgsConstructor;
import net.franz.myband.profile.domain.Profile;
import net.franz.myband.profile.exception.ProfileNotFoundException;
import net.franz.myband.profile.repository.ProfileRepository;
import net.franz.myband.profile.service.ProfileService;
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

    public Profile updateProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public void deleteProfile(String profileId) {
        profileRepository.deleteById(profileId);
    }
}
