package simbank.simbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

import org.springframework.jdbc.core.RowMapper;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Get all users
    public List<User> getAllUsers() {
        String sql = "SELECT id, first_name, email FROM employees"; // Adjust your table name and columns
        return jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("first_name"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        });
    }

    public User getFirstUser() {
        String sql = "SELECT id, first_name, email FROM employees LIMIT 1"; // Query to fetch the first user
        return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        });
    }
    // Get a user by id
    public User getUserById(Long id) {
        String sql = "SELECT id, first_name, email FROM employees WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<User>() {
            @Override
            public User mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        });
    }

    // Create a new user
    public void createUser() {
        String sql = "INSERT INTO public.employees(\n" + //
                        "\tfirst_name, last_name, email, username, password)\n" + //
                        "\tVALUES ('admin3', 'admin3', ?, ?, 'admin3');";
        jdbcTemplate.update(sql, "b", "h");
    }

    public Object login(String username, String password){
        String sql = "SELECT password FROM employees WHERE username = ?";
        String corectPass = "";
        try {
            corectPass = jdbcTemplate.queryForObject(sql, new Object[]{username}, String.class);
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            return new Err("Invalid credentials");
        }
        if(corectPass.equals(password)){
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true); // true to create if not exist
            String token = createSession(session, username);
            String mode = (username.equals("admin"))?"admin":"employee";
            LoginData a = new LoginData(mode, token);
            return a;
        }
        return new Err("Invalid credentials");
    }
    public String createSession(HttpSession session, String username) {
        // Set a session attribute (e.g., username)
        session.setAttribute("username", username);

        // Retrieve and return the session ID
        String sessionId = session.getId();
        return sessionId;
    }
}
class Err{
    String error;
    public Err(String error){
        this.error = error;
    }
    public String getError(){
        return error;
    }
}