/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hw8;

/**
 * This is an example of priority queue class
 * High priority items have low 'prio' value, i.e. ("str1", 0) > ("str2", 1)
 * @author Author
 */
public class MyPriorityQueue<T> {
    
    /**
     * Constructor
     */
    public MyPriorityQueue() {
        head = new QueueElement(); 
    }

    /**
     * Add item to queue
     * @param val value to add
     * @param prio priority of element
     */
    public void enqueue(T val, int prio) {
        QueueElement cur = head;
        while (cur.getNext() != null && cur.getNext().getPrio() < prio) {
            cur = cur.getNext();
        }
        QueueElement tmp = new QueueElement(val, prio);
        tmp.setNext(cur.getNext());
        cur.setNext(tmp);
    }

    /**
     * Get item from queue with least priority
     * @return value of deleted element
     * @throws Exception if queue is empty
     */
    public T dequeue() throws EmptyQueueException {
        if (head.getNext() == null)
            throw new EmptyQueueException();
        QueueElement tmp = head.getNext();
        head.setNext(tmp.getNext());
        return tmp.getValue();
    }

    private QueueElement head;
    
    private class QueueElement {
        
        /**
         * Constructor
         */
        public QueueElement() {}
        
        /**
         * Yet another constructor
         * @param val value
         * @param priority priority
         */
        public QueueElement(T val, int priority) {
            next = null;
            value = val;
            prio = priority;
        }
        
        /**
         * 
         * @return next QueueElement
         */
        public QueueElement getNext() {
            return next;
        }
        
        /**
         * Set next QueueElement
         * @param nxt element
         */
        public void setNext(QueueElement nxt) {
            next = nxt;
        }
        
        /**
         * 
         * @return value of QueueElement
         */
        public T getValue() {
            return value;
        }
        
        /**
         * 
         * @return priority of QueueElement
         */
        public int getPrio() {
            return prio;
        }
        
        private T value;           
        private QueueElement next;  
        private int prio;      
    }
}