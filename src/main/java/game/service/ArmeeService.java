package game.service;

import game.model.Armee;

import java.util.ArrayList;
import java.util.List;

public class ArmeeService {
    private List<Armee> armees = new ArrayList<>();

    public List<Armee> getArmees() {
        return armees;
    }

    public void setArmees(List<Armee> armees) {
        this.armees = armees;
    }
}
