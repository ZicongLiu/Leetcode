public class Solution {
   public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] result = new int[k];
        if (nums1.length + nums2.length < k){
            return result;
        }
        for (int length1 = 0 ;
                length1 <= Math.min(nums1.length, k) ; length1++){
            int length2 = k - length1;
            if (length2 > nums2.length){
                continue;
            }

            int[] list1 = getKLenStack(nums1, length1);
            int[] list2 = getKLenStack(nums2, length2);
            int[] newResult = new int[k];
            mergeStacks(list1, list2, newResult);

            for (int resIdx = 0 ; resIdx < newResult.length ; resIdx ++){
                if (newResult[resIdx] == result[resIdx]){
                    continue;
                }
                else if (newResult[resIdx] > result[resIdx]){
                    result = newResult;
                    break;
                }
                else{
                    break;
                }
            }
        }
        return result;
    }
    
    private void mergeStacks(int[] list1, int[] list2, int[] result){

        int idx = 0;
        int idx1 = 0, idx2 = 0;
        while (idx1 < list1.length && idx2 < list2.length){
            if (list1[idx1] > list2[idx2]){
                result[idx ++] = list1[idx1 ++];
            }
            else if (list1[idx1] < list2[idx2]){
                result[idx ++] = list2[idx2 ++];
            }
            else{
                int next1 = list1[idx1];
                int next2 = list2[idx2];
                int count = 1;
                while (next1 == next2){
                    if (idx1 + count < list1.length){
                        next1 = list1[idx1 + count];
                    }
                    if (idx2 + count < list2.length){
                        next2 = list2[idx2 + count];
                    }
                    count ++;
                    if (idx1 + count > list1.length
                            && idx2 + count > list2.length){
                        break;
                    }
                }
                if (next1 >= next2){
                    result[idx ++] = list1[idx1 ++];
                }
                else{
                    result[idx ++] = list2[idx2 ++];
                }
            }
        }
        while (idx1 < list1.length){
            result[idx ++] = list1[idx1 ++];
        }
        while (idx2 < list2.length){
            result[idx ++] = list2[idx2 ++];
        }
    }
    
    private int[] getKLenStack(int[] nums, int length){
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<Integer>();
        int curLen = 0;
        for (int numIdx = 0 ; numIdx < nums.length ; numIdx ++){
            int num = nums[numIdx];
            if (nums.length + stack.size() - numIdx <= length){
                stack.push(num);
                result[curLen] = num;
                curLen ++;
                continue;
            }
            while (!stack.isEmpty()
                    && num > stack.peek()
                    && stack.size() + nums.length - numIdx > length){
                stack.pop();
                curLen --;
            }
            if (curLen < length){
                stack.push(num);
                result[curLen] = num;
                curLen ++;
            }
        }
        return result;
    }
}