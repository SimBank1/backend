package simbank.simbank;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private final UserService userService;

    public AppRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Fetch all users from the database
        List<User> users = userService.getAllUsers();
        userService.createUser();

        // Check if users are present and print their details
        if (!users.isEmpty()) {
            System.out.println("All users in the database:");
            for (User user : users) {
                System.out.println("ID: " + user.getId() + ", Name: " + user.getName() + ", Email: " + user.getEmail());
            }
        } else {
            System.out.println("No users found in the database.");
        }
    }
}
