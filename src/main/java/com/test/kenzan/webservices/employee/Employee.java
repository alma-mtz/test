package com.test.kenzan.webservices.employee;

import java.util.Date;

public class Employee {

	private Integer id;
	private String FirstName;
	private String MiddleInitial;
	private String LastName;
	private Date DateOfBirth;
	private Date DateOfEmployment;
	private boolean Status;
	
	public Employee(Integer id, String FirstName, String MiddleInitial, String LastName, Date DateOfBirth, Date DateOfEmployment, boolean Status) {
		super();
		this.id = id;
		this.FirstName = FirstName;
		this.MiddleInitial = MiddleInitial;
		this.LastName = LastName;
		this.DateOfBirth = DateOfBirth;
		this.DateOfEmployment = DateOfEmployment;
		this.Status = Status;
	}
	
	public Employee() {
		
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}
	
	public String getMiddleInitial() {
		return MiddleInitial;
	}
	public void setMiddleInitial(String MiddleInitial) {
		this.MiddleInitial = MiddleInitial;
	}
	
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String LastName) {
		this.LastName = LastName;
	}
	
	public Date getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(Date DateOfBirth) {
		this.DateOfBirth = DateOfBirth;
	}
	
	public Date getDateOfEmployment() {
		return DateOfEmployment;
	}
	public void setDateOfEmployment(Date DateOfEmployment) {
		this.DateOfEmployment = DateOfEmployment;
	}
	
	public boolean getStatus() {
		return Status;
	}
	public void setStatus(boolean Status) {
		this.Status = Status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
