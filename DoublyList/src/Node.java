
class Node<T> { 
    T data = null; 
    Node<T> next = null;
    Node<T> prev = null;
    public Node(T data) { this.data = data; } 
    public T data() { return data; }      
    public Node<T> next() { return next; } 
} 