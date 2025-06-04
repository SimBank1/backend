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
        List<Client> users = userService.getAllClients();
        //userService.createUser();

        // Check if users are present and print their details
        if (!users.isEmpty()) {
            System.out.println("All users in the database:");
            for (Client user : users) {
                System.out.println("ID: " + user.getId() + ", Name: " + user.getFirstName() + ", Email: " + user.getEmail());
            }
        } else {
            System.out.println("No users found in the database.");
        }
        Address a = new Address();
        a.setApartment("a");
        a.setCountry("slov");
        System.out.println("a"+a.toJson());

    
    }
}
