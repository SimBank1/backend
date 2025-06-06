package simbank.simbank;

import java.time.LocalDate;

public class Client {

    private long id;
    private String first_name;
    private String email;
    private String last_name;
    private String personal_code;

    private String doc_type;
    private String doc_number;
    private LocalDate doc_expiry_date;
    private LocalDate date_of_birth;
    private String phone_number;
    private Address reg_address;
    private Address cor_address;
    private boolean marketing_consent;
    private long[] bank_accs;
    private String other_bank_accounts;

    // Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPersonalCode() {
        return personal_code;
    }

    public void setPersonal_code(String personal_code) {
        this.personal_code = personal_code;
    }

    public String getDocType() {
        return doc_type;
    }

    public void setDoc_type(String doc_type) {
        this.doc_type = doc_type;
    }

    public String getDocNumber() {
        return doc_number;
    }

    public void setDoc_number(String doc_number) {
        this.doc_number = doc_number;
    }

    public LocalDate getDocExpiryDate() {
        return doc_expiry_date;
    }

    public void setDoc_expiry_date(LocalDate doc_expiry_date) {
        this.doc_expiry_date = doc_expiry_date;
    }

    public LocalDate getDateOfBirth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Address getRegAddress() {
        return reg_address;
    }

    public void setReg_address(Address reg_address) {
        this.reg_address = reg_address;
    }

    public Address getCorAddress() {
        return cor_address;
    }

    public void setCor_address(Address cor_address) {
        this.cor_address = cor_address;
    }

    public boolean getMarketingConsent() {
        return marketing_consent;
    }

    public void setMarketing_consent(boolean marketing_consent) {
        this.marketing_consent = marketing_consent;
    }

    public long[] getBankAccs() {
        return bank_accs;
    }

    public void setBank_accs(long[] bank_accs) {
        this.bank_accs = bank_accs;
    }
    public String getOther_bank_accounts() {
        return other_bank_accounts;
    }

    public void setOther_bank_accounts(String other_bank_accounts) {
        this.other_bank_accounts = other_bank_accounts;
    }
    public Client(){};
    public Client(String first_name, String email, String last_name, String personal_code, String doc_type, String doc_number, LocalDate doc_expiry_date, LocalDate date_of_birth, String phone_number, Address reg_address, Address cor_address, boolean marketing_consent, long[] bank_accs) {
        this.first_name = first_name;
        this.email = email;
        this.last_name = last_name;
        this.personal_code = personal_code;
        this.doc_type = doc_type;
        this.doc_number = doc_number;
        this.doc_expiry_date = doc_expiry_date;
        this.date_of_birth = date_of_birth;
        this.phone_number = phone_number;
        this.reg_address = reg_address;
        this.cor_address = cor_address;
        this.marketing_consent = marketing_consent;
        this.bank_accs = bank_accs;
    }
}
