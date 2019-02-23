package game.service;

import game.model.Batiment;

import java.util.ArrayList;
import java.util.List;

public class BatimentService {
    private List<Batiment> batiments = new ArrayList<>();

    public List<Batiment> getBatiments() {
        return batiments;
    }

    public void setBatiments(List<Batiment> batiments) {
        this.batiments = batiments;
    }

    public Batiment findBatimentById(int id) {
        return batiments.stream().filter(batiment -> batiment.getId() == id).findFirst().orElse(null);
    }

    public void updateBatimentById(int id, int orRestant, int productionMax, int type, int proprietaire, int param1, int param2) {
        Batiment batimentToUpadte = findBatimentById(id);
        batimentToUpadte.setOrRestant(orRestant);
        batimentToUpadte.setProductionMax(productionMax);
        batimentToUpadte.setType(type);
        batimentToUpadte.setProprietaire(proprietaire);
        batimentToUpadte.setParam1(param1);
        batimentToUpadte.setParam2(param2);
    }

}
