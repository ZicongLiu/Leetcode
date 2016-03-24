public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // ADD this statement will get a WA
        // if (prerequisites.length == 0){
        //     return new int[numCourses];
        // }
        int[] indegree = new int[numCourses];
        
        List<List<Integer>> adjacency = new ArrayList<List<Integer>>();
        for (int i = 0 ; i < numCourses ; i++){
            adjacency.add(new ArrayList<Integer>());
        }
        
        for (int preIdx = 0 ; preIdx < prerequisites.length ; preIdx ++){
            adjacency.get(prerequisites[preIdx][1]).
            add(prerequisites[preIdx][0]);
            indegree[prerequisites[preIdx][0]] ++;
        }
        
        Queue<Integer> startingCourses = new LinkedList<Integer>();
        for (int courseIdx = 0 ; courseIdx < numCourses ; courseIdx ++){
            if (indegree[courseIdx] == 0){
                startingCourses.offer(courseIdx);
            }
        }
        
        int[] result = new int[numCourses];
        int courseNum = 0;
        while (!startingCourses.isEmpty()){
            int courseIdx = startingCourses.poll();
            for (int latterCourseIdx : adjacency.get(courseIdx)){
                if (--indegree[latterCourseIdx] == 0){
                    startingCourses.offer(latterCourseIdx);
                }
            }
            
            result[courseNum] = courseIdx;
            courseNum ++;
        }
        
        return (courseNum == numCourses) ? result : new int[0];
    }
}