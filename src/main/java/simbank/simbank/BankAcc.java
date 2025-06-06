package simbank.simbank;

import java.time.LocalDate;

public class BankAcc {
    private long id;
    private String first_name;
    private String personal_code;
    private long iban;
    private String currency;
    private long balance;
    private String type;
    private String plan;
    private LocalDate opening_date;

    // Getter and Setter for id
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    // Getter and Setter for firstName
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String firstName) {
        this.first_name = firstName;
    }

    // Getter and Setter for personalCode
    public String get_personal_code() {
        return personal_code;
    }
    public void setPersonal_code(String personalCode) {
        this.personal_code = personalCode;
    }

    // Getter and Setter for iban
    public long getIban() {
        return iban;
    }
    public void setIban(long iban) {
        this.iban = iban;
    }

    // Getter and Setter for currency
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    // Getter and Setter for balance
    public long getBalance() {
        return balance;
    }
    public void setBalance(long balance) {
        this.balance = balance;
    }

    // Getter and Setter for type
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    // Getter and Setter for plan
    public String getPlan() {
        return plan;
    }
    public void setPlan(String plan) {
        this.plan = plan;
    }

    // Getter and Setter for openingDate
    public LocalDate getOpeningDate() {
        return opening_date;
    }
    public void setOpening_date(LocalDate openingDate) {
        this.opening_date = openingDate;
    }
    public String toJSON(){
        return "{\"first_name\":\""+first_name+"\", \"personal_code\":\""+personal_code+"\", \"iban\":\""+iban+"\", \"currency\":\""+currency+"\", \"balance\":\""+balance+"\", \"type\":\""+type+"\", \"plan\":\""+plan+"\", \"opening_date\":\""+opening_date+"\"}";
    }
}
