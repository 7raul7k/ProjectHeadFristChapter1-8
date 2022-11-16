package ro.myClass.user;

public class User extends UserData {
  private String firstName;
  private String lastName;
  private int age;

  private String email;

  private String password;

    public User(String firstName, String lastName, int age,String email,String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public User(String text){
        String[] proprietes = text.split(",");
        this.firstName = proprietes[0];
        this.lastName = proprietes[1];
        this.age = Integer.parseInt(proprietes[2]);
        this.email = proprietes[3];
        this.password = proprietes[4];

    }

    @Override
    public void registerUser(User newUser) {
        super.registerUser(newUser);
    }

    @Override
    public void removeUser(User User) {
        super.removeUser(User);
    }

    @Override
    public User getUser(String firstName, String lastName) {
        return super.getUser(firstName, lastName);
    }

    @Override
    public String display() {
        return super.display();
    }

    @Override
    public String toString(){
    return firstName+","+lastName+","+age+","+email+","+password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
