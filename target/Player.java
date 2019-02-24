import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {
// ************************************
// ** Constante.java
// ************************************

public static class Constante { // line  3
    public static int largeurMap = 1920; // line  4
    public static int hauteurMap = 1000; // line  6
    public static final int prixChevalier = 80; // line  8
    public static final int prixArcher = 100; // line 10
    public static final int prixGeant = 140; // line 12
} // line 13

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
        this.orRestant = -1; // line  25
    } // line  26
    public int getId() { // line  28
        return id; // line  29
    } // line  30
    public void setId(int id) { // line  32
        this.id = id; // line  33
    } // line  34
    public int getPositionX() { // line  36
        return positionX; // line  37
    } // line  38
    public void setPositionX(int positionX) { // line  40
        this.positionX = positionX; // line  41
    } // line  42
    public int getPositionY() { // line  44
        return positionY; // line  45
    } // line  46
    public void setPositionY(int positionY) { // line  48
        this.positionY = positionY; // line  49
    } // line  50
    public int getRayon() { // line  52
        return rayon; // line  53
    } // line  54
    public void setRayon(int rayon) { // line  56
        this.rayon = rayon; // line  57
    } // line  58
    public int getOrRestant() { // line  60
        return orRestant; // line  61
    } // line  62
    public void setOrRestant(int orRestant) { // line  64
        this.orRestant = orRestant; // line  65
    } // line  66
    public int getProductionMax() { // line  68
        return productionMax; // line  69
    } // line  70
    public void setProductionMax(int productionMax) { // line  72
        this.productionMax = productionMax; // line  73
    } // line  74
    public int getType() { // line  76
        return type; // line  77
    } // line  78
    public void setType(int type) { // line  80
        this.type = type; // line  81
    } // line  82
    public int getProprietaire() { // line  84
        return proprietaire; // line  85
    } // line  86
    public void setProprietaire(int proprietaire) { // line  88
        this.proprietaire = proprietaire; // line  89
    } // line  90
    public int getParam1() { // line  92
        return param1; // line  93
    } // line  94
    public void setParam1(int param1) { // line  96
        this.param1 = param1; // line  97
    } // line  98
    public int getParam2() { // line 100
        return param2; // line 101
    } // line 102
    public void setParam2(int param2) { // line 104
        this.param2 = param2; // line 105
    } // line 106
    public double getNoteMine() { // line 108
        return noteMine; // line 109
    } // line 110
    public void setNoteMine(double noteMine) { // line 112
        this.noteMine = noteMine; // line 113
    } // line 114
    public double getDistanceAvecMaReine() { // line 116
        return distanceAvecMaReine; // line 117
    } // line 118
    public void setDistanceAvecMaReine(double distanceAvecMaReine) { // line 120
        this.distanceAvecMaReine = distanceAvecMaReine; // line 121
    } // line 122
    public double getDistanceAvecMilieuDeMap() { // line 124
        return distanceAvecMilieuDeMap; // line 125
    } // line 126
    public void setDistanceAvecMilieuDeMap(double distanceAvecMilieuDeMap) { // line 128
        this.distanceAvecMilieuDeMap = distanceAvecMilieuDeMap; // line 129
    } // line 130
    public double getDistanceAvecEnnemy() { // line 132
        return distanceAvecEnnemy; // line 133
    } // line 134
    public void setDistanceAvecEnnemy(double distanceAvecEnnemy) { // line 136
        this.distanceAvecEnnemy = distanceAvecEnnemy; // line 137
    } // line 138
    public int getTourRayonAttaque() { // line 140
        return tourRayonAttaque; // line 141
    } // line 142
    public void setTourRayonAttaque(int tourRayonAttaque) { // line 144
        this.tourRayonAttaque = tourRayonAttaque; // line 145
    } // line 146
    @Override // line 148
    public String toString() { // line 149
        return "Batiment{" + // line 150
                "id=" + id + // line 151
                ", positionX=" + positionX + // line 152
                ", positionY=" + positionY + // line 153
                ", rayon=" + rayon + // line 154
                ", orRestant=" + orRestant + // line 155
                ", productionMax=" + productionMax + // line 156
                ", type=" + type + // line 157
                ", proprietaire=" + proprietaire + // line 158
                ", param1=" + param1 + // line 159
                ", param2=" + param2 + // line 160
                ", noteMine=" + noteMine + // line 161
                ", distanceAvecMaReine=" + distanceAvecMaReine + // line 162
                ", distanceAvecMilieuDeMap=" + distanceAvecMilieuDeMap + // line 163
                ", distanceAvecEnnemy=" + distanceAvecEnnemy + // line 164
                ", tourRayonAttaque=" + tourRayonAttaque + // line 165
                '}'; // line 166
    } // line 167
} // line 168

// ************************************
// ** ArmeeService.java
// ************************************

