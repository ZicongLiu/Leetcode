public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int min_x = Integer.MAX_VALUE, min_y = Integer.MAX_VALUE;
        int max_x = Integer.MIN_VALUE, max_y = Integer.MIN_VALUE;
        int area = 0;
        Set<String> set = new HashSet<String>();
        for (int[] rect : rectangles){
            min_x = Math.min(rect[0], min_x);
            min_y = Math.min(rect[1], min_y);
            max_x = Math.max(rect[2], max_x);
            max_y = Math.max(rect[3], max_y);
            
            String p1 = rect[0] + "." + rect[1];
            String p2 = rect[0] + "." + rect[3];
            String p3 = rect[2] + "." + rect[1];
            String p4 = rect[2] + "." + rect[3];
            
            String[] points = {p1, p2, p3, p4};
            for (int idx = 0 ; idx < 4 ; idx ++){
                if (set.contains(points[idx])){
                    set.remove(points[idx]);
                }
                else{
                    set.add(points[idx]);
                }    
            }
            area += (rect[3] - rect[1]) * (rect[2] - rect[0]);
        }
        return ((set.size() == 4 
            && set.contains(min_x + "." + min_y)
            && set.contains(min_x + "." + max_y)
            && set.contains(max_x + "." + min_y)
            && set.contains(max_x + "." + max_y))
            && (area == (max_y - min_y) * (max_x - min_x)));
    }
}