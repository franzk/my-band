package net.franzka.myband.profile.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CollectionItem {
    private LocalDateTime created;
    private LocalDateTime updated;
}
