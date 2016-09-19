public class Solution {
    List<String> result = new ArrayList<String>();
    int clockDigits = 10;
    int hourSplit = 4;
    public List<String> readBinaryWatch(int num) {
        boolean[] isOne = new boolean[clockDigits];
        Arrays.fill(isOne, false);
        findTimes(isOne, num, 0);
        Collections.reverse(result);
        return result;
    }
    
    private void findTimes(boolean[] isOne, int remains, int curIdx){
        if (curIdx > clockDigits){
            return;
        }
        if (remains == 0){
            String time = formTime(isOne);
            if (time != null){
                result.add(time);
            }
            return;
        }
        
        for (int idx = curIdx ; idx < clockDigits ; idx ++){
            isOne[idx] = true;
            findTimes(isOne, remains - 1, idx + 1);
            isOne[idx] = false;
        }
    }
    
    private String formTime(boolean[] isOne){
        int hour = 0;
        int minute = 0;
        int count = 0;
        for (int i = 0 ; i < hourSplit ; i ++){
            if (isOne[i]){
                hour += 1 << (hourSplit - i - 1);
            }
        }
        for (int i = hourSplit ; i < clockDigits ; i ++){
            if (isOne[i]){
                minute += 1 << (clockDigits - i - 1);
            }
        }
        if (hour > 11 || minute > 59){
            return null;
        }
        return hour + ":" + ((minute < 10) ? ("0" + minute) : minute);
    }
}