import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {
// ************************************
// ** ArmeeConst.java
// ************************************

public static class ArmeeConst { // line 3
    public static final int prixChevalier = 80; // line 4
    public static final int prixArcher = 100; // line 6
    public static final int prixGeant = 140; // line 8
} // line 9

// ************************************
// ** Armee.java
// ************************************

public static class Armee { // line  3
    private int positionX; // line  4
    private int positionY; // line  5
    private int proprietaire; // line  6
    private int type; // line  7
    private int pointsDeVie; // line  8
    private double distanceAvecMaReine; // line  9
    public Armee(int positionX, int positionY, int proprietaire, int type, int pointsDeVie) { // line 11
        this.positionX = positionX; // line 12
        this.positionY = positionY; // line 13
        this.proprietaire = proprietaire; // line 14
        this.type = type; // line 15
        this.pointsDeVie = pointsDeVie; // line 16
    } // line 17
    public int getPositionX() { // line 19
        return positionX; // line 20
    } // line 21
    public void setPositionX(int positionX) { // line 23
        this.positionX = positionX; // line 24
    } // line 25
    public int getPositionY() { // line 27
        return positionY; // line 28
    } // line 29
    public void setPositionY(int positionY) { // line 31
        this.positionY = positionY; // line 32
    } // line 33
    public int getProprietaire() { // line 35
        return proprietaire; // line 36
    } // line 37
    public void setProprietaire(int proprietaire) { // line 39
        this.proprietaire = proprietaire; // line 40
    } // line 41
    public int getType() { // line 43
        return type; // line 44
    } // line 45
    public void setType(int type) { // line 47
        this.type = type; // line 48
    } // line 49
    public int getPointsDeVie() { // line 51
        return pointsDeVie; // line 52
    } // line 53
    public void setPointsDeVie(int pointsDeVie) { // line 55
        this.pointsDeVie = pointsDeVie; // line 56
    } // line 57
    public double getDistanceAvecMaReine() { // line 59
        return distanceAvecMaReine; // line 60
    } // line 61
    public void setDistanceAvecMaReine(double distanceAvecMaReine) { // line 63
        this.distanceAvecMaReine = distanceAvecMaReine; // line 64
    } // line 65
    @Override // line 67
    public String toString() { // line 68
        return "Armee{" + // line 69
                "positionX=" + positionX + // line 70
                ", positionY=" + positionY + // line 71
                ", proprietaire=" + proprietaire + // line 72
                ", type=" + type + // line 73
                ", pointsDeVie=" + pointsDeVie + // line 74
                ", distanceAvecMaReine=" + distanceAvecMaReine + // line 75
                '}'; // line 76
    } // line 77
} // line 78

// ************************************
// ** Batiment.java
// ************************************

public static class Batiment { // line   3
    private int id; // line   4
    private int positionX; // line   5
    private int positionY; // line   6
    private int rayon; // line   7
    private int orRestant; // line   8
    private int productionMax; // line   9
    private int type; // line  10
    private int proprietaire; // line  11
    private int param1; // line  12
    private int param2; // line  13
    private double noteMine; // line  14
    private double distanceAvecMaReine; // line  15
    private double distanceAvecMilieuDeMap; // line  16
    private double distanceAvecEnnemy; // line  17
    private int tourRayonAttaque; // line  18
    public Batiment(int id, int positionX, int positionY, int rayon) { // line  20
        this.id = id; // line  21
        this.positionX = positionX; // line  22
        this.positionY = positionY; // line  23
        this.rayon = rayon; // line  24
    } // line  25
    public int getId() { // line  27
        return id; // line  28
    } // line  29
    public void setId(int id) { // line  31
        this.id = id; // line  32
    } // line  33
    public int getPositionX() { // line  35
        return positionX; // line  36
    } // line  37
    public void setPositionX(int positionX) { // line  39
        this.positionX = positionX; // line  40
    } // line  41
    public int getPositionY() { // line  43
        return positionY; // line  44
    } // line  45
    public void setPositionY(int positionY) { // line  47
        this.positionY = positionY; // line  48
    } // line  49
    public int getRayon() { // line  51
        return rayon; // line  52
    } // line  53
    public void setRayon(int rayon) { // line  55
        this.rayon = rayon; // line  56
    } // line  57
    public int getOrRestant() { // line  59
        return orRestant; // line  60
    } // line  61
    public void setOrRestant(int orRestant) { // line  63
        this.orRestant = orRestant; // line  64
    } // line  65
    public int getProductionMax() { // line  67
        return productionMax; // line  68
    } // line  69
    public void setProductionMax(int productionMax) { // line  71
        this.productionMax = productionMax; // line  72
    } // line  73
    public int getType() { // line  75
        return type; // line  76
    } // line  77
    public void setType(int type) { // line  79
        this.type = type; // line  80
    } // line  81
    public int getProprietaire() { // line  83
        return proprietaire; // line  84
    } // line  85
    public void setProprietaire(int proprietaire) { // line  87
        this.proprietaire = proprietaire; // line  88
    } // line  89
    public int getParam1() { // line  91
        return param1; // line  92
    } // line  93
    public void setParam1(int param1) { // line  95
        this.param1 = param1; // line  96
    } // line  97
    public int getParam2() { // line  99
        return param2; // line 100
    } // line 101
    public void setParam2(int param2) { // line 103
        this.param2 = param2; // line 104
    } // line 105
    public double getNoteMine() { // line 107
        return noteMine; // line 108
    } // line 109
    public void setNoteMine(double noteMine) { // line 111
        this.noteMine = noteMine; // line 112
    } // line 113
    public double getDistanceAvecMaReine() { // line 115
        return distanceAvecMaReine; // line 116
    } // line 117
    public void setDistanceAvecMaReine(double distanceAvecMaReine) { // line 119
        this.distanceAvecMaReine = distanceAvecMaReine; // line 120
    } // line 121
    public double getDistanceAvecMilieuDeMap() { // line 123
        return distanceAvecMilieuDeMap; // line 124
    } // line 125
    public void setDistanceAvecMilieuDeMap(double distanceAvecMilieuDeMap) { // line 127
        this.distanceAvecMilieuDeMap = distanceAvecMilieuDeMap; // line 128
    } // line 129
    public double getDistanceAvecEnnemy() { // line 131
        return distanceAvecEnnemy; // line 132
    } // line 133
    public void setDistanceAvecEnnemy(double distanceAvecEnnemy) { // line 135
        this.distanceAvecEnnemy = distanceAvecEnnemy; // line 136
    } // line 137
    public int getTourRayonAttaque() { // line 139
        return tourRayonAttaque; // line 140
    } // line 141
    public void setTourRayonAttaque(int tourRayonAttaque) { // line 143
        this.tourRayonAttaque = tourRayonAttaque; // line 144
    } // line 145
    @Override // line 147
    public String toString() { // line 148
        return "Batiment{" + // line 149
                "id=" + id + // line 150
                ", positionX=" + positionX + // line 151
                ", positionY=" + positionY + // line 152
                ", rayon=" + rayon + // line 153
                ", orRestant=" + orRestant + // line 154
                ", productionMax=" + productionMax + // line 155
                ", type=" + type + // line 156
                ", proprietaire=" + proprietaire + // line 157
                ", param1=" + param1 + // line 158
                ", param2=" + param2 + // line 159
                ", noteMine=" + noteMine + // line 160
                ", distanceAvecMaReine=" + distanceAvecMaReine + // line 161
                ", distanceAvecMilieuDeMap=" + distanceAvecMilieuDeMap + // line 162
                ", distanceAvecEnnemy=" + distanceAvecEnnemy + // line 163
                ", tourRayonAttaque=" + tourRayonAttaque + // line 164
                '}'; // line 165
    } // line 166
} // line 167

// ************************************
// ** ArmeeService.java
// ************************************

public static class ArmeeService { // line  7
    private List<Armee> armees; // line  8
    public List<Armee> getArmees() { // line 10
        return armees; // line 11
    } // line 12
    public void setArmees(List<Armee> armees) { // line 14
        this.armees = armees; // line 15
    } // line 16
} // line 17

// ************************************
// ** BatimentService.java
// ************************************

public static class BatimentService { // line  8
    private List<Batiment> batiments = new ArrayList<>(); // line  9
    public List<Batiment> getBatiments() { // line 11
        return batiments; // line 12
    } // line 13
    public void setBatiments(List<Batiment> batiments) { // line 15
        this.batiments = batiments; // line 16
    } // line 17
    public Batiment findBatimentById(int id) { // line 19
        return batiments.stream().filter(batiment -> batiment.getId() == id).findFirst().orElse(null); // line 20
    } // line 21
    public void updateBatimentById(int id, int orRestant, int productionMax, int type, int proprietaire, int param1, int param2) { // line 23
        Batiment batimentToUpadte = findBatimentById(id); // line 24
        batimentToUpadte.setOrRestant(orRestant); // line 25
        batimentToUpadte.setProductionMax(productionMax); // line 26
        batimentToUpadte.setType(type); // line 27
        batimentToUpadte.setProprietaire(proprietaire); // line 28
        batimentToUpadte.setParam1(param1); // line 29
        batimentToUpadte.setParam2(param2); // line 30
    } // line 31
} // line 33


    public static void main(String args[]) {
        BatimentService batimentService = new BatimentService();
        ArmeeService armeeService = new ArmeeService();
        Scanner in = new Scanner(System.in);
        int numSites = in.nextInt();
        for (int i = 0; i < numSites; i++) {
            int siteId = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            int radius = in.nextInt();
            Batiment batiment = new Batiment(siteId, x, y, radius);
            batimentService.getBatiments().add(batiment);
        }
        // game loop
        while (true) {
            int gold = in.nextInt();
            int touchedSite = in.nextInt(); // -1 if none
            for (int i = 0; i < numSites; i++) {
                int siteId = in.nextInt();
                int goldRemaining = in.nextInt(); // -1 if unknown
                int maxMineSize = in.nextInt(); // -1 if unknown
                int structureType = in.nextInt(); // -1 = No structure, 0 = Goldmine, 1 = Tower, 2 = Barracks
                int owner = in.nextInt(); // -1 = No structure, 0 = Friendly, 1 = Enemy
                int param1 = in.nextInt();
                int param2 = in.nextInt();
                batimentService.updateBatimentById(siteId, goldRemaining, maxMineSize, structureType, owner, param1, param2);
            }
            int numUnits = in.nextInt();
            for (int i = 0; i < numUnits; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                int owner = in.nextInt();
                int unitType = in.nextInt(); // -1 = QUEEN, 0 = KNIGHT, 1 = ARCHER, 2 = GIANT
                int health = in.nextInt();
            }
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            for (Batiment batiment : batimentService.getBatiments()) {
                System.err.println(batiment);
            }
            // First line: A valid queen action
            // Second line: A set of training instructions
            System.out.println("WAIT");
            System.out.println("TRAIN 1");
        }
    }
}