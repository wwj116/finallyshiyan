package ll;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
 
public class StudentOp {
	Scanner in = new Scanner(System.in);
	Student st;
	List<Student> students = new ArrayList<Student>();
	List<Course> courses = new ArrayList<Course>();
	Map<String, Course> map = new HashMap<String, Course>();
 
	public StudentOp(int no) {
		load3(no);
		load4();
 
	}
 
	// ~~~~~~~~~~~~~~~~~从文件读入信息~~~~~~~~~~~~~~~~~~~~~
	public void load3(int n) {
		File file = new File("students.txt");
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
		for (int i = 0; i < students.size(); i++) {
			if (n == students.get(i).getId()) {
				st = students.get(i);
				break;
			}
		}
 
	}
 
	public void load4() {
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
 
// 将信息写回文件
	public void save3() {
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
 
	public void save4() {
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
	public void createMap() {
		for (int i = 0; i < courses.size(); i++) {
			map.put(courses.get(i).getId(), courses.get(i));
		}
 
		//遍历map
		  /*Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + " " + map.get(key));
		}		*/
	}
 
//遍历显示备选课程
	public void displayAllCourse() {
		System.out.println("所有的备选课程信息：");
		for (Course course : courses) {
			System.out.println(course.toString());
		}
	}
 
//根据课程号查询备选课程
	public void queryCourse() {
		System.out.println("请输入要查询的课程号：");
		String str = in.next();
		System.out.println(str);
		System.out.println((map.containsKey(str) ? "yes" : "no"));
		System.out.println(map.get(str));
	}
 
//显示所选课程
	public void display() {
		System.out.println("所选课程：");
		st.travese();
	}
 
//增加所选课程
	public void addSelect() {
		System.out.println("输入所选课程的课程号，输入end结束");
		while (true) {
			String id = in.nextLine();
			if (!id.equals("end")) {
				Course cr = map.get(id);
				st.getCourses().add(cr);
				System.out.println("选课成功");
			} else {
				// System.out.println("添加结束");
				break;
			}
		}
	}
 
//减少所选课程
	public void deleteSelect() {
		System.out.println("要删除课程的课程号，输入end结束");
		while (true) {
			String id = in.nextLine();
			if (!id.equals("end")) {
				Course cr = map.get(id);
				st.getCourses().remove(cr);
				System.out.println("删除成功");
			} else {
				// System.out.println("添加结束");
				break;
			}
		}
	}
 
	public void close() {
		in.close();
	}
}

