package net.franz.myband.profile.service;

import net.franz.myband.profile.domain.Post;
import net.franz.myband.profile.exception.PostNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    Post createPost(Post post);

    Post getPostById(String id) throws PostNotFoundException;

    List<Post> getPostsByProfileId(String profileId);

    Post updatePost(Post post) throws PostNotFoundException;

    void deletePost(String id);

}
