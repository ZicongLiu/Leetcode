public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cand1 = -1 ,  cand2 = -1;
        int count1 = 0 , count2 = 0;
        
        for (int num : nums){
            if (num == cand1){
                count1 ++;   
            }else if (num == cand2){
                count2 ++;
            }
            else {
                // num <> cand1 & num <> cand2
                if (count1 == 0){
                    cand1 = num;
                    count1 = 1;
                }
                else if (count2 == 0){
                    cand2 = num;
                    count2 = 1;
                }
                else{
                    count1 --;
                    count2 --;
                }
            }
        }
        count1 = 0;
        count2 = 0;
        // check if there is only one majority element
        for (int num : nums){
            if (num == cand1){
                count1 ++;
            }
            if (num == cand2){
                count2 ++;
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        if (count1 > nums.length / 3){
            result.add(cand1);
        }
        if (count2 > nums.length / 3){
            result.add(cand2);
        }
        
        return result;
    }
}