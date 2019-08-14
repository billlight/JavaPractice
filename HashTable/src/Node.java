
public class Node<T> {
	final int key;
	T data;
	public Node(T val){
		this.key = val.hashCode();
		this.data = val;
	}
	public Node(int key, T val){
		this.key = key;
		this.data = val;
	}
}
