public class Main {
    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DefaultDoublyLinkedList();
        doublyLinkedList.add(1);
        doublyLinkedList.add(2);
        doublyLinkedList.add(3);
        doublyLinkedList.add(4);
        doublyLinkedList.add(5);
        doublyLinkedList.add(6);

        System.out.println(doublyLinkedList.toString());

//        System.out.println(doublyLinkedList.indexOf(3));

        System.out.println(doublyLinkedList.removeAt(3));
        System.out.println(doublyLinkedList.toString());

        System.out.println(doublyLinkedList.removeFirst());
        System.out.println(doublyLinkedList.toString());

        System.out.println(doublyLinkedList.removeLast());
        System.out.println(doublyLinkedList.toString());




    }
}