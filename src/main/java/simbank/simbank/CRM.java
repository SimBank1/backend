package simbank.simbank;

import java.time.LocalDate;

public class CRM {
    private String first_name, last_name, contact_type, content;
    private long personal_code;
    private LocalDate date_of_contact;
    public CRM(String first_name, String last_name, long personal_code, LocalDate date_of_contact, String contact_type, String content){
        this.first_name = first_name;
        this.last_name = last_name;
        this.personal_code = personal_code;
        this.date_of_contact = date_of_contact;
        this.contact_type = contact_type;
        this.content = content;
    }
    public String getFirst_name() {
        return first_name;
    }
    
    public String getLast_name() {
        return last_name;
    }
    
    public String getContact_type() {
        return contact_type;
    }
    
    public String getContent() {
        return content;
    }
    
    public long getPersonal_code() {
        return personal_code;
    }
    
    public LocalDate getDate_of_contact() {
        return date_of_contact;
    }
    public String toJSON(){
        return "{\"first_name\":\""+first_name+"\", \"last_name\":\""+last_name+"\", \"personal_code\":\""+personal_code+"\", \"date_of_contact\":\""+date_of_contact+"\", \"contact_type\":\""+contact_type+"\", \"content\":\""+content+"\"}";
    }
}