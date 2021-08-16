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
public class IceCreamDairyManufacturer {
    private int size;
    private String flavor;
    private String serialNo;
    private int manufacturingLine;
    private String manufactingPlant;
    
    public IceCreamDairyManufacturer(int size, String flavor, String serialNo, int manufacturingLine, String manufactingPlant) {
        this.size = size;
        this.flavor = flavor;
        this.serialNo = serialNo;
        this.manufacturingLine = manufacturingLine;
        this.manufactingPlant = manufactingPlant;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public int getManufacturingLine() {
        return manufacturingLine;
    }

    public void setManufacturingLine(int manufacturingLine) {
        this.manufacturingLine = manufacturingLine;
    }

    public String getManufactingPlant() {
        return manufactingPlant;
    }

    public void setManufactingPlant(String manufactingPlant) {
        this.manufactingPlant = manufactingPlant;
    }
}
