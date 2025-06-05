package simbank.simbank;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
public class SessionController {

    // Create a session and store an attribute
    /*@GetMapping("/create")
    public String createSession(HttpSession session) {
        // Set a session attribute (e.g., username)
        session.setAttribute("username", "admin");

        // Retrieve and return the session ID
        String sessionId = session.getId();
        return "Session created with ID: " + sessionId;
    }*/

    private UserService userService;

    public String getSessionNoBS(HttpSession session) {
        // Get the session attribute (username)
        String username = (String) session.getAttribute("username");

        // If no session exists, return an error message
        if (username == null) {
            return "404";
        }

        // Return session data to the client
        return username;
    }

    // Invalidate the sessiongit add .GetExchange
    @GetMapping("/logout")
    public String invalidateSession(HttpSession session) {
        // Invalidate the session
        session.invalidate();
        return "Session invalidated!";
    }

    @PostMapping("/login")
    public Object login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        return userService.login(username, password);
    }
}


