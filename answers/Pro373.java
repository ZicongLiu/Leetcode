public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result  = new ArrayList<int[]>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (int[] a, int[] b) -> (a[0] + a[1] - b[0] - b[1]));
        if (nums1.length == 0 || nums2.length == 0 || k == 0){
            return result;
        }
        for (int idx = 0 ; idx < nums1.length ; idx ++){
            queue.offer(new int[]{nums1[idx], nums2[0], 0});
        }
        while (result.size() < k && !queue.isEmpty()){
            int[] cur = queue.poll();
            result.add(new int[]{cur[0], cur[1]});
            if (cur[2] == nums2.length - 1){
                continue;
            }
            queue.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return result;
    }
}