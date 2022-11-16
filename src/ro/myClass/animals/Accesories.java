package ro.myClass.animals;

public class Accesories extends AnimalBehavior {
    Animals animals;
    public Accesories(Animals animals) {
        this.animals = animals;
    }


    @Override
    public void getDescription() {
        System.out.println("You bought Accesories! ");
        System.out.println(this.display());
    }
    @Override
    public double cost() {
        double cost = animals.cost();
        if(animals.getAnimalType() == Type.DOG){
            cost += 7.25;
        }else if(animals.getAnimalType() == Type.CAT){
            cost += 6.07;
        }else if(animals.getAnimalType() == Type.RABBIT) {
            cost += 5.79;
        }
        return cost;
    }

    @Override
    public String display() {
        return "\n you bought accesories ! \n" + animals.display();
    }
}
