package ro.myClass.animals;

import ro.myClass.user.User;

public class RemoteAnimals {
    String[] type;
    String[] pets;
    String[] firstname;
    String[] lastname;

    double[] price;

    public RemoteAnimals() {
        pets = new String[10];
        firstname = new String[10];
        lastname = new String[10];
        price = new double[10];
        type = new String[10];
        Command cmmd = new NoCommand();

    }
    public void setCommand(int slot, User user,Animals animal,String t,double p){
        price[slot] = p;
        this.type[slot] = t;
        pets[slot] = animal.getType();
        firstname[slot] = user.getFirstName();
        lastname[slot] = user.getLastName();
    }

    public int returnSlot(){
        for (int i = 0; i < firstname.length;i++){
            if(firstname[i] == null){
                return i;
            }
        }
        return -1;
    }
    public void clear(){
        for (int i = 0 ; i < 10 ; i ++){
            firstname[i] = null;
            lastname[i] = null;
            pets[i] = null;
            type [i] = null;

        }
    }

    @Override
    public String toString(){
        double totalPrice = 0;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n------------ Cart --------------------\n");
        stringBuffer.append("Slot  |   Owner    |   Type    | Price  |  Animal name \n");
        for(int i = 0; i < 10;i++) {
            stringBuffer.append("[slot" + i + "]  " + firstname[i] + "  " + lastname[i] + "  | " + type[i]
                    + "     " + "$" + price[i] + "     " +
                    " Animal: " + pets[i] + "\n");
            totalPrice += price[i];

        }
        stringBuffer.append("Total Price:  $" + totalPrice);
        return stringBuffer.toString();
    }
}
