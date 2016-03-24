class Point{
    int x, y;
    boolean left;
    int index;
    public Point(int x, int y , boolean left, int index){
        this.x = x;
        this.y = y;
        this.left = left;
        this.index = index;
    }
}
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings.length == 0){
            return new ArrayList<int[]>();
        }
        List<int[]> result = new ArrayList<int[]>();
        List<Point> points = new ArrayList<Point>();
        for (int i = 0 ; i < buildings.length ; i++){
            int[] building = buildings[i];
            Point left = new Point(building[0], building[2], true, i);
            Point right = new Point(building[1], building[2], false, i);
            points.add(left);
            points.add(right);
        }
        Queue<Integer> heap = new PriorityQueue<Integer>(
            buildings.length , new Comparator<Integer>(){
            public int compare(Integer i1 , Integer i2){
                return i2 - i1;
            }
        });
            
        heap.offer(0);
        Collections.sort(points, new Comparator<Point>(){
            public int compare(Point p1 , Point p2){
                if (p1.x == p2.x){
                    if (p1.left && !p2.left){
                        return -1;
                    }
                    else if (!p1.left && p2.left){
                        return 1;
                    }
                    else{
                        return 0;
                    }
                }
                return p1.x - p2.x;
            }
        });
        for (Point point : points){
            if (point.left){
                if (point.y > heap.peek()){
                    if (result.size() > 0
                     && result.get(result.size() - 1)[0] == point.x){
                        result.remove(result.size() - 1);
                    }
                    result.add(new int[] {point.x, point.y});
                }
                heap.offer(point.y);
            }else{
                heap.remove(point.y);
                if (point.y > heap.peek()){
                    if (result.size() > 0
                     && result.get(result.size() - 1)[0] == point.x){
                        result.remove(result.size() - 1);
                    }
                    result.add(new int[] {point.x, heap.peek()});
                }
            }
        }
        return result;
    }
}