package game;

import java.awt.geom.Point2D;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int numSites = in.nextInt();
        List<Site> sites = new ArrayList<Site>();
        for (int i = 0; i < numSites; i++) {
            int siteId = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            int radius = in.nextInt();
            Site site = new Site(siteId, x, y, radius);
            sites.add(site);
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
                completeSiteObject(sites, siteId, structureType, owner, param1, param2, maxMineSize, goldRemaining);
            }
            int numUnits = in.nextInt();
            List<Unit> units = new ArrayList<Unit>();
            for (int i = 0; i < numUnits; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                int owner = in.nextInt();
                int unitType = in.nextInt(); // -1 = QUEEN, 0 = KNIGHT, 1 = ARCHER
                int health = in.nextInt();
                Unit unit = new Unit(x, y, owner, unitType, health);
                units.add(unit);
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // First line: A valid queen action
            // Second line: A set of training instructions
            initSiteDistanceWithMyQueen(sites, units);
            initSiteDistanceWithMidleMap(sites, units);
            initUnitDistanceWithMyQueen(units);
            List<Site> siteOrderByDistance = sites.stream()
                    .sorted(Comparator.comparing(Site::getDistanceWithMyQueen))
                    .collect(Collectors.toList());
            List<Site> siteOrderByMidleMapDistance = sites.stream()
                    .sorted(Comparator.comparing(Site::getDistanceWithMidleMap))
                    .collect(Collectors.toList());
            List<Site> siteOrderByDistanceDescending = sites.stream()
                    .sorted(Comparator.comparing(Site::getDistanceWithMyQueen).reversed())
                    .collect(Collectors.toList());
            Site closestSiteIdToBuild = siteOrderByDistance.stream().filter(site -> site.getStructureType() == -1).findFirst().orElse(null);

            Site farthestSiteIdToBuild = siteOrderByDistanceDescending.stream().filter(site -> site.getStructureType() == -1).findFirst().orElse(null);
            Site closestMineIdToBuild = siteOrderByDistance.stream().filter(site -> site.getStructureType() == -1 && site.getGoldRemaining() > 1).findFirst().orElse(null);
            Site closestAllyTower = siteOrderByDistance.stream().filter(site -> site.getOwner() == 0 && site.getStructureType() == 1).findFirst().orElse(null);
            Site farthestAllySite = siteOrderByDistanceDescending.stream().filter(site -> site.getOwner() == 0).findFirst().orElse(null);
            Site closestMidleMapSiteToBuild = siteOrderByMidleMapDistance.stream().filter(site -> site.getStructureType() == -1).findFirst().orElse(null);
            List<Site> myTowers = sites.stream().filter(site -> site.getStructureType() == 1 && site.getOwner() == 0).collect(Collectors.toList());
            List<Site> ennemyTowers = sites.stream().filter(site -> site.getStructureType() == 1 && site.getOwner() == 1).collect(Collectors.toList());
            List<Site> myMines = sites.stream().filter(site -> site.getStructureType() == 0 && site.getOwner() == 0).collect(Collectors.toList());
            List<Site> ennemyMines = sites.stream().filter(site -> site.getStructureType() == 0 && site.getOwner() == 1).collect(Collectors.toList());

            List<Site> myMinesOrderByDistance = myMines.stream()
                    .sorted(Comparator.comparing(Site::getDistanceWithMyQueen))
                    .collect(Collectors.toList());
            List<Site> myBarracks = sites.stream().filter(site -> site.getStructureType() == 2 && site.getOwner() == 0).collect(Collectors.toList());
            List<Unit> attackEnnemyUnits = units.stream().filter(unit -> unit.getOwner() == 1 && unit.getUnitType() != -1 && unit.getUnitType() != 1).sorted(Comparator.comparing(Unit::getDistanceWithMyQueen)).collect(Collectors.toList());
            List<Unit> farthestattackEnnemyUnits = units.stream().filter(unit -> unit.getOwner() == 1 && unit.getUnitType() != -1 && unit.getUnitType() != 1).sorted(Comparator.comparing(Unit::getDistanceWithMyQueen).reversed()).collect(Collectors.toList());
            double closestAttackEnnemyUnitsDistance = getClosestAttackEnnemyUnitsDistance(units, attackEnnemyUnits);
            double farthestAttackEnnemyUnitsDistance = getClosestAttackEnnemyUnitsDistance(units, farthestattackEnnemyUnits);

            boolean queenIsAroundConstructionSite = touchedSite == -1 || !checkIfCanBuildBySiteId(touchedSite, sites);
            boolean inAllyTowersRange = myTowers.stream().anyMatch(site -> site.getDistanceWithMyQueen() - 20 <= site.getTowerAttackRange());
            boolean inEnnemyTowersRange = ennemyTowers.stream().anyMatch(site -> site.getDistanceWithMyQueen() <= site.getTowerAttackRange());

            /*        System.err.println(sites);*/
            System.err.println("debut condition");
            if ((myTowers.size() > 2 && !attackEnnemyUnits.isEmpty()) && sites.stream().noneMatch(site -> site.getStructureType() == 1 && site.getParam1() < 120 && site.getOwner() == 0) && closestAllyTower != null && attackEnnemyUnits != null && (closestAttackEnnemyUnitsDistance < 245 || attackEnnemyUnits.size() > 4)) {
                System.err.println("ENNEMY A PORTER COURIR");
                System.err.println(closestAttackEnnemyUnitsDistance);
                if (!myTowers.isEmpty()) {
                    if (!inAllyTowersRange) {
                        System.err.println("JE NE SUIS PAS DANS LA RANGE D UNE TOUR GO VERS TOUR");
                        runToSite(sites, touchedSite, gold, closestAllyTower, units, myMines, myTowers, ennemyTowers);
                    } else {
                        System.err.println("JE SUIS DANS LA RANGE D UNE TOUR SA PORTE EST DE");
                        System.err.println(closestAllyTower.getTowerAttackRange());

                        Integer cordxToGo = null;
                        Integer cordyToGo = null;
                        if (farthestattackEnnemyUnits.get(0).getX() >= closestAllyTower.getX()) {
                            cordxToGo = closestAllyTower.getX() - closestAllyTower.getTowerAttackRange();
                        } else if (farthestattackEnnemyUnits.get(0).getX() <= closestAllyTower.getX()) {
                            cordxToGo = closestAllyTower.getX() + closestAllyTower.getTowerAttackRange();
                        }
                        if (farthestattackEnnemyUnits.get(0).getY() >= closestAllyTower.getY()) {
                            cordyToGo = closestAllyTower.getY() - closestAllyTower.getTowerAttackRange();
                        } else if (farthestattackEnnemyUnits.get(0).getY() <= closestAllyTower.getY()) {
                            cordyToGo = closestAllyTower.getY() + closestAllyTower.getTowerAttackRange();
                        }
                        System.err.println(cordxToGo);
                        System.err.println(cordyToGo);
                        runToCordXY(sites, touchedSite, gold, cordxToGo, cordyToGo, units, myMines, myTowers, ennemyTowers);
                    }
                } else {
                    runToSite(sites, touchedSite, gold, farthestAllySite, units, myMines, myTowers, ennemyTowers);
                }
            } else if ((myBarracks.size() < 1 && myTowers.size() < 1 && myMines.size() > 2) || (myBarracks.size() < 2 && myTowers.size() > 2 && myMines.size() > 2 && ennemyTowers.size() > 2)) {
                System.err.println("Si barracks inf à 2");
                if (queenIsAroundConstructionSite) { // si la reine n'est pas à coter d'un site de construction
                    // si un site de construction est disponible
                    if (checkIfBuildingSiteAvailable(sites)) {
                        moveToClosestSite(closestMidleMapSiteToBuild, sites, gold, units, myMines, myTowers, ennemyTowers);
                    } else {
                        runToSite(sites, touchedSite, gold, farthestAllySite, units, myMines, myTowers, ennemyTowers);
                    }
                } else {
                    build(touchedSite, "BARRACKS-KNIGHT", sites, gold, units, myMines, myTowers, ennemyTowers);
                }
            } else if (closestAttackEnnemyUnitsDistance > 260 && myMines.stream().anyMatch(mine -> mine.getParam1() != -1 && mine.getParam1() < levelMaxOfMine(myTowers, mine.getMaxMineSize()) && mine.getMaxMineSize() > mine.getParam1() && mine.getGoldRemaining() > 150)) {
                System.err.println("Si une mine alliée n'est pas à son niveau maximum");
                Site closestMineIdToImprove = myMinesOrderByDistance.stream().filter(mine -> mine.getParam1() != -1 && mine.getParam1() < mine.getMaxMineSize()).findFirst().orElse(null);
                System.out.println("BUILD " + closestMineIdToImprove.getSiteID() + " MINE");
                String allBarracksId = getStringOfAllBarracksId(myBarracks, gold, units, myMines, myTowers, ennemyTowers);
                System.out.println("TRAIN " + allBarracksId);
            } else if (((queenIsAroundConstructionSite && closestMineIdToBuild != null) || (touchedSite != -1 && myMines.stream().noneMatch(mine -> mine.getSiteID() == touchedSite))) && (closestAttackEnnemyUnitsDistance > 260 && myMines.size() < 3 || (myTowers.size() > 3 && myBarracks.stream().anyMatch(barrack -> barrack.getParam2() == 2)) && checkIfMineBuildingSiteAvailable(sites))) {
                System.err.println("Mine inf à 4");
                System.err.println(queenIsAroundConstructionSite);
                System.err.println(closestMineIdToBuild);
                System.err.println(touchedSite != -1);
                System.err.println(myMines.stream().noneMatch(mine -> mine.getSiteID() == touchedSite));
                if (queenIsAroundConstructionSite && closestMineIdToBuild != null) { // si la reine n'est pas à coter d'un site de construction
                    System.err.println(closestMineIdToBuild);
                    moveToClosestSite(closestMineIdToBuild, sites, gold, units, myMines, myTowers, ennemyTowers);
                    System.err.println("Move to Mine a construire la plus proche");
                } else if (touchedSite != -1 && myMines.stream().noneMatch(mine -> mine.getSiteID() == touchedSite)) {
                    System.err.println(sites.stream().filter(site -> site.getSiteID() == touchedSite).findFirst().orElse(null));
                    System.err.println(checkIfMineBuildingSiteAvailable(sites));
                    build(touchedSite, "MINE", sites, gold, units, myMines, myTowers, ennemyTowers);
                }
            } else if ((myBarracks.stream().noneMatch(barrack -> barrack.getParam2() == 2) && myTowers.size() > 3) || (ennemyMines.size() < 1 && myMines.size() > 0 && ennemyTowers.size() > 1 && myBarracks.stream().noneMatch(barrack -> barrack.getParam2() == 2))) {
                System.err.println("Si aucune barrakcs de geant et gold sup a 400");
                if (queenIsAroundConstructionSite) { // si la reine n'est pas à coter d'un site de construction
                    // si un site de construction est disponible
                    if (checkIfBuildingSiteAvailable(sites)) {
                        moveToClosestSite(closestSiteIdToBuild, sites, gold, units, myMines, myTowers, ennemyTowers);
                    } else {
                        runToSite(sites, touchedSite, gold, farthestAllySite, units, myMines, myTowers, ennemyTowers);
                    }
                } else {
                    build(touchedSite, "BARRACKS-GIANT", sites, gold, units, myMines, myTowers, ennemyTowers);
                }
            } else if (sites.stream().anyMatch(site -> site.getStructureType() == 1 && site.getParam1() < 600 && site.getOwner() == 0) && (closestAttackEnnemyUnitsDistance > 230 || sites.stream().anyMatch(site -> site.getStructureType() == 1 && site.getParam1() < 120 && site.getOwner() == 0)) && (ennemyMines.size() > 0 && ennemyTowers.size() > 2)) {
                System.err.println("Si il y a des tower a upgrade");
                Site closestTowerIdToBuild = siteOrderByDistance.stream().filter(site -> site.getStructureType() == 1 && site.getParam1() < 700 && site.getOwner() == 0).findFirst().orElse(null);
                upgradeOrRepairTower(closestTowerIdToBuild, sites, gold, units, myMines, myTowers, ennemyTowers);
            } else if (myTowers.size() < 8) {
                System.err.println("Si tower inf  a 5");
                if (queenIsAroundConstructionSite) { // si la reine n'est pas à coter d'un site de construction
                    // si un site de construction est disponible
                    if (checkIfBuildingSiteAvailable(sites)) {
                        System.err.println("move to site a construire le plus loin pour tourelle");
                        if (myTowers.size() < 1 && attackEnnemyUnits.isEmpty()) {
                            System.err.println("go to mdile map " + closestMidleMapSiteToBuild);
                            moveToClosestSite(closestMidleMapSiteToBuild, sites, gold, units, myMines, myTowers, ennemyTowers);
                        } else if (!attackEnnemyUnits.isEmpty() && myTowers.size() < 1) {
                            initSiteDistanceWithEnnemy(sites, attackEnnemyUnits);
                            List<Site> siteOrderBydistanceWithEnnemyDescending = sites.stream()
                                    .sorted(Comparator.comparing(Site::getDistanceWithEnnemy).reversed())
                                    .collect(Collectors.toList());
                            for (Site site : siteOrderBydistanceWithEnnemyDescending) {
                                System.err.println(site);
                            }
                            Site farthestEnnemyUnitSiteToBuild = siteOrderBydistanceWithEnnemyDescending.stream().filter(site -> site.getStructureType() == -1).findFirst().orElse(null);
                            moveToClosestSite(farthestEnnemyUnitSiteToBuild, sites, gold, units, myMines, myTowers, ennemyTowers);
                        } else {
                            moveToClosestSite(closestSiteIdToBuild, sites, gold, units, myMines, myTowers, ennemyTowers);
                        }
                    } else {
                        System.err.println("Aucun emplacement a construire dispo");
                        runToSite(sites, touchedSite, gold, farthestAllySite, units, myMines, myTowers, ennemyTowers);
                    }
                } else {
                    System.err.println("BUILD TOWER SUR LE SITE COLLER");
                    build(touchedSite, "TOWER", sites, gold, units, myMines, myTowers, ennemyTowers);
                }
            } else {
                System.err.println("Sinon");
                runToSite(sites, touchedSite, gold, farthestAllySite, units, myMines, myTowers, ennemyTowers);
            }
            System.err.println("fin des conditions");
/*            if (getEnnemyQueen(units).getHealth() < 88 / 2 || getMyQueen(units).getHealth() < 94 / 2) {
                if (sites.stream().anyMatch(site -> site.getStructureType() == 1 && site.getParam1() < 500 && site.getOwner() == 0)) {
                    game.Site closestTowerIdToBuild = siteOrderByDistance.stream().filter(site -> site.getStructureType() == 1 && site.getParam1() < 500 && site.getOwner() == 0).findFirst().orElse(null);
                    upgradeOrRepairTower(closestTowerIdToBuild, sites, gold, units);
                } else {
                    logic(sites, gold, touchedSite, units, closestSiteIdToBuild, farthestAllySite);
                }
            } else {
                logic(sites, gold, touchedSite, units, closestSiteIdToBuild, farthestAllySite);
            }*/


        }
    }

    private static boolean positionIsInTurretRange(List<Site> towers, int positionX, int positionY) {
        if (towers.stream().anyMatch(tower -> calculateDistanceBetweenPointsWithPoint2D(positionX, positionY, tower.getX(), tower.getY()) <= tower.getTowerAttackRange())) {
            return true;
        }
        return false;
    }

    private static double getClosestAttackEnnemyUnitsDistance(List<Unit> units, List<Unit> attackEnnemyUnits) {
        if (!attackEnnemyUnits.isEmpty()) {
            return calculateDistanceBetweenPointsWithPoint2D(getMyQueen(units).getX(), getMyQueen(units).getY(), attackEnnemyUnits.get(0).getX(), attackEnnemyUnits.get(0).getY());
        }
        return 9999;
    }

    private static int levelMaxOfMine(List<Site> myTowers, int maxMineSize) {
        if (myTowers.size() < 3) {
            return 2;
        } else {
            return maxMineSize;
        }
    }

    private static void runToSite(List<Site> sites, int touchedSite, int gold, Site siteToRun, List<Unit> units, List<Site> myMines, List<Site> myTowers, List<Site> ennemyTowers) {
        runToCordXY(sites, touchedSite, gold, siteToRun.getX(), siteToRun.getY(), units, myMines, myTowers, ennemyTowers);
    }

    private static void runToCordXY(List<Site> sites, int touchedSite, int gold, int cordX, int cordY, List<Unit> units, List<Site> myMines, List<Site> myTowers, List<Site> ennemyTowers) {
        List<Site> myBarracks = sites.stream().filter(site -> site.getStructureType() == 2 && site.getOwner() == 0).collect(Collectors.toList());
        System.out.println("MOVE " + cordX + " " + cordY);
        if (myBarracks.isEmpty()) {
            System.out.println("TRAIN " + touchedSite);
        } else {
            String allBarracksId = getStringOfAllBarracksId(myBarracks, gold, units, myMines, myTowers, ennemyTowers);
            System.out.println("TRAIN " + allBarracksId);
        }
    }

    private static void upgradeOrRepairTower(Site closestTowerIdToBuild, List<Site> sites, int gold, List<Unit> units, List<Site> myMines, List<Site> myTowers, List<Site> ennemyTowers) {
        List<Site> myBarracks = sites.stream().filter(site -> site.getStructureType() == 2 && site.getOwner() == 0).collect(Collectors.toList());
        System.err.println(closestTowerIdToBuild);
        System.out.println("BUILD " + closestTowerIdToBuild.getSiteID() + " TOWER");
        if (myBarracks.isEmpty()) {
            System.out.println("TRAIN 1");
        } else {
            String allBarracksId = getStringOfAllBarracksId(myBarracks, gold, units, myMines, myTowers, ennemyTowers);
            System.out.println("TRAIN " + allBarracksId);
        }

    }

    private static String getStringOfAllBarracksId(List<Site> myBarracks, int gold, List<Unit> units, List<Site> myMines, List<Site> myTowers, List<Site> ennemyTowers) {
        StringJoiner myBarracksToTrain = new StringJoiner(" ");
        List<Site> myBarracksKnight = myBarracks.stream().filter(site -> site.getParam2() == 0).collect(Collectors.toList());
        List<Site> myBarracksGiant = myBarracks.stream().filter(site -> site.getParam2() == 2).collect(Collectors.toList());
        if (myBarracksGiant.size() >= 1 && units.stream().noneMatch(unit -> unit.getUnitType() == 2 && unit.getOwner() == 0)) {
            System.err.println(myBarracksGiant);
            myBarracksToTrain.add(Integer.toString(myBarracksGiant.get(0).getSiteID()));
            gold -= 140;
        }
        if ((myBarracks.size() > 1 && myTowers.size() > 1 && ennemyTowers.size() > 2)) {
            System.err.println("coukou");
            if (gold >= 200) {
                trainKnigth(gold, myBarracksToTrain, myBarracksKnight);
            } else {
                return "1";
            }
        } else {
            trainKnigth(gold, myBarracksToTrain, myBarracksKnight);
        }
        if (myBarracksToTrain.length() == 0) {
            return "1";
        }
        return String.valueOf(myBarracksToTrain);
    }

    private static void trainKnigth(int gold, StringJoiner myBarracksToTrain, List<Site> myBarracksKnight) {
        for (Site site : myBarracksKnight) {
            if (gold - 100 >= 0) {
                myBarracksToTrain.add(Integer.toString(site.getSiteID()));
                gold -= 100;
            } else {
                break;
            }
        }
    }

    private static void build(int touchedSite, String batiment, List<Site> sites, int gold, List<Unit> units, List<Site> myMines, List<Site> myTowers, List<Site> ennemyTowers) {
        List<Site> myBarracks = sites.stream().filter(site -> site.getStructureType() == 2 && site.getOwner() == 0).collect(Collectors.toList());
        if (myBarracks.isEmpty()) {
            System.err.println(touchedSite + " touched game.Site a build dans la fonction si barrack empty");
            System.out.println("BUILD " + touchedSite + " " + batiment);
            System.out.println("TRAIN " + touchedSite);
        } else {
            System.err.println(touchedSite + " touched game.Site a build dans la fonction si barrack non empty");
            String allBarracksId = getStringOfAllBarracksId(myBarracks, gold, units, myMines, myTowers, ennemyTowers);
            System.out.println("BUILD " + touchedSite + " " + batiment);
            System.err.println("ID de toutes les barracks : " + allBarracksId);
            System.out.println("TRAIN " + allBarracksId);
        }
    }

    private static void moveToClosestSite(Site closestSiteIdToBuild, List<Site> sites, int gold, List<Unit> units, List<Site> myMines, List<Site> myTowers, List<Site> ennemyTowers) {
        List<Site> myBarracks = sites.stream().filter(site -> site.getStructureType() == 2 && site.getOwner() == 0).collect(Collectors.toList());
        if (myBarracks.isEmpty()) {
            System.out.println("MOVE " + closestSiteIdToBuild.getX() + " " + closestSiteIdToBuild.getY());
            System.out.println("TRAIN " + closestSiteIdToBuild.getSiteID());
        } else {
            String allBarracksId = getStringOfAllBarracksId(myBarracks, gold, units, myMines, myTowers, ennemyTowers);
            System.out.println("MOVE " + closestSiteIdToBuild.getX() + " " + closestSiteIdToBuild.getY());
            System.out.println("TRAIN " + allBarracksId);
        }

    }


    private static boolean checkIfBuildingSiteAvailable(List<Site> sites) {
        return sites.stream().anyMatch(site -> site.getStructureType() == -1);
    }

    private static boolean checkIfMineBuildingSiteAvailable(List<Site> sites) {
        return sites.stream().anyMatch(site -> site.getStructureType() == -1 && site.getGoldRemaining() > 1);
    }

    private static boolean checkIfCanBuildBySiteId(int touchedSite, List<Site> sites) {
        return sites.stream().anyMatch(site -> site.getSiteID() == touchedSite && site.getStructureType() == -1);
    }

    private static void initSiteDistanceWithMyQueen(List<Site> sites, List<Unit> units) {
        for (Site site : sites) {
            site.setDistanceWithMyQueen(calculateDistanceBetweenPointsWithPoint2D(site.getX(), site.getY(), getMyQueen(units).getX(), getMyQueen(units).getY()));
        }
    }

    private static void initSiteDistanceWithMidleMap(List<Site> sites, List<Unit> units) {
        for (Site site : sites) {
            site.setDistanceWithMidleMap(calculateDistanceBetweenPointsWithPoint2D(site.getX(), site.getY(), 960, 500));
        }
    }

    private static void initSiteDistanceWithEnnemy(List<Site> sites, List<Unit> ennemyUnits) {
        System.err.println("init site distance with ennemy");
        System.err.println(ennemyUnits);
        for (Site site : sites) {
            site.setDistanceWithEnnemy(calculateDistanceBetweenPointsWithPoint2D(site.getX(), site.getY(), ennemyUnits.get(0).getX(), ennemyUnits.get(0).getY()));
        }
    }

    private static void initUnitDistanceWithMyQueen(List<Unit> units) {
        for (Unit unit : units) {
            unit.setDistanceWithMyQueen(calculateDistanceBetweenPointsWithPoint2D(unit.getX(), unit.getY(), getMyQueen(units).getX(), getMyQueen(units).getY()));
        }
    }


    private static Unit getMyQueen(List<Unit> units) {
        return units.stream().filter(unit -> unit.getUnitType() == -1 && unit.getOwner() == 0).findFirst().orElse(null);
    }

    private static Unit getEnnemyQueen(List<Unit> units) {
        return units.stream().filter(unit -> unit.getUnitType() == -1 && unit.getOwner() == 1).findFirst().orElse(null);
    }


    private static void printSitesAndUnits(List<Site> sites, List<Unit> units) {
        for (Site site : sites) {
            System.err.println(site);
        }
        for (Unit unit : units) {
            System.err.println(unit);
        }
    }

    private static void completeSiteObject(List<Site> sites, int siteId, int structureType, int owner, int param1, int param2, int maxMineSize, int goldRemaining) {
        Optional<Site> siteToUpdateOptional = sites.stream().
                filter(site -> site.getSiteID() == siteId).
                findFirst();
        Site siteToUpdate = siteToUpdateOptional.orElse(null);
        if (siteToUpdate != null) {
            siteToUpdate.setStructureType(structureType);
            siteToUpdate.setOwner(owner);
            siteToUpdate.setParam1(param1);
            siteToUpdate.setParam2(param2);
            if (maxMineSize != -1) {
                siteToUpdate.setMaxMineSize(maxMineSize);
            }
            if (goldRemaining != -1 || siteToUpdate.getDistanceWithMyQueen() < 300) {
                siteToUpdate.setGoldRemaining(goldRemaining);
            }
            if (siteToUpdate.getStructureType() == 1) {
                siteToUpdate.setTowerAttackRange(param2);
            }
        }
    }

    private static double calculateDistanceBetweenPointsWithPoint2D(double x1, double y1, double x2, double y2) {
        return Point2D.distance(x1, y1, x2, y2);
    }
}