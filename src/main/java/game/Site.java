package game;

public class Site {
    private int siteID;
    private int x;
    private int y;
    private int radius;
    private int structureType;
    private int owner;
    private int param1;
    private int param2;
    private double distanceWithMyQueen;
    private double distanceWithMidleMap;
    private double distanceWithEnnemy;
    private int maxMineSize;
    private int goldRemaining;
    private int towerAttackRange;

    Site(int siteID, int x, int y, int radius) {
        this.siteID = siteID;
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getDistanceWithEnnemy() {
        return distanceWithEnnemy;
    }

    public void setDistanceWithEnnemy(double distanceWithEnnemy) {
        this.distanceWithEnnemy = distanceWithEnnemy;
    }

    public double getDistanceWithMidleMap() {
        return distanceWithMidleMap;
    }

    public void setDistanceWithMidleMap(double distanceWithMidleMap) {
        this.distanceWithMidleMap = distanceWithMidleMap;
    }

    public int getTowerAttackRange() {
        return towerAttackRange;
    }

    public void setTowerAttackRange(int towerAttackRange) {
        this.towerAttackRange = towerAttackRange;
    }

    public int getGoldRemaining() {
        return goldRemaining;
    }

    public void setGoldRemaining(int goldRemaining) {
        this.goldRemaining = goldRemaining;
    }

    public int getMaxMineSize() {
        return maxMineSize;
    }

    public void setMaxMineSize(int maxMineSize) {
        this.maxMineSize = maxMineSize;
    }

    public double getDistanceWithMyQueen() {
        return distanceWithMyQueen;
    }

    public void setDistanceWithMyQueen(double distanceWithMyQueen) {
        this.distanceWithMyQueen = distanceWithMyQueen;
    }

    int getSiteID() {
        return siteID;
    }

    public void setSiteID(int siteID) {
        this.siteID = siteID;
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

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getStructureType() {
        return structureType;
    }

    public void setStructureType(int structureType) {
        this.structureType = structureType;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getParam1() {
        return param1;
    }

    public void setParam1(int param1) {
        this.param1 = param1;
    }

    public int getParam2() {
        return param2;
    }

    public void setParam2(int param2) {
        this.param2 = param2;
    }

    @Override
    public String toString() {
        return "game.Site{" +
                "siteID=" + siteID +
                ", x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                ", structureType=" + structureType +
                ", owner=" + owner +
                ", param1=" + param1 +
                ", param2=" + param2 +
                ", distanceWithMyQueen=" + distanceWithMyQueen +
                ", distanceWithMidleMap=" + distanceWithMidleMap +
                ", distanceWithEnnemy=" + distanceWithEnnemy +
                ", maxMineSize=" + maxMineSize +
                ", goldRemaining=" + goldRemaining +
                ", towerAttackRange=" + towerAttackRange +
                '}';
    }


}