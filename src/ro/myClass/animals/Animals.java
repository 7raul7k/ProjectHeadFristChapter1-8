package ro.myClass.animals;

public abstract class Animals {

    public enum Type{DOG,CAT,RABBIT };
    Type animalType = Type.DOG;
    private String firstName;
    private String lastName;
    private String petName;
    private String type;

  public void Animal(String text){
      String[] proprietes = text.split(",");
      this.type = proprietes[0];
      this.firstName = proprietes[1];
      this.lastName = proprietes[2];
      this.petName = proprietes[3];
  }
    public double cost(){
        double price = 0.0;
        if(animalType.equals(Type.CAT)){
            price += 90;
        } else if (animalType.equals(Type.DOG)) {
            price += 70;
        } else if (animalType.equals(Type.RABBIT)) {
          price += 40;
        }
        return price;
    }
    public abstract String display();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Type getAnimalType() {
        return animalType;
    }

    public boolean setAnimalType(Type animalType) {
       if(type.equals("dog")){
           this.animalType = Type.DOG;
           return true;
       }else if(type.equals("cat")){
           this.animalType = Type.CAT;
           return true;
       }else if(type.equals("rabbit")){
           this.animalType = Type.RABBIT;
           return true;
       }
       return false;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



}
