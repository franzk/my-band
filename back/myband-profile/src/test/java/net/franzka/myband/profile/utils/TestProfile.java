package net.franzka.myband.profile.utils;

import net.bytebuddy.utility.RandomString;
import net.franzka.myband.profile.domain.Profile;

import java.util.List;

public class TestProfile {

    public static Profile create() {
        Profile profile = new Profile();
        profile.setUsername(RandomString.make(64));
        profile.setTitle(RandomString.make(64));
        profile.setSlogan(RandomString.make(64));
        profile.setBio(RandomString.make(64));
        profile.setAvatarUrl(RandomString.make(64));
        profile.setCoverImageUrl(RandomString.make(64));
        profile.setTags(List.of(RandomString.make(64), RandomString.make(64)));
        profile.setYoutubeId(RandomString.make(64));
        return profile;
    }
}
