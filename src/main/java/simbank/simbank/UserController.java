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
    public List<Client> getAllClients() {
        return userService.getAllClients();
    }

    // Get user by id
    @GetMapping("/clients/{id}")
    public Client getClientById(@PathVariable Long id) {
        return userService.getClientById(id);
    }
  
    @GetMapping("/employees")
    public List<Client> getAllEmployees() {
        return userService.getAllEmployees();
    }

    // Get user by id
    @GetMapping("/employees/{id}")
    public Client getEmployeeById(@PathVariable Long id) {
        return userService.getEmployeeById(id);
    }
  
    @PostMapping("/login")
    public Object login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        return userService.login(username, password);
    }
    
}
class LoginRequest {
    private String username;
    private String password;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

}