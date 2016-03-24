public class Solution {
    
    private boolean traverse(int courseIdx,ArrayList<Integer>[] adjacency
        ,int[] visited ){
        visited[courseIdx] = -1;
        for (int adjacencyEle : adjacency[courseIdx]){
            if (visited[adjacencyEle] == -1){
                return false;
            }
            else if (visited[adjacencyEle] == 0){
                    if (!traverse(adjacencyEle, adjacency,visited)){
                        return false;
                    }
            }
        }
        
        visited[courseIdx] = 1;
        return true;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adjacency = new ArrayList[numCourses];
        for (int i = 0 ; i < numCourses ; i ++){
            adjacency[i] = new ArrayList<Integer>();
        }
        for (int i = 0 ; i < prerequisites.length ; i ++){
            adjacency[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        int[] visited = new int[numCourses];
        for (int courseIdx = 0 ; courseIdx < numCourses ; courseIdx ++){
            if (visited[courseIdx] == 0){
                if (!traverse(courseIdx, adjacency,visited)){
                    return false;
                }
            } 
        }
        
        
        return true;
        
    }
}