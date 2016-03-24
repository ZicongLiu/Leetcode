public class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap =
     new PriorityQueue<Integer>(10000, new Comparator<Integer>(){
        @Override
        public int compare(Integer x, Integer y){
            return y - x;
        }
    });
    // Adds a number into the data structure.
    public void addNum(int num) {
        if (minHeap.size() == maxHeap.size()){
            maxHeap.offer(num);
        }
        else{
            minHeap.offer(num);
        }
        if (!minHeap.isEmpty() && (maxHeap.peek() > minHeap.peek())){
            minHeap.offer(maxHeap.poll());
            maxHeap.offer(minHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if ((minHeap.size() + maxHeap.size()) % 2 == 0){
            return (maxHeap.peek() + minHeap.peek()) * 1.0 / 2;
        }
        else{
            return maxHeap.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();