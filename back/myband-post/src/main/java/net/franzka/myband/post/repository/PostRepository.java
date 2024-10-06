package net.franzka.myband.post.repository;

import net.franzka.myband.post.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByProfileId(String profileId);
}
