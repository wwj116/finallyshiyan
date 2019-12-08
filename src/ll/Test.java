package ll;
import java.util.Scanner;

public class Test {
 
	public static void main(String[] args) {
//~~~~~~~~~~~~~测试管理端~~~~~~~~~~~~~~~~~~~~~~~~~~
	    //添加学生
		AdministratorOp a1=new AdministratorOp();
		a1.add();
		a1.display1();
		a1.close();
		a1.save1();
		//添加课程
		AdministratorOp a2=new AdministratorOp();
		a2.add2();
		a2.display2();
		a2.close();			    
	    a2.save2();
//	测试删除，查找，修改
	    AdministratorOp a3=new AdministratorOp();
		a3.load1();
		a3.createMap1();
		a3.load2();
		a3.createMap2();
		a3.display1();
		a3.del();
		a3.display1();
		a3.del2();
		a3.display2();
		a3.query1();
		a3.query2();
		a3.modify1();
		a3.display1();
		a3.modify2();
		a3.display2();
        a3.close();
        a3.save1();
        a3.save2();
//~~~~~~~~~~~~~~~~测试学生端~~~~~~~~~~~~~~~~~~~~~~~~~
    /*Scanner in=new Scanner(System.in);
    System.out.println("请输入学号：");
    int id=in.nextInt();
	StudentOp sto=new StudentOp(id);
	sto.createMap();
	//sto.displayAllCourse();
	//sto.queryCourse();
	
//	sto.addSelect();
//	sto.deleteSelect();
	sto.display();
	sto.close();
	in.close();
//	sto.save3();
//	sto.save4();
*/	}
 
}
