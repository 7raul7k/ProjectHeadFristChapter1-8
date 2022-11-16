package ro.myClass.animals;

public class Dog extends Animals implements Eatable, SoundableBehavior,Comparable<Dog> {
    public Dog(String firstName, String lastName, String petName) {
        super.setType("dog");
        super.setAnimalType(Type.DOG);super.setFirstName(firstName);
        super.setLastName(lastName);super.setPetName(petName);
    }

    public Dog(String text){
     super.Animal(text);
    }

    @Override
    public void performSound() {
        System.out.println("Bark Bark !");
    }

    @Override
    public void performEat() {
        System.out.println("Dog is eating");
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
    public int compareTo(Dog o) {
        if(this.getPetName().compareTo(o.getPetName())<0) {
            return -1;
        }else if(this.getPetName().compareTo(o.getPetName())>0){
            return 1;
        }
        return 0;
    }
}
