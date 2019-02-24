package game;

import game.model.Armee;
import game.model.Batiment;
import game.service.ArmeeService;
import game.service.BatimentService;
import game.service.LogiqueService;

import java.util.Scanner;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

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