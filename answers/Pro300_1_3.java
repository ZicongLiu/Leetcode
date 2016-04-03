import java.io.*;
import java.util.*;
public class LIS {
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in));
            int count = Integer.parseInt(br.readLine());
            int nums[] = new int[count];
            for (int i = 0 ; i < count ; i ++){
                nums[i] = Integer.parseInt(br.readLine());
            }
            
            List<List<Integer>> seq = new ArrayList<List<Integer>>();
            
            List<Integer> initialList = new ArrayList<Integer>();
            initialList.add(nums[0]);
            seq.add(initialList);
            
            for (int i = 1; i < count ; i ++){
                List<Integer> lastEle = seq.get(seq.size() - 1);
                if (nums[i] > lastEle.get(lastEle.size() - 1)){
                    List<Integer> endList = new ArrayList<Integer>();
                    int maxLevel = getMaxLevel(seq, seq.size());
                    for (int idx = 0 ; idx < maxLevel ; idx ++){
                        endList.add(-1);
                    }
                    endList.add(nums[i]);
                    seq.add(endList);
                }
                else if (nums[i] ==  lastEle.get(lastEle.size() - 1)){
                    continue;
                }
                else{
                    insertIntoSeq(seq, nums[i]);
                }
            }
            
            int maxLevel = getMaxLevel(seq, seq.size());
            System.out.println(seq.size());
            for (int seqIdx = seq.size() - 1 ; seqIdx >= 0 ; seqIdx --){
                List<Integer> curList = seq.get(seqIdx);
                if (curList.size() - 1 <= maxLevel){
                    maxLevel = curList.size() - 1;
                }
                System.out.print(curList.get(maxLevel) + "  ");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int getMaxLevel(List<List<Integer>> seq, int idx) {
        int maxLevel = -1;
        for (int seqIdx = 0 ; seqIdx < idx ; seqIdx ++){
            maxLevel = Math.max(maxLevel, seq.get(seqIdx).size() - 1);
        }
        return maxLevel;
    }

    private static void insertIntoSeq(List<List<Integer>> seq, int num) {
        int start = 0 , end = seq.size() - 1;
        while (start < end){
            int mid = start + (end - start) / 2;
            int cur = seq.get(mid).get(seq.get(mid).size() - 1);
            if (num < cur){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        int maxLevel = getMaxLevel(seq, start);
        int sub = maxLevel - seq.get(start).size();
        List<Integer> newList = new ArrayList<Integer>();
        for (int i = 0 ; i < sub ; i ++){
            newList.add(-1);
        }
        for (int ele : seq.get(start)){
            newList.add(ele);
        }
        newList.add(num);
        seq.set(start, newList);
    }
}
