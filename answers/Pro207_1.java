public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0){
            return true;
        }
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<List<Integer>>(numCourses);
        for (int i = 0 ; i < numCourses ; i ++){
            adjacency.add(new ArrayList<Integer>());
        }
        
        for (int i = 0 ; i < prerequisites.length ; i ++){
            adjacency.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]] ++;
        }
        
        Queue<Integer> outQueue = new LinkedList<Integer>();
        
        for (int courseIdx = 0 ; courseIdx < numCourses; courseIdx++){
            if (indegree[courseIdx] == 0){
                outQueue.offer(courseIdx);
            }
        }
        
        int courseCount = 0;
        while (!outQueue.isEmpty()){
            int courseIdx = outQueue.poll();
            
            List<Integer> latterCourses = adjacency.get(courseIdx);
            for (int latterCourseIdx : latterCourses){
                indegree[latterCourseIdx] --;
                if (indegree[latterCourseIdx] == 0){
                    outQueue.offer(latterCourseIdx);
                }
            }
            
            courseCount ++;
        }
        
        return courseCount == numCourses;
        
        
    }
}