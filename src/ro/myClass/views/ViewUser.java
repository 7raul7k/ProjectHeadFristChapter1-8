package ro.myClass.views;

import ro.myClass.animals.Animals;
import ro.myClass.controllers.ControllerAnimalStore;
import ro.myClass.controllers.ControllerUser;
import ro.myClass.user.User;

import java.util.Scanner;

public class ViewUser {

    private ControllerAnimalStore animalStore;

    private ControllerUser controllerUser;

    public Scanner scanner;

    private User user;

    public ViewUser(User newUser){
        this.animalStore = new ControllerAnimalStore();
        this.scanner = new Scanner(System.in);
        this.controllerUser = new ControllerUser();
        this.user = newUser ;
    }

    public void show(){
        System.out.println("Press 1 to show your pets");
        System.out.println("Press 2 to show your orders");
        System.out.println("Press 3 to buy a new animal");
        System.out.println("Press 4 to order accesories/food/clothes for animals");
        System.out.println("Press 5 to remove pet");
        System.out.println("Press 6 to update your last mame");
        System.out.println("Press 7 to update your password");
        System.out.println("Press 8 to clear all orders");

    }
    public void play(){
        boolean running = true;
        while(running){
          this.show();
          int choice = Integer.parseInt(scanner.nextLine());
          switch (choice){
              case 1: animalStore.showYourPets(user.getFirstName(), user.getLastName());
              break;
              case 2 : animalStore.showOrders();
              break;
              case 3 : addPet();
              break;
              case 4 : order();
              break;
              case 5 : removePet();
              break;
              case 6 : updateLastName();
              break;
              case 7 : updatePassword();
              break;
              case 8 : animalStore.clearOrders();
              break;
          }
        }
    }
    public void addPet(){
        System.out.println("Input type of animal : dog/cat/rabbit");
        String type = scanner.nextLine();
        String fName = user.getFirstName();
        String lName = user.getLastName();
        System.out.println("Input pet name");
        String petName = scanner.nextLine();
        animalStore.buyAnimal(type,fName,lName,petName);
    }
    public void order(){
        System.out.println("Input pet name");
        String petname = scanner.nextLine();
        Animals animals = animalStore.returnAnimalbyName(user.getLastName(),petname);
        String choice = scanner.nextLine();
        switch (choice){
            case "food":animalStore.order(this.user,animals,true,false, false);
            break;
            case "clothes":animalStore.order(this.user,animals,false,true,false);
            break;
            case "accesories":animalStore.order(this.user,animals,false, false,true);
            break;
        }
    }
    public void removePet(){
        System.out.println("Input pet Name");
        String petName = scanner.nextLine();
        Animals animals = animalStore.returnAnimalbyName(this.user.getLastName(),petName);
        animalStore.remove(animals);
    }
    public void updateLastName(){
        System.out.println("Input your new last name");
        String lName = scanner.nextLine();
        controllerUser.updateFirstName(user.getFirstName(), user.getLastName(), lName);
    }
    public void updatePassword(){
        System.out.println("Input new password");
        String pass = scanner.nextLine();
        controllerUser.updatePassword(user.getFirstName(), user.getLastName(), pass);
    }

}
