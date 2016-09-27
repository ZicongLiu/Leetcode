public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0){
            return new int[0][2];
        }
        PriorityQueue<int[]> queue  = new PriorityQueue<int[]>(
            people.length, new Comparator<int[]>(){
            public int compare(int[] i1, int[] i2){
                if (i1[0] == i2[0]){
                    return i1[1] - i2[1];
                }
                else {
                    return i2[0] - i1[0];
                }
            }
        });
        for (int[] p : people){
            queue.offer(p);
        }
        
        LinkedList<int[]> list = new LinkedList<int[]>();
        int[][] result = new int[people.length][2];
        while (!queue.isEmpty()){
            int[] cur = queue.poll();            
            list.add(cur[1], cur);   
        }
        for (int i = 0 ; i < list.size() ; i ++){
            result[i] = list.get(i);
        }
        
        return result;
    }
}