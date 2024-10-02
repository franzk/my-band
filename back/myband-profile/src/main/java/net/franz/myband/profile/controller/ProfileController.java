package net.franz.myband.profile.controller;

import lombok.AllArgsConstructor;
import net.franz.myband.profile.domain.Profile;
import net.franz.myband.profile.exception.ProfileNotFoundException;
import net.franz.myband.profile.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/profile")
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/{username}")
    public ResponseEntity<Profile> getProfile(@PathVariable String username) throws ProfileNotFoundException {
        return ResponseEntity.ok(profileService.getProfileByUsername(username));
    }

    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        return ResponseEntity.ok(profileService.createProfile(profile));
    }
}
