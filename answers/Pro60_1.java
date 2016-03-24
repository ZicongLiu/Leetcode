public class Solution {
    public String getPermutation(int n, int k) {
        Set<Integer> numbers = new HashSet<Integer>();
        for (int i = 1;  i <= n ; i++){
            numbers.add(i);
        }
        return getPermutation(numbers , n , k);
    }
    private String getPermutation(Set<Integer> numbers, int n, int k) {
        if (n == 0){
            return "";
        }
        int qou = (k - 1) / getFact(n - 1);
        int rem = (k - 1) % getFact(n - 1);
        Iterator<Integer> ite = numbers.iterator();
        int num = ite.next();
        int count = qou;
        
        while (ite.hasNext() && count-- > 0){
            num = ite.next();
        }
        numbers.remove(num);
        return String.valueOf(num) + getPermutation(numbers, n - 1, rem + 1);
    }

    private int getFact(int n){
        for (int i = 1 ; i <= n ; i++){
            power *= i;
        }
        return power;
    }
}