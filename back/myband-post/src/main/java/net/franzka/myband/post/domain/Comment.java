package net.franzka.myband.post.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper=false)
@Document(collection = "post-comments")
public class Comment extends CollectionItem {
    private String id;
    private String postId;
    private String username;
    private String content;
}
