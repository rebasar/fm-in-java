package net.fazlamesai.posts.api;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import net.fazlamesai.posts.api.repositories.PostsRepository;
import net.fazlamesai.posts.api.resources.PostsResource;

import java.text.DateFormat;

public class PostsApi extends Application<PostsApiConfiguration> {
    @Override
    public void run(final PostsApiConfiguration configuration, final Environment environment) throws Exception {
        environment.jersey().register(new PostsResource(new PostsRepository(), configuration));
        environment.getObjectMapper().setDateFormat(DateFormat.getDateInstance());
    }

    public static void main(final String[] args) throws Exception {
        new PostsApi().run(args);
    }
}
