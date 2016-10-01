class Edge{
    public String source;
    public String target;
    public double value;
    public Edge(String source, String target, double value){
        this.source = source;
        this.target = target;
        this.value = value;
    }
}
public class Solution {
    Set<String> pass = new HashSet<String>();
    Map<String, List<Edge>> graph = new HashMap<String, List<Edge>>();
    public double[] calcEquation(String[][] equations,
                                 double[] values,
                                 String[][] queries) {
        double[] result = new double[queries.length];
        // initialize graph
        for (int eqIdx = 0 ; eqIdx < equations.length ; eqIdx ++){
            String[] equation = equations[eqIdx];
            String source = equation[0], target = equation[1];
            double value = values[eqIdx];
            // towards
            List<Edge> targets = (graph.containsKey(source)) ?
             graph.get(source) : new ArrayList<Edge>();
            targets.add(new Edge(source, target, value));
            graph.put(source, targets);
            // backwards
            List<Edge> sources = (graph.containsKey(target)) ?
             graph.get(target) : new ArrayList<Edge>();
            if (value != 0){
                sources.add(new Edge(target, source, 1 / value));
                graph.put(target, sources);
            }
        }
        
        // dfs to get each query result
        for (int queryIdx = 0 ; queryIdx < queries.length ; queryIdx ++){
            String[] query = queries[queryIdx];
            String source = query[0], target = query[1];
            result[queryIdx] = calVal(source, target, 1);
        }
        
        return result;
    }
    
    private double calVal(String source, String target, double value){
        if (!graph.containsKey(source)){
            return -1;
        }
        else{
            if (source.equals(target)){
                return 1;
            }
            else{
                List<Edge> edgesFromSource = graph.get(source);
                for (Edge edge : edgesFromSource){
                    if (edge.target.equals(target)){
                        return edge.value;
                    }
                }
                for (Edge edge : edgesFromSource){
                    if (pass.contains(edge.target)){
                        continue;
                    }
                    pass.add(edge.target);
                    double valRet = calVal(edge.target, target, value);
                    pass.remove(edge.target);
                    if (valRet != -1){
                        return value * valRet * edge.value;
                    }
                }
            }
        }
        return -1;
    }
}