package ro.myClass.animals;

public class SimpleAnimalFactory {

    public Animals createAnimal(String type,String fName,String lName,String petName){
        Animals animals = null;
        if(type.equals("dog")){
            animals = new Dog(fName,lName,petName);
        }else if(type.equals("cat")){
            animals = new Cat(fName,lName,petName);
        }else if(type.equals("rabbit")){
            animals = new Rabbit(fName,lName,petName);
        }
        return animals;
    }
}
