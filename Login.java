package ll;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
//首先实现登录界面
public class Login {
	
	//主函数入口
	public static void main(String args[]) {
		Login l=new Login();
		l.showUI();
	}
	
	public void showUI() {
		javax.swing.JFrame jf=new javax.swing.JFrame();
		jf.setTitle("登录界面");
		jf.setSize(340,340);//只对顶级容器有效
		jf.setDefaultCloseOperation(3);//窗体关闭时结束程序
		jf.setLocationRelativeTo(null);//居中
		jf.setResizable(true);
		
 
		//选择布局类型，定义流式布局的对象,并且设置每个组件之间相隔5cm
		java.awt.FlowLayout fl=new java.awt.FlowLayout(FlowLayout.CENTER,20,20);
		jf.setLayout(fl);//设置顶级容器的布局为流式布局
		
		//设置格式大小
		
		java.awt.Dimension dim2=new java.awt.Dimension(50, 50);//标签的大小
		java.awt.Dimension dim3=new java.awt.Dimension(230,30);//输入框的大小		
		java.awt.Dimension dim4=new java.awt.Dimension(100, 40);//按钮的大小	
		
		
		
		//添加“账号”标签
		JLabel labname=new JLabel();
		labname.setText("账号：");
		labname.setPreferredSize(dim2);
		jf.add(labname);
		
		//添加账号输入框，并添加监控事件
		JTextField textname=new JTextField();
		textname.setPreferredSize(dim3);
		jf.add(textname);
		
		//添加“密码”标签
		JLabel labpassword=new JLabel();
		labpassword.setText("密码：");
		labpassword.setPreferredSize(dim2);
		jf.add(labpassword);
		
		//添加密码输入框，并添加监控事件
		JPasswordField jp=new JPasswordField();
		jp.setPreferredSize(dim3);
		jf.add(jp);
		
		//添加一个button按钮
		javax.swing.JButton button=new javax.swing.JButton();
		button.setText("登录");
		button.setPreferredSize(dim4);
		jf.add(button);
		
		javax.swing.JButton button2=new javax.swing.JButton();
		button2.setText("注册");
		button2.setPreferredSize(dim4);
		jf.add(button2);
		
		jf.setVisible(true);
		
		//首先实例化登录按钮监听类的对象，并把登录界面中账号和密码输入框的对象传给它
		LoginListener ll=new LoginListener(jf,textname,jp);
		//对当前窗体添加监听方法
		button.addActionListener(ll);//监控按钮
		
	}
}

		