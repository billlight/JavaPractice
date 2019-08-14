
public class Stack<T> extends List<T>{
	public Stack() { super(); }
	public Stack<T> push(T val) {
		add(val, 0);
		return this;
	}
	public Stack<T> pop() {
		remove(0);
		return this;
	}
	public Node<T> top() {
		Node<T> ptr = this.front;
		return ptr;
	}
}
