class BSTNode{
    BSTNode left;
    BSTNode right;
    int count;
    int leftCnt;
    int rightCnt;
    long val;
    public BSTNode(long val){
        this.count = 1;
        this.val = val;
    }
}
public class Solution {
    private int countLower(BSTNode node, long val){
        if (node == null){
            return 0;
        }
        if (node.val == val){
            return node.leftCnt;
        }
        else if (node.val > val){
            return countLower(node.left, val);
        }
        else{
            return node.leftCnt + node.count + countLower(node.right, val);
        }
    }
    
    private int countUpper(BSTNode node, long val){
        if (node == null){
            return 0;
        }
        if (node.val == val){
            return node.rightCnt;
        }
        else if (node.val < val){
            return countUpper(node.right, val);
        }
        else {
            return node.rightCnt + node.count + countUpper(node.left, val);
        }
    }
    private BSTNode insert(BSTNode node, long val){
        if (node == null){
            return new BSTNode(val);
        }
        if (node.val == val){
            node.count ++;
            return node;
        }
        else if (node.val > val) {
            node.leftCnt ++;
            node.left = insert(node.left, val);
        }
        else{
            node.rightCnt ++;
            node.right = insert(node.right, val);
        }
        return node;
    }
    
    private int countInRange(BSTNode root, long lower, long upper){
        int total = root.count + root.leftCnt + root.rightCnt;
        int lowerCnt = countLower(root, lower);
        int upperCnt = countUpper(root, upper);
        return total - lowerCnt - upperCnt;
    }
    
    public int countRangeSum(int[] nums, int lower, int upper) {
        long sums[] = new long[nums.length + 1];
        for (int i = 0 ; i < nums.length ; i ++){
            sums[i + 1] = sums[i] + nums[i];
        }
        
        BSTNode root = new BSTNode(sums[0]);
        int total = 0;
        for (int i = 1 ; i < sums.length ; i++){
            total += countInRange(root, sums[i] - upper, sums[i] - lower);
            insert(root, sums[i]);
        }
        
        return total > 0 ? total : 0;
    }
}