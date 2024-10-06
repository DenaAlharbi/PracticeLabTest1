//**************************  SLL.java  *********************************
//           a generic singly linked list class 
//Task 2 from the singly linked list lab

public class SLL<T> {
    public static void main(String[] args) {
        SLL<String> myList = new SLL<String>();
        String[] cityNames = {"Jubail", "Riyadh", "Abha", "Dammam", "Taif"};
        for(int i = 0; i < cityNames.length; i++)
            myList.addToHead(cityNames[i]);

        System.out.println("Original list: " + myList);
        System.out.println("Element deleted from head: " + myList.deleteFromHead());
        System.out.println("Modified list: " + myList);
        System.out.println("It is " + myList.contains("Dammam") + " that the list contains Dammam.");
        myList.insertBefore(0, "kk");
        System.out.println("list with insert before: " + myList);
        myList.delete(1);
        System.out.println("list with delete: " + myList);
        SLL<Integer> myList2 = new SLL<Integer>();
        myList2.addToHead(9);        myList2.addToHead(7);        myList2.addToHead(50);        myList2.addToHead(3);        myList2.addToHead(5);        myList2.addToHead(7);
        System.out.println("Original list: " + myList2);
        myList2.insertAfterSecondOccurrence(30,7);
        System.out.println("After inserting 30 after the second occurance of 7: " + myList2);







    }
    private class SLLNode<T> {
        private T info;
        private SLLNode<T> next;
        public SLLNode() {
            this(null,null);
        }
        public SLLNode(T el) {
            this(el,null);
        }
        public SLLNode(T el, SLLNode<T> ptr) {
            info = el; next = ptr;
        }
    }

    protected SLLNode<T> head, tail;
    public SLL() {
        head = tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void addToHead(T el) {
        head = new SLLNode<T>(el,head);
        if (tail == null)
            tail = head;
    }
    public void addToTail(T el) {
        if (!isEmpty()) {
            tail.next = new SLLNode<T>(el);
            tail = tail.next;
        }
        else head = tail = new SLLNode<T>(el);
    }
    public T deleteFromHead() { // delete the head and return its info; 
        if (isEmpty())
            return null;
        T el = head.info;
        if (head == tail)       // if only one node on the list;
            head = tail = null;
        else head = head.next;
        return el;
    }
    public T deleteFromTail() { // delete the tail and return its info;
        if (isEmpty())
            return null;
        T el = tail.info;
        if (head == tail)       // if only one node in the list;
            head = tail = null;
        else {                  // if more than one node in the list,
            SLLNode<T> tmp;    // find the predecessor of tail;
            for (tmp = head; tmp.next != tail; tmp = tmp.next);
            tail = tmp;        // the predecessor of tail becomes tail;
            tail.next = null;
        }
        return el;
    }
    public void delete(T el) {  // delete the node with an element el;
        if (!isEmpty())
            if (head == tail && el.equals(head.info)) // if only one
                head = tail = null;       // node on the list;
            else if (el.equals(head.info)) // if more than one node on the list;
                head = head.next;    // and el is in the head node;
            else {                    // if more than one node in the list
                SLLNode<T> pred, tmp;// and el is in a nonhead node;
                for (pred = head, tmp = head.next;
                     tmp != null && !tmp.info.equals(el);
                     pred = pred.next, tmp = tmp.next);
                if (tmp != null) {   // if el was found;
                    pred.next = tmp.next;
                    if (tmp == tail) // if el is in the last node;
                        tail = pred;
                }
            }
    }

    @Override
    public String toString() {
        if(head == null)
            return "[ ]";
        String str = "[ ";
        SLLNode<T> tmp = head;
        while(tmp != null){
            str += tmp.info + " ";
            tmp = tmp.next;
        }
        return str+"]";
    }

    public boolean contains(T el) {
        if(head == null)
            return false;
        SLLNode<T> tmp = head;
        while(tmp != null){
            if(tmp.info.equals(el))
                return true;
            tmp = tmp.next;
        }
        return false;
    }

    public int size(){
        if(head == null)
            return 0;

        int count = 0;
        SLLNode<T> p = head;
        while(p != null) {
            count++;
            p = p.next;
        }

        return count;
    }

    //  Please write the methods of Task02 here:
    public void insertBefore(int index, T newElem) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        SLLNode<T> newNode = new SLLNode<>(newElem);

        // If inserting before the first element
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        SLLNode<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }
    public T delete(int index){
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        SLLNode<T> tmp = new SLLNode<>();

        if (index == 0) {
            T info = head.info;
            head = head.next;
            return info;
        }

        SLLNode<T> current = head;
        tmp= head.next;
        for (int i = 1; i < index; i++) {
            current = current.next;
            tmp = tmp.next;
        }
        T info = tmp.info;

        current.next= tmp.next;
        return info;
    }
    public void insertAfterSecondOccurrence(T e1Insert, T e2){
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        SLLNode<T> newNode = new SLLNode<>(e1Insert);


        SLLNode<T> current = head;
        int i = 0;

        for (int r = 0; r < size() && i!=2; r++) {
            if(e2.equals(current.info))
                i++;
            if(i!=2)
                current = current.next;
        }
        if(i == 2){
            newNode.next= current.next;
            current.next = newNode;

        }else
            throw new IllegalArgumentException("doesnt have another occurrence");

    } //Another way to do it
    public void insertAfterSecondOccurrence2(T e1, T e2) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }

        SLLNode<T> current = head;
        int count = 0;

        // Traverse the list to find the second occurrence of e2
        while (current != null) {
            if (current.info.equals(e2)) {
                count++;
                if (count == 2) {
                    break;
                }
            }
            current = current.next;
        }

        // If there is no second occurrence of e2
        if (count < 2) {
            throw new IllegalArgumentException("No second occurrence of the specified element");
        }

        // Insert the new element after the second occurrence of e2
        SLLNode<T> newNode = new SLLNode<>(e1);
        newNode.next = current.next;
        current.next = newNode;
    }

}