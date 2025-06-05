package simbank.simbank;

import java.time.LocalDate;

public class BankAcc {
    private long id;
    private String firstName;
    private long personalCode;
    private long iban;
    private String currency;
    private long balance;
    private String type;
    private String plan;
    private LocalDate openingDate;

    // Getter and Setter for id
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    // Getter and Setter for firstName
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and Setter for personalCode
    public long getPersonalCode() {
        return personalCode;
    }
    public void setPersonalCode(long personalCode) {
        this.personalCode = personalCode;
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
        return openingDate;
    }
    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }
}
