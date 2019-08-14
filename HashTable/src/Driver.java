
import java.util.Random;
import java.util.Scanner;

public class Driver {
	static Hash<Member> myHash = new Hash<Member>();
	static Random r = new Random();
	static Scanner s = new Scanner(System.in);

	
	//command 'g': to generate the hash table with random members
	public static void generateTable() {
	    int cap = 0; double MLF = 0;
		System.out.printf("Enter capacity\n");
		cap = s.nextInt(); s.nextLine();
		System.out.printf("Enter load factor\n");
		MLF = s.nextDouble(); s.nextLine();
		myHash = new Hash<Member>(cap, MLF);
		addItem((int) (cap * MLF));
	}
	//randomly generate a member obj from five classes
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
	//add desired number of items to the hash table
	public static void addItem(int num) {
		Member mem = new Member();
		for(int i = 0; i < num; i++) {
			mem = nextMember();
			Node<Member> nn = new Node<> ((int)mem.ID, mem);
			myHash.add(nn);
		}
	}

	//command 'a': instantiate and add a new member object
	public static void instantiate() {
		Member nn = nextMember();
		Node<Member> toAdd = new Node<> ((int)nn.ID, nn);
		myHash.add(toAdd);
		printobj(toAdd);
	}
	
	//command 'r': remove the member with the ID entered
	public static void remove() {
		System.out.printf("Enter ID\n");
		int id = s.nextInt(); s.nextLine();
		myHash.remove( id, true);
	}
	
	//command 'f': show the member with the ID entered
	public static void displayObj() {
		System.out.printf("Enter ID\n");
		int id = s.nextInt(); s.nextLine();
		if(myHash.get(id) != null) printobj(myHash.get(id));
	}
	//print out the member entered
	public static void printobj(Node<Member> obj) {
		int homeAdd = myHash.hash(obj);
		String infor = obj.data.toString();
		int current = myHash.curAdd(obj);
		int distance = myHash.distance(homeAdd, current);		
		System.out.printf("\t+==============================================================================================+\n");
		System.out.printf("\t|                        Object Value                                  |Current| Home  |Displac|\n");
		System.out.printf("\t|                                                                      |Address|Address| ement |\n");
		System.out.printf("\t+----------------------------------------------------------------------+-------+-------+-------+\n");
		System.out.printf("\t|%-70s|%-7d|%-7d|%-7d|\n", infor, current, homeAdd, distance);
		System.out.printf("\t+----------------------------------------------------------------------+-------+-------+-------+\n");
	}
	
	//command 'i': remove the member with the ID entered, but no shifting
	public static void removeNoShift() {
		System.out.printf("Enter ID\n");
		int id = s.nextInt(); s.nextLine();
		myHash.remove( id, false );
	}

	public static void timeComplxHead() {
		System.out.printf("\t+================================================================+\n");        
		System.out.printf("\t|      Time Complexities of Practical & Theoretic Hashtable      |\n");        
		System.out.printf("\t|          Search vs. Theoretic Binary Search Algorithm          |\n");        
		System.out.printf("\t+================================================================+\n");        
		System.out.printf("\t| Practical  | Practical  | Theoretic  | Theoretic  |Theoretical |\n");        
		System.out.printf("\t| Hashtable  | Hashtable  | Hashtable  | Hashtable  |   Binary   |\n");        
		System.out.printf("\t| Successful |Unsuccessful| Successful |Unsuccessful|   Search   |\n");        
		System.out.printf("\t|   Search   |   Search   |   Search   |   Search   |            |\n");        
		System.out.printf("\t+------------+------------+------------+------------+------------+\n");        
	}

	public static void timeComplx() {
		float successCount = myHash.successSearch();
		float failCount = failSearch();
		double a = myHash.MLF();
		double theoSuccess = ((1 + 1 / (1 - a))/2);
		double thoefail = ((1+1/(1-a)/(1-a))/2) ;
		double binarySearch = Math.log(myHash.capacity())/Math.log(2);
		timeComplxHead();
		System.out.printf("\t|   %5.2f    |   %5.2f    |   %5.2f    |    %5.2f   |    %5.2f   |\n", successCount, failCount, theoSuccess, thoefail, binarySearch);        
		System.out.printf("\t+------------+------------+------------+------------+------------+\n");  
	}
	
	public static float failSearch() {
		int count = 0, tot = 0;
		while(count < myHash.capacity()) {
			Member nn = nextMember();
			Node<Member> toAdd = new Node<> ((int)nn.ID, nn);
			if(myHash.get(toAdd) == null) {
				tot += myHash.search(toAdd.key);
				count++;
			}
		}
		return (float)tot/(float)count;
	}
	
	//command'p' List the table parameters.
	public static void parameter() {
		System.out.printf("\t+================================================================+\n");       
		System.out.printf("\t|                  Parameters of The Hash Table                  |\n");      
		System.out.printf("\t+================================================================+\n");       
		System.out.printf("\t|  Capacity  |    Size    | Increment  | Specified  |Actual Load |\n");  
		System.out.printf("\t|            |            |            |Load Factor |   Factor   |\n");  
		System.out.printf("\t+------------+------------+------------+------------+------------+\n");  
		System.out.printf("\t|%12d|%12d|%12.2f|%12.2f|%12.2f|\n", myHash.capacity(),  myHash.size(),  myHash.incPer(),  myHash.MLF(),  myHash.curMLF());       
		System.out.printf("\t+------------+------------+------------+------------+------------+\n");
		return;
	}
	
	public static void main(String[] args) {
	    char c = ' ';
	    while ( c != 'q' && c != 'Q' ) {
	    	System.out.printf("\nEnter H/h/? for help, or command: \n");
	    	c = s.nextLine().charAt(0);
	    	switch(c) {
	        	case '?': case 'H': case 'h':
	        		Names.menu();
	        		break;
	        	case 'g': case 'G':
	        		generateTable();
	        		break;
	        	case 'a': case 'A':
	        		instantiate();
	        		break;
	        	case 'r': case 'R':
	        		remove();
	        		break;
	        	case 'f': case 'F':
	        		displayObj();
	        		break;
	        	case 'c': case 'C':
	        		myHash.show();
	        		break;
	        	case 'i': case 'I':
	        		removeNoShift();
	        		break;
	        	case 't': case 'T':
	        		timeComplx();
	        		break;
	        	case 'b': case 'B':
	        		myHash.showBlock();
	        		break;
	        	case 'p': case 'P':
	        		parameter();
	        		break;
	        	case 'v': case 'V':
	        		System.out.printf("The statement all non-null elements are reachable is %b",myHash.reachable());
	        		break;
	        	case 'q': case 'Q':
	        		return;
	    	}
	    }
		s.close();
	}
}



