package ro.myClass.controllers;

import ro.myClass.animals.*;
import ro.myClass.user.*;


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ControllerAnimalStore {

    private ArrayList<Animals> animals;
    private SimpleAnimalFactory simpleAnimalFactory;

    private RemoteAnimals remoteAnimals;

    public ControllerAnimalStore() {
        this.animals = new ArrayList<>();
        this.simpleAnimalFactory = new SimpleAnimalFactory();
        this.remoteAnimals = new RemoteAnimals();
        this.load();
    }
    public void load(){
        try{
            File file = new File("C:\\Head-First-DP\\ProjectHeadFirstChapter1-8\\src\\ro\\myClass\\resources\\animal.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String text = scanner.nextLine();
                switch (text.split(",")[0]){
                    case "dog":
                        this.animals.add(new Dog(scanner.nextLine()));
                        break;
                    case "cat":
                        this.animals.add(new Cat(scanner.nextLine()));
                        break;
                    case "rabbit":
                        this.animals.add(new Rabbit(scanner.nextLine()));
                        break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void buyAnimal(String type,String fName,String lName,String petName){
      Animals animal = simpleAnimalFactory.createAnimal(type,fName,lName,petName);
      this.animals.add(animal);
    }

    public void remove(Animals animal){
        int flag = findAnimal(animal.getLastName(),animal.getPetName());
        if(flag == -1){
            this.animals.remove(animal);
        }
    }
    public int findAnimal(String lastName,String petName){
        for(int i = 0 ; i < animals.size();i++){
            if(animals.get(i).getLastName().equals(lastName)&&animals.get(i).getPetName().equals(petName)){
                return i;
            }
        }
        return -1;
    }
    public void showYourPets(String fName,String lName){
        for(Animals m : animals ){
        if(m.getFirstName().equals(fName)&&m.getLastName().equals(lName)){
            System.out.println(m.display());
        }
    }
    }
    public void order(User user, Animals animals,boolean food,boolean clothes,boolean accesories){
        RoAnimalStore roAnimalStore = new RoAnimalStore();
        double cost = roAnimalStore.order(user,animals,food,clothes,accesories);
        int slot = remoteAnimals.returnSlot();
        if(food == true) {
            remoteAnimals.setCommand(slot, user, animals,"food",cost);
        }else if(clothes == true){
            remoteAnimals.setCommand(slot,user,animals,"clothes",cost);
        }else if(accesories == true){
            remoteAnimals.setCommand(slot,user,animals,"accesories", cost);
        }
    }
    public void showOrders(){
        System.out.println(remoteAnimals);
    }

    public Animals returnAnimalbyName(String lastName,String petName){
        for(Animals m : animals){
            if(m.getLastName().equals(lastName)&&m.getPetName().equals(petName)){
                return m;
            }
        }
         return null;
    }
    public void clearOrders(){
        this.remoteAnimals.clear();
    }

}
