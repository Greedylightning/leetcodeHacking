public class Hash<K, V>{

    private static class LinkedListNode<K,V>{
        public LinkedListNode<K, V> prev;
        public LinkedListNode<K, V> next;
        public K key;
        public V value;

        pubblic LinkedListNode(K k, V v){
            key = k;
            value = v;
        }
    }

    private ArrayList<LinkedListNode<K, V>> array;

    public Hash(int capacity){
        array = new ArrayList<LinkedListNode<K,V>>();
        for(int i = 0; i < capacity; i++){
            array.add(null);
        }
    }

    public V put(K key, V value){
        LinkedListNode<K, V> node = getNodeForKey(key);
        if(node != null){
            V oldValue = node.value;
            node.value = value;
            return oldValue;
        }

        node = new LinkedListNode<K, V>(key, value);
        int index = getIndexForKey(key);
        if(array.get(index) != null){
            node.next = array.get(index);
            node.next.prev = node;
        }
        array.set(index, node);
        return null;
    }
}

public V remove(K key){
    LinkedListNode node = getNodeForKey(key);
    if(node == null) return null;
    if(node.prev != null){
        node.prev.next = node.next;
    }
    else{
        int hashKey = getIndexForKey(key);
        array.set(hashKey, node.next);
    }
    if(node.next != null){
        node.next.prev = node.prev;
    }
    return node.value;
}

public V get(K key){
    LinkedListNode node = getNodeForKey(key);
    if(node == null) return null;
    return node.value;
}

public LinkedListNode<K, V> getNodeForKey(K key){

    int index = getIndexForKey(key);
    LinkedListNode<K, V> current = array.get(index);
    while(current != null){
        if(current.key == key) return current;
        current = current.next;
    }
    return null;
}

public int getIndexForKey(K key){
    return Math.abs(key.hashCode() % array.size());
}