

public class Faculty extends Employee{
	protected String degreeHeld;
	public Faculty() {
		generate();
	}
	public Faculty(long id, String fname, String lName, String major, int year, String degree) {
		super(id, fname, lName, major, year);
		this.degreeHeld = degree;
	}
	@Override
	public void generate() {
		super.generate();
		this.degreeHeld = Names.degree[r.nextInt(Names.degree.length)];
	}
	@Override
	public String toString() {
		return String.format("%s %10s", super.toString(), this.degreeHeld);
	}
	public String toString(boolean classifier) {
		return String.format("%s %s",classifier? "FAC:":"", this.toString());
	}
    public String htmlRow() {
    	return String.format("<TR>%s</TR>\n", htmlColumns() );
    }
    @Override
    public String htmlColumns() {
    	return String.format("%s <TD>Degree: %10s</TD>", super.htmlColumns(), degreeHeld);
    }
}
