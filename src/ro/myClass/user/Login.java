package ro.myClass.user;

public interface Login {
    public void registerUser(User user);
    public void removeUser(User user);

    public User getUser(String firstName,String lastName);
}
