/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "[]";
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        ArrayList<Integer> valueList = new ArrayList<Integer>();
        
        while (!queue.isEmpty()){
            TreeNode curNode = queue.poll();
            if (curNode != null){
                valueList.add(curNode.val);
            } else{
                valueList.add(null);
                continue;
            }
            
            // if (queue.isEmpty()){
            //     // push non-null node
            //     if (curNode.left != null && curNode.right != null){
            //         queue.offer(curNode.left);
            //         queue.offer(curNode.right);
            //     }else if (curNode.left != null){
            //         queue.offer(curNode.left);
            //     }else if (curNode.right != null){
            //         queue.offer(curNode.right);
            //     }
            // }else{
                // push all children, including null node
                queue.offer(curNode.left);
                queue.offer(curNode.right);
            // }
        }
        
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append("[");
        for (int valueIdx = 0 ; valueIdx < valueList.size() - 1 ; valueIdx ++){
            if (valueList.get(valueIdx) == null){
                resultBuilder.append("#");
            } else{
                resultBuilder.append(String.valueOf(valueList.get(valueIdx)));
            }
            resultBuilder.append(",");
        }
        
        if (valueList.get(valueList.size() - 1) == null){
            resultBuilder.append("#");
        }else{
            resultBuilder.append(
                String.valueOf(valueList.get(valueList.size() - 1)));
        }
        resultBuilder.append("]");
        
        return resultBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")){
            return null;
        }
        
        data = data.substring(1, data.length() - 1);
        
        Queue<TreeNode> resolvingQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> waitingQueue = new LinkedList<TreeNode>();
        
        String[] values = data.split(",");
        for (int idxValue = 0 ; idxValue < values.length ; idxValue ++){
            if (values[idxValue].equals("#")){
                waitingQueue.offer(null);
            }else{
                waitingQueue.offer(
                    new TreeNode(Integer.parseInt(values[idxValue])));
            }
        }
        TreeNode rootNode = waitingQueue.poll();
        resolvingQueue.offer(rootNode);
        while (!resolvingQueue.isEmpty() && !waitingQueue.isEmpty()){
            TreeNode resolvingNode = resolvingQueue.poll();
            if (resolvingNode != null) {
                TreeNode leftChild = waitingQueue.poll();
                TreeNode rightChild = waitingQueue.poll();
            
           
                resolvingNode.left = leftChild;
                resolvingNode.right = rightChild;
            
                resolvingQueue.offer(leftChild);
                resolvingQueue.offer(rightChild);
            }
        }
        
        return rootNode;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));