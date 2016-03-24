class Bucket{
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    int size = 0;
    List<Integer> list = new ArrayList<Integer>();
}
public class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2){
            return 0;
        }
        if (nums.length == 2){
        	return Math.abs(nums[0] - nums[1]);
        }
        int totalMax = Integer.MIN_VALUE;
        int totalMin = Integer.MAX_VALUE;
        for (int i = 0 ; i < nums.length ; i ++){
            totalMax = Math.max(totalMax, nums[i]);
            totalMin = Math.min(totalMin, nums[i]);
        }
        
        int interval = (int) Math.ceil((double)(totalMax + 1 - totalMin)
             / (nums.length - 1));
        int bucketCnt = (int) Math.ceil((double)(totalMax + 1 - totalMin) / interval);
        Bucket[] buckets = new Bucket[bucketCnt];
        for (int i = 0 ; i < buckets.length ; i ++){
            buckets[i] = new Bucket();
        }
        
        if (interval == 0){
        	return 0;
        }
        for (int i = 0 ; i < nums.length ; i ++){
            int idx = (nums[i] - totalMin) / interval;
            buckets[idx].size ++;
            buckets[idx].list.add(nums[i]);
            buckets[idx].max = Math.max(buckets[idx].max, nums[i]);
            buckets[idx].min = Math.min(buckets[idx].min, nums[i]);
        }
        
        int maxGap = 0;
        int lastMax = Integer.MIN_VALUE;
        for (int i = 0 ; i < buckets.length ; i ++){
            if (buckets[i].size == 0){
                continue;
            } else{
                if (lastMax == Integer.MIN_VALUE){
                    lastMax = buckets[i].max;
                }else{
                    maxGap = Math.max(maxGap, buckets[i].min - lastMax);
                    lastMax = buckets[i].max;
                }
            }
        }
        
        return maxGap;
    }
}