/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day1;

/**
 *
 * @author coleogden
 */
public class DealershipCar {
    private int price;
    private String make;
    private String model;
    private int year;
    private String color;
    
    public DealershipCar(int price, String make, String model, int year, String color) {
        this.price = price;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public static void main(String [] args) {
            DealershipCar car = new DealershipCar(200000,"Ferarri", "458", 2021, "Red");
            System.out.println("Welcome to your new $" + car.getPrice() + " " + car.getYear() + " " + 
                    car.getColor() + " " + car.getMake() + " " + car.getModel() + "!");
    }
}
