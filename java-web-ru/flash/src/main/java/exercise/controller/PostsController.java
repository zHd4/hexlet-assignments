package exercise.controller;

import java.util.Collections;
import java.util.List;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.posts.BuildPostPage;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    public static void build(Context ctx) {
        var page = new BuildPostPage();
        ctx.render("posts/build.jte", Collections.singletonMap("page", page));
    }

    // BEGIN
    public static void index(Context ctx) {
        List<Post> posts = PostRepository.getEntities();
        String message = ctx.consumeSessionAttribute("flash");

        PostsPage page = new PostsPage(posts);
        page.setFlash(message);

        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        try {
            String name = ctx.formParamAsClass("name", String.class)
                    .check(value -> value.length() >= 2, "Название должно быть не короче двух символов")
                    .get();

            String body = ctx.formParam("body");
            Post newPost = new Post(name, body);

            PostRepository.save(newPost);

            ctx.sessionAttribute("flash", "Пост был успешно создан!");
            ctx.redirect(NamedRoutes.postsPath());
        } catch (ValidationException e) {
            String name = ctx.formParam("name");
            String body = ctx.formParam("body");

            BuildPostPage page = new BuildPostPage(name, body, e.getErrors());
            ctx.render(NamedRoutes.buildPostPath(), Collections.singletonMap("page", page));
        }
    }
    // END

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("Post not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
}
