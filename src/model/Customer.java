package model;

import java.util.regex.Pattern;

public class Customer {

    private String firstName;
    private String lastName;
    private String email;

    public Customer(String firstName, String lastName, String email) {

        this.firstName = firstName;
        this.lastName = lastName;

      //needs refinement to add illegalerrorexception
        String emailRegex = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
    
        if (!(pattern.matcher(email).matches())) {
            //illegalerrorexception here
        } else {
            this.email = email;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name:" + firstName + " " + lastName;
    }

}
