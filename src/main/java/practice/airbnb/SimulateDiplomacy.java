package practice.airbnb;

import java.util.*;

public class SimulateDiplomacy {
//    public List<String> solution(List<String> actions) {
//        Map<String, String> armyToLocation = new HashMap<>();
//        Map<String, List<String>> locationToArmy = new HashMap<>();
//        Map<String, Integer> armyToStrength = new HashMap<>();
//        Map<String, String> armyToSupport = new HashMap<>();
//        Map<String, List<String>> supportToArmy = new HashMap<>();
//        Set<String> inBattle = new HashSet<>();
//        for (String a : actions) {
//            String[] strArr = a.split(" ");
//            String army = strArr[0];
//            String location = strArr[1];
//            String action = strArr[2];
//            if (action.equals("Move")) {
//                String des = strArr[3];
//                inBattle.add(des);
//                locationToArmy.putIfAbsent(des, new ArrayList<>());
//                locationToArmy.get(des).add(army);
//                armyToLocation.put(army, des);
//            } else if (action.equals("Hold")) {
//                locationToArmy.putIfAbsent(location, new ArrayList<>());
//                locationToArmy.get(location).add(army);
//                armyToLocation.put(army, location);
//            } else if (action.equals("Support")) {
//                String supp = strArr[3];
//                armyToSupport.put(army, supp);
//                armyToLocation.put(army, location);
//                locationToArmy.putIfAbsent(location, new ArrayList<>());
//                locationToArmy.get(location).add(army);
//            }
//            armyToStrength.put(army, 1);
//        }
//        Set<String> dead = new HashSet<>();
//        for (Map.Entry<String, String> e : armyToSupport.entrySet()) {
//            String army = e.getKey();
//            String supported = e.getValue();
//            String location = armyToLocation.get(army);
//            if (inBattle.contains(location)) {
//                armyToSupport.remove(army);
//                dead.add(army);
//            } else {
//                supportToArmy.putIfAbsent(supported, new ArrayList<>());
//                supportToArmy.get(supported).add(army);
//            }
//        }
//        for (Map.Entry<String, String> e : armyToSupport.entrySet()) {
//            String army = e.getKey();
//            String supported = e.getValue();
//            armyToStrength.put(supported, armyToStrength.get(supported) + 1);
//        }
//        for (Map.Entry<String, List<String>> e : locationToArmy.entrySet()) {
//            String location = e.getKey();
//            List<String> armies = e.getValue();
//            if (armies.size() > 1) {
//                if (armies.size() == 2) {
//                    if (dead.contains(armies.get(0)) || dead.contains(armies.get(1))) {
//                        dead.add(armies.get(0));
//                        dead.add(armies.get(1));
//                    }
//                } else {
//                    TreeMap<Integer, List<String>> strengthToArmies = new TreeMap<>(Collections.reverseOrder());
//                    for (String army : armies) {
//                        if (dead.contains(army))
//                            continue;
//                        int strength = armyToStrength.get(army);
//                        strengthToArmies.putIfAbsent(strength, new ArrayList<>());
//                        strengthToArmies.get(strength).add(army);
//                    }
//                    if (strengthToArmies.size() > 0) {
//                        Map.Entry<Integer, List<String>> firstEntry = strengthToArmies.firstEntry();
//                        List<String> value = firstEntry.getValue();
//                        if (value.size() == 1) {
//                            String winner = value.get(0);
//                            for (Map.Entry<Integer, List<String>> subE : strengthToArmies.entrySet()) {
//                                for (String army : subE.getValue()) {
//                                    if (winner != army)
//                                        dead.add(army);
////                                else {
////                                    for (String a : supportToArmy.get(winner)) {
////                                        armyToLocation.put(a, location);
////                                    }
////                                }
//                                }
//                            }
//                        } else {
//                            for (Map.Entry<Integer, List<String>> subE : strengthToArmies.entrySet()) {
//                                for (String army : subE.getValue()) {
//                                    dead.add(army);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        List<String> res = new ArrayList<>();
//        for (Map.Entry<String, String> e : armyToLocation.entrySet()) {
//            String army = e.getKey();
//            String location = e.getValue();
//            if (dead.contains(army)) {
//                res.add(army + " [dead]");
//            } else {
//                res.add(army + " " + location);
//            }
//        }
//        return res;
//    }

    public List<String> solutionTwo(List<String> input) {
        List<String> res = new ArrayList<>();
// deal with support
        HashMap<String, List<String>> posMap = new HashMap<>(); // position--army
        HashMap<String, String> resMap = new HashMap<>(); // army--res
        HashMap<String, Integer> strengthMap = new HashMap<>();// army--strength
        for (String line : input) {
            String[] parse = line.split(" ");
// initialize the strength map
            String army = parse[0];
            strengthMap.put(army, 1);
// initialize the position map
            String pos = "";
            if (parse[2].equals("Hold") || parse[2].equals("Support")) {
                pos = parse[1];
            }
            if (parse[2].equals("Move")) {
                pos = parse[3];
            }
            if (!posMap.containsKey(pos)) {
                posMap.put(pos, new ArrayList<String>());
            }
            posMap.get(pos).add(army);
        }

// update strength map through support
        for (String line : input) {
            String[] parse = line.split(" ");
            if (parse[2].equals("Support")) {
                String supportPos = parse[1];
                String supportTo = parse[3];
                if (posMap.get(supportPos).size() == 1) { // No other attack for support
                    strengthMap.put(supportTo, strengthMap.get(supportTo) + 1);
                }
            }
        }
// attack compute
        for (String pos : posMap.keySet()) {
            List<String> armyList = posMap.get(pos);
            if (armyList.size() == 1) {
                resMap.put(armyList.get(0), pos);
            } else {
                int maxStrength = 0;
                String win = "";
                for (String army : armyList) {
                    int curStrength = strengthMap.get(army);
                    if (curStrength > maxStrength) {
                        if (win.length() > 0) {
                            resMap.put(win, "[dead]");
                        }
                        maxStrength = curStrength;
                        win = army;
                        resMap.put(army, pos);
                    } else if (curStrength == maxStrength) {
                        resMap.put(army, "[dead]");
                        resMap.put(win, "[dead]");
                    } else if (curStrength < maxStrength) {
                        resMap.put(army, "[dead]");
                    }
                }
            }
        }
        for (String armyItem : resMap.keySet()) {
            System.out.println(armyItem + " " + resMap.get(armyItem));
        }
        return res;
    }
}
