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
    List<Integer> list = new ArrayList<Integer>();
    Iterator<Integer> ite;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInt : nestedList){
            flatten(nestedInt);
        }
        ite = list.iterator();
    }
    
    private void flatten(NestedInteger nestedInt){
        if (nestedInt.isInteger()){
            list.add(nestedInt.getInteger());
        }else{
            List<NestedInteger> nestedList = nestedInt.getList();
            for (NestedInteger nested : nestedList){
                flatten(nested);
            }
        }
    }

    @Override
    public Integer next() {
        return ite.next();
    }

    @Override
    public boolean hasNext() {
        return ite.hasNext();
    }
 
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */