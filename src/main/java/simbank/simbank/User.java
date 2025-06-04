package simbank.simbank;

import java.time.LocalDate;

public class User {

    private long id;
    private String firstName;
    private String email;
    private String lastName;
    private long personalCode;

    private long iban;
    private String currency;
    private long balance;
    private String type;
    private String plan;
    private LocalDate openingDate;
    private String docType;
    private long docNumber;
    private LocalDate docExpiryDate;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private Address regAddress;
    private Address corAddress;
    private boolean marketingConsent;
    private long[] bankAccs;
    private String username;
    private String password;

    // Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(long personalCode) {
        this.personalCode = personalCode;
    }

    public long getIban() {
        return iban;
    }

    public void setIban(long iban) {
        this.iban = iban;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public long getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(long docNumber) {
        this.docNumber = docNumber;
    }

    public LocalDate getDocExpiryDate() {
        return docExpiryDate;
    }

    public void setDocExpiryDate(LocalDate docExpiryDate) {
        this.docExpiryDate = docExpiryDate;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getRegAddress() {
        return regAddress;
    }

    public void setRegAddress(Address regAddress) {
        this.regAddress = regAddress;
    }

    public Address getCorAddress() {
        return corAddress;
    }

    public void setCorAddress(Address corAddress) {
        this.corAddress = corAddress;
    }

    public boolean isMarketingConsent() {
        return marketingConsent;
    }

    public void setMarketingConsent(boolean marketingConsent) {
        this.marketingConsent = marketingConsent;
    }

    public long[] getBankAccs() {
        return bankAccs;
    }

    public void setBankAccs(long[] bankAccs) {
        this.bankAccs = bankAccs;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
