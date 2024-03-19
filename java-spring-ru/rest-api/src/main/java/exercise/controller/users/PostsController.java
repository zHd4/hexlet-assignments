package exercise.controller.users;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {
    private static final List<Post> POSTS = Data.getPosts();

    @GetMapping("/users/{id}/posts")
    public ResponseEntity<List<Post>> show(@PathVariable String id) {
        try {
            List<Post> userPosts = POSTS.stream()
                    .filter(post -> post.getUserId() == Integer.parseInt(id))
                    .toList();

            return ResponseEntity.ok()
                    .header("X-Total-Count", String.valueOf(userPosts.size()))
                    .body(userPosts);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/users/{id}/posts")
    public ResponseEntity<Post> create(@PathVariable String id, @RequestBody Post post) {
        try {
            post.setUserId(Integer.parseInt(id));
            POSTS.add(post);

            return ResponseEntity.created(URI.create("/api/users/" + id + "/posts")).body(post);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
// END
