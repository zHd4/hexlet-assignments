package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    // BEGIN
    public static String postsPath() {
        return "/posts";
    }

    public static String postsPath(int pageNumber) {
        return postsPath(String.valueOf(pageNumber));
    }

    public static String postsPath(String pageNumber) {
        return "/posts?page=" + pageNumber;
    }

    public static String postPath() {
        return "/posts/{id}";
    }

    public static String postPath(long id) {
        return postPath(String.valueOf(id));
    }

    public static String postPath(String id) {
        return "/posts/" + id;
    }
    // END
}
