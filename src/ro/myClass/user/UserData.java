package ro.myClass.user;

import java.util.ArrayList;

public class UserData implements Login {

    private ArrayList<User> user;


    @Override
    public void registerUser(User newUser) {
        this.user.add(newUser);

    }

    @Override
    public void removeUser(User User) {
      this.user.remove(user);

    }

    @Override
    public User getUser(String firstName, String lastName) {
        for(User m : user){
            if(m.getFirstName().equals(firstName) && m.getLastName().equals(lastName)){
                return m;
            }
        }
        return null;
    }

    public String display() {
        String text = "";
        for (int i = 0; i < user.size(); i++) {
            text += "First Name: " + user.get(i).getFirstName();
            text += "\nLast Name: " + user.get(i).getLastName();
            text += "\nAge: " + user.get(i).getAge();
            text += "\n================================================\n";
        }
        return text;
    }

}
