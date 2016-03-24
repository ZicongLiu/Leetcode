/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors
 *       = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    HashMap<UndirectedGraphNode, UndirectedGraphNode> map
     = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null){
            return null;
        }
        
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        if (!map.containsKey(node)){
            map.put(node, newNode);
        }
        else{
            return map.get(node);
        }
        for (UndirectedGraphNode neighborNode : node.neighbors){
            if (map.containsKey(neighborNode)){
                map.get(node).neighbors.add(map.get(neighborNode));
            }
            else{
                map.get(node).neighbors.add(cloneGraph(neighborNode));
            }
        }
        
        return newNode;
    }
}