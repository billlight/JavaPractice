import java.util.Random;

public class Member implements Comparable<Member>{
	static Random r = new Random();
	protected String firstName, lastName; long ID;
	static final int emptySlot = -9999991;
	public Member() {
		generate();
	}
	public Member(long id, String fname, String lName) {
		this.firstName = fname;
		this.lastName = lName;
		this.ID = id;
	}
	public void generate() {
		this.firstName = Names.firstName[r.nextInt(Names.firstName.length)];
		this.lastName = Names.lastName[r.nextInt(Names.lastName.length)];
		this.ID = r.nextInt(10000000);
	}
	public String toString() {
		int a, b, c;
		a = (int) (ID % 10000);
		c = (int) (ID / 10000);
		b = c % 100;
		c = c / 100;
		return String.format("%03d-%02d-%04d %10s %-10s", c, b, a, this.firstName, this.lastName);
	}
	public String toString(boolean classifier) {
		return String.format("%s %s",classifier? "MEM:":"", this.toString());
	}
	@Override
	public int compareTo(Member x) {
		return (int)(this.ID - x.ID);
	}
    public String htmlRow() {
    	return String.format("<TR>%s</TR>\n", htmlColumns() );
    }
    public String htmlColumns() {
    	return String.format("<TD>%09d</TD> <TD>%10s</TD> <TD>%10s</TD>",ID, firstName, lastName);
    }

}
