package ll;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
//����ʵ�ֵ�¼����
public class Login {
	
	//���������
	public static void main(String args[]) {
		Login l=new Login();
		l.showUI();
	}
	
	public void showUI() {
		javax.swing.JFrame jf=new javax.swing.JFrame();
		jf.setTitle("��¼����");
		jf.setSize(340,340);//ֻ�Զ���������Ч
		jf.setDefaultCloseOperation(3);//����ر�ʱ��������
		jf.setLocationRelativeTo(null);//����
		jf.setResizable(true);
		
 
		//ѡ�񲼾����ͣ�������ʽ���ֵĶ���,��������ÿ�����֮�����5cm
		java.awt.FlowLayout fl=new java.awt.FlowLayout(FlowLayout.CENTER,20,20);
		jf.setLayout(fl);//���ö��������Ĳ���Ϊ��ʽ����
		
		//���ø�ʽ��С
		
		java.awt.Dimension dim2=new java.awt.Dimension(50, 50);//��ǩ�Ĵ�С
		java.awt.Dimension dim3=new java.awt.Dimension(230,30);//�����Ĵ�С		
		java.awt.Dimension dim4=new java.awt.Dimension(100, 40);//��ť�Ĵ�С	
		
		
		
		//��ӡ��˺š���ǩ
		JLabel labname=new JLabel();
		labname.setText("�˺ţ�");
		labname.setPreferredSize(dim2);
		jf.add(labname);
		
		//����˺�����򣬲���Ӽ���¼�
		JTextField textname=new JTextField();
		textname.setPreferredSize(dim3);
		jf.add(textname);
		
		//��ӡ����롱��ǩ
		JLabel labpassword=new JLabel();
		labpassword.setText("���룺");
		labpassword.setPreferredSize(dim2);
		jf.add(labpassword);
		
		//�����������򣬲���Ӽ���¼�
		JPasswordField jp=new JPasswordField();
		jp.setPreferredSize(dim3);
		jf.add(jp);
		
		//���һ��button��ť
		javax.swing.JButton button=new javax.swing.JButton();
		button.setText("��¼");
		button.setPreferredSize(dim4);
		jf.add(button);
		
		javax.swing.JButton button2=new javax.swing.JButton();
		button2.setText("ע��");
		button2.setPreferredSize(dim4);
		jf.add(button2);
		
		jf.setVisible(true);
		
		//����ʵ������¼��ť������Ķ��󣬲��ѵ�¼�������˺ź����������Ķ��󴫸���
		LoginListener ll=new LoginListener(jf,textname,jp);
		//�Ե�ǰ������Ӽ�������
		button.addActionListener(ll);//��ذ�ť
		
	}
}

		