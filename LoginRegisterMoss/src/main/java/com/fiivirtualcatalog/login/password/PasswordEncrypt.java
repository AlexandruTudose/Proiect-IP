package com.fiivirtualcatalog.login.password;

import com.fiivirtualcatalog.login.rsa.RSA;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncrypt {

    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String encryptPassword(){
        String s;
        RSA rsa=new RSA(passwordToNumber());
        rsa.computeNumbers();
        s=rsa.criptare();
        return s;
    }

    private String passwordToNumber(){
        StringBuilder s=new StringBuilder();
        for(int i=0;i<password.length();i++)
            s=s.append((int) password.charAt(i));
        return s.toString();
    }


    public boolean compare(String sir){
        for(int i=0;i<password.length();i++){
            if(password.charAt(i)!=sir.charAt(i))
                return false;
        }
        if(password.length()<sir.length())
            return false;
        return true;
    }
}
