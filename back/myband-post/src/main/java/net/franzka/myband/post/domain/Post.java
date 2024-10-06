package net.franzka.myband.post.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.franzka.myband.post.domain.media.Image;
import net.franzka.myband.post.domain.media.Video;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode(callSuper=false)
@Document(collection = "posts")
public class Post extends CollectionItem {

    @Id
    private String id;

    private String profileId;

    private String content;

    private Image image;
    private Video video;

    Integer commentsCount;

}
