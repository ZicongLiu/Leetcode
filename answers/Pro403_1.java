public class Solution {
    public boolean canCross(int[] stones) {
        if (stones.length <= 1){
            return true;
        }
        Map<Integer, Set<Integer>> map = new HashMap<Integer,
         Set<Integer>>();
        for (int idx = 0 ; idx < stones.length ; idx ++){
            map.put(stones[idx], new HashSet<Integer>());
        }
        map.get(0).add(1);
        map.put(0, map.get(0));
        for (int idx = 0 ; idx < stones.length - 1 ; idx ++){
            Set<Integer> steps = map.get(stones[idx]);
            Iterator<Integer> stepIte = steps.iterator();
            while (stepIte.hasNext()){
                int step = stepIte.next();
                if (map.containsKey(stones[idx] + step)){
                    Set<Integer> set = map.get(stones[idx] + step);
                    if (step > 1){
                        set.add(step - 1);
                    }
                    set.add(step);
                    set.add(step + 1);
                    map.put(stones[idx] + step, set);
                }
            }
        }
        
        return map.get(stones[stones.length - 1]).size() > 0;
    }
}