package ro.myClass.animals;

public class Food extends AnimalBehavior{
    Animals animals;

    public Food(Animals animals) {
        this.animals = animals;
    }

    @Override
    public void getDescription() {
        System.out.println("You bought food! ");
    }
    public double cost(){
            double cost = animals.cost();
            if(animals.getAnimalType() == Type.CAT ){
                cost +=  30.25;
            }else if(animals.getAnimalType() == Type.DOG){
                cost +=  29.99;
            }else if(animals.getAnimalType() == Type.RABBIT){
                cost += 26.03;
            }
        return cost;
    }

    @Override
    public String display() {
        return "You bought food!\n"+ animals.display() ;
    }
}
