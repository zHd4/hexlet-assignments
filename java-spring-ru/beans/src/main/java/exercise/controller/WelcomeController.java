package exercise.controller;

import exercise.daytime.Day;
import exercise.daytime.Daytime;
import exercise.daytime.Night;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

// BEGIN
@RestController
public class WelcomeController {
    @GetMapping("/welcome")
    public String index() {
        int hour = LocalDateTime.now().getHour();
        Daytime daytime = hour >= 6 && hour < 22 ? new Day() : new Night();

        return "It is " + daytime.getName() + " now! Welcome to Spring!";
    }
}
// END
