package simbank.simbank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // Get all users
    @GetMapping("/clients")
    public List<User> getAllClients() {
        return userService.getAllClients();
    }

    // Get user by id
    @GetMapping("/clients/{id}")
    public User getClientById(@PathVariable Long id) {
        return userService.getClientById(id);
    }

    // Create a new user
    @PostMapping
    public void createUser(@RequestBody User user) {
        //userService.createUser(user);
    }
    @GetMapping("/employees")
    public List<User> getAllEmployees() {
        return userService.getAllEmployees();
    }

    // Get user by id
    @GetMapping("/employees/{id}")
    public User getEmployeeById(@PathVariable Long id) {
        return userService.getEmployeeById(id);
    }
}