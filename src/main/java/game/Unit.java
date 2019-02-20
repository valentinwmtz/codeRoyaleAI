package game;

public class Unit {
    private int x;
    private int y;
    private int owner;
    private int unitType;
    private int health;
    private double distanceWithMyQueen;


    Unit(int x, int y, int owner, int unitType, int health) {
        this.x = x;
        this.y = y;
        this.owner = owner;
        this.unitType = unitType;
        this.health = health;
    }

    public double getDistanceWithMyQueen() {
        return distanceWithMyQueen;
    }

    public void setDistanceWithMyQueen(double distanceWithMyQueen) {
        this.distanceWithMyQueen = distanceWithMyQueen;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getUnitType() {
        return unitType;
    }

    public void setUnitType(int unitType) {
        this.unitType = unitType;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "game.Unit{" +
                "x=" + x +
                ", y=" + y +
                ", owner=" + owner +
                ", unitType=" + unitType +
                ", health=" + health +
                ", distanceWithMyQueen=" + distanceWithMyQueen +
                ", towerAttackRange=" +
                '}';
    }
}