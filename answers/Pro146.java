class CacheEntry{
    int value, key;
    CacheEntry pre, next;
    public CacheEntry(int key, int value){
        this.key = key;
        this.value = value;
    }
}
public class LRUCache {
    CacheEntry dummyHead;
    CacheEntry dummyTail;
    int capacity;
    int curSize;
    HashMap<Integer, CacheEntry> map = new HashMap<Integer, CacheEntry>();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        curSize = 0;
        dummyHead = new CacheEntry(-1 , -1);
        dummyTail = new CacheEntry(-1 , -1);
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }
    
    public int get(int key) {
        if (map.containsKey(key)){
            CacheEntry entry = map.get(key);
            moveToHead(entry);
            
            return entry.value;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)){
            CacheEntry entry = map.get(key);
            entry.value = value;
            moveToHead(entry);
            map.put(key, entry);
        }else{
            CacheEntry entry = new CacheEntry(key, value);
            if (curSize < capacity){
                curSize ++;
                addToHead(entry);
            }   
            else{
                map.remove(dummyTail.pre.key);
                removeEntry(dummyTail.pre);
                addToHead(entry);
            }
            map.put(key, entry);
        }
    }
    
    private void moveToHead(CacheEntry node){
        removeEntry(node);
        addToHead(node);
    }
    private void removeEntry(CacheEntry node){
        // remove node
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }
    private void addToHead(CacheEntry node){
        node.next = dummyHead.next;
        dummyHead.next.pre = node;
        node.pre = dummyHead;
        dummyHead.next = node;
    }
}