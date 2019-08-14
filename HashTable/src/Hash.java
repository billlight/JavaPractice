import java.util.Random;
import java.util.Scanner;

public class Hash<T>  {
	static Scanner s = new Scanner(System.in);
	static Random r = new Random();
	protected Node<T>[] table;
	protected int cap, size;
	protected double MLF, incPer;
	//initialize table
	public void initialize() { size = 0; }
	
	//constructors
	@SuppressWarnings("unchecked")
	public Hash() {
		cap = 10; size = 0; MLF = 0.75; incPer = 0.20;
		table = new Node[cap];
		initialize();
	}
	@SuppressWarnings("unchecked")
	public Hash(int cap, double MLF) {
		this.cap = cap; size = 0; this.MLF = MLF; incPer = 0.20;
		table = new Node[cap];
		initialize();
	}
	
	//parameters
	int capacity() {return cap;}
	int size() {return size;}
	double MLF() {return MLF;}
	double incPer() {return incPer;}
	
	
	public int distance(int from, int to){
		return to >= from ? to - from: cap - from + to;
	}
	//hashCode function
	public int hash(Node<T> item) {
		return hash(item.key);
	}
	public int hash(int key) {
		return key % cap;
	}
	public double curMLF() {
		return (double)(size)/(double)(cap);
	}
	
	//add Function
	public void add(Node<T> nn) {
		int homeAdd = hash(nn);
		while(table[homeAdd] != null) homeAdd = (homeAdd + 1) % cap;
		table[homeAdd] = nn;
		size++;
		double curMLF = curMLF();
		if(curMLF > MLF) rehash();
	}
	@SuppressWarnings("unchecked")
	public void rehash() {
		int length = cap;
		cap = (int) ((double)cap * ( 1.0 + incPer));
		Node<T>[] tmp = table;
		table = new Node[cap];
		initialize();
		for(int i = 0; i < length; i++) {
			if(tmp[i] != null) add(tmp[i]);
		}
	}
	
	//get Function
	public Node<T> get(Node<T> target) {
		return get(target.key);
	}
	public Node<T> get(int key) {
		if(key < 0) return null;
		int homeAdd = key % cap;
		while(table[homeAdd] != null && table[homeAdd].key != key) homeAdd = (homeAdd + 1) % cap;
		return table[homeAdd];
	}
	
	//remove Function
	public void remove(Node<T> toDelete, boolean toShift) {
		remove(toDelete.key, toShift);
	}
	public void remove(int key, boolean toShift) {
		int homeAdd = key % cap;
		while(table[homeAdd] != null && table[homeAdd].key != key) homeAdd = (homeAdd + 1) % cap;
		Node<T> tmp = table[homeAdd];
		table[homeAdd] = null;
		if( tmp != null && tmp.key == key ) size--;
		if (toShift) shift( homeAdd, (homeAdd + 1) % cap );
	}
	public void shift(int empty, int cur) {
		if( table[cur] == null ) return;
		int homeAdd = hash(table[cur]);
		int dis1 = distance(homeAdd, empty);
		int dis2 = distance(homeAdd, cur);
		if( dis1 < dis2) {
			table[empty] = table[cur];
			table[cur] = null;
			shift( cur, (cur+1) % cap );
		}else shift( empty, (cur + 1) % cap );
	}
	
	//Show function and other necessary functions excludes add remove and get
	//show the hash Table. 10 elements per screen
	public void show() {
		heading();
		//if(block) blockHeading();
		int homeAdd, totDis = 0;
		int count = 0;
		char c = 'c';
		for(int i = 0; i < cap; i++) {
			homeAdd = table[i] == null? i:hash(table[i]);
			totDis += distance(homeAdd, i);
			System.out.printf("\t|%-70s|%-7d|%-7d|%-7d|\n", table[i] == null? "":table[i].data.toString(), i, homeAdd, distance(homeAdd, i));
			System.out.printf("\t+----------------------------------------------------------------------+-------+-------+-------+\n");
			count++;
			if (count % 10 == 0 && count < cap) {
				System.out.printf("\t%d more record(s) to list (Q/q to quit) ... Q\n", cap-count);
				c = s.nextLine().charAt(0);
				if(c == 'q' || c == 'Q') break;
				System.out.printf("\t+----------------------------------------------------------------------+-------+-------+-------+\n");
			}
		}
		showDis();
	}
	public void heading() {
		System.out.printf("\t+==============================================================================================+\n");
		System.out.printf("\t+                               Contents of Hash Table                                         +\n");
		System.out.printf("\t+                 [Capacity-%-4d, Size-%-3d, Load Fac.-%.2f , Increment-%.1f]                    +\n", cap, size, MLF, incPer);
		System.out.printf("\t+==============================================================================================+\n");
		System.out.printf("\t|                        Object Value                                  |Current| Home  |Displac|\n");
		System.out.printf("\t|                                                                      |Address|Address| ement |\n");
		System.out.printf("\t+----------------------------------------------------------------------+-------+-------+-------+\n");
	} 
	//sub function of show Function: count and show the displacement and the average 
	public void showDis() {
		int homeAdd, distance, totDis = 0;
		int count = 0;
		for(int i = 0; i < cap; i++) {
			homeAdd = table[i] == null? i:hash(table[i]);
			distance = distance(homeAdd, i);
			totDis += distance;
			if(table[i] != null) count++;
		}
		System.out.printf("\t|                  Displacement: Total = %2d Average = %.2f                                     |\n",totDis, (double)totDis/(double)count);
		System.out.printf("\t+----------------------------------------------------------------------+-------+-------+-------+\n");
	}
	
