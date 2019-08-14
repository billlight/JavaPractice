
public class Queue<T> extends List<T>{
	public Queue() { super(); }
	public Queue<T> enque(T val) {
		add(val, size);
		return this;
	}
	public Queue<T> deque() {
		remove(0);
		return this;
	}
	public Node<T> front() {
		Node<T> ptr = this.front;
		return ptr;
	}
	
}