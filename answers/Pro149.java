/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length <= 1){
            return points.length;
        }
        Map<Double, Integer> slopeCnt = new HashMap<Double, Integer>();
        int max = 0;
        for (int i = 0 ; i < points.length ; i ++){
            slopeCnt.clear();
            Point pointX = points[i];
            int duplicate = 0;
            for (int j = 0 ; j < points.length ; j++){
                if (i == j){
                    continue;
                }
                Point pointY = points[j];
                if (pointX.x == pointY.x && pointX.y == pointY.y){
                    duplicate ++;
                    continue;
                }
                else if (pointX.x == pointY.x){
                    slopeCnt.put(Double.MAX_VALUE,
                     slopeCnt.containsKey(Double.MAX_VALUE)
                      ? slopeCnt.get(Double.MAX_VALUE) + 1 : 1);
                }
                else{
                    double slope =
                     (pointY.y - pointX.y) * 1.0 / (pointY.x - pointX.x);
                    slopeCnt.put(slope, slopeCnt.containsKey(slope)
                     ? slopeCnt.get(slope) + 1 : 1);
                }
            }
            // System.out.println("Current pos: " + pointX.x + " , " + pointX.y);
            for (Double key : slopeCnt.keySet()){
                // System.out.println("\t" + key + " : " + slopeCnt.get(key));
                max = Math.max(max, slopeCnt.get(key) + duplicate + 1);
            }
            if (slopeCnt.keySet().size() == 0){
                max = Math.max(max, duplicate + 1);
            }
        }
        
        return max;
    }
}