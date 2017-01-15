package net.fazlamesai.posts.api.resources;

import net.fazlamesai.posts.api.PostsApiConfiguration;
import net.fazlamesai.posts.api.dto.Post;
import net.fazlamesai.posts.api.repositories.PostsRepository;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Path("/posts")
@Produces(MediaType.APPLICATION_JSON)
public class PostsResource {

    private final PostsRepository postsRepository;
    private final PostsApiConfiguration configuration;

    public PostsResource(final PostsRepository postsRepository, final PostsApiConfiguration configuration) {
        this.postsRepository = postsRepository;
        this.configuration = configuration;
    }

    @GET
    @Path("/{id}")
    public Optional<Post> getPost(@Nonnull @PathParam("id") final UUID id) {
        return postsRepository.getPost(id);
    }

    @GET
    public List<Post> getPosts() {
        return postsRepository.getPosts(configuration.getMaxPostsLimit());
    }

    @POST
    public Post createPost(@Valid final Post post) {
        final Post storedPost = Post.copyOf(post)
                                    .withId(UUID.randomUUID())
                                    .withCreatedDate(LocalDateTime.now())
                                    .withPublishedDate(Optional.empty());
        return postsRepository.createPost(storedPost);
    }

}
