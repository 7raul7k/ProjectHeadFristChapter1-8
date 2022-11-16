package ro.myClass.controllers;

import ro.myClass.user.User;
import ro.myClass.user.UserData;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerUser {

    private ArrayList<User> users;




    public ControllerUser(){
        this.users = new ArrayList<>();
        this.load();
    }
    public void load(){
        try{
            File file = new File("C:\\Head-First-DP\\ProjectHeadFirstChapter1-8\\src\\ro\\myClass\\resources\\user.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                this.users.add(new User(scanner.nextLine()));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void add(User user){
        int pos = findUser(user.getFirstName(), user.getLastName());
        if(pos == -1){
            this.users.add(user);
        }
    }
    public int size(){
        return users.size();
    }
    public int findUser(String fName,String lName){
        for(int i = 0 ; i < users.size();i++){
            if(users.get(i).getFirstName().equals(fName)&&users.get(i).getLastName().equals(lName)){
                return i;
            }
        }
        return -1;
    }
    public boolean updateFirstName(String firstName,String lName,String newLName){
        int pos = findUser(firstName,lName);
        if(pos != -1 ) {
            this.users.get(pos).setFirstName(newLName);
            return true;
        }
        return false;
    }
    public boolean updatePassword(String firstName,String lName,String newPassword){
        int pos = findUser(firstName,lName);
        if(pos != -1 ) {
            this.users.get(pos).setPassword(newPassword);
            return true;

        }
        return false;
    }
    public boolean verifyEmail(String fName,String lName,String email){
        for(User m : users){
            if(m.getFirstName().equals(fName)&&m.getLastName().equals(lName)&&m.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
    public boolean loginUser(String email,String pass){
        for(User m : users){
            if(m.getEmail().equals(email)&&m.getPassword().equals(pass)){
                return true;
            }
        }
        return false;
    }
    public User returnUserbyEmail(String email){
        for (User m : users){
            if(m.getEmail().equals(email)){
                return m;
            }
        }
        return null;
    }
}
