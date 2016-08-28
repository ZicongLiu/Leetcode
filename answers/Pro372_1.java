public class Solution {
    public int superPow(int a, int[] b) {
        if (isZero(b)){
            return 1;
        }
        boolean isEven = (b[b.length - 1] % 2 == 0);
        int product = superPow(a, div2(b)) % 1337;
        if (isEven){
            return product * product % 1337;
        }
        else{
            return (product * product % 1337 * (a % 1337)) % 1337; 
        }
    }
    private boolean isZero(int[] b){
        for (int digit : b){
            if (digit != 0){
                return false;
            }
        }
        return true;
    }   
    private int[] div2(int[] b){
        int carry = 0;
        for (int idxB = 0 ; idxB < b.length ; idxB ++){
            b[idxB] = carry * 10 + b[idxB];
            carry = b[idxB] % 2;
            b[idxB] /= 2;
        }
        return b;
    }
}