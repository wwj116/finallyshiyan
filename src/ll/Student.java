package ll;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
 
public class Student implements Serializable,Comparable<Student>{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Set<Course> courses;
 
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.courses = new HashSet<Course>();
	}
 
	public Student() {
		super();
		this.id = 0;
		this.name = null;
		this.courses = new HashSet<Course>();
	}
 
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
 
	public Set<Course> getCourses() {
		return courses;
	}
 
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
 
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
 
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id != other.id)
			return false;
		return true;
	}
 
	
	public String toString() {
		return "学号："+id+" " +"姓名："+name;
	}
	//遍历输出所选课程
	public void travese()
	{
		if(courses.size()>0)
		{
		for (Course course : courses) {
			System.out.println(course);
		}
		}
		else
		{
			System.out.println("还没有选课");
		}
	}
 
	public int compareTo(Student s) {
		
	   int result=this.id-s.id;
	   return result;
	}
	
	
}