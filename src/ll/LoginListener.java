package ll;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
 
//�����¼�
public class LoginListener implements ActionListener{
 
	private javax.swing.JTextField jt;//�˺���������
	private javax.swing.JPasswordField jp;//������������
	
	
	
	private javax.swing.JFrame login;//����һ���������
	public LoginListener(javax.swing.JFrame login,javax.swing.JTextField jt,javax.swing.JPasswordField jp) {
		this.login=login;//��ȡ��¼����
		this.jt=jt;//��ȡ��¼�����е��˺���������
		this.jp=jp;//��ȡ��¼�����е�������������
	}
 
	public LoginListener(JFrame jf, JButton button) {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		//����get��������ȡ�˺ź����������ı���Ϣ������equal���������жϡ���ò�Ҫ��==����==����ط���֤����ȥ��
		if(jt.getText().equals("Alex")&&jp.getText().equals("123")) {
		
		//����������������һ���µĽ���
		javax.swing.JFrame jf=new javax.swing.JFrame();
		jf.setTitle("��ӭ����ѧ��ѡ��ϵͳ");
		jf.setSize(400,400);//ֻ�Զ���������Ч
		jf.setDefaultCloseOperation(3);//����ر�ʱ��������
		jf.setLocationRelativeTo(null);//����
		jf.setResizable(true);
		jf.setVisible(true);
		
		java.awt.FlowLayout fl=new java.awt.FlowLayout(FlowLayout.CENTER,100,10);
		jf.setLayout(fl);
		
		java.awt.Dimension dim=new java.awt.Dimension(100, 40);//��ť�Ĵ�С	
		
		javax.swing.JButton button=new javax.swing.JButton();
		button.setText("ѡ��");
		button.setPreferredSize(dim);
		jf.add(button);
		
		javax.swing.JButton button2=new javax.swing.JButton();
		button2.setText("�˿�");
		button2.setPreferredSize(dim);
		jf.add(button2);
		
		javax.swing.JButton button3=new javax.swing.JButton();
		button3.setText("��ӡ�α�");
		button3.setPreferredSize(dim);
		jf.add(button3);
		
		
					
			
		}
		// ͨ�����ǻ�ȡ�ĵ�¼���������dispose�����ر���
		login.dispose();
		}
	}

