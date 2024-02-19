import java.util.List;

public class LinkedList {
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static LinkedList insert(LinkedList list, int data){
        Node newNode = new Node(data);
        if (list.head == null){
            list.head = newNode;
        }else {
            Node currentNode = list.head;
            while (currentNode.getNext() != null){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
        return list;
    }


    public static String printList(LinkedList list){
        int size = 0;
        Node currentNode = list.head;
        while (currentNode != null){
            size++;
            currentNode = currentNode.getNext();
        }

        if (size == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder(size);
            sb.append("[");
            Node newNode = list.head;
            while (newNode != null) {
                sb.append(newNode.getData());
                if (newNode.getNext() != null){
                    sb.append(",");
                }
                newNode = newNode.getNext();
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static LinkedList deleteByKey(LinkedList list, int key){
        Node currentNode = list.head;
        Node prevNode = null;

        // case 1: neu can xoa o dau list
        if (currentNode != null && currentNode.data == key){
            list.head = currentNode.getNext();
            System.out.println(key+ " found and deleted");
            return list;
        }

        // case 2: node can xoa o dau do middle list

        while (currentNode != null && currentNode.data != key){
            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }

        if (currentNode != null){
            prevNode.next = currentNode.next;
            System.out.println(key + " found and deleted");
        }

        // case 3: node can xoa ko co trong list

        if (currentNode == null){
            System.out.println(key + " not found");
        }
        return list;
    }

    public static LinkedList deleteByIndex(LinkedList list, int index){
        Node currentNode = list.head;
        Node prevNode = null;

        // case 1: index = 0 in the head list
        if (index == 0 && currentNode != null){
            list.head = currentNode.getNext();
            System.out.println(index + " position element deleted");
            return list;
        }
        // case 2:
        int count = 0;

        while (currentNode!= null){
            if (count == index){
                prevNode.next = currentNode.getNext();
                System.out.println(index +" position element deleted");
                break;
            }else {
                prevNode = currentNode;
                currentNode = currentNode.next;
                count++;
            }
        }

        if (currentNode == null){
            System.out.println(index + " position element not found");
        }

        return list;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list = insert(list,1);
        list = insert(list,2);
        list = insert(list,3);
        list = insert(list,4);
        list = insert(list,5);

        System.out.println(list.printList(list));

        deleteByKey(list,4);

        System.out.println(list.printList(list));

        deleteByIndex(list,3);

        System.out.println(list.printList(list));
    }
}
