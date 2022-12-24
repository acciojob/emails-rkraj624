package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        if(this.password.equals(oldPassword)) {
            if(meetCondition(newPassword)) this.password = newPassword;
        }
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
    }

    boolean meetCondition(String s) {
        boolean condition1=false,condition2=false,condition3=false,condition4=false,condition5=false;
        if(s.length()>=8) condition1 = true;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            condition2 |= isUpperCase(ch);
            condition3 |= isLoweCase(ch);
            condition4 |= isDigit(ch);
            condition5 |= (!isUpperCase(ch) && !isLoweCase(ch) && !isDigit(ch));
        }
        return condition1 && condition2 && condition3 && condition4 && condition5;
    }

    boolean isUpperCase(char ch){
        return ch>='A' && ch<='Z';
    }

    boolean isLoweCase(char ch) {
        return ch>='a' && ch<='z';
    }

    boolean isDigit(char ch) {
        return ch>='0' && ch<='9';
    }
}
