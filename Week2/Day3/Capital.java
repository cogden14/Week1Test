/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Day3;

/**
 *
 * @author coleogden
 */
public class Capital {
    private String name;
    private int population;
    private double squareMilage;

    public Capital(String name, int population, double squareMilage) {
        this.name = name;
        this.population = population;
        this.squareMilage = squareMilage;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getSquareMilage() {
        return squareMilage;
    }

    public void setSquareMilage(double squareMilage) {
        this.squareMilage = squareMilage;
    }
    
    @Override
    public String toString() {
        return this.name + " | Population: " + this.population + " | Area: " + this.squareMilage + " sq mi";
    }
}