	//To show the data and empty blocks information:
	public void showBlock() {////////need revise
		blockHeading();
		boolean prev, cur, next;
		int start = 0, end = 0, size = 0, count = 0;
		int countData = 0, countEmpty = 0, maxData = 0, maxEmpty = 0, minData = 9999999, minEmpty = 9999999, totDataSize = 0, totEmpSize = 0;
		if((table[0] == null) != (table[1] == null)) {
			printBlock(table[0], 0, 0) ; 
			if (table[0] != null) {countData++; minData = 1; if(maxData < 1) maxData = 1; totDataSize += 1;} 
			if (table[0] == null) {countEmpty++;  minEmpty = 1;if(maxEmpty < 1) maxEmpty = 1; totEmpSize += 1;} 
		}
		int i = 0, j = 1;int k;
		for(k = 2; k < cap+2; k++) {
			i = (k - 2) % cap;
			j = (k - 1) % cap;
			k = k % cap;
			prev = (table[i] == null); cur = (table[j] == null); next = (table[k] == null);
			if(prev != cur && cur != next) {
				printBlock(table[j], j, j);
				if (table[j] != null) {countData++; minData = 1; if(maxData < 1) maxData = 1; totDataSize += 1;} 
				if (table[j] == null) {countEmpty++;  minEmpty = 1;if(maxEmpty < 1) maxEmpty = 1; totEmpSize += 1;} 
				}
			if(prev != cur && cur == next) start = j;
			if(prev == cur && cur != next) {
				end = j; size = end - start + 1;
				printBlock(table[j], start, end);
				if (table[j] != null) {countData++; if(maxData < size) maxData = size; if(minData > size) minData = size; totDataSize += size;} 
				if (table[j] == null) {countEmpty++; if(maxEmpty < size) maxEmpty = size; if(minEmpty > size) minEmpty = size; totEmpSize += size;} 
			}
		}
		size = (cap - 1) - (end + 1) + 1;
		printBlock(table[cap-1], end+1, cap-1);		
		if (table[cap-1] != null) {countData++; if(maxData < size) maxData = size; if(minData > size) minData = size; totDataSize += size;} 
		if (table[cap-1] == null) {countEmpty++; if(maxEmpty < size) maxEmpty = size; if(minEmpty > size) minEmpty = size; totEmpSize += size;} 
		
		blockEnd(countData, countEmpty, maxData, maxEmpty, minData, minEmpty, totDataSize, totEmpSize);
	}
	public void printBlock(Node <T> ptr, int start, int end) {
		System.out.printf("\t|%-12s|%-12d|%-12d|%-12d|\n", ptr == null? "Empty": "Data", start, end, end-start+1);
		System.out.printf("\t+------------+------------+------------+------------+\n"); 
	}
	public void blockHeading() {
		System.out.printf("\t+===================================================+\n");
		System.out.printf("\t|       Information on Data and Blank Blocks        |\n"); 
		System.out.printf("\t+===================================================+\n");
		System.out.printf("\t| Block Type |  Starting  |   Ending   |    Size    |\n");              
		System.out.printf("\t|            |  Address   |  Address   |            |\n");              
		System.out.printf("\t+------------+------------+------------+------------+\n"); 
	}
	public void blockEnd(int countData, int countEmpty, int maxData, int maxEmpty, int minData, int minEmpty, int totDataSize, int totEmpSize) {
		System.out.printf("\t|   Block Type  Count   Maximum Minimum Avg Size    |\n");              
		System.out.printf("\t|     Data       %3d      %3d     %3d    %.2f       |\n", countData, maxData, minData, (double)totDataSize/(double)countData ) ;          
		System.out.printf("\t|     Empty      %3d      %3d     %3d    %.2f       |\n", countEmpty, maxEmpty, minEmpty, (double)totEmpSize/(double)countEmpty ) ;            
		System.out.printf("\t+---------------------------------------------------+\n") ;
	}
	
	//find the current address in the table
	public int curAdd(Node<T> ptr) {
		int i = 0;
		for(i = 0; i < cap; i++) {
			if(table[i] != null && ptr.key == table[i].key) return i;
		}
		return -9999991;
	}

	//Perform a successful search on each of object in the hash table
	public float successSearch() {
		int count = 0;
		int tot = 0;
		for ( int i = 0; i < cap; i++) {
			if(table[i] != null) {
				count++;
				tot += search(table[i].key);
			}
		}
		return (float)tot/(float)count;
	}
	//calculate the complexity of finding each element
	public int search(int key) {
		int count = 0;
		int homeAdd = key % cap;
		while(table[homeAdd] != null && table[homeAdd].key != key) { 
			homeAdd = (homeAdd + 1) % cap;
			count++;
		}
		return count;
	}
	
	//command'v' Verify whether all non-null elements in table are reachable
	public boolean reachable() {
		for(int i = 0; i < cap; i++) {
			if( table[i] != null && get(table[i].key) == null) return false;
		}
		return true;
	}
}
