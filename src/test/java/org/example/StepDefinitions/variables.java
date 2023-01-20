package org.example.StepDefinitions;

public class variables {
    public variables() {
    }

    boolean status = true;

    private String email = configuration.get("email");



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    protected static String recoveryMessage = "Email with instructions has been sent to you.";
    private  String actualResult = null;

    public  String getRecoveryMessage() {
        return recoveryMessage;
    }

    public void setActualResult(String actualResult) {
        this.actualResult = actualResult;
    }

    public String getActualResult() {
        return actualResult;
    }
}
