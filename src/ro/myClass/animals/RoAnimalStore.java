package ro.myClass.animals;

import ro.myClass.user.User;

public class RoAnimalStore {


    public double order(User user,Animals animals,boolean food,boolean clothes,boolean accesories){

        if(food == true){
           animals = new Food(animals);
           this.food();
        }else if(clothes == true){
            animals =  new Clothes(animals);
            this.clothes();
        }else if(accesories == true){
            animals = new Accesories(animals);
            this.accesories();
        }
        return animals.cost();
    }
    public void food(){
        System.out.println("Food was added in your cart...");
    }
    public void accesories(){
        System.out.println("Accesories was added in your cart...");
    }
    public void clothes(){
        System.out.println("Clothes was added in your cart");
    }
}
