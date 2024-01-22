package exercise.controller;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void index(Context ctx) {
        List<Post> posts = PostRepository.getEntities();

        int pageNumber = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        int per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);

        int offset = (pageNumber - 1) * per;

        int previousPageNumber = pageNumber - 1;
        int nextPageNumber = posts.size() - (offset + per) > per ? pageNumber + 1 : 0;

        List<Post> sliceOfPosts = posts.subList(offset, offset + per);
        PostsPage page = new PostsPage(sliceOfPosts, previousPageNumber, nextPageNumber);

        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) {
        long id = ctx.pathParamAsClass("id", Long.class).get();

        Post post = PostRepository.find(id).orElseThrow(NotFoundResponse::new);
        PostPage page = new PostPage(post);

        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
    // END
}
