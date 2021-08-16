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
public class AirplaneFlightSimulator {
    private double latitude;
    private double longitude;
    private int altitude;
    private String direction;
    private double speed;
    
    public AirplaneFlightSimulator(double latitude, double longitude, int altitude, String direction, double speed) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
        this.direction = direction;
        this.speed = speed;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }
        public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public static void main(String [] args) {
            AirplaneFlightSimulator obj = new AirplaneFlightSimulator(11.11, 23.222, 11344, "NW", 11.4);
            System.out.println(obj.getAltitude());
    }
}
