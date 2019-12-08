package ll;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
 
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
		javax.swing.JFrame jf=new javax.swing.JFrame();
		jf.setTitle("欢迎来到学生选课系统");
		jf.setSize(400,400);//只对顶级容器有效
		jf.setDefaultCloseOperation(3);//窗体关闭时结束程序
		jf.setLocationRelativeTo(null);//居中
		jf.setResizable(true);
		jf.setVisible(true);
		
		java.awt.FlowLayout fl=new java.awt.FlowLayout(FlowLayout.CENTER,100,10);
		jf.setLayout(fl);
		
		java.awt.Dimension dim=new java.awt.Dimension(100, 40);//按钮的大小	
		
		javax.swing.JButton button=new javax.swing.JButton();
		button.setText("选课");
		button.setPreferredSize(dim);
		jf.add(button);
		
		javax.swing.JButton button2=new javax.swing.JButton();
		button2.setText("退课");
		button2.setPreferredSize(dim);
		jf.add(button2);
		
		javax.swing.JButton button3=new javax.swing.JButton();
		button3.setText("打印课表");
		button3.setPreferredSize(dim);
		jf.add(button3);
		
		
					
			
		}
		// 通过我们获取的登录界面对象，用dispose方法关闭它
		login.dispose();
		}
	}

