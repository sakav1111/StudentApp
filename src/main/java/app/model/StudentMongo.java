package app.model;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class StudentMongo {
	
	@Id
	private int sno;
	
	
	private String name;
	
	
	private String city;
	
	
	private int marks;

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
	public StudentMongo() {
		// TODO Auto-generated constructor stub
	}

	public StudentMongo(int sno, String name, String city, int marks) {
		super();
		this.sno = sno;
		this.name = name;
		this.city = city;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", name=" + name + ", city=" + city + ", marks=" + marks + "]";
	}
	
	
	
	

}
