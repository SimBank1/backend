package simbank.simbank;

import java.time.LocalDate;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

public class CRM {
    private String username, contact_type, content;
    private String personal_code;
    private LocalDate date_of_contact;
    public CRM(String personal_code, LocalDate date_of_contact, String contact_type, String content){
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(true); // true to create if not exist
        username = (String)session.getAttribute("username");
        this.personal_code = personal_code;
        this.date_of_contact = date_of_contact;
        this.contact_type = contact_type;
        this.content = content;
    }
    public String getContact_type() {
        return contact_type;
    }

    public String getUsername() {
        return username;
    }
    
    public String getContent() {
        return content;
    }
    
    public String getPersonal_code() {
        return personal_code;
    }
    
    public LocalDate getDate_of_contact() {
        return date_of_contact;
    }
    public String toJSON(){
        return "{\"username\":\""+username+"\", \"date_of_contact\":\""+date_of_contact+"\", \"contact_type\":\""+contact_type+"\", \"content\":\""+content+"\"}";
    }
}