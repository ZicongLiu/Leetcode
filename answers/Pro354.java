public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        quickSort(envelopes, 0, envelopes.length - 1);
        List<Integer> increasing = new ArrayList<Integer>();
        for (int idx = 0 ; idx < envelopes.length ; idx ++){
            if (increasing.size() == 0 
                || envelopes[idx][1] > increasing.get(increasing.size() - 1)){
                increasing.add(envelopes[idx][1]);
            }
            else{
                // binary search
                int properIdx = binarySearch(increasing, 0,
                 increasing.size() - 1, envelopes[idx][1]);
                if (properIdx < increasing.size()){
                    increasing.set(properIdx, envelopes[idx][1]);
                }
            }
        }
        return increasing.size();
    }

    private void quickSort(int[][] envelopes, int start, int end){
        if (start >= end){
            return;
        }
        int pivot = envelopes[start][0];
        int pivot2 = envelopes[start][1];
        int low = start, high = end;
        while (low < high){
            while (low < high && (envelopes[high][0] > pivot
             || (envelopes[high][0] == pivot && envelopes[high][1] <= pivot2))){
                high --;
            }
            envelopes[low][0] = envelopes[high][0];
            envelopes[low][1] = envelopes[high][1];

            while (low < high && (envelopes[low][0] < pivot
             || (envelopes[low][0] == pivot && envelopes[low][1] >= pivot2))){
                low ++;
            }
            envelopes[high][0] = envelopes[low][0];
            envelopes[high][1] = envelopes[low][1];
        }
        envelopes[low][0] = pivot;
        envelopes[low][1] = pivot2;

        quickSort(envelopes, start, low - 1);
        quickSort(envelopes, low + 1, end);
    }

    private int binarySearch(List<Integer> list, int start, int end, int target){
        int low = start, high = end;
        int mid = start + (end - start) / 2;
        while (low < high){
            mid = low + (high - low) / 2;
            if (list.get(mid) < target){
                low = mid + 1;
            }
            else if (list.get(mid) > target){
                high = mid - 1;
            }
            else{
                return mid;
            }
        }
        if (list.get(low) < target){
            return low + 1;
        }
        else{
            return low;
        }
    }
}