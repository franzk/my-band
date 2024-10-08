package net.franzka.myband.post.service;

import net.franzka.myband.post.domain.Post;
import net.franzka.myband.post.exception.PostNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    Post createPost(Post post);

    Post getPostById(String id) throws PostNotFoundException;

    List<Post> getPostsByProfileId(String profileId);

    Post updatePost(Post post) throws PostNotFoundException;

    Post incrementCommentCount(String postId) throws PostNotFoundException;

    Post decrementCommentCount(String postId) throws PostNotFoundException;

    void deletePost(String id);

}
