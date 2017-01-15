package net.fazlamesai.posts.api.repositories;

import net.fazlamesai.posts.api.dto.Post;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static java.util.stream.Collectors.toList;

public class PostsRepository {

    private static final ConcurrentMap<UUID, Post> posts = new ConcurrentHashMap<>();

    public Optional<Post> getPost(final UUID id) {
        return Optional.ofNullable(posts.get(id));
    }

    public List<Post> getPosts(final int limit) {
        return posts.values().stream().sorted(Comparator.comparing(Post::getCreatedDate)).limit(limit).collect(toList());
    }

    public Post createPost(final Post post) {
        return posts.putIfAbsent(post.getId(), post);
    }
}
