public class Node<T>{
    private T data;
    Node<T> prev, next;
    public T getData(){
        return data;
    }
    public void setData(T data){
        this.data = data;
    }

    public Node<T> getPrev(){
        return prev;
    }

    public void setPrev(Node<T> prev){
        this.prev = prev;
    }

    public Node<T> getNext(){
        return next;
    }
    public void setNext(Node<T> next){
        this.next = next;
    }

    public Node(T data, Node<T> prev, Node<T> next){
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public String toString(){
        return data.toString();
    }
}
