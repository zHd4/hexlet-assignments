package exercise.controller;

import exercise.model.User;
import exercise.repository.UserRepository;
import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;

import java.util.Collections;
import java.util.Optional;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) {
        String firstName = ctx.formParam("firstName");
        String lastName = ctx.formParam("lastName");

        String email = ctx.formParam("email");
        String password = ctx.formParam("password");

        String token = Security.generateToken();

        User user = new User(firstName, lastName, email, password, token);
        UserRepository.save(user);

        ctx.cookie("token", token);
        ctx.redirect(NamedRoutes.userPath(user.getId()));
    }

    public static void show(Context ctx) {
        long id = ctx.pathParamAsClass("id", Long.class).get();
        String token = ctx.cookie("token");

        Optional<User> optionalUser = UserRepository.find(id);

        if (token == null ||
                optionalUser.isEmpty() ||
                !optionalUser.get().getToken().equals(token)) {
            ctx.redirect(NamedRoutes.buildUserPath());
        } else {
            User user = optionalUser.get();
            ctx.render("users/show.jte", Collections.singletonMap("user", user));
        }
    }
    // END
}
