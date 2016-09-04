public class RandomizedCollection {
    static int MAX_LENGTH = 1000000;
    int[] elements;
    int size;
    HashMap<Integer, Set<Integer>> positions
     = new HashMap<Integer, Set<Integer>>();
    Random rand = new Random();
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        elements = new int[MAX_LENGTH];
        size = 0;
    }
    
    /** Inserts a value to the collection.
     Returns true if the collection did not
      already contain the specified element. */
    public boolean insert(int val) {
        boolean result = true;
        if (positions.containsKey(val)){
            result = false;
        }
        Set<Integer> poss = positions.containsKey(val)
         ? positions.get(val) : new HashSet<Integer>();
        poss.add(size);
        positions.put(val, poss);
        elements[size++] = val;
        
        return result;
    }
    
    /** Removes a value from the collection.
     Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!positions.containsKey(val)){
            return false;
        }        
        // pick one position
        Set<Integer> poss = positions.get(val);
        if (poss.isEmpty()){
            return false;
        }
        Iterator<Integer> ite = poss.iterator();
        int position = ite.next();
        while (ite.hasNext()){
            position = ite.next();
        }
        
        // swap 
        if (position != size - 1){
            Set<Integer> swapPoss = positions.get(elements[size - 1]);
            swapPoss.remove(size - 1);
            swapPoss.add(position);
            positions.put(elements[size - 1], swapPoss);
            
            int swap = elements[position];
            elements[position] = elements[size - 1];
            elements[size - 1] = swap;
        }
        size --;
        poss.remove(position);
        if (poss.size() == 0){
            positions.remove(val);    
        }
        else{
            positions.put(val, poss);
        }
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {  
        int idx = rand.nextInt(size);
        return elements[idx]; 
    }

}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */