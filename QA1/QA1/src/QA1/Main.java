package QA1;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        
        // CREATING AN INSTANCE
        Car bryarsCar = new Car();
        
        // MODIFYING DATA IN ONE INSTANCE
        bryarsCar.setMake("Jaguar");
        bryarsCar.setModel("XK");
        bryarsCar.setYear(2007);
        bryarsCar.setColor("Silver");

        // CREATING INSTANCE USING CONSTRUCTOR W/PARAMETERS
        Car carolinesCar = new Car("Porshe", 
                "911", 2017, "Maroon");


        System.out.println("\n" + "Bryar drives a " + bryarsCar.getInfo());
        System.out.println("\n" + "Caroline drives a " + carolinesCar.getInfo());

        bryarsCar.start();
        carolinesCar.start();

        carolinesCar.showCar();
        carolinesCar.drive();
    }


    
}

class Car {
    /*
    ||----------------------------||
    || Data is called Attributes  ||
    ||----------------------------||
    */
    private String make;
    private String model;
    private int year;
    private String color;

    private String[] picture = {
        "     _____          ",
        "   _/|_||_\\`.__    ",
        " /  _      _   \\   ",
        " `-(_)----(_)--'    "
    };  // Original Art Design:  Hayley Jane Wakenshaw 
        //  [https://www.asciiart.eu/vehicles/cars]
        // Art modified by Bryar Frank for this project

    //==================================================================//

    // DEFAULT CONSTRUCTOR
    public Car () {}

    // CONSTRUCTOR WITH PARAMETERS
    public Car(String make, String model, 
                    int year, String color) {

        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }    

    /*
    ||----------------------------||
    || Actions are called Methods ||
    ||----------------------------||
    */

    public void setMake(String make) {
        this.make = make;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getInfo() {
        return String.format("%d %s %s %s!", 
                            year, color, make, model);
    }

    public void start() {
        System.out.printf("\nThe %d %s %s makes a deep rumble.\n", year, make, model);
    }
    
    public void showCar() {
        for(int i=0; i<4; i++) {
            System.out.println(picture[i]);
        }
    }

    public void drive() {
        String road = "";
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {e.printStackTrace();}
        
        while (road.length() < 110) {
            try {
                System.out.print("\033[4F\33[K");  
                System.out.flush();
                
                for(int i=0; i<4; i++) {
                    System.out.println(road + picture[i]);
                }
                road += " ";

                TimeUnit.MILLISECONDS.sleep(20);
            } catch (Exception e) {e.printStackTrace();}
        }
    }

}


