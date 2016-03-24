public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>(rowIndex + 1);
        for (int i = 0 ; i <= rowIndex ; i++){
            list.add(0);
        }
        for (int i = 0 ; i <= rowIndex ; i ++){
            list.set(i, 1);
            for (int j = i - 1 ; j > 0 ; j --){
                list.set(j, list.get(j) + list.get(j - 1));
            }
        }
        return list;
    }
}