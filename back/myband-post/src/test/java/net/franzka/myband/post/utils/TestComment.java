package net.franzka.myband.post.utils;

import net.bytebuddy.utility.RandomString;
import net.franzka.myband.post.domain.Comment;

import java.time.LocalDateTime;

public class TestComment {
    public static Comment create() {
        Comment comment = new Comment();
        comment.setId(RandomString.make(64));
        comment.setPostId(RandomString.make(64));
        comment.setUsername(RandomString.make(64));
        comment.setContent(RandomString.make(64));
        return comment;
    }
}
