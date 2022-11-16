package ro.myClass.animals;

public class Rabbit extends Animals implements Eatable, SoundableBehavior,Comparable<Rabbit> {
    public Rabbit( String firstName, String lastName, String petName) {
        super.setType("rabbit");
        super.setAnimalType(Type.RABBIT);super.setFirstName(firstName);
        super.setFirstName(lastName);super.setPetName(petName);
    }

    public Rabbit(String text){
        super.Animal(text);
    }

    @Override
    public void performSound() {
        System.out.println(" Squeak squeak!");
    }

    @Override
    public String display() {
        String text = "";
        text += "Owner:"  + super.getFirstName() + " " + super.getLastName();
        text += "\nPet type : " + super.getType();
        text += "\nPet:" + super.getPetName() ;
        text += "\n================================\n";
        return text;
    }

    @Override
    public void performEat() {
        System.out.println("Rabbit are eating");
    }

    @Override
    public int compareTo(Rabbit o) {
        if(this.getPetName().compareTo(o.getPetName())<0) {
            return -1;
        }else if(this.getPetName().compareTo(o.getPetName())>0){
            return 1;
        }
        return 0;

    }
}
