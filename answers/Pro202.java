public class Solution {
    public boolean isHappy(int n){
        Set<Integer> set = new HashSet<Integer>();
        int sum = 0;
        while (true){
            while (n != 0){
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            if (sum == 1){
                break;
            }
            if (set.contains(sum)){
                return false;
            }
            else{
                set.add(sum);
            }
            n = sum;
            sum = 0;
        }
        return true;
    }
}