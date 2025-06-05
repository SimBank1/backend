package simbank.simbank;

import java.time.LocalDate;

public class Client {

    private long id;
    private String firstName;
    private String email;
    private String lastName;
    private String personalCode;

    private String docType;
    private String docNumber;
    private LocalDate docExpiryDate;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private Address regAddress;
    private Address corAddress;
    private boolean marketingConsent;
    private long[] bankAccs;

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

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
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
    public Client(){};
    public Client(String firstName, String email, String lastName, String personalCode, String docType, String docNumber, LocalDate docExpiryDate, LocalDate dateOfBirth, String phoneNumber, Address regAddress, Address corAddress, boolean marketingConsent, long[] bankAccs) {
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
        this.personalCode = personalCode;
        this.docType = docType;
        this.docNumber = docNumber;
        this.docExpiryDate = docExpiryDate;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.regAddress = regAddress;
        this.corAddress = corAddress;
        this.marketingConsent = marketingConsent;
        this.bankAccs = bankAccs;
    }
}
