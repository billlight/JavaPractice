import java.util.Iterator;

class ListIterator<T> implements Iterator<T> { 
    Node<T> current; 
    boolean direction;
    public ListIterator(Node<T> ptr, boolean dir) { current = ptr; direction = dir;} 
    public boolean hasNext() { return current != null; }  
    public T next() { 
    	T data = current.data(); 
    	current = current.next(); 
        return data; 
    } 
    public void remove() { 
        throw new UnsupportedOperationException(); 
    } 
} 