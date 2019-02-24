package game.service;

import game.model.Batiment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BatimentService {
    private ArmeeService armeeService;
    private List<Batiment> batiments = new ArrayList<>();

    public List<Batiment> getBatiments() {
        return batiments;
    }

    public void setArmeeService(ArmeeService armeeService) {
        this.armeeService = armeeService;
    }

    public Batiment findBatimentById(int id) {
        return batiments.stream().filter(batiment -> batiment.getId() == id).findFirst().orElse(null);
    }

    public boolean findSiSiteDeConstructionPeuxAvoirMine(int id) {
        return findBatimentById(id).getOrRestant() != 0 && findBatimentById(id).getType() != 0;
    }

    public void updateBatimentById(int id, int orRestant, int productionMax, int type, int proprietaire, int param1, int param2) {
        Batiment batimentToUpadte = findBatimentById(id);
        if (orRestant != -1) {
            batimentToUpadte.setOrRestant(orRestant);
        }
        if (productionMax != -1) {
            batimentToUpadte.setProductionMax(productionMax);
        }
        batimentToUpadte.setType(type);
        batimentToUpadte.setProprietaire(proprietaire);
        batimentToUpadte.setParam1(param1);
        batimentToUpadte.setParam2(param2);
    }

    public void updateBatimentDistanceAvecMaReine() {
        for (Batiment batiment : batiments) {
            batiment.setDistanceAvecMaReine(LogiqueService.calculateDistanceBetweenPointsWithPoint2D(batiment.getPositionX(), batiment.getPositionY(), armeeService.getAmicalReine().getPositionX(), armeeService.getAmicalReine().getPositionY()));
        }
    }

    public List<Batiment> getBatimentsAmical() {
        return batiments.stream().filter(batiment -> batiment.getProprietaire() == 0).collect(Collectors.toList());
    }

    public List<Batiment> getMinesAmical() {
        return getBatimentsAmical().stream().filter(batiment -> batiment.getType() == 0).collect(Collectors.toList());
    }

    public List<Batiment> getListeSiteConstructionPourConstruireMineOrderByPertinence() {
        return armeeService.getPositionDepartReineAmical() == 0 ? batiments.stream().filter(batiment -> batiment.getOrRestant() != 0 && batiment.getType() != 0).sorted(Comparator.comparing(Batiment::getPositionX)).collect(Collectors.toList()) : batiments.stream().filter(batiment -> batiment.getOrRestant() != 0 && batiment.getType() != 0).sorted(Comparator.comparing(Batiment::getPositionX).reversed()).collect(Collectors.toList());
    }

    public Batiment getSiteConstructionPourConstruireMineLaPlusPertinente() {
        return getListeSiteConstructionPourConstruireMineOrderByPertinence().get(0);
    }

    public List<Batiment> getListeSiteConstructionPourConstruireMineOrderByDistance() {
        return batiments.stream().filter(batiment -> batiment.getOrRestant() != 0 && batiment.getType() != 0).sorted(Comparator.comparing(Batiment::getDistanceAvecMaReine)).collect(Collectors.toList());
    }

    public Batiment getSiteConstructionPourConstruireMineLaPlusProche() {
        return getListeSiteConstructionPourConstruireMineOrderByDistance().get(0);
    }
}
