

public interface Names {
	// Fields in interface are always and implicitly public, static and final.
    // All methods in interface are implicitly public and abstract.
	static void menu() {
		System.out.printf(  "\t+===========================================================================================================================+\n");
		System.out.printf(  "\t|                                                Implementation of Hashtable                                                |\n");
		System.out.printf(  "\t|                                                        Assignment                                                         |\n");
		System.out.printf(  "\t+===========================================================================================================================+\n");
		System.out.printf(  "\t| Command  |                   Description                    | Command  |                   Description                    |\n");
		System.out.printf(  "\t+----------+--------------------------------------------------+----------+--------------------------------------------------+\n");
		System.out.printf(  "\t|   g G    |  Prompt for two intergers, the capacity and the  |   t T    | Perform a successful search on each of object in |\n");
		System.out.printf(  "\t|          |  load factor of a hash table. Create a new hash  |show Time | the hash table, and 'capacity' many unsuccessful |\n");
		System.out.printf(  "\t|          |table, with 0.20 as increment percentage, generate |Complexity| searches, list the (1) avareage comparions from  |\n");
		System.out.printf(  "\t|          |(capacity * load factor) many mixed Member objects|of Bin. & |all successful searchs, the theoretic susccessful |\n");
		System.out.printf(  "\t|          |         and add them to the hash table.          |Hash. Srch|search complexity [(1 + 1/(1-a))/2], and the      |\n");
		System.out.printf(  "\t+----------+--------------------------------------------------+See exampl|theoretical un-successful search time complexity  |\n");
		System.out.printf(  "\t|   a A    | Instanciate a new member object, and the object  |e below.  |[(1+1/(1-a)**2)/2], where a is the loading factor.|\n");
		System.out.printf(  "\t|          |   into the hash table. Display the newly added   +----------+--------------------------------------------------+\n");
		System.out.printf(  "\t|          |  member, its home address and current address.   |   b B    |Display information on blocks formed by contiguous|\n");
		System.out.printf(  "\t+----------+--------------------------------------------------+          |data or empty cells inside table. For each block, |\n");
		System.out.printf(  "\t|   r R    | Ask for an ID or hash code of an object. Remove  |          |display the type of block (either data or empty), |\n");
		System.out.printf(  "\t|          |     the object whose ID matchs the given ID.     |          |the starting and ending addresses, size of block. |\n");
		System.out.printf(  "\t+----------+--------------------------------------------------+          |At the end of block listing, show the total number|\n");
		System.out.printf(  "\t|   f F    |   Ask for an ID or hash code, of a object,       |          |   of blocks, the maximum, the minimum and the    |\n");
		System.out.printf(  "\t|          | display the object, ID current address and home  |          |  average block sizes, for each type. Allow quit  |\n");
		System.out.printf(  "\t|          |                     address.                     |          | listing the total, maximum, minimum and average  |\n");
		System.out.printf(  "\t+----------+--------------------------------------------------+          |must show the correct data even if the listing of |\n");
		System.out.printf(  "\t|   c C    |Show contents of hash table in a tabular way. one |          |                   block ends.                    |\n");
		System.out.printf(  "\t|          | object per line and ten objects per screen. for  +----------+--------------------------------------------------+\n");
		System.out.printf(  "\t|          |   each line, the following columns have to be    |   p P    |List the table parameters. The parameters include.|\n");
		System.out.printf(  "\t|          | displayed: OBject, current address, home address |          |    the capacity, size, load factor, increment    |\n");
		System.out.printf(  "\t|          |  and the displacement from home address to its   |          |      percentage,and the actual load factor.      |\n");
		System.out.printf(  "\t|          |                 current address.                 +----------+--------------------------------------------------+\n");
		System.out.printf(  "\t+----------+--------------------------------------------------+   v V    |    Verify whether all non-null elements in table |\n");
		System.out.printf(  "\t|  i I x   |   Remove object at I, and do not shift.          |          |         are rearchable or not.                   |\n");
		System.out.printf(  "\t+----------+--------------------------------------------------+----------+--------------------------------------------------+\n");
		System.out.printf(  "\t|  h H ?   |                 Show this menu.                  |   q Q    |                Exit the program.                 |\n");
		System.out.printf(  "\t+----------+--------------------------------------------------+----------+--------------------------------------------------+\n");
	}
    public static final String sport [] = {
        "Basketball", "Table Tennis", "Swiming", "Tennis", "Golf", "Hockey",
        "Target Shooting", "VolleyBall", "Soccer", "FootBall"};

    public static final String department [] = {
        "Math", "Business", "Moden Language", "Dentistry", "Optomistry",
        "Computer Sci.", "Pharmacy", "Engineering", "Fine Arts", "MIS",
        "Biology", "Nursing"};

    public static final String title [] = {
        "Accountant", "Adm. Assit.", "Techician", "Manager" };

    public static final String position[] = {
        "Lecturer", "Assoc. Prof", "Assit. Prof.", "Professor" };

    public static final String degree[] = { "B.S.", "M.S.", "Ph.D.", "M.D." };

    public static final String skill[] = {
        "Typist", "Admin", "Admin. Assist.", "PC Main.", "Elec.", "Account.", "Purch." };

