package game.service;

import game.model.Batiment;

import java.awt.geom.Point2D;

public class LogiqueService {

    private ArmeeService armeeService;
    private BatimentService batimentService;
    private int siteConstructionContactReine;

    public LogiqueService(ArmeeService armeeService, BatimentService batimentService) {
        this.armeeService = armeeService;
        this.batimentService = batimentService;
    }

    public void setSiteConstructionContactReine(int siteConstructionContactReine) {
        this.siteConstructionContactReine = siteConstructionContactReine;
    }

    public static double calculateDistanceBetweenPointsWithPoint2D(double x1, double y1, double x2, double y2) {
        return Point2D.distance(x1, y1, x2, y2);
    }

    public void standarLogique() {
        System.err.println("Standar Logique");
        // Si je n'ai pas 2 mines et que il y quelque part sur la carte ou je peux construire une mine
        mineLogique();
    }

    private void mineLogique() {
        if (batimentService.getMinesAmical().size() < 2 && !batimentService.getListeSiteConstructionPourConstruireMineOrderByPertinence().isEmpty()) {
            System.err.println("J'ai moins de 2 mines et il y des mines disponible sur la carte !");
            if (armeeService.getPointsDeVieDePartReineAmical() == armeeService.getAmicalReine().getPointsDeVie() && batimentService.getBatimentsAmical().size() < 2) {
                System.err.println("J'ai autant de points de vie que au départ et je n'ai pas plus de 1 batiment !");
                if (siteConstructionContactReine != -1 && batimentService.findSiSiteDeConstructionPeuxAvoirMine(siteConstructionContactReine)) {
                    System.err.println("Je suis au contacte d'un site de construction ou je peux poser une mine, je la construit !");
                    construire(siteConstructionContactReine, "MINE");
                } else {
                    System.err.println("Je ne suis pas au contacte d'un site de construction ou je peux poser une mine !");
                    System.err.println("Je me déplace au site de construction pour mine le plus proche !");
                    deplacerReine(batimentService.getSiteConstructionPourConstruireMineLaPlusProche().getPositionX(), batimentService.getSiteConstructionPourConstruireMineLaPlusProche().getPositionY());
                }
            } else {
                System.err.println("J'ai moins de points de vie que au départ et je + de 1 batiment !");
                Batiment mineLaPlusPertinente = batimentService.getSiteConstructionPourConstruireMineLaPlusPertinente();
                if (siteConstructionContactReine != -1 && siteConstructionContactReine == mineLaPlusPertinente.getId()) {
                    System.err.println("Je suis au contacte d'un site de construction ou je peux poser une mine et c'est le plus pertinent, je la construit !");
                    construire(mineLaPlusPertinente.getId(), "MINE");
                } else {
                    System.err.println("Je suis au contacte d'un site de construction ou je peux poser une mine le plus pertinent, je me déplace làba !");
                    deplacerReine(mineLaPlusPertinente.getPositionX(), mineLaPlusPertinente.getPositionY());
                }
            }
        }
    }

    public void deplacerReine(int positionX, int positionY) {
        System.out.println("MOVE " + positionX + " " + positionY);
    }

    public void construire(int siteDeConstructionId, String batiment) {
        System.out.println("BUILD " + siteDeConstructionId + " " + batiment);
    }

}
