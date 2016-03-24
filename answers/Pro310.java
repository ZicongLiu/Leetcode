public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<Integer>();
        if (n == 1){
            result.add(0);
            return result;
        }
        
        int degree[] = new int[n];
        List[] adjacency = new ArrayList[n];
        for (int i = 0 ; i < n ; i ++){
            adjacency[i] = new ArrayList<Integer>();
        }
        
        for (int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];
            degree[node1] ++;
            degree[node2] ++;
            adjacency[node1].add(node2);
            adjacency[node2].add(node1);
        }
        
        Queue<Integer> leaves = new LinkedList<Integer>();
        for (int i = 0 ; i < n ; i ++){
            if (degree[i] == 1){
                leaves.offer(i);
            }
        }
        
        int remaining = n;
        while (remaining > 2){
            remaining -= leaves.size();
            List<Integer> leavesList = new ArrayList<Integer>();
            while (!leaves.isEmpty()){
                leavesList.add(leaves.poll());
            }
            for (int leafIdx : leavesList){
                List<Integer> neighbors = adjacency[leafIdx];
                for (int neighborIdx : neighbors){
                    degree[neighborIdx] --;
                    if (degree[neighborIdx] == 1){
                        leaves.offer(neighborIdx);
                    }
                }
            }
                
        }
        while (!leaves.isEmpty()){
            result.add(leaves.poll());
        }
        return result;
    }
}