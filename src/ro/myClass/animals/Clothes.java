package ro.myClass.animals;

public class Clothes extends AnimalBehavior{

    Animals animals;
    public Clothes(Animals animals) {
        this.animals = animals;
    }

    @Override
    public void getDescription() {
        System.out.println("You bought clothes! ");
    }

    @Override
    public double cost() {
        double cost = animals.cost();
        if(animals.getAnimalType() == Type.DOG){
            cost += 20.50;
        }else if (animals.getAnimalType() == Type.CAT){
            cost += 17.30;
        }else if(animals.getAnimalType() == Type.RABBIT){
            cost += 10;
        }
        return cost;
    }

    @Override
    public String display() {
        return " you bought clothes! \n"+animals.display();
    }
}
