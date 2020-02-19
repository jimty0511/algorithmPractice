package practice.airbnb;

import java.util.*;

// https://leetcode.com/discuss/interview-question/250075/Airbnb-or-Phone-screen-or-Lowest-Common-Ancestor-of-Two-Regions
public class LowestCommonAncestorOfTwoRegions {

    /**
     * Union find way
     */
    public List<String> solution(List<String[]> territories, List<String[]> inputs) {
        List<String> res = new ArrayList<>();
        Map<String, String> map = buildMapTwo(territories);
        for (String[] i : inputs) {
            res.add(findLCA(map, i[0], i[1]));
        }
        return res;
    }

    private String findLCA(Map<String, String> map, String a, String b) {
        if (!map.containsKey(a) || !map.containsKey(b))
            return "Invalid";
        Set<String> parent = new HashSet<>();
        while (map.get(a) != null) {
            parent.add(a);
            a = map.get(a);
        }
        while (!parent.contains(b) && map.get(b) != null)
            b = map.get(b);
        return b;
    }

    private Map<String, String> buildMapTwo(List<String[]> territories) {
        Map<String, String> map = new HashMap<>();
        for (String[] t : territories) {
            if (!map.containsKey(t[0]))
                map.put(t[0], null);
            for (int i = 1; i < t.length; i++)
                map.put(t[i], t[0]);
        }
        return map;
    }

    /**
     * OOD way
     */
    class Location {
        Location parent;
        String name;
        Map<String, Location> subLocations;

        public Location(String name) {
            this.name = name;
            this.subLocations = new HashMap<>();
        }
    }

    Map<String, Location> map = new HashMap<>();

    public void buildMap(List<List<String>> input) {
        for (List<String> locs : input) {
            insert(locs.get(0), null);
            for (int i = 1; i < locs.size(); i++) {
                insert(locs.get(i), locs.get(0));
            }
        }
    }

    private void insert(String name, String parent) {
        Location location = new Location(name);
        if (parent != null) {
            location.parent = map.get(parent);
        } else {
            location.parent = getParent(name);
        }
        if (location.parent != null)
            location.parent.subLocations.put(name, location);
        map.put(name, location);
    }

    private Location getParent(String name) {
        for (Map.Entry<String, Location> e : map.entrySet()) {
            if (e.getValue().subLocations.containsKey(name))
                return e.getValue();
        }
        return null;
    }

    public String getCommonAncestor(String first, String second) {
        Location firstLoc = map.get(first);
        Location secondLoc = map.get(second);
        if (firstLoc.parent.equals(secondLoc.parent))
            return firstLoc.parent.name;
        Set<String> parents = new HashSet<>();
        Location cur = firstLoc.parent;
        while (cur != null) {
            parents.add(cur.name);
            cur = cur.parent;
        }
        cur = secondLoc.parent;
        while (parents.add(cur.name))
            cur = cur.parent;
        return cur.name;
    }
}
