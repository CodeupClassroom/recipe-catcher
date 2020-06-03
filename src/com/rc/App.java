package com.rc;

import com.rc.users.Guest;
import com.rc.users.Registered;
import com.rc.users.User;
import com.rc.util.Input;

public class App {
    public static void main(String[] args) {
        User fer = new Registered("Fernando", "Mendoza", "fer@mail.com", "fer", "pass");

        Input input = new Input();

        System.out.println("Welcome to Recipe Catcher");
        //Register or Login or Proceed as guest
        System.out.println("How do you want to proceed?\n" +
                "1 - Register as a new user\n" +
                "2 - Login\n" +
                "3 - Proceed as Guest");
        int userStatus = input.getInt(1, 3);
        User currentUser = null;
        switch (userStatus)  {
            case 1:
                System.out.println("Register as a new user.");
                String firstName = input.getString("First Name: ");
                String lastName = input.getString("Last Name: ");
                String email = input.getString("Email: ");
                String username = input.getString("Username: ");
                String password = input.getString("Password: ");
                currentUser = new Registered(firstName, lastName, email, username, password);
                break;
            case 2:
                System.out.println("Login system is not implemented yet.");
                break;
            case 3:
                System.out.println("Proceeding as guest.");
                currentUser = new Guest(input.getString("First Name: "), input.getString("Last Name: "), input.getString("Email: "));
                break;
        }

        System.out.println("currentUser = " + currentUser);
    }
}