public static class ArmeeService { // line  9
    private BatimentService batimentService; // line 10
    private List<Armee> armees = new ArrayList<>(); // line 11
    private Integer positionDepartReineAmical = null; // line 12
    private Integer pointsDeVieDePartReineAmical = null; // line 13
    public void setBatimentService(BatimentService batimentService) { // line 15
        this.batimentService = batimentService; // line 16
    } // line 17
    public Integer getPointsDeVieDePartReineAmical() { // line 19
        return pointsDeVieDePartReineAmical; // line 20
    } // line 21
    public void setPointsDeVieDePartReineAmical(Integer pointsDeVieDePartReineAmical) { // line 23
        this.pointsDeVieDePartReineAmical = pointsDeVieDePartReineAmical; // line 24
    } // line 25
    public Integer getPositionDepartReineAmical() { // line 27
        return positionDepartReineAmical; // line 28
    } // line 29
    public void setPositionDepartReineAmical(Integer positionDepartReineAmical) { // line 31
        this.positionDepartReineAmical = positionDepartReineAmical; // line 32
    } // line 33
    public List<Armee> getArmees() { // line 35
        return armees; // line 36
    } // line 37
    public List<Armee> getArmeesAmical() { // line 39
        return armees.stream().filter(armee -> armee.getProprietaire() == 0).collect(Collectors.toList()); // line 40
    } // line 41
    public Armee getAmicalReine() { // line 43
        return getArmeesAmical().stream().filter(armee -> armee.getType() == -1).findFirst().orElse(null); // line 44
    } // line 45
} // line 46

// ************************************
// ** BatimentService.java
// ************************************

public static class BatimentService { // line 10
    private ArmeeService armeeService; // line 11
    private List<Batiment> batiments = new ArrayList<>(); // line 12
    public List<Batiment> getBatiments() { // line 14
        return batiments; // line 15
    } // line 16
    public void setArmeeService(ArmeeService armeeService) { // line 18
        this.armeeService = armeeService; // line 19
    } // line 20
    public Batiment findBatimentById(int id) { // line 22
        return batiments.stream().filter(batiment -> batiment.getId() == id).findFirst().orElse(null); // line 23
    } // line 24
    public boolean findSiSiteDeConstructionPeuxAvoirMine(int id) { // line 26
        return findBatimentById(id).getOrRestant() != 0 && findBatimentById(id).getType() != 0; // line 27
    } // line 28
    public void updateBatimentById(int id, int orRestant, int productionMax, int type, int proprietaire, int param1, int param2) { // line 30
        Batiment batimentToUpadte = findBatimentById(id); // line 31
        if (orRestant != -1) { // line 32
            batimentToUpadte.setOrRestant(orRestant); // line 33
        } // line 34
        if (productionMax != -1) { // line 35
            batimentToUpadte.setProductionMax(productionMax); // line 36
        } // line 37
        batimentToUpadte.setType(type); // line 38
        batimentToUpadte.setProprietaire(proprietaire); // line 39
        batimentToUpadte.setParam1(param1); // line 40
        batimentToUpadte.setParam2(param2); // line 41
    } // line 42
    public void updateBatimentDistanceAvecMaReine() { // line 44
        for (Batiment batiment : batiments) { // line 45
            batiment.setDistanceAvecMaReine(LogiqueService.calculateDistanceBetweenPointsWithPoint2D(batiment.getPositionX(), batiment.getPositionY(), armeeService.getAmicalReine().getPositionX(), armeeService.getAmicalReine().getPositionY())); // line 46
        } // line 47
    } // line 48
    public List<Batiment> getBatimentsAmical() { // line 50
        return batiments.stream().filter(batiment -> batiment.getProprietaire() == 0).collect(Collectors.toList()); // line 51
    } // line 52
    public List<Batiment> getMinesAmical() { // line 54
        return getBatimentsAmical().stream().filter(batiment -> batiment.getType() == 0).collect(Collectors.toList()); // line 55
    } // line 56
    public List<Batiment> getListeSiteConstructionPourConstruireMineOrderByPertinence() { // line 58
        return armeeService.getPositionDepartReineAmical() == 0 ? batiments.stream().filter(batiment -> batiment.getOrRestant() != 0 && batiment.getType() != 0).sorted(Comparator.comparing(Batiment::getPositionX)).collect(Collectors.toList()) : batiments.stream().filter(batiment -> batiment.getOrRestant() != 0 && batiment.getType() != 0).sorted(Comparator.comparing(Batiment::getPositionX).reversed()).collect(Collectors.toList()); // line 59
    } // line 60
    public Batiment getSiteConstructionPourConstruireMineLaPlusPertinente() { // line 62
        return getListeSiteConstructionPourConstruireMineOrderByPertinence().get(0); // line 63
    } // line 64
    public List<Batiment> getListeSiteConstructionPourConstruireMineOrderByDistance() { // line 66
        return batiments.stream().filter(batiment -> batiment.getOrRestant() != 0 && batiment.getType() != 0).sorted(Comparator.comparing(Batiment::getDistanceAvecMaReine)).collect(Collectors.toList()); // line 67
    } // line 68
    public Batiment getSiteConstructionPourConstruireMineLaPlusProche() { // line 70
        return getListeSiteConstructionPourConstruireMineOrderByDistance().get(0); // line 71
    } // line 72
} // line 73

