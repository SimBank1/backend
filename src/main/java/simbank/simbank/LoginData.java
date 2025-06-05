package simbank.simbank;

public class LoginData{
    private String mode;
    private String token;
    public LoginData(String mode, String token){
        this.mode = mode;
        this.token = token;
    }
    public String getMode(){
        return mode;
    }
    public String getToken(){
        return token;
    }
}