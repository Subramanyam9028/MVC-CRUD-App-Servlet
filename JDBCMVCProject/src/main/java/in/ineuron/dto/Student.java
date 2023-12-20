package in.ineuron.dto;

public class Student {

	
	private Integer sid;
	private String sage;
	private String sname;
	private String saddress;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(Integer sid, String sage, String sname, String saddress) {
		super();
		this.sid = sid;
		this.sage = sage;
		this.sname = sname;
		this.saddress = saddress;
	}


	public Integer getSid() {
		return sid;
	}


	public String getSage() {
		return sage;
	}


	public void setSage(String sage) {
		this.sage = sage;
	}


	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	
	public void setSid(Integer sid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "Student [name="+this.sname+" age="+this.sage+" Address="+this.saddress +"]";
	}

}
