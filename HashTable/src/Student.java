

public class Student extends Member{
	protected String major; float GPA;
	public Student() {
		generate();
	}
	public Student(long id, String fname, String lName, String major, float gpa) {
		super(id, fname, lName);
		this.major = major;
		this.GPA = gpa;
	}
	@Override
	public void generate() {
		super.generate();
		this.major = Names.department[r.nextInt(Names.department.length)];
		this.GPA = (float) ((float)r.nextInt(4)/4.0);
	}
	@Override
	public String toString() {
		return String.format("%s %10s %f", super.toString(), this.major, this.GPA);
	}
	public String toString(boolean classifier) {
		return String.format("%s %s",classifier? "STU:":"", this.toString());
	}
    public String htmlRow() {
    	return String.format("<TR>%s</TR>\n", htmlColumns() );
    }
    @Override
    public String htmlColumns() {
    	return String.format("%s <TD>Major: %10s, GPA: %f</TD>", super.htmlColumns(), major, GPA);
    }
}
