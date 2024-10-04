package net.franzka.myband.profile.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.franzka.myband.profile.domain.media.Image;
import net.franzka.myband.profile.domain.media.Video;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper=false)
@Document(collection = "posts")
public class Post extends CollectionItem {

    @Id
    private String id;

    private String profileId;

    private String title;
    private String content;

    private Image image;
    private Video video;

    List<Comment> comments;

}
