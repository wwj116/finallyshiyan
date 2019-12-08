# finallyshiyan
综合性实验  学生选课系统设计

实验目的
分析学生选课系统
使用GUI窗体及其组件设计窗体界面
完成学生选课过程业务逻辑编程
基于文件保存并读取数据
处理异常
实验要求
一、系统角色分析及类设计
例如：学校有“人员”，分为“教师”和“学生”，教师教授“课程”，学生选择课程。
定义每种角色人员的属性，及其操作方法。
属性示例：	人员（编号、姓名、性别……）
教师（编号、姓名、性别、所授课程、……）
			学生（编号、姓名、性别、所选课程、……）
			课程（编号、课程名称、上课地点、时间、授课教师、……）
以上属性仅为示例，同学们可以自行扩展。

二、要求:
1、设计GUI窗体，支持学生注册、课程新加、学生选课、学生退课、打印学生选课列表等操作。
2、基于事件模型对业务逻辑编程，实现在界面上支持上述操作。
3、针对操作过程中可能会出现的各种异常，做异常处理
4、基于输入/输出编程，支持学生、课程、教师等数据的读写操作。
5、基于Github.com提交实验，包括实验SRC源文件夹程序、README.MD实验报告文档。
6、本次实验是综合性实验，在40%的实验成绩中占比最大，望同学们认真对待。
7、提交截止时间：12月8日。
实验过程：
在实验GUI编程代码的基础上完善代码
1.书104页例5-4，通过按钮点击事件连接界面
按钮点击事件又需要监听来实现
//对当前窗体添加监听方法
		button.addActionListener(ll);//监控按钮
所以通过在窗体添加监听方法实现监听。
核心代码：

		//首先实例化登录按钮监听类的对象，并把登录界面中账号和密码输入框的对象传给它
		LoginListener ll=new LoginListener(jf,textname,jp);
		//对当前窗体添加监听方法
		button.addActionListener(ll);//监控按钮
    
    //监听事件
public class LoginListener implements ActionListener{
 
	private javax.swing.JTextField jt;//账号输入框对象
	private javax.swing.JPasswordField jp;//密码输入框对象
	
	
	
	private javax.swing.JFrame login;//定义一个窗体对象
	public LoginListener(javax.swing.JFrame login,javax.swing.JTextField jt,javax.swing.JPasswordField jp) {
		this.login=login;//获取登录界面
		this.jt=jt;//获取登录界面中的账号输入框对象
		this.jp=jp;//获取登录界面中的密码输入框对象
	}
 
	public LoginListener(JFrame jf, JButton button) {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		//利用get方法来获取账号和密码对象的文本信息，并用equal方法进行判断。最好不要用==，用==这个地方验证不过去。
		if(jt.getText().equals("Alex")&&jp.getText().equals("123")) {
		
		//满足条件，则生成一个新的界面
  
  编写感想：
  感觉Java是一门很需要英语作为基础的编程语言，逻辑性思维也要强。另一方面，也要花时间研究。然后就是把之前的信息放到打印这一块还没有实现，
  交互性不够，需要完善。总得一句话来说，任何一种编程语言都需要大量的时间去练习，才可能有所成果。
    
