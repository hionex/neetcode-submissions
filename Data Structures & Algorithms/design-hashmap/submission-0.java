class MyHashMap {

    private class Node {
        int hash;
        int key;
        int value;
        Node next;

        Node(int key, int value, int hash){
            this.key = key;
            this.value = value;
            this.hash = hash;
        }
    }

    private Node[] table;
    private int size;
    private int capacity = 4;
    private final double loadFactor = 0.75;

    public MyHashMap() {
        table = new Node[capacity];
        size = 0;
    }
    
    public void put(int key, int value) {
        if(size >= loadFactor * capacity) resize();

        int hashCode = hash(key);
        int index = hashCode & (capacity - 1);

        if(table[index] == null){
            table[index] = new Node(key, value, hashCode);
            size++;
        }

        Node curr = table[index];
        Node prev = null;

        while (curr != null) {
            if (curr.hash == hashCode && curr.key == key) {
                curr.value = value;
                return; 
            }
            prev = curr;
            curr = curr.next;
        }

        prev.next = new Node(key, value, hashCode);
        size++;
    }
    
    public int get(int key) {
        int hashCode = hash(key);
        int index = hashCode & (capacity - 1);

        Node curr = table[index];

        while(curr != null){
            if(curr.hash == hashCode && curr.key == key){
                return curr.value;
            }
            
            curr = curr.next;
        }

        return -1;
    }
    
    public void remove(int key) {
        int hashCode = hash(key);
        int index = hashCode & (capacity - 1);

        Node curr = table[index];
        Node prev = null;

        while (curr != null) {
            if (curr.hash == hashCode && curr.key == key) {
                if (prev == null) {
                    table[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                size--;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    private int hash(int key){
        return key ^ (key >> 16);
    }

    private void resize() {
        int oldCap = capacity;
        int newCap = oldCap * 2;
        Node[] newTable = new Node[newCap];

        for (int i = 0; i < oldCap; i++) {
            Node curr = table[i];
            if (curr == null) continue;

            Node loHead = null, loTail = null;
            Node hiHead = null, hiTail = null;
            Node next;

            while (curr != null) {
                next = curr.next;
                
                if ((curr.hash & oldCap) == 0) {
                    if (loTail == null) loHead = curr;
                    else loTail.next = curr;
                    loTail = curr;
                } else {
                    if (hiTail == null) hiHead = curr;
                    else hiTail.next = curr;
                    hiTail = curr;
                }
                curr = next;
            }

            if (loTail != null) {
                loTail.next = null;
                newTable[i] = loHead;
            }
            if (hiTail != null) {
                hiTail.next = null;
                newTable[i + oldCap] = hiHead;
            }
        }
        table = newTable;
        capacity = newCap;
    }

}
