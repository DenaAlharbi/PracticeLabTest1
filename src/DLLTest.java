import java.util.Random;

//Second lab
public class DLLTest {
    public static void main(String[] args) {
        DLL<String> test = new DLL<String>();
        for (int i = 1; i < 8; i++)
            test.addToTail(String.valueOf(i));
        test.printAll();
        test.delete7();

        test.printAll();

        DLL<String> test1 = new DLL<String>();
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            int tmp = rand.nextInt(100) + 1;
            test1.addToTail(String.valueOf(tmp));
        }

        System.out.println("\nThe output of the insertAlternate method");
        test1.printAll();

        test.insertAlternate(test1);
        test.printAll();

    }

    public static class DLLNode<T> {
        public T info;
        public DLLNode<T> next, prev;

        public DLLNode() {
            next = null;
            prev = null;
        }

        public DLLNode(T el) {
            info = el;
            next = null;
            prev = null;
        }

        public DLLNode(T el, DLLNode<T> n, DLLNode<T> p) {
            info = el;
            next = n;
            prev = p;
        }
    }

    public static class DLL<T> {

        private DLLNode<T> head, tail;

        public DLL() {
            head = tail = null;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public void setToNull() {
            head = tail = null;
        }

        public T firstEl() {
            if (head != null)
                return head.info;
            else return null;
        }

        public void addToHead(T el) {
            if (head != null) {
                head = new DLLNode<T>(el, head, null);
                head.next.prev = head;
            } else head = tail = new DLLNode<T>(el);
        }

        public void addToTail(T el) {
            if (tail != null) {
                tail = new DLLNode<T>(el, null, tail);
                tail.prev.next = tail;
            } else head = tail = new DLLNode<T>(el);
        }

        public T deleteFromHead() {
            if (isEmpty())
                return null;
            T el = head.info;
            if (head == tail)   // if only one node on the list;
                head = tail = null;
            else {              // if more than one node in the list;
                head = head.next;
                head.prev = null;
            }
            return el;
        }

        public T deleteFromTail() {
            if (isEmpty())
                return null;
            T el = tail.info;
            if (head == tail)   // if only one node on the list;
                head = tail = null;
            else {              // if more than one node in the list;
                tail = tail.prev;
                tail.next = null;
            }
            return el;
        }

        public void printAll() {
            for (DLLNode<T> tmp = head; tmp != null; tmp = tmp.next)
                System.out.print(tmp.info + " ");
            System.out.println();
        }

        public T find(T el) {
            DLLNode<T> tmp;
            for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next) ;
            if (tmp == null)
                return null;
            else return tmp.info;
        }

        public void printReverse() {
            for (DLLNode<T> tmp = tail; tmp != null; tmp = tmp.prev)
                System.out.print(tmp.info + " ");

        }

        public int size() {
            if (head == null)
                return 0;

            int count = 0;
            DLLNode<T> p = head;
            while (p != null) {
                count++;
                p = p.next;
            }

            return count;
        }

        //Go back to this
        public void delete7() {
            DLLNode<T> h = head;
            int count = 1;

            while (h != null && count < 7) {
                count++;
                h = h.next;
            }

            if (count == 7 && h != null) {
                if (h.prev != null) {
                    h.prev.next = h.next;
                } else {
                    head = h.next;
                }
                if (h.next != null) {
                    h.next.prev = h.prev;
                }
            } else {
                DLLNode<T> p = tail;

                while (p.prev != null&& count!=7) {
                    p = p.prev;
                    count++;
                }
                p.prev.next = p.next;

                p.next.prev = p.prev;

            }
        }



        public void insertAlternate(DLL<T> newList) {
            DLLNode<T> current1 = head;
            DLLNode<T> current2 = newList.head;

            while (current1 != null && current2 != null) {
                DLLNode<T> next1 = current1.next;
                DLLNode<T> next2 = current2.next;

                current1.next = current2;
                current2.prev = current1;

                if (next1 != null) {
                    current2.next = next1;
                    next1.prev = current2;
                }

                current1 = next1;
                current2 = next2;
            }

            if (current2 != null) {
                if (current1 == null) {
                    head = newList.head;
                } else {
                    current1.next = current2;
                    current2.prev = current1;
                }
            }
        }



    }
}
