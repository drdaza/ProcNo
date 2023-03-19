package com.procno.project_procno.user.domain.payloads;

public class RegisterPayload {

    private String usernameAndPass;
    private String emailAndPass;
    
    public RegisterPayload() {
    }

    public RegisterPayload(String usernameAndPass, String emailAndPass) {
        this.usernameAndPass = usernameAndPass;
        this.emailAndPass = emailAndPass;
    }

    public String getUsernameAndPass() {
        return usernameAndPass;
    }

    public void setUsernameAndPass(String usernameAndPass) {
        this.usernameAndPass = usernameAndPass;
    }

    public String getEmailAndPass() {
        return emailAndPass;
    }

    public void setEmailAndPass(String emailAndPass) {
        this.emailAndPass = emailAndPass;
    }
    
    
}
