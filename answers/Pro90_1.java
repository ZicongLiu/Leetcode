public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        List<List<Integer>> generatedList = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        for (int eleIdx = 0 ; eleIdx < nums.length ; eleIdx ++){
            int num = nums[eleIdx];
            if (eleIdx > 0 && nums[eleIdx] == nums[eleIdx - 1]){
                List<List<Integer>> newGeneratedList = new ArrayList<List<Integer>>();
                for (int formerIdx = 0 ; formerIdx < generatedList.size() ; formerIdx ++){
                    List<Integer> formerElement = new ArrayList(generatedList.get(formerIdx));
                    formerElement.add(num);
                    newGeneratedList.add(formerElement);
                }
                result.addAll(newGeneratedList);
                generatedList = newGeneratedList;
            }
            else{
                generatedList.clear();
                for (int formerIdx = 0 ; formerIdx < result.size() ; formerIdx ++){
                    List<Integer> formerElement = new ArrayList(result.get(formerIdx));
                    formerElement.add(num);
                    generatedList.add(formerElement);
                }
                result.addAll(generatedList);
            }
        }
        
        return result;
    }
}