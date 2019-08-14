import java.util.Iterator;


class List<T> implements Iterable<T> { 
    protected Node<T> front, rear;
    protected int size;
    public List() {front = rear = null; size = 0;}
	public int size() { return size;}
	public boolean empty() { return size < 1;} 
    public Node<T> front() { return this.front; }       
    public Node<T> rear() {return this.rear;}      
    // return Iterator instance 
    public Iterator<T> iterator(boolean dir) { 
    	return new ListIterator<T>(this.front, dir); 
    } 
    //add Function
	protected void addFront(T val) {
		Node<T> tmp = new Node<>(val); 
		if(empty()) {front = rear = tmp; size++; return;}		
		tmp.next = front;
		front.prev = tmp;
		front = tmp;
		size++; 
		return;
	}
	protected void addRear(T val) {
		Node<T> tmp = new Node<>(val);
		rear.next = tmp;
		tmp.prev = rear;
		rear = tmp;
		size++;
		return;
	}
	//Must have two or more nodes inside
	protected void addbetween(T val, int pos) {
		Node<T> tmp = new Node<>(val);
		Node<T> cur = front;
		for(int i = 1; i < pos; i++)cur = cur.next;
		tmp.next = cur.next;
		tmp.prev = cur;
		cur.next.prev = tmp;
		cur.next = tmp;
		size++;
		return;
	}
	public void add(T val, int pos) {
		if( empty() || pos < 1 ) {addFront(val); return;}
		if(pos >= size ) {addRear(val); return;}
		addbetween(val, pos);
		return;
	}
	//remove function
	public void remove(int pos) {
		if(empty() || pos < 0 || pos > size - 1) return;
		if(this.size() == 1) { front = rear = null; size--; return; }
		if(pos == 0 || size <= 1) { removeFront();return; }
		if(pos == size - 1) { removeRear();return; }
		removebetween(pos);
		return;
	}
	protected void removeFront() {
		Node<T> toDelete = front;
		front = toDelete.next;
		front.prev = null;
		toDelete.next = null;
		size--;
		return;
	}
	protected void removeRear() {
		Node<T> toDelete = rear;
		rear = toDelete.prev;
		rear.next = null;
		toDelete.prev = null;
		size--;
		return;
	}
	protected void removebetween(int pos) {
		Node<T> cur = front;
		Node<T> toDelete = front;
		for(int i = 0; i < pos; i++) {
			cur = toDelete;
			toDelete = toDelete.next;
		}
		cur.next = toDelete.next;
		toDelete.next.prev = cur;
		toDelete.next = toDelete.prev = null;
		size--;
		return;
	}
	//get data function
	public T data(int pos) {
		if(pos > size-1) return null;
		Node<T> ptr = front;
		for(int i = 0; i < pos; i++) {
			ptr = ptr.next;
		}
		return ptr.data;
	}
	@Override
	public Iterator<T> iterator() {
		return null;
	}      

} 
