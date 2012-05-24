package hw9t2;

import java.util.ArrayList;

public class BTree {
    
    /**
     * Constructor
     * @param order order
     */
    public BTree(int order) {
        this.minKeySize = order;
        this.minChildrenSize = minKeySize + 1;
        this.maxKeySize = 2 * order;
        this.maxChildrenSize = maxKeySize + 1;
    }
    
    /**
     * Add element to BTree
     * @param key key
     * @param value value of element
     */
    public void add(int key, int value) {
         if (root == null) {
             root = new Node(null, maxKeySize, maxChildrenSize);
             root.addEl(key, value);
         } else {
             Node node = root;
             while (node != null) {
                if (node.numberOfChildren() == 0) {
                    node.addEl(key, value);
                    if (node.numberOfKeys() <= maxKeySize) {
                        break;
                    } else {
                        split(node);
                        break;
                    }
                } else {
                    if (key < node.getKey(0)) {
                        node = node.getChild(0);
                        continue;
                    }
                    if (key > node.getKey(node.numberOfKeys() - 1)) {
                        node = node.getChild(node.numberOfKeys());
                        continue;
                    }
                    for (int i = 1; i < node.numberOfKeys(); i++) {
                        if (key > node.getKey(i - 1) && key < node.getKey(i)) {
                            node = node.getChild(i);
                            break;
                        }
                    }
                }
            }
         }
         size++;
     }
     
     /**
      * Divide the node
      * @param node node
      */
     public void split(Node node) {
         int size = node.numberOfKeys();
         int medianIndex = size / 2;
         int medianKey = node.getKey(medianIndex);
         int medianValue = node.getValue(medianIndex);
         Node left = new Node(null, maxKeySize, maxChildrenSize);
         for (int i = 0; i < medianIndex; i++) {
             left.addEl(node.getKey(i), node.getValue(i));
         }
         if (node.numberOfChildren() > 0) {
             for (int j = 0; j <= medianIndex; j++) {
                 Node c = node.getChild(j);
                 left.addChild(c);
             }
         }
         Node right = new Node(null, maxKeySize, maxChildrenSize);
         for (int i = medianIndex + 1; i < size; i++) {
             right.addEl(node.getKey(i), node.getValue(i));
         }
         if (node.numberOfChildren() > 0) {
             for (int j = medianIndex + 1; j < node.numberOfChildren(); j++) {
                 Node c = node.getChild(j);
                 right.addChild(c);
             }
         }
         if (node.parent == null) {
             Node newRoot = new Node(null, maxKeySize, maxChildrenSize);
             newRoot.addEl(medianKey, medianValue);
             node.parent = newRoot;
             root = newRoot;
             node = root;
             node.addChild(left);
             node.addChild(right);
         } else {
             Node parent = node.parent;
             parent.addEl(medianKey, medianValue);
             parent.removeChild(node);
             parent.addChild(left);
             parent.addChild(right);
             if (parent.numberOfKeys() > maxKeySize) 
                 split(parent);
         }   
     }
     
     /**
      * Find the value by the key
      * @param node node
      * @param key key
      * @return value
      */
     public int search(Node node, int key) {
         if (node.exist(key))
             return node.findValue(key);
         else {
             for (int i = 0; i < node.keysSize; i++) {
                 if (key < node.getKey(i)) {
                     node = node.getChild(i);
                     return search(node, key);
                 }
             }   
             if (key > node.getKey(node.numberOfKeys() - 1)) {
                 node = node.getChild(node.numberOfKeys());
                 return search(node, key);
             }
         }
         return 0; 
     }
     
     /**
      * Root of the tree
      * @return root
      */
     public Node getRoot() {
        return root;
     }
      
     private int minKeySize;
     private int minChildrenSize;
     private int maxKeySize;
     private int maxChildrenSize;
     private Node root;
     private int size = 0;
     
     public static class Node {
         
         public Node(Node parent, int maxKeySize, int maxChildrenSize) {
             this.parent = parent;
             this.keys =  new ArrayList<Entry>(maxKeySize + 1);
             this.keysSize = 0;
             this.children = new Node[maxChildrenSize + 1];
             this.childrenSize = 0;
         }        
        
         public int getKey(int index) {
             return keys.get(index).key;
         }
         
         public int getValue(int index) {
             return  keys.get(index).value;
         }

         public boolean exist(int key) {
             for (int i = 0; i < keysSize; i++) {
                 if (keys.get(i).key == key)
                     return true;;
             }
             return false;
         }
         
         public int findValue(int key) {
             for (int i = 0; i < keysSize; i++) {
                 if (keys.get(i).key == key) 
                     return keys.get(i).value;;
             }
             return 0;
         }
         
         public void addEl(int key, int value) {
             keys.add(new Entry(key, value));
             keysSize++;
             for (int i = 0; i < keys.size() - 1; i++) {
                 for (int j = i; j < keys.size(); j++) {
                     if (keys.get(i).key > keys.get(j).key) {
                         Entry temp = keys.get(j);
                         keys.set(j, keys.get(i));
                         keys.set(i, temp);
                     }
                 }
             }
         } 
         
         public int numberOfKeys() {
             return keysSize;
         }

         public Node getChild(int index) {
             if (index >= childrenSize) 
                 return null;
             return children[index];
         }
        
         public boolean addChild(Node child) {
             child.parent = this;
             children[childrenSize++] = child;
             return true;
         }
        
         public boolean removeChild(Node child) {
             boolean found = false;
             if (childrenSize == 0) 
                 return found;
             for (int i = 0; i < childrenSize; i++) {
                 if (children[i].equals(child)) {
                     found = true;
                 } else if (found) {
                     children[i - 1] = children[i];
                 }
             }
             if (found) {
                 childrenSize--;
                 children[childrenSize] = null;
             }
             return found;
         }
        
         public int numberOfChildren() {
             return childrenSize;
         }
           
         private int childrenSize = 0;
         private Node[] children = null;
         private ArrayList<Entry> keys;
         private int keysSize = 0;
         private Node parent = null;
     }

     private static class Entry {

        public Entry(int key, int value) {
            this.key   = key;
            this.value = value;
        }
        
        private int key; 
        private int value;
    }   
}
