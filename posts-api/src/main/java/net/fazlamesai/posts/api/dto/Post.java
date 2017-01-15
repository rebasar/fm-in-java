package net.fazlamesai.posts.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value.Immutable;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Immutable
@JsonDeserialize(as = ImmutablePost.class)
public interface Post {
    UUID getId();
    LocalDateTime getCreatedDate();
    Optional<LocalDateTime> getPublishedDate();
    String getTitle();
    String getBody();

    static ImmutablePost.Builder builder(){
        return ImmutablePost.builder();
    }

    static ImmutablePost copyOf(Post post){
        return ImmutablePost.copyOf(post);
    }
}
