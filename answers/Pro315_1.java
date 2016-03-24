class Number{
    int num;
    int index;
    
    public Number(int num, int index){
        this.num = num;
        this.index = index;
    }
}
public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] count = new int[nums.length];
        Number[] numbers=  new Number[nums.length];
        for (int i = 0 ; i < nums.length ; i++){
            Number number = new Number(nums[i] , i);
            numbers[i] = number;
        }
        mergeSort(numbers, 0, numbers.length - 1, count);
        
        List<Integer> result = new ArrayList<Integer>();
        for (int c : count){
            result.add(c);
        }
        
        return result;
    }
    
    private void mergeSort(Number[] numbers, int start, int end , int[] count){
        if (start >= end){
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(numbers, start, mid, count);
        mergeSort(numbers, mid + 1 , end, count);
        mergeCombine(numbers, start, mid, mid + 1, end, count);
    }
    private void mergeCombine(Number[] numbers, int start1,
     int end1, int start2, int end2, int[] count){
        Number[] result = new Number[end2 - start1 + 1];
        int idx = result.length - 1;
        int idxLeft = end1, idxRight = end2;
        while(idxLeft >= start1 && idxRight >= start2){
            if (numbers[idxRight].num >= numbers[idxLeft].num){
                result[idx --] = numbers[idxRight --];
            }
            else{
                count[numbers[idxLeft].index] += idxRight - start2 + 1;
                result[idx --] = numbers[idxLeft --];
            }
        }
        while (idxLeft >= start1){
            count[numbers[idxLeft].index] += idxRight - start2 + 1;
            result[idx --] = numbers[idxLeft --];
        }
        while (idxRight >= start2){
            result[idx --] = numbers[idxRight --];
        }
        
        for (int i = 0 ; i < result.length ; i ++){
            numbers[start1 + i] = result[i];
        }
    }
    
}