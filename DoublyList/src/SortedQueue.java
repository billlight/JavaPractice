import java.util.Iterator;

public class SortedQueue<T extends Comparable<T>> extends List<T>{
	public SortedQueue() { super(); }
	public SortedQueue<T> enque(T val) {
		if(this.empty()) {add(val, size-1); return this;}
		Iterator<T> itr = this.iterator(true);
		T nn; int i = 0;
		while(itr.hasNext()) {
			nn = itr.next();
			if (nn.compareTo(val) > 0) break;
			i++;
		}
		add(val, i);
		return this;
	}
	public SortedQueue<T> deque() {
		remove(0);
		return this;
	}
	public Node<T> front() {
		Node<T> ptr = this.front;
		return ptr;
	}
}
