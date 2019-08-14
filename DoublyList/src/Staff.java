

public class Staff extends Employee{
	protected String jobTitle;
	public Staff() {
		generate();
	}
	public Staff(long id, String fname, String lName, String major, int year, String title) {
		super(id, fname, lName, major, year);
		this.jobTitle = title;
	}
	@Override
	public void generate() {
		super.generate();
		this.jobTitle = Names.title[r.nextInt(Names.title.length)];
	}
	@Override
	public String toString() {
		return String.format("%s %10s", super.toString(), this.jobTitle);
	}
	public String toString(boolean classifier) {
		return String.format("%s %s",classifier? "STA:":"", this.toString());
	}
    public String htmlRow() {
    	return String.format("<TR>%s</TR>\n", htmlColumns() );
    }
    @Override
    public String htmlColumns() {
    	return String.format("%s <TD>Title: %10s</TD>",super.htmlColumns(), jobTitle);
    }
}