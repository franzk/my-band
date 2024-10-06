package net.franzka.myband.post.utils;

import net.bytebuddy.utility.RandomString;
import net.franzka.myband.post.domain.Post;

import java.util.Random;

public class TestPost {
    public static Post create() {
        Post post = new Post();
        post.setId(RandomString.make(64));
        post.setContent(RandomString.make(64));
        post.setCommentsCount(new Random().nextInt(100));
        return post;
    }
}
