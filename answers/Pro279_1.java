public class Solution {
    public int numSquares(int n) {
        Queue<Integer> counts = new LinkedList<Integer>();
        Queue<Integer> values = new LinkedList<Integer>();
        ArrayList<Integer> squares = new ArrayList<Integer>();
        for (int i = 1 ; i <= n ; i ++){
            int square = i * i;
            if (square > n){
                break;
            }
            else{
                if (square == n){
                    return 1;
                }
                squares.add(square);
            }
        }
        for (int i = squares.size() - 1 ; i >= 0 ; i--){
            values.offer(squares.get(i));
            counts.offer(1);
        }
        int count = -1;
        while (!values.isEmpty()){
            int value = values.poll();
            count = counts.poll();
            
            for(int i = squares.size() - 1 ; i >= 0 ; i --){
                if (value < squares.get(i)){
                    continue;
                }
                if (value + squares.get(i) > n){
                    continue;
                }
                else if (value + squares.get(i) == n){
                    return count + 1;
                }
                else{
                    values.offer(value + squares.get(i));
                    counts.offer(count + 1);
                }
            }
        }
        return count;
    }
}