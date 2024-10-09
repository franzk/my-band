package net.franzka.myband.post.utils;

import net.bytebuddy.utility.RandomString;
import net.franzka.myband.post.domain.Post;
import net.franzka.myband.post.domain.media.Image;
import net.franzka.myband.post.domain.media.Video;

import java.util.Random;

public class TestPost {
    public static Post create() {
        Post post = new Post();
        post.setId(RandomString.make(64));
        post.setProfileId(RandomString.make(64));
        post.setTitle(RandomString.make(64));
        post.setContent(RandomString.make(64));

        Image image = new Image();
        image.setUrl(RandomString.make(64));
        post.setImage(image);

        Video video = new Video();
        video.setYoutubeId(RandomString.make(64));
        post.setVideo(video);

        return post;
    }
}
