package game.model;

public class Batiment {
    private int id;
    private int positionX;
    private int positionY;
    private int rayon;
    private int orRestant;
    private int productionMax;
    private int type;
    private int proprietaire;
    private int param1;
    private int param2;
    private double noteMine;
    private double distanceAvecMaReine;
    private double distanceAvecMilieuDeMap;
    private double distanceAvecEnnemy;
    private int tourRayonAttaque;

    public Batiment(int id, int positionX, int positionY, int rayon) {
        this.id = id;
        this.positionX = positionX;
        this.positionY = positionY;
        this.rayon = rayon;
        this.orRestant = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getRayon() {
        return rayon;
    }

    public void setRayon(int rayon) {
        this.rayon = rayon;
    }

    public int getOrRestant() {
        return orRestant;
    }

    public void setOrRestant(int orRestant) {
        this.orRestant = orRestant;
    }

    public int getProductionMax() {
        return productionMax;
    }

    public void setProductionMax(int productionMax) {
        this.productionMax = productionMax;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(int proprietaire) {
        this.proprietaire = proprietaire;
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

    public double getNoteMine() {
        return noteMine;
    }

    public void setNoteMine(double noteMine) {
        this.noteMine = noteMine;
    }

    public double getDistanceAvecMaReine() {
        return distanceAvecMaReine;
    }

    public void setDistanceAvecMaReine(double distanceAvecMaReine) {
        this.distanceAvecMaReine = distanceAvecMaReine;
    }

    public double getDistanceAvecMilieuDeMap() {
        return distanceAvecMilieuDeMap;
    }

    public void setDistanceAvecMilieuDeMap(double distanceAvecMilieuDeMap) {
        this.distanceAvecMilieuDeMap = distanceAvecMilieuDeMap;
    }

    public double getDistanceAvecEnnemy() {
        return distanceAvecEnnemy;
    }

    public void setDistanceAvecEnnemy(double distanceAvecEnnemy) {
        this.distanceAvecEnnemy = distanceAvecEnnemy;
    }

    public int getTourRayonAttaque() {
        return tourRayonAttaque;
    }

    public void setTourRayonAttaque(int tourRayonAttaque) {
        this.tourRayonAttaque = tourRayonAttaque;
    }

    @Override
    public String toString() {
        return "Batiment{" +
                "id=" + id +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                ", rayon=" + rayon +
                ", orRestant=" + orRestant +
                ", productionMax=" + productionMax +
                ", type=" + type +
                ", proprietaire=" + proprietaire +
                ", param1=" + param1 +
                ", param2=" + param2 +
                ", noteMine=" + noteMine +
                ", distanceAvecMaReine=" + distanceAvecMaReine +
                ", distanceAvecMilieuDeMap=" + distanceAvecMilieuDeMap +
                ", distanceAvecEnnemy=" + distanceAvecEnnemy +
                ", tourRayonAttaque=" + tourRayonAttaque +
                '}';
    }
}
