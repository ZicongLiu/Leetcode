public class RandomizedSet {
    static int MAX_LENGTH = 1000000;
    int[] elements;
    int size;
    HashMap<Integer, Integer> positions = new HashMap<Integer, Integer>();
    Random rand = new Random();;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        elements = new int[MAX_LENGTH];
        size = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set
     did not already contain the specified element. */
    public boolean insert(int val) {
        if (positions.containsKey(val)){
            return false;
        }
        positions.put(val, size);
        elements[size++] = val;
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set
     contained the specified element. */
    public boolean remove(int val) {
        if (!positions.containsKey(val)){
            return false;
        }        
        // swap 
        int position = positions.get(val);
        if (position != size - 1){
            positions.put(elements[size - 1], position);
            int swap = elements[position];
            elements[position] = elements[size - 1];
            elements[size - 1] = swap;
        }
        size --;
        
        positions.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int idx = rand.nextInt(size);
        return elements[idx];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */