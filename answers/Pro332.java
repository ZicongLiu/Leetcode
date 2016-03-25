public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        if (tickets.length == 0) {
            return new ArrayList<String>();
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String[] ticket : tickets) {
            String from = ticket[0], to = ticket[1];
            List<String> oldList = map.containsKey(from) ? map.get(from)
                    : new ArrayList<String>();
            oldList.add(to);
            map.put(from, oldList);
        }
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
        }
        List<String> result = new ArrayList<String>();
        exploreItinerary(map, "JFK", result, tickets.length + 1);
        return result;
    }

    private boolean exploreItinerary(Map<String, List<String>> map,
            String curPort, List<String> result, int targetSize) {
        result.add(curPort);
        if (result.size() == targetSize) {
            return true;
        }
        if (map.get(curPort) != null){
            // Note: you can remove elements when iterating using index
            for (int idx = 0 ; idx < map.get(curPort).size() ; idx ++) {
                String to = map.get(curPort).get(idx);
                map.get(curPort).remove(idx);
                if (exploreItinerary(map, to, result, targetSize)) {
                    return true;
                }
                map.get(curPort).add(to);
                Collections.sort(map.get(curPort));
            }
        }
        result.remove(result.size() - 1);
        return false;
    }
}