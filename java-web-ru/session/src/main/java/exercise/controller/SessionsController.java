package exercise.controller;

import exercise.dto.LoginPage;
import exercise.dto.MainPage;
import exercise.repository.UsersRepository;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;

import java.util.Collections;

import static exercise.util.Security.encrypt;

public class SessionsController {

    // BEGIN
    public static void index(Context ctx) {
        String username = ctx.sessionAttribute("name");
        MainPage page = new MainPage(username);

        ctx.render("index.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        LoginPage page = new LoginPage(null, null);
        ctx.render("build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        String username = ctx.formParam("name");
        String password = ctx.formParam("password");

        if (!UsersRepository.existsByName(username) ||
                !UsersRepository.findByName(username).getPassword().equals(encrypt(password))) {
            LoginPage page = new LoginPage(username, "Wrong username or password");
            ctx.render("build.jte", Collections.singletonMap("page", page));
        } else {
            ctx.sessionAttribute("name", username);
            ctx.redirect(NamedRoutes.rootPath());
        }
    }

    public static void delete(Context ctx) {
        ctx.sessionAttribute("name", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
