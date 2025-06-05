package simbank.simbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.time.LocalDate;


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
                user.setPersonalCode(rs.getString("personal_code"));
                user.setDocType(rs.getString("doc_type"));
                user.setDocNumber(rs.getString("doc_number"));
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
        String sql = "SELECT id, first_name, last_name, email, personal_code, doc_type, doc_number, doc_expiry_date, date_of_birth, phone_number, marketin_consent, reg_address, cor_address, bank_accs FROM clients WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Client>() {
            @Override
            public Client mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                Client user = new Client();
                user.setId(rs.getLong("id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setPersonalCode(rs.getString("personal_code"));
                user.setDocType(rs.getString("doc_type"));
                user.setDocNumber(rs.getString("doc_number"));
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
        }, id);
    }

    public void createUser() {
        String sql = "INSERT INTO public.employees(\n" + //
                        "\tfirst_name, last_name, email, username, password)\n" + //
                        "\tVALUES ('admin3', 'admin3', ?, ?, 'admin3');";
        jdbcTemplate.update(sql, "b", "h");
    }

    public List<Employee> getAllEmployees() {
        String sql = "SELECT id, first_name, last_name, email, username, password FROM employees";

        return jdbcTemplate.query(sql, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                Employee emp = new Employee();
                emp.setId(rs.getLong("id"));
                emp.setFirstName(rs.getString("first_name"));
                emp.setLastName(rs.getString("last_name"));
                emp.setEmail(rs.getString("email"));
                emp.setUsername(rs.getString("username"));
                emp.setPassword(rs.getString("password"));
                return emp;
            }
        });
    }
    public Employee getEmployeeById(Long id) {
        String sql = "SELECT id, first_name, last_name, email, username, password FROM employees WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                Employee emp = new Employee();
                emp.setId(rs.getLong("id"));
                emp.setFirstName(rs.getString("first_name"));
                emp.setLastName(rs.getString("last_name"));
                emp.setEmail(rs.getString("email"));
                emp.setUsername(rs.getString("username"));
                emp.setPassword(rs.getString("password"));
                return emp;
            }
        }, id);
    }

    public List<BankAcc> getAllBankAccounts() {
        String sql = "SELECT id, first_name, personal_code, iban, currency, balance, type, plan, opening_date FROM bank_accounts";
    
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            BankAcc account = new BankAcc();
            account.setId(rs.getLong("id"));
            account.setFirstName(rs.getString("first_name"));
            account.setPersonalCode(rs.getString("personal_code"));
            account.setIban(rs.getLong("iban"));
            account.setCurrency(rs.getString("currency"));
            account.setBalance(rs.getLong("balance"));
            account.setType(rs.getString("type"));
            account.setPlan(rs.getString("plan"));
    
            java.sql.Date sqlDate = rs.getDate("opening_date");
            if (sqlDate != null) {
                account.setOpeningDate(sqlDate.toLocalDate());
            }
            return account;
        });
    }

    public BankAcc getBankAccountById(long id) {
        String sql = "SELECT id, first_name, personal_code, iban, currency, balance, type, plan, opening_date FROM bank_accounts WHERE id = ?";
    
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            BankAcc account = new BankAcc();
            account.setId(rs.getLong("id"));
            account.setFirstName(rs.getString("first_name"));
            account.setPersonalCode(rs.getString("personal_code"));
            account.setIban(rs.getLong("iban"));
            account.setCurrency(rs.getString("currency"));
            account.setBalance(rs.getLong("balance"));
            account.setType(rs.getString("type"));
            account.setPlan(rs.getString("plan"));
    
            java.sql.Date sqlOpeningDate = rs.getDate("opening_date");
            if (sqlOpeningDate != null) {
                account.setOpeningDate(sqlOpeningDate.toLocalDate());
            }
            return account;
        }, id);
    }

    public Object createCRM(CRM crm){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(true); // true to create if not exist
        if(((String) session.getAttribute("username")) == null){
            return new Err("timeout", true);
        }
        String sql = "UPDATE clients\n" + //
                    "\tSET crm = crm || ?::jsonb\n" + //
                    "\tWHERE personal_code=?;";
        jdbcTemplate.update(sql, crm.toJSON(), crm.getPersonal_code());
        return crm;
    }

    public Object login(String username, String password){
        String sql = "SELECT password FROM employees WHERE username = ?";
        String corectPass = "";
        try {
            corectPass = jdbcTemplate.queryForObject(sql, new Object[]{username}, String.class);
        } catch (org.springframework.dao.EmptyResultDataAccessException e) {
            return new Err("Invalid credentials", false);
        }
        if(corectPass.equals(password)){
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true); // true to create if not exist
            String token = createSession(session, username);
            String mode = (username.equals("admin"))?"admin":"employee";
            LoginData a = new LoginData(mode);
            return a;
        }
        return new Err("Invalid credentials", false);
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
    boolean timeout;
    public Err(String error, boolean timeout){
        this.error = error;
        this.timeout = timeout;
    }
    public String getError(){
        return error;
    }
    public boolean getTimeout(){
        return timeout;
    }
}