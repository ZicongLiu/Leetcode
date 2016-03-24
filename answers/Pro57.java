/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals.size() == 0){
            result.add(newInterval);
            return result;
        }
        Interval compare = new Interval(newInterval.start, newInterval.end);
        int endIdx = -1;
        for (int i = 0 ; i < intervals.size() ; i ++){
            Interval cur = intervals.get(i);
            if (cur.end < compare.start){
                result.add(cur);
            }
            else if (cur.start > compare.end){
                endIdx = i;
                break;
            }
            else{
                compare.start = Math.min(compare.start, cur.start);
                compare.end = Math.max(compare.end, cur.end);
            }
        }
        result.add(compare);
        if (endIdx != -1){
            for (int i = endIdx ; i < intervals.size() ; i ++){
                result.add(intervals.get(i));
            }
        }
        return result;
    }
}