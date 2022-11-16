package ro.myClass.views;

import ro.myClass.controllers.ControllerUser;

import ro.myClass.user.User;

import java.util.Scanner;

public class ViewLogin {

    private ControllerUser controllerUser;

    public Scanner scanner;

    public ViewLogin() {
        this.controllerUser = new ControllerUser();
        this.scanner = new Scanner(System.in);
    }

    public void show(){
        System.out.println("Press 1 to register");
        System.out.println("Press 2 to login");
    }
    public void play(){
        boolean running = true;
        while (running){
            this.show();
            int choice = Integer.parseInt(scanner.nextLine());
            switch(choice){
                case 1: register();
                break;
                case 2 : login();
                break;
            }
        }
    }
    public void register() {
        System.out.println("Input first name:");
        String fName = scanner.nextLine();
        System.out.println("Input last name:");
        String lName = scanner.nextLine();
        System.out.println("Input age:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Input email:");
        String email = scanner.nextLine();
        System.out.println("Input password");
        String password = scanner.nextLine();
        User user = new User(fName, lName, age, email, password);

        if (controllerUser.verifyEmail(fName, lName, email) == false) {
            this.controllerUser.add(user);
        }else{
            System.out.println("This mail is used");
        }
    }
    public void login(){
        System.out.println("Input email");
        String email = scanner.nextLine();
        System.out.println("Input password");
        String pass = scanner.nextLine();
        if(controllerUser.loginUser(email,pass)){
           ViewUser viewUser = new ViewUser(controllerUser.returnUserbyEmail(email));
           viewUser.play();
        }else{
            System.out.println("Wrong email or password");
        }

    }
}
