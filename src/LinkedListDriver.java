import java.util.LinkedList;
//Task 1 from the singly linked list lab

class LinkedListDriver {
    public static void main(String[] args) {
        LinkedList<String> stringList = new LinkedList<>();

        stringList.add("Madinah");
        stringList.add("Dammam");
        stringList.add("Riyadh");
        stringList.add("Dhahraan");

        System.out.println("List: " + stringList);

        int index = stringList.indexOf("Riyadh");
        if(index == -1)
            System.out.println("Riyadh is not in the list");
        else{
            stringList.add(index + 1, "Jubail"); // insert Jubail after Riyadh
            stringList.addFirst("Najraan");   // insert Najraan at the beginning
        }

        System.out.println("List: " + stringList);

        index = stringList.indexOf("Dhahraan");
        if(index == -1)
            System.out.println("Dhahraan is not in the list");
        else
            stringList.set(index, "Abha");   // replace Dhahran with Abha

        String removedString = stringList.removeFirst();
        System.out.println("Removed Element: " + removedString);
        stringList.addFirst("Taif");
        System.out.println("Updated list: " + stringList);

        // Add code that will insert "Tabouk" before "Dammam", display error message if
        // "Dammam" is not in list or if the list is empty. Your code must work for any
        // two strings str1 and str2.
        int indexOfDAmmam = stringList.indexOf("Dammam");
        if(indexOfDAmmam ==-1 || stringList.isEmpty()){
            System.out.println("Error");
        }
        else
            stringList.add(indexOfDAmmam ,"Tabouk");
        System.out.println(stringList);





        // Add code that will insert "AlKhafj" before the last node, your code must work
        // for any non-empty list. Display an error message if the list is empty.


        if(stringList.isEmpty())
            System.out.println("Empty");
        else
            stringList.add(stringList.size() - 1, "AlKhafj");

        System.out.println("Updated list2: " + stringList);



    }
}
// notes from the linked list file
/*public static void main(String args[]){ ----------using iterator--------
    LinkedList<String> list = new LinkedList<>();
    list.add("Riyadh");list.add("Dammam"); list.add("Jubail");
    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()) {
        System.out.print(iterator.next() + " ");
    }

    for(String cityName : list) { --------going through a list-------
        System.out.print(cityName + " ");
     }

}*/

/* ------methods in linked lists ---------
void addLast(E e)
addFirst(E e)
void add(int index, E element)

E removeFirst()
E removeLast()
E remove(int index)
boolean removeFirstOccurrence(Object o)
boolean removeLastOccurrence(Object o)

int indexOf(Object o)
int lastIndexOf(Object o)
boolean contains(Object o)

E set(int index, E element)
Iterator<E> iterator()
void clear()
Object[] toArray()
 */