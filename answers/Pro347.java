public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<Integer>();
        PriorityQueue<Entry> queue = new PriorityQueue<Entry>(
            (a,b) -> b.count - a.count);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums){
            if (map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }
            else{
                map.put(num, 1);
            }
        }
        for (int key : map.keySet()){
            Entry entry = new Entry();
            entry.value = key;
            entry.count = map.get(key);
            queue.offer(entry);
        }
        
        for (int idx = 0 ; idx < k ; idx ++){
            Entry entry = queue.poll();
            result.add(entry.value);
        }
        return result;
    }
}
class Entry{
    public int value;
    public int count;
}