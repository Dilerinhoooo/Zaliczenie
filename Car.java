package Szkola;

class Car {
    private boolean engineOn = false;
    private double speed;
    private int gear = 0;
    private double engineSpeed;

    Car() {
    }

    public boolean isEngineOn() {
        return this.engineOn;
    }

    public void setEngineOn(boolean engineOn) {
        this.engineOn = engineOn;
    }

    public double getSpeed() {
        return this.speed;
    }

    public int getGear() {
        return this.gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getEngineSpeed() {
        return this.engineSpeed;
    }

    public void setEngineSpeed(double engineSpeed) {
        this.engineSpeed = engineSpeed;
    }
}
