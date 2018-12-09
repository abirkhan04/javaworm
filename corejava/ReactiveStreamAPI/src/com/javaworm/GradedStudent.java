package com.javaworm;

public class GradedStudent extends Student{
	
	private int gid;

	public GradedStudent(int i, String s) {
		super(i, s);
		// TODO Auto-generated constructor stub
	}
	
	public GradedStudent(int id, int gid, String name) {
		super(id, name);
		this.gid = gid;
	}
	
	@Override
	public String toString() {
		return "[id="+super.getId()+",name="+super.getName()+",fid="+gid+"]";
	}

}
