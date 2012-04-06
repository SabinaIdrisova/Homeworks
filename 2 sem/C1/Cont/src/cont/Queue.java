package cont;

public class Queue<T>  {
    
    /**
     * Add value with priority to queue (1 - the highest priority)
     * @param value value to add
     * @param priority priority
     */
    public void enqueue(T value, int priority) {
        if (isEmpty()) {
            QueueElement newEl = new QueueElement(value, priority, first);
            first = newEl;
        }
        else {
            QueueElement cur = first;
            if (priority <= cur.priority) {
                QueueElement newEl = new QueueElement(value, priority, first);
                first = newEl;
            }
            else {
                while ((cur.priority < priority) && (cur.next != null)) 
                    cur = cur.next;
                if (cur.next == null && cur.priority < priority) {
                    QueueElement newEl = new QueueElement(value, priority, null);
                    cur.next = newEl;
                }
                else {
                    QueueElement temp = previous(cur);
                    QueueElement newEl = new QueueElement(value, priority, cur);
                    temp.next = newEl;
                }
            }
        }
    }
        
    /**
     * Delete value with the highest priority
     * @return value with the highest priority
     * @throws EmptyQueueException throws an exception if the queue is empty
     */
    public T dequeue() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException();
        T result = first.value;
        first = first.next;
        return result;  
    }
    
    /**
     * Print the queue 
     * @throws EmptyQueueException throws an exception if the queue is empty
     */
    public void print() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException();
        QueueElement cur = first;
        while (cur != null) {
           System.out.println("value = " + cur.value + " priority = " + cur.priority);
           cur = cur.next; 
        }       
    }

    /**
     * Check the queue is empty
     * @return true if queue is empty, false if queue isn't empty
     */
    public boolean isEmpty() {
        return first == null;
    }
    
    /**
     * Previous element
     * @param el element
     * @return previous element
     */
    public QueueElement previous(QueueElement el) {
        QueueElement cur = first;
        while (cur.next!= el) {
            cur = cur.next;             
        }
        return cur;
    }
    
    private QueueElement first = null;
    
    private class QueueElement {
    
        public QueueElement(T value, int priority, QueueElement next) {
            this.value = value;
            this.priority = priority;
            this.next = next;
        }
    
        private int priority;
    
        private T value;
    
        private QueueElement next;
    }
}
