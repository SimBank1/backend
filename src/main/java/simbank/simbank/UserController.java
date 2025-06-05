package simbank.simbank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;


@RestController
public class UserController {

    @Autowired
    private UserService userService;
    private SessionController ctrl = new SessionController();
    // Get all users
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return userService.getAllClients();
    }

    @GetMapping("/rand")
    public EmployeesAndClientsResponse getAll() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(true); // true to create if not exist
        EmployeesAndClientsResponse resp = new EmployeesAndClientsResponse();
        if(ctrl.getSessionNoBS(session).equals("admin")){
            resp.setEmployees(getAllEmployees());
        }
        if(!ctrl.getSessionNoBS(session).equals("404")){
            resp.setClients(getAllClients());
        }
        return resp;
    }
    

    // Get user by id
    @GetMapping("/clients/{id}")
    public Client getClientById(@PathVariable Long id) {
        return userService.getClientById(id);
    }
  
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return userService.getAllEmployees();
    }

    // Get user by id
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return userService.getEmployeeById(id);
    }
    /*
    @PostMapping("/login")
    public Object login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        return userService.login(username, password);
    }*/
    
}
class LoginRequest {
    private String username;
    private String password;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

}

class EmployeesAndClientsResponse {
    private List<Employee> employees;
    private List<Client> clients;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