    public static final String lastName [] = {
        "Abdalla", "Andres", "Anzai", "Armstrong", "Arvig", "Ash", "Baca", "Badine",
        "Baehr", "Bair", "Baligad", "Barlow", "Barrett", "Becker", "Bell",
        "Benbow", "Biggs", "Blevins", "Blood", "Bohan", "Bond", "Bonner",
        "Bosch", "Bryson", "Buechele", "Bullis", "Burk", "Burns", "Byron",
        "Calderon", "Careuthers", "Carr", "Carson", "Carter", "Castle", "Chan",
        "Charney", "Christenson", "Cisneros", "Cliton", "Coldewey", "Coodey",
        "Cook", "Cooper", "Coy", "Currie", "Curtis", "Dirkse", "Dirscoll",
        "Dodrill", "Ehlert", "Elias", "Elliott", "Enterline", "Ericsson",
        "Fernandez", "Fisher", "Flory", "Freese", "Fruzza", "Fu", "Fuhrman", "Gage",
        "Garcia", "Garmon", "Giffith", "Gill", "Gillen", "Glascock", "Gomez",
        "Goraya", "Greer", "Hansen", "Hartley", "Hawkins", "Hemme", "Hensley",
        "Hentges", "Herron", "Hightower", "Hines", "Holloway", "Holmes",
        "Issac", "Jackson", "Jagodin", "Jiang", "Johnson", "Jordan", "Jouda", "Joven",
        "Kalpesh", "Katz", "Kaur", "Kegley", "Kimsey", "King", "Kohn", "Kone",
        "LaCasse", "Lackey", "Lathrop", "Le", "Levy", "Lynos", "Maas", "Mackall",
        "Madsen", "Magee", "Maldonado", "McDaneld", "McMillian", "McNeill",
        "Meadors", "Medina", "Metz", "Millikin", "Minner", "Mondragon", "Monge", "Moore",
        "Moreno", "Murkland", "Musick", "Myers", "Neal", "Ngo", "Nolan", "Nunez",
        "O'Neil", "Oropeza", "Owen", "Patel", "Pfister", "Philips", "Picato",
        "Porras", "Porter", "Pratt", "Pryor", "Ragle", "Rai", "Raja", "Rill",
        "Roberts", "Roddy", "Rose", "Roux", "Rubio", "Ruiz", "Saito", "Samidin",
        "Sampson", "Sanchez", "Scanlan", "Schmidt", "Schoberg", "Sheppard",
        "Simmons", "Sison", "Smith", "Snow", "Soto", "Sozinho", "Stevens",
        "Stidham", "Strange", "Sy", "Tamayo", "Taylor", "Thomas", "Tran", "Vincent",
        "Walker", "Wandke", "Ward", "Warner", "Waugh", "Webb", "Wells", "White",
        "Wilson", "Winther", "Wuertz", "Yong" };

   public static final String firstName [] = {
        "Aaron","Alan", "Ali", "Alicia","Andrew", "Anne", "Anthony", "Archie", "Ariel",
        "Arlene", "Barbara", "Bebedict", "Benjamin", "Bey-Fen", "Bikram", "Brain",
        "Brandon", "Brent", "Brian", "Brock", "Candice", "Cathleen", "Chad",
        "Charles", "Charlie", "Christopher", "Cindy", "Clinton", "Craig", "Daniel",
        "Danna", "David", "Dean", "Denise", "Dexter", "Diane", "Dinna", "Donna",
        "Douglas", "Eduardo", "Edward", "Elsa", "Eric", "Ernesto", "Fernando",
        "Francisco", "Frank", "Gabby", "Garmund", "Garvin", "Genevieve", "George",
        "Gil", "Gregory", "Gurinder", "Hemant", "Herman", "Hernando", "Isabel",
        "James", "Janet", "Janice", "Jarret", "Jason", "Javier", "Jeffrey",
        "Jennifer", "Jeremy", "Jerold", "Jerrie", "Jim", "Joanna", "Joe", "Joel", "John",
        "Jon", "Jonathan", "Jose", "Joseph", "Josephine", "Josh", "Joshua",
        "Julie", "Kenneth", "Kenny", "Kent", "Kristi", "Kurt", "Kyle", "Lance",
        "Laura", "Leslie", "Malcolm", "Maneje", "Manja", "Marco", "Marcos",
        "Marcus", "Marianna", "Maritza", "Mark", "Marques", "Masaaki", "Mathew", "Matt",
        "Mayur", "Melissa", "Michael", "Miera", "Mike", "Mina", "Mohamed", "Moises",
        "Morgan", "Muntaga", "Myron", "Nathan", "Nilli", "Norma", "Olga",
        "Paradorn", "Patel", "Patrick", "Paul", "Pedro", "Peter", "Philip",
        "Preet", "Ralf", "Ralph", "Raymond", "Reuben", "Ricardo", "Richard",
        "Robert", "Roberto", "Rohit", "Ronald", "Ronne", "Rosa", "Roy", "Rushabh",
        "Ryan", "Samat", "Sara", "Sarah", "Scott", "Sean", "Sergio", "Shahzad", "Shawn",
        "Shi-Wei", "Silvia", "Simon", "Stacy", "Stephanie", "Stephen", "Steven",
        "Sukhum", "Susan", "Suzanne", "Tahnee", "Tahra", "Tam", "Tammy", "Tate",
        "Terry", "Thomas", "Thonas", "To", "Todd", "Tommy", "Travis", "Trevor",
        "Troy", "Valerie", "Ven", "Victor", "Vidya", "Vikramjwed", "Wernher",
        "Wesley", "William", "Yu" } ;

}
