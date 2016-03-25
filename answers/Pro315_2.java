class BITree{
    int capacity;
    int[] elements;
    
    private int lowbit(int num){
        return num & (-num);
    }
    
    public BITree(int capacity){
        this.capacity = capacity;
        elements = new int[capacity + 1];
    }
    
    public void add(int index, int value){
        while (index <= capacity){
            elements[index] += value;
            index += lowbit(index);
            if (index == 0){
                break;
            }
        }
    }
    public int sum(int index){
        int sum = 0;
        while (index > 0){
            sum += elements[index];
            index -= lowbit(index);
        }
        return sum;
    }
}
public class Solution {
    public List<Integer> countSmaller(int[] nums){
        // Sort and Discretize
        int[] clone = new int[nums.length];
        for (int numIdx = 0 ; numIdx < nums.length ; numIdx ++){
            clone[numIdx] = nums[numIdx];
        }
        // Sorting
        Arrays.sort(clone);
        // Discretization
        Map<Integer, Integer> discreteMap = new HashMap<Integer, Integer>();
        int count = 0;
        for (int dIdx = 0 ; dIdx < clone.length ; dIdx++){
            if (dIdx > 0 && clone[dIdx] == clone[dIdx - 1]){
                continue;
            }
            // discrete index is from 1~n not 0~n
            // since tree.elements[0] is
            //  to store the count less than minimum value in array
            discreteMap.put(clone[dIdx] , ++ count );
        }
        Integer[] result = new Integer[nums.length];
        BITree tree = new BITree(discreteMap.keySet().size());
        for (int numIdx = nums.length - 1 ; numIdx >= 0 ; numIdx --){
        	// here -1 means finding smaller elements
            result[numIdx] = tree.sum(discreteMap.get(nums[numIdx]) - 1);
            tree.add(discreteMap.get(nums[numIdx]) , 1);
        }
        return new ArrayList<Integer>(Arrays.asList(result));
    }   
}