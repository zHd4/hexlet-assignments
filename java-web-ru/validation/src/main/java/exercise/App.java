package exercise;

import io.javalin.Javalin;
import io.javalin.validation.ValidationException;
import java.util.List;
import exercise.model.Article;
import exercise.dto.articles.ArticlesPage;
import exercise.dto.articles.BuildArticlePage;
import java.util.Collections;

import exercise.repository.ArticleRepository;
import io.javalin.validation.Validator;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/articles", ctx -> {
            List<Article> articles = ArticleRepository.getEntities();
            var page = new ArticlesPage(articles);
            ctx.render("articles/index.jte", Collections.singletonMap("page", page));
        });

        // BEGIN
        app.get("/articles/build", ctx -> {
            ctx.render("articles/build.jte", Collections.singletonMap("page", new BuildArticlePage()));
        });

        app.post("/articles", ctx -> {
            Validator<String> titleValidator = ctx.formParamAsClass("title", String.class);
            Validator<String> contentValidator = ctx.formParamAsClass("content", String.class);

            try {
                String title = titleValidator
                        .check(value -> value.length() >= 2, "Название не должно быть короче двух символов")
                        .check(value -> !ArticleRepository.existsByTitle(value), "Статья с таким названием уже существует")
                        .get();

                String content = contentValidator
                        .check(value -> value.length() >= 10, "Статья должна быть не короче 10 символов")
                        .get();

                Article article = new Article(title, content);
                ArticleRepository.save(article);

                ctx.redirect("/articles");
            } catch (ValidationException e) {
                BuildArticlePage page = new BuildArticlePage(
                        titleValidator.get(),
                        contentValidator.get(),
                        e.getErrors());

                //ctx.status(422);
                ctx.render("articles/build.jte", Collections.singletonMap("page", page));
            }
        });
        // END

//        app.post("/articles", ctx -> {
//            String title = ctx.formParam("title");
//            String content = ctx.formParam("content");
//
//            try {
//                String title = titleValidator
//                        .check(value -> value.length() >= 2, "Название не должно быть короче двух символов")
//                        .check(value -> !ArticleRepository.existsByTitle(value), "Статья с таким названием уже существует")
//                        .get();
//
//                String content = contentValidator
//                        .check(value -> value.length() >= 10, "Статья должна быть не короче 10 символов")
//                        .get();
//
//                if (title.length() < 2 || ArticleRepository.existsByTitle(title)) {
//                    throw new ValidationException("s");
//                }
//
//                Article article = new Article(title, content);
//                ArticleRepository.save(article);
//
//                ctx.redirect("/articles");
//            } catch (ValidationException e) {
//                BuildArticlePage page = new BuildArticlePage(title, content, e.getErrors());
//
//                ctx.status(422);
//                ctx.render("articles/build.jte", Collections.singletonMap("page", page));
//            }
//        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
