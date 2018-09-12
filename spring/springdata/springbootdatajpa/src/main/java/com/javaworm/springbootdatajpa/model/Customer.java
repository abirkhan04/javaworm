package com.javaworm.springbootdatajpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="customer")
public class Customer {    
	
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id;
	    private String firstName;
	    public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		private String lastName;

	    protected Customer() {}

	    public Customer(String firstName, String lastName) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	    }

	    @Override
	    public String toString() {
	        return String.format(
	                "Customer[id=%d, firstName='%s', lastName='%s']",
	                id, firstName, lastName);
	    }
	
	
}
