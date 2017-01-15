package net.fazlamesai.posts.api;

import io.dropwizard.Configuration;

public class PostsApiConfiguration extends Configuration {
    private int maxPostsLimit = 25;

    public int getMaxPostsLimit() {
        return maxPostsLimit;
    }

    public void setMaxPostsLimit(final int maxPostsLimit) {
        this.maxPostsLimit = maxPostsLimit;
    }
}
