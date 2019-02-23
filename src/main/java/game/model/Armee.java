package game.model;

public class Armee {
    private int positionX;
    private int positionY;
    private int proprietaire;
    private int type;
    private int pointsDeVie;
    private double distanceAvecMaReine;

    public Armee(int positionX, int positionY, int proprietaire, int type, int pointsDeVie) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.proprietaire = proprietaire;
        this.type = type;
        this.pointsDeVie = pointsDeVie;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(int proprietaire) {
        this.proprietaire = proprietaire;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public double getDistanceAvecMaReine() {
        return distanceAvecMaReine;
    }

    public void setDistanceAvecMaReine(double distanceAvecMaReine) {
        this.distanceAvecMaReine = distanceAvecMaReine;
    }

    @Override
    public String toString() {
        return "Armee{" +
                "positionX=" + positionX +
                ", positionY=" + positionY +
                ", proprietaire=" + proprietaire +
                ", type=" + type +
                ", pointsDeVie=" + pointsDeVie +
                ", distanceAvecMaReine=" + distanceAvecMaReine +
                '}';
    }
}