package activities;

public class Car {
            String color="";
    String transmission="";
    int make=0;
    int tyres=0;
    int doors=0;
    Car(){
        tyres=4;
        doors=4;
    }
    public void displayCharacteristics(){
    System.out.println("tyres:"+tyres+"\n"+"doors:"+doors);
    }
    public void accelarate(){
        System.out.println("Car is moving forward.");
    }
    public void brake(){
        System.out.println("Car has stopped.");
    }
}
