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
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1){
            return intervals;
        }
        List<Interval> result = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        Interval cur = new Interval(intervals.get(0).start, intervals.get(0).end);
        for (int idx = 1 ; idx < intervals.size() ; idx ++){
            Interval interval = intervals.get(idx);
            if (cur.end >= interval.start){
                cur.end = Math.max(cur.end, interval.end);
            }
            else{
                result.add(cur);
                cur = new Interval(interval.start, interval.end);
            }
        }
        result.add(cur);
        return result;
    }
}