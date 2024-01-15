package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            int page = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
            int per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);

            List<List<Map<String, String>>> pages = new ArrayList<>();
            List<Map<String, String>> currentPage = new ArrayList<>();

            for (int i = 0; i < USERS.size(); i++) {
                Map<String, String> user = USERS.get(i);
                currentPage.add(user);

                if (currentPage.size() == per || i == USERS.size() - 1) {
                    pages.add(new ArrayList<>(currentPage));
                    currentPage = new ArrayList<>();
                }
            }

            ctx.json(pages.get(page - 1));
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
