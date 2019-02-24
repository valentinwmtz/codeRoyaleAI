package game.service;

import game.model.Armee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArmeeService {
    private BatimentService batimentService;
    private List<Armee> armees = new ArrayList<>();
    private Integer positionDepartReineAmical = null;
    private Integer pointsDeVieDePartReineAmical = null;

    public void setBatimentService(BatimentService batimentService) {
        this.batimentService = batimentService;
    }

    public Integer getPointsDeVieDePartReineAmical() {
        return pointsDeVieDePartReineAmical;
    }

    public void setPointsDeVieDePartReineAmical(Integer pointsDeVieDePartReineAmical) {
        this.pointsDeVieDePartReineAmical = pointsDeVieDePartReineAmical;
    }

    public Integer getPositionDepartReineAmical() {
        return positionDepartReineAmical;
    }

    public void setPositionDepartReineAmical(Integer positionDepartReineAmical) {
        this.positionDepartReineAmical = positionDepartReineAmical;
    }

    public List<Armee> getArmees() {
        return armees;
    }

    public List<Armee> getArmeesAmical() {
        return armees.stream().filter(armee -> armee.getProprietaire() == 0).collect(Collectors.toList());
    }

    public Armee getAmicalReine() {
        return getArmeesAmical().stream().filter(armee -> armee.getType() == -1).findFirst().orElse(null);
    }
}
