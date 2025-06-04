package simbank.simbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;


import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.jdbc.core.RowMapper;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Get all users
    public List<Client> getAllClients() {
        String sql = "SELECT id, first_name, last_name, email, personal_code, doc_type, doc_number, doc_expiry_date, date_of_birth, phone_number, marketin_consent, reg_address, cor_address, bank_accs FROM clients"; // Adjust your table name and columns
        return jdbcTemplate.query(sql, new RowMapper<Client>() {
            @Override
            public Client mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                Client user = new Client();
                user.setId(rs.getLong("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setPersonalCode(rs.getLong("personal_code"));
                user.setDocType(rs.getString("doc_type"));
                user.setDocNumber(rs.getLong("doc_number"));
                java.sql.Date sqlDocExpiryDate = rs.getDate("doc_expiry_date");
                if(sqlDocExpiryDate != null) user.setDocExpiryDate(sqlDocExpiryDate.toLocalDate());
                java.sql.Date sqlDateOfBirth = rs.getDate("date_of_birth");
                if(sqlDateOfBirth != null) user.setDateOfBirth(sqlDateOfBirth.toLocalDate());
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setMarketingConsent(rs.getBoolean("marketin_consent"));
                
                ObjectMapper objectMapper = new ObjectMapper();

                try {
                    String regAddressJson = rs.getString("reg_address");
                    if (regAddressJson != null) {
                        Address regAddress = objectMapper.readValue(regAddressJson, Address.class);
                        user.setRegAddress(regAddress);
                    }

                    String corAddressJson = rs.getString("cor_address");
                    if (corAddressJson != null) {
                        Address corAddress = objectMapper.readValue(corAddressJson, Address.class);
                        user.setCorAddress(corAddress);
                    }
                } catch (JsonProcessingException e) {
                    // Handle the exception:
                    // - log the error
                    // - optionally throw a runtime exception if you want to fail fast
                    throw new RuntimeException("Failed to parse address JSON", e);
                }
                                return user;
                            }
                        });
}

    // Get a user by id
    public Client getClientById(Long id) {
        String sql = "SELECT id, first_name, email FROM clients WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Client>() {
            @Override
            public Client mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                Client user = new Client();
                user.setId(rs.getLong("id"));
                user.setFirstName(rs.getString("first_name"));  // make sure this matches the column name
                user.setEmail(rs.getString("email"));
                return user;
            }
        }, id);
    }

    // Create a new user
    //public void createUser() {
    //    String sql = "INSERT INTO public.employees(\n" + //
    //                    "\tfirst_name, last_name, email, username, password)\n" + //
    //                    "\tVALUES ('admin3', 'admin3', ?, ?, 'admin3');";
    //    jdbcTemplate.update(sql, "b", "h");
    //}

    public List<Client> getAllEmployees() {
        String sql = "SELECT id, first_name, email FROM employees"; // Adjust your table name and columns
        return jdbcTemplate.query(sql, new RowMapper<Client>() {
            @Override
            public Client mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                Client user = new Client();
                user.setId(rs.getLong("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        });
    }
    public Client getEmployeeById(Long id) {
        String sql = "SELECT id, first_name, email FROM employees WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Client>() {
            @Override
            public Client mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                Client user = new Client();
                user.setId(rs.getLong("id"));
                user.setFirstName(rs.getString("first_name"));  // make sure this matches the column name
                user.setEmail(rs.getString("email"));
                return user;
            }
        }, id);
    }


}