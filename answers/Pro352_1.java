/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {
    List<Interval> intervals = new ArrayList<Interval>(); 
    /** Initialize your data structure here. */
    public SummaryRanges() {
        
    }
    
    public void addNum(int val) {
        
        if (intervals.size() == 0){
            intervals.add(new Interval(val, val));
            return;
        }
        if (val > intervals.get(intervals.size() - 1).end){
            if (val != intervals.get(intervals.size() - 1).end + 1){
                intervals.add(new Interval(val, val));
            }
            else{
                intervals.get(intervals.size() - 1).end = val;
            }
            return;
        }
        if (val < intervals.get(0).start){
            if (val != intervals.get(0).start - 1){
                intervals.add(0, new Interval(val, val));
            }
            else{
                intervals.get(0).start = val;
            }
            return;
        }
        
        int idx = binarySearch(intervals, val, 0, intervals.size() - 1);
        
        System.out.println("Adding " + val);
        if (val <= intervals.get(idx).end && val >= intervals.get(idx).start){
            return;
        }
        
        if (intervals.get(idx).end < val){
            idx ++;
        }
        if (intervals.get(idx - 1).end + 1 == val
             && intervals.get(idx).start - 1 == val){
            Interval newInterval = new Interval(intervals.get(idx - 1).start,
                                                 intervals.get(idx).end);
            intervals.remove(idx);
            intervals.set(idx - 1, newInterval);
        }
        else if (intervals.get(idx - 1).end + 1 == val){
            intervals.get(idx - 1).end  = val;
        }
        else if (intervals.get(idx).start - 1 == val){
            intervals.get(idx).start = val;
        }
        else{
            Interval newInterval = new Interval(val, val);
            intervals.add(idx, newInterval);
        }
    }
    
    public List<Interval> getIntervals() {
        return intervals;
    }
    
    private int binarySearch(List<Interval> intervals, int val, int start, int end){
        while (start < end){
            int mid = start + (end - start) / 2;
            if (val < intervals.get(mid).start){
                end = mid - 1;
                continue;
            }
            else if (val <= intervals.get(mid).end){
                return mid;
            }
            if (val > intervals.get(mid).end){
                start = mid + 1;
                continue;
            }
            else if (val >= intervals.get(mid).start){
                return mid;
            }
        }
        
        return start;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */