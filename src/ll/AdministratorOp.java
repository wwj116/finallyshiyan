package ll;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
 
public class AdministratorOp {
//管理端，用来管理学生信息和备选课程	
	List<Student> students = new ArrayList<Student>();
	Map<Integer, Student> map1 = new HashMap<Integer, Student>();
	List<Course> courses = new ArrayList<Course>();
	Map<String, Course> map2 = new HashMap<String, Course>();
	Scanner in = new Scanner(System.in);
 
	public AdministratorOp() {
	}
 
//~~~~~~~~~~~~~~~~~从文件读入List~~~~~~~~~~~~~~~~~~~~~
	public void load1() {
		File file = new File("students.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			students = (List<Student>) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
 
	}
 
	public void load2() {
		File file = new File("courses.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			courses = (List<Course>) ois.readObject();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
 
	}
 
//将信息写回文件
	public void save1() {
		File file = new File("students.txt");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(students);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
 
	}
 
	public void save2() {
		File file = new File("courses.txt");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(courses);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
 
	}
 
//~~~~~~~~~~~~~~~~~~~~~~~~~ 根据List来创建Map~~~~~~~~~~~~~~~~~~~~~~~
	public void createMap1() {
		for (int i = 0; i < students.size(); i++) {
			map1.put(students.get(i).getId(), students.get(i));
		}
	}
 
	public void createMap2() {
		for (int i = 0; i < courses.size(); i++) {
			map2.put(courses.get(i).getId(), courses.get(i));
		}
	}
 
	// ~~~~~~~~~~~~~~~~~~~~~~ 增删查改~~~~~~~~~~~~~~~~~~~~~~~
	// 增加学生基本信息
	public void add() {
		System.out.println("输入学生信息，输入0结束");
		while (true) {
			int id = in.nextInt();
			if(id!=0) {
			String name = in.next();
			Student s = new Student(id, name);
			students.add(s);
			Collections.sort(students);
			map1.put(id, s);
			System.out.println("添加成功");
			}
			if (id == 0) {
				break;
			}
		}
	}
 
	// 删除学生信息
	public void del() {
		while(true) {
			int id = in.nextInt();
			Student s = map1.get(id);
			students.remove(s);
			map1.remove(id);
			System.out.println("移除成功");
			if (id == 0) {
				break;
			}
		}
	}
	// 增加课程基本信息
	public void add2() {
		System.out.println("输入课程信息，输入end结束");
		while (true) {	
			String id = in.nextLine();
			if(!id.equals("end"))
			{
			String name = in.nextLine();
			Course cr = new Course(id, name);
			courses.add(cr);
			map2.put(id, cr);
			System.out.println("添加成功");
			}
			else{
				//System.out.println("添加结束");
				break;
			}
		}
	}
 
	// 删除课程信息
	public void del2() {
		while(true) {
			String id = in.next();
			if(!id.equals("end")) {
			Course cr = map2.get(id);
			courses.remove(cr);
			map2.remove(id);
			System.out.println("移除成功");
			}
			else
			{
				break;
			}
		}
	}
 
	// 根据学号查找学生
	public void query1() {
		System.out.println("请输入要查询的学生学号：");
		if (in.hasNext()) {
			int id = in.nextInt();
			System.out.println(map1.get(id));
			map1.get(id).travese();
		}
	}
 
	// 根据课程号查找课程
	public void query2() {
		System.out.println("请输入要查询的课程号：");
		if (in.hasNext()) {
			String id = in.nextLine();
			System.out.println(map2.get(id));
		}
	}
 
	// 修改学生基本信息
	public void modify1() {
		System.out.println("请输入要修改的学生的学号：");
		int id = in.nextInt();
		Student s = map1.get(id);
		System.out.println("输入修改后的学生信息：");
		int no = in.nextInt();
		String name = in.next();
		int i = students.indexOf(s);
		students.set(i, new Student(no, name));
		Collections.sort(students);
		map1.remove(id);
		map1.put(no, new Student(no, name));
		System.out.println("修改成功");
	}
 
	// 修改课程信息
	public void modify2() {
		System.out.println("请输入要修改的课程的课程号：");
		String id = in.nextLine();
		Course cr = map2.get(id);
		System.out.println("输入修改后的课程信息：");
		String no = in.nextLine();
		String name = in.nextLine();
		int i = courses.indexOf(cr);
		courses.set(i, new Course(no, name));
		map2.remove(id);
		map2.put(no, new Course(no, name));
		System.out.println("修改成功");
	}
 
//	~~~~~~~~~~~~~~~~~~~~~~ 遍历list~~~~~~~~~~~~~~~~~~~~~~~
	void display1() {
		System.out.println("所有的学生信息：");
		for (Student s : students) {
			System.out.println(s.toString());
			s.travese();
		}
	}
 
	void display2() {
		System.out.println("所有的备选课程信息：");
		for (Course course : courses) {
			System.out.println(course.toString());
		}
	}
public	void close()
{
	in.close();
}
}