// ************************************
// ** LogiqueService.java
// ************************************

public static class LogiqueService { // line  7
    private ArmeeService armeeService; // line  9
    private BatimentService batimentService; // line 10
    private int siteConstructionContactReine; // line 11
    public LogiqueService(ArmeeService armeeService, BatimentService batimentService) { // line 13
        this.armeeService = armeeService; // line 14
        this.batimentService = batimentService; // line 15
    } // line 16
    public void setSiteConstructionContactReine(int siteConstructionContactReine) { // line 18
        this.siteConstructionContactReine = siteConstructionContactReine; // line 19
    } // line 20
    public static double calculateDistanceBetweenPointsWithPoint2D(double x1, double y1, double x2, double y2) { // line 22
        return Point2D.distance(x1, y1, x2, y2); // line 23
    } // line 24
    public void standarLogique() { // line 26
        System.err.println("Standar Logique"); // line 27
        // Si je n'ai pas 2 mines et que il y quelque part sur la carte ou je peux construire une mine // line 28
        if (batimentService.getMinesAmical().size() < 2 && !batimentService.getListeSiteConstructionPourConstruireMineOrderByPertinence().isEmpty()) { // line 29
            System.err.println("J'ai moins de 2 mines et il y des mines disponible sur la carte !"); // line 30
            if (armeeService.getPointsDeVieDePartReineAmical() == armeeService.getAmicalReine().getPointsDeVie() && batimentService.getBatimentsAmical().size() < 2) { // line 31
                System.err.println("J'ai autant de points de vie que au départ et je n'ai pas plus de 1 batiment !"); // line 32
                if (siteConstructionContactReine != -1 && batimentService.findSiSiteDeConstructionPeuxAvoirMine(siteConstructionContactReine)) { // line 33
                    System.err.println("Je suis au contacte d'un site de construction ou je peux poser une mine, je la construit !"); // line 34
                    construire(siteConstructionContactReine, "MINE"); // line 35
                } else { // line 36
                    System.err.println("Je ne suis pas au contacte d'un site de construction ou je peux poser une mine !"); // line 37
                    System.err.println("Je me déplace au site de construction pour mine le plus proche !"); // line 38
                    deplacerReine(batimentService.getSiteConstructionPourConstruireMineLaPlusProche().getPositionX(), batimentService.getSiteConstructionPourConstruireMineLaPlusProche().getPositionY()); // line 39
                } // line 40
            } else { // line 41
                System.err.println("J'ai moins de points de vie que au départ et je + de 1 batiment !"); // line 42
                Batiment mineLaPlusPertinente = batimentService.getSiteConstructionPourConstruireMineLaPlusPertinente(); // line 43
                if (siteConstructionContactReine != -1 && siteConstructionContactReine == mineLaPlusPertinente.getId()) { // line 44
                    System.err.println("Je suis au contacte d'un site de construction ou je peux poser une mine et c'est le plus pertinent, je la construit !"); // line 45
                    construire(mineLaPlusPertinente.getId(), "MINE"); // line 46
                } else { // line 47
                    System.err.println("Je suis au contacte d'un site de construction ou je peux poser une mine le plus pertinent, je me déplace làba !"); // line 48
                    deplacerReine(mineLaPlusPertinente.getPositionX(), mineLaPlusPertinente.getPositionY()); // line 49
                } // line 50
            } // line 51
        } // line 52
    } // line 53
    public void deplacerReine(int positionX, int positionY) { // line 55
        System.out.println("MOVE " + positionX + " " + positionY); // line 56
    } // line 57
    public void construire(int siteDeConstructionId, String batiment) { // line 59
        System.out.println("BUILD " + siteDeConstructionId + " " + batiment); // line 60
    } // line 61
} // line 63


    public static void main(String args[]) {
        BatimentService batimentService = new BatimentService();
        ArmeeService armeeService = new ArmeeService();
        batimentService.setArmeeService(armeeService);
        armeeService.setBatimentService(batimentService);
        LogiqueService logiqueService = new LogiqueService(armeeService, batimentService);
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
            logiqueService.setSiteConstructionContactReine(touchedSite);
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
                Armee armee = new Armee(x, y, owner, unitType, health);
                armeeService.getArmees().add(armee);
            }
            if (armeeService.getPositionDepartReineAmical() == null) {
                armeeService.setPositionDepartReineAmical(armeeService.getAmicalReine().getPositionX() < 960 ? 0 : 1);
            }
            if (armeeService.getPointsDeVieDePartReineAmical() == null) {
                armeeService.setPointsDeVieDePartReineAmical(armeeService.getAmicalReine().getPointsDeVie());
            }
            batimentService.updateBatimentDistanceAvecMaReine();
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            // First line: A valid queen action
            // Second line: A set of training instructions
            logiqueService.standarLogique();
            System.out.println("TRAIN 0");
        }
    }
}