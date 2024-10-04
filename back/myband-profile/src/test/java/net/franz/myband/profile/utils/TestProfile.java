package net.franz.myband.profile.utils;

import net.bytebuddy.utility.RandomString;
import net.franz.myband.profile.domain.Profile;
import net.franz.myband.profile.domain.media.Video;

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
        Video video = new Video();
        video.setYoutubeId(RandomString.make(64));
        profile.setVideo(video);
        return profile;
    }
}
