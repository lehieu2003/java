import com.sun.source.tree.WhileLoopTree;

import java.util.WeakHashMap;

public class DoublyLinkedList {
    private Link first;               // ref to first item
    private Link last;                // ref to last item
    // -------------------------------------------------------------
    public DoublyLinkedList()         // constructor
    {
        first = null;                  // no items on list yet
        last = null;
    }
    // -------------------------------------------------------------
    public boolean isEmpty()          // true if no links
    { return first==null; }
    // -------------------------------------------------------------
    public void insertFirst(long dd)  // insert at front of list
    {
// YOUR CODE STARTS HERE
        Link newLink = new Link(dd);
        if (isEmpty()) {
            last = newLink;  // the new link is also the last one
        } else {
            first.previous = newLink;
        }
        newLink.next = first;
        first = newLink;
// YOUR CODE ENDS HERE
    }
    // -------------------------------------------------------------
    public void insertLast(long dd)   // insert at end of list
    {
// YOUR CODE STARTS HERE
        Link newLink = new Link(dd);
        if (isEmpty()) {
            first = newLink;  // the new link is also the first one
        } else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
// YOUR CODE ENDS HERE
    }
    // -------------------------------------------------------------
    public Link deleteFirst()         // delete first link
    {                              // (assumes non-empty list)
// YOUR CODE STARTS HERE
        Link temp = first;
        if (first.next == null) {
            last = null;  // if there is only one link
        } else {
            first.next.previous = null;
        }
        first = first.next;
        return temp;

// YOUR CODE ENDS HERE
    }
    // -------------------------------------------------------------
    public Link deleteLast()          // delete last link
    {                              // (assumes non-empty list)
// YOUR CODE STARTS HERE
        Link temp = last;
        if (first.next == null) {
            first = null;  // if there is only one link
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
// YOUR CODE ENDS HERE
    }
    // -------------------------------------------------------------
    // insert dd just after key
    public boolean insertAfter(long key, long dd)
    {                              // (assumes non-empty list)
        Link current = first;          // start at beginning
        while(current.dData != key)    // until match is found,
        {
            current = current.next;     // move to next link
            if(current == null)
                return false;            // didn't find it
        }
        Link newLink = new Link(dd);   // make new link

        if(current==last)              // if last link,
        {
            newLink.next = null;        // newLink --> null
            last = newLink;             // newLink <-- last
        }
        else                           // not last link,
        {
            newLink.next = current.next; // newLink --> old next
            // newLink <-- old next
            current.next.previous = newLink;
        }
        newLink.previous = current;    // old current <-- newLink
        current.next = newLink;        // old current --> newLink
        return true;                   // found it, did insertion
    }
    // -------------------------------------------------------------
    public Link deleteKey(long key)   // delete item w/ given key
    {                              // (assumes non-empty list)
// YOUR CODE STARTS HERE
        Link current = first;
        while (current.dData != key) {
            current = current.next;
            if (current == null)
                return null;  // key not found
        }
        if (current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;
        }
        if (current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }
        return current;

// YOUR CODE ENDS HERE
    }
    // -------------------------------------------------------------
    public void displayForward()
    {
// YOUR CODE STARTS HERE
        System.out.print("List (forward): ");
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
// YOUR CODE ENDS HERE
    }
    // -------------------------------------------------------------
    public void displayBackward()
    {
// YOUR CODE STARTS HERE
        System.out.print("List (backward): ");
        Link current = last;
        while (current != null) {
            current.displayLink();
            current = current.previous;
        }
        System.out.println();
// YOUR CODE ENDS HERE
    }
    // ---------------------------------------------------------------
    public void mergeList(DoublyLinkedList list1, DoublyLinkedList list2){
        DoublyLinkedList mergeList = new DoublyLinkedList();

        Link current1 = list1.first;
        Link current2 = list2.first;

        while (current1 != null && current2 != null){
           if (current1.dData <= current2.dData){
               mergeList.insertLast(current1.dData);
                current1 = current1.next;
           }else {
               mergeList.insertLast(current2.dData);
               current2 = current2.next;
           }
        }

        while (current1 != null){
            mergeList.insertLast(current1.dData);
            current1 = current1.next;
        }

        while (current2 != null){
            mergeList.insertLast(current2.dData);
            current2 = current2.next;
        }
        mergeList.displayForward();
    }
    public void selectionSort(){
        Link current = first;
        while (current != last){
            Link min = current;
            Link j  = current.next;
            while (j != null){
                if (j.dData < min.dData){
                    min = j;
                }
                j = j.next;
            }
            if (min != current){
                long temp = current.dData;
                current.dData = min.dData;
                min.dData = temp;
            }
            current = current.next;
        }
    }
    public void bubbleSort(){
        Link current = first;
        while (current != last){
            Link j = current.next;
            while (j != null){
                if (j.dData < current.dData){
                    long temp = current.dData;
                    current.dData = j.dData;
                    j.dData = temp;
                }
                j = j.next;
            }
            current = current.next;
        }
    }
    public void insertionSort() {
        Link current = first.next;
        while (current != null) {
            long currentData = current.dData;
            Link j = current;
            while (j.previous != null && j.previous.dData > currentData) {
                j.dData = j.previous.dData;
                j = j.previous;
            }
            j.dData = currentData;
            current = current.next;
        }
    }
}
