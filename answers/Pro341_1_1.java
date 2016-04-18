/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack = new Stack<NestedInteger>();
    private NestedInteger curInt;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        push(nestedList);
    }

    @Override
    public Integer next() {
        return curInt.getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()){
            curInt = stack.pop();
            if (curInt.isInteger()){
                return true;
            }
            push(curInt.getList());
        }
        return false;
    }
    
    private void push(List<NestedInteger> list){
        for (int nIdx = list.size() - 1; nIdx >= 0; nIdx --){
            stack.push(list.get(nIdx));            
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */