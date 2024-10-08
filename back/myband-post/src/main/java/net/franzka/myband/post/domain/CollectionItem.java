package net.franzka.myband.post.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CollectionItem {
    private LocalDateTime created;
    private LocalDateTime updated;
}
