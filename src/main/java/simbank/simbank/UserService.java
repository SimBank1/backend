package simbank.simbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Get all users
    public List<User> getAllClients() {
        String sql = "SELECT id, first_name, email FROM clients"; // Adjust your table name and columns
        return jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setFirstName(rs.getString("first_name"));
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
                user.setFirstName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        });
    }
    // Get a user by id
    public User getClientById(Long id) {
        String sql = "SELECT id, first_name, email FROM clients WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setFirstName(rs.getString("first_name"));  // make sure this matches the column name
                user.setEmail(rs.getString("email"));
                return user;
            }
        }, id);
    }

    // Create a new user
    public void createUser() {
        String sql = "INSERT INTO public.employees(\n" + //
                        "\tfirst_name, last_name, email, username, password)\n" + //
                        "\tVALUES ('admin3', 'admin3', ?, ?, 'admin3');";
        jdbcTemplate.update(sql, "b", "h");
    }

    public List<User> getAllEmployees() {
        String sql = "SELECT id, first_name, email FROM employees"; // Adjust your table name and columns
        return jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        });
    }
    public User getEmployeeById(Long id) {
        String sql = "SELECT id, first_name, email FROM employees WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            @Override
            public User mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setFirstName(rs.getString("first_name"));  // make sure this matches the column name
                user.setEmail(rs.getString("email"));
                return user;
            }
        }, id);
    }


}