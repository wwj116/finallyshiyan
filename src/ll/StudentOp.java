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
 
	// ~~~~~~~~~~~~~~~~~���ļ�������Ϣ~~~~~~~~~~~~~~~~~~~~~
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
 
// ����Ϣд���ļ�
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
			// TODO �Զ����ɵ� catch ��
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
 
	}
 
//~~~~~~~~~~~~~~~~~~~~~~~~~ ����List������Map~~~~~~~~~~~~~~~~~~~~~~~
	public void createMap() {
		for (int i = 0; i < courses.size(); i++) {
			map.put(courses.get(i).getId(), courses.get(i));
		}
 
		//����map
		  /*Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			System.out.println(key + " " + map.get(key));
		}		*/
	}
 
//������ʾ��ѡ�γ�
	public void displayAllCourse() {
		System.out.println("���еı�ѡ�γ���Ϣ��");
		for (Course course : courses) {
			System.out.println(course.toString());
		}
	}
 
//���ݿγ̺Ų�ѯ��ѡ�γ�
	public void queryCourse() {
		System.out.println("������Ҫ��ѯ�Ŀγ̺ţ�");
		String str = in.next();
		System.out.println(str);
		System.out.println((map.containsKey(str) ? "yes" : "no"));
		System.out.println(map.get(str));
	}
 
//��ʾ��ѡ�γ�
	public void display() {
		System.out.println("��ѡ�γ̣�");
		st.travese();
	}
 
//������ѡ�γ�
	public void addSelect() {
		System.out.println("������ѡ�γ̵Ŀγ̺ţ�����end����");
		while (true) {
			String id = in.nextLine();
			if (!id.equals("end")) {
				Course cr = map.get(id);
				st.getCourses().add(cr);
				System.out.println("ѡ�γɹ�");
			} else {
				// System.out.println("��ӽ���");
				break;
			}
		}
	}
 
//������ѡ�γ�
	public void deleteSelect() {
		System.out.println("Ҫɾ���γ̵Ŀγ̺ţ�����end����");
		while (true) {
			String id = in.nextLine();
			if (!id.equals("end")) {
				Course cr = map.get(id);
				st.getCourses().remove(cr);
				System.out.println("ɾ���ɹ�");
			} else {
				// System.out.println("��ӽ���");
				break;
			}
		}
	}
 
	public void close() {
		in.close();
	}
}

