package com.javaworm;

public class Student {
	
	  public Student(int i, String s) {
		   this.id = i;
		   this.name = s;
	    }


		private int id;
		private String name;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		@Override
		public String toString() {
			return "[id="+id+",name="+name+"]";
		}
	}


