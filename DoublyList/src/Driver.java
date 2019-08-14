import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Driver { 
	static Stack<Member> myStack = new Stack<>(); 
	static Queue<Member> myQueue = new Queue<>(); 
	static SortedQueue<Member> sQueue = new SortedQueue<>(); 
	static Random r = new Random();
	static Scanner s = new Scanner(System.in);
	static void menu() {
		System.out.printf(  "\t+===================================================+\n");
		System.out.printf(  "\t|    G: Ask for a N, and generate N members of mixed|\n");
		System.out.printf(  "\t|     kinds and put them into three list structures.|\n");
		System.out.printf(  "\t|     Make sure you destroy the lists before create |\n");
		System.out.printf(  "\t|     new ones if the lists are not empty.          |\n");
		System.out.printf(  "\t+---------------------------------------------------+\n");
		System.out.printf(  "\t|    S: List members in stack, 1 memebr per line,   |\n");
		System.out.printf(  "\t|     20 members per screen with header line, allow |\n");
		System.out.printf(  "\t|     Q/q to quit listing after each 20 members.    |\n");
		System.out.printf(  "\t|     List last 20 members if quit early.           |\n");
		System.out.printf(  "\t+---------------------------------------------------+\n");
		System.out.printf(  "\t|    List members in queue (same requirements).     |\n");
		System.out.printf(  "\t+---------------------------------------------------+\n");
		System.out.printf(  "\t|    O: List members in ordered queue sorted by SSN |\n");
	    System.out.printf(  "\t|    (same requirements)                            |\n");
		System.out.printf(  "\t+---------------------------------------------------+\n");
		System.out.printf(  "\t|    D: Remove first element from queue, pop member |\n");
		System.out.printf(  "\t|      from stack, and delete the same member from  |\n");
		System.out.printf(  "\t|      sorted queue as the one removed from stack.  |\n");
		System.out.printf(  "\t+---------------------------------------------------+\n");
		System.out.printf(  "\t|    I: Randomly generate new member, and put       |\n");
		System.out.printf(  "\t|      the object into the three structures. Print  |\n");
		System.out.printf(  "\t|      out the new member added in.                 |\n");
	    System.out.printf(  "\t+---------------------------------------------------+\n");
	    System.out.printf(  "\t|    H/?: Display this menu.                        |\n");
	    System.out.printf(  "\t|     E  : Exit                                     |\n");
	    System.out.printf(  "\t+---------------------------------------------------+\n");
	}
	
	public static  Member nextMember() {
		Member mem = new Member();
		int k = r.nextInt(5);
		switch (k) {
			case 0:
				return new Member();
			case 1:
				return new Student();
			case 2:
				return new Employee();
			case 3:
				return new Faculty();
			case 4:
				return new Staff();
		}
		return mem;		
	}
	public static Member addItem(int nNums) {
		Member mem = new Member();
		for(int i = 0; i < nNums; i++) {
			mem = nextMember();
			myStack.push(mem);
			myQueue.enque(mem);
			sQueue.enque(mem);
		}
		return mem;
	}
	//merge to one
	public static void show(List<Member> myStack) {
		Iterator<Member> itr = myStack.iterator(true);
		int count = 0;
		char c = 'c';
		while(itr.hasNext()) {
			count++;
			System.out.printf("%s\n", itr.next().toString());
			if(count % 20 == 0) {
				System.out.printf("Quit?\n");
				c = s.nextLine().charAt(0);
				if(c == 'q') return;
			}
		}
		System.out.print("\n");
	}

    public static void main(String[] args) {
    	int N = 0;
	    char c = ' ';	    
	    while ( c != 'e' && c != 'E' ) {
	    	System.out.printf("\nEnter H/h/? for help, or command: Q, q to quit or G/S/Q/O/D/I command:\n");
	    	c = s.nextLine().charAt(0);
	    	switch(c) {
	        	case '?': case 'H': case 'h':
	        		menu();
	        		break;
	        	case 'g': case 'G':
	        		System.out.printf("Ask for N\n");
	        		myStack = new Stack<>(); 
	        		myQueue = new Queue<>(); 
	        		sQueue = new SortedQueue<>(); 
	        		N = s.nextInt(); s.nextLine();
	        		addItem(N);
	        		break;
	        	case 's': case 'S':
	        		show(myStack);
	        		break;
	        	case 'q': case 'Q':
	        		show(myQueue);
	        		break;
	        	case 'o': case 'O':
	        		show(sQueue);
	        		break;
	        	case 'i': case 'I':
	        		System.out.printf("%s",addItem(1).toString());
	        		break;
	        	case 'd': case 'D':
	    			myStack.pop();
	    			myQueue.deque();
	    			sQueue.deque();
	    			show(myStack);
	        		break;
	        	case 'e': case 'E':
	        		return;
	    	}
	    }
	}
} 
