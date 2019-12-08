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
//����ˣ���������ѧ����Ϣ�ͱ�ѡ�γ�	
	List<Student> students = new ArrayList<Student>();
	Map<Integer, Student> map1 = new HashMap<Integer, Student>();
	List<Course> courses = new ArrayList<Course>();
	Map<String, Course> map2 = new HashMap<String, Course>();
	Scanner in = new Scanner(System.in);
 
	public AdministratorOp() {
	}
 
//~~~~~~~~~~~~~~~~~���ļ�����List~~~~~~~~~~~~~~~~~~~~~
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
 
//����Ϣд���ļ�
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
			// TODO �Զ����ɵ� catch ��
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
 
	}
 
//~~~~~~~~~~~~~~~~~~~~~~~~~ ����List������Map~~~~~~~~~~~~~~~~~~~~~~~
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
 
	// ~~~~~~~~~~~~~~~~~~~~~~ ��ɾ���~~~~~~~~~~~~~~~~~~~~~~~
	// ����ѧ��������Ϣ
	public void add() {
		System.out.println("����ѧ����Ϣ������0����");
		while (true) {
			int id = in.nextInt();
			if(id!=0) {
			String name = in.next();
			Student s = new Student(id, name);
			students.add(s);
			Collections.sort(students);
			map1.put(id, s);
			System.out.println("��ӳɹ�");
			}
			if (id == 0) {
				break;
			}
		}
	}
 
	// ɾ��ѧ����Ϣ
	public void del() {
		while(true) {
			int id = in.nextInt();
			Student s = map1.get(id);
			students.remove(s);
			map1.remove(id);
			System.out.println("�Ƴ��ɹ�");
			if (id == 0) {
				break;
			}
		}
	}
	// ���ӿγ̻�����Ϣ
	public void add2() {
		System.out.println("����γ���Ϣ������end����");
		while (true) {	
			String id = in.nextLine();
			if(!id.equals("end"))
			{
			String name = in.nextLine();
			Course cr = new Course(id, name);
			courses.add(cr);
			map2.put(id, cr);
			System.out.println("��ӳɹ�");
			}
			else{
				//System.out.println("��ӽ���");
				break;
			}
		}
	}
 
	// ɾ���γ���Ϣ
	public void del2() {
		while(true) {
			String id = in.next();
			if(!id.equals("end")) {
			Course cr = map2.get(id);
			courses.remove(cr);
			map2.remove(id);
			System.out.println("�Ƴ��ɹ�");
			}
			else
			{
				break;
			}
		}
	}
 
	// ����ѧ�Ų���ѧ��
	public void query1() {
		System.out.println("������Ҫ��ѯ��ѧ��ѧ�ţ�");
		if (in.hasNext()) {
			int id = in.nextInt();
			System.out.println(map1.get(id));
			map1.get(id).travese();
		}
	}
 
	// ���ݿγ̺Ų��ҿγ�
	public void query2() {
		System.out.println("������Ҫ��ѯ�Ŀγ̺ţ�");
		if (in.hasNext()) {
			String id = in.nextLine();
			System.out.println(map2.get(id));
		}
	}
 
	// �޸�ѧ��������Ϣ
	public void modify1() {
		System.out.println("������Ҫ�޸ĵ�ѧ����ѧ�ţ�");
		int id = in.nextInt();
		Student s = map1.get(id);
		System.out.println("�����޸ĺ��ѧ����Ϣ��");
		int no = in.nextInt();
		String name = in.next();
		int i = students.indexOf(s);
		students.set(i, new Student(no, name));
		Collections.sort(students);
		map1.remove(id);
		map1.put(no, new Student(no, name));
		System.out.println("�޸ĳɹ�");
	}
 
	// �޸Ŀγ���Ϣ
	public void modify2() {
		System.out.println("������Ҫ�޸ĵĿγ̵Ŀγ̺ţ�");
		String id = in.nextLine();
		Course cr = map2.get(id);
		System.out.println("�����޸ĺ�Ŀγ���Ϣ��");
		String no = in.nextLine();
		String name = in.nextLine();
		int i = courses.indexOf(cr);
		courses.set(i, new Course(no, name));
		map2.remove(id);
		map2.put(no, new Course(no, name));
		System.out.println("�޸ĳɹ�");
	}
 
//	~~~~~~~~~~~~~~~~~~~~~~ ����list~~~~~~~~~~~~~~~~~~~~~~~
	void display1() {
		System.out.println("���е�ѧ����Ϣ��");
		for (Student s : students) {
			System.out.println(s.toString());
			s.travese();
		}
	}
 
	void display2() {
		System.out.println("���еı�ѡ�γ���Ϣ��");
		for (Course course : courses) {
			System.out.println(course.toString());
		}
	}
public	void close()
{
	in.close();
}
}

