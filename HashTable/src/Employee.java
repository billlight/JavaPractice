

public class Employee extends Member{
	protected String department; int yearHired;
	public Employee() {
		generate();
	}
	public Employee(long id, String fname, String lName, String major, int year) {
		super(id, fname, lName);
		this.department = major;
		this.yearHired = year;
	}
	@Override
	public void generate() {
		super.generate();
		this.department = Names.department[r.nextInt(Names.department.length)];
		this.yearHired = r.nextInt(30);
	}
	@Override
	public String toString() {
		return String.format("%s %10s %3d", super.toString(), this.department, this.yearHired);
	}
	public String toString(boolean classifier) {
		return String.format("%s %s",classifier? "EMP:":"", this.toString());
	}
    public String htmlRow() {
    	return String.format("<TR>%s</TR>\n", htmlColumns() );
    }
    @Override
    public String htmlColumns() {
    	return String.format("%s <TD>Department: %10s, Year Hired: %3d</TD>",super.htmlColumns(), department, yearHired);
    }
}
