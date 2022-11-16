package ro.myClass.animals;

public class Cat extends Animals implements Eatable, SoundableBehavior,Comparable<Cat> {
    public Cat(String firstName, String lastName, String petName)
    {
        super.setType("cat");
        super.setAnimalType(Type.CAT);super.setFirstName(firstName);
        super.setFirstName(lastName);super.setPetName(petName);
    }

    public Cat(String text){
        super.Animal(text);
    }
    @Override
    public void performSound() {
        System.out.println("Meow Meow!");
    }

    @Override
    public void performEat() {
        System.out.println("Cat is eating !");
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
    public int compareTo(Cat o) {
        if(this.getPetName().compareTo(o.getPetName())<0) {
            return -1;
        }else if(this.getPetName().compareTo(o.getPetName())>0){
            return 1;
        }
        return 0;
    }
}
