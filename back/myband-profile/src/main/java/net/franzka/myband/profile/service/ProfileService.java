package net.franzka.myband.profile.service;

import net.franzka.myband.profile.domain.Profile;
import net.franzka.myband.profile.exception.ProfileNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfileService {

    // crud operations
    Profile createProfile(Profile profile);
    List<Profile> findAll();
    Profile getProfileByUsername(String username) throws ProfileNotFoundException;
    Profile updateProfile(Profile profile) throws ProfileNotFoundException;
    void deleteProfile(String profileId);
}
