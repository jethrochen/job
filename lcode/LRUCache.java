class Entry<int, int> {
	public Entry pre;
	public Entry next;
	public int key;
	public int val;
}

public class LRUCache<int, int> {
	public int capacity;
	public int curSize;
	public HashMap<int, int> nodes;
	public Entry first;
	public Entry last;

	public LRUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.nodes = new HashMap<>(capacity, 0.75f);
        this.first = null;
        this.last = null;
    }
    
    public int get(int key) {
        Entry node = nodes.get(key);
        if (node == null) {
        	return -1;
        } else {
        	moveToHead(node);
        	return node.val;
        }
    }
    
    public void set(int key, int value) {
        Entry node = nodes.get(key);
        if (node == null) {
        	if (curSize >= capacity) {
        		removeLRU();
        	} else {
        		curSize++;
        	}
        	node = new Entry;
        	node.key = key;
        	node.val = value;
        	node.put(key, node);
        	moveToHead(node);
        } else {
        	node.val = value;
        	moveToHead(node);
        }
    }

    public void moveToHead(Entry node) {
    	node.pre.next = node.next;
    	node.next.pre = node.pre;
    	node.pre = null;
    	node.next = first;
    	first = node;
    }

    private void removeLRU() {
    	last = last.pre;
    	last.next = null;
    }
}