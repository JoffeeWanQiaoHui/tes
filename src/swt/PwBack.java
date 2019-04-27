package swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class PwBack {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PwBack window = new PwBack();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage("D:\\\u5783\u573E\u6587\u4EF6\\swt\\src\\com\\yc\\image\\pwbg.jpg"));
		shell.setImage(SWTResourceManager.getImage("D:\\\u5783\u573E\u6587\u4EF6\\swt\\src\\com\\yc\\image\\pwback.jpg"));
		shell.setSize(445, 314);
		shell.setText("\u5BC6\u7801\u627E\u56DE");
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x/2, Display.getCurrent() 
                .getClientArea().height / 2 - shell.getSize().y/2); 

		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		label.setBounds(87, 92, 71, 17);
		label.setText("\u8D26\u53F7\u6216\u90AE\u7BB1");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(175, 92, 122, 17);
		
		Button btnNewUtton = new Button(shell, SWT.NONE);
		btnNewUtton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String t=text.getText();
				//����һ���ļ�
						//����һ���ļ�������ԭ��������,true������
						//��false��ʾ����,�ؼ�������ļ�������ʱ��IO�쳣
						FileOutputStream fos = null;
						try {
							fos = new FileOutputStream("d:/a.txt",false);
						} catch (FileNotFoundException e2) {
							e2.printStackTrace();
						}
						BufferedOutputStream bos=new BufferedOutputStream(fos);
						DataOutputStream dos=new DataOutputStream(bos);
						try {
							dos.writeUTF(t);
						} catch (IOException e2) {
							e2.printStackTrace();
						}
						try {
							dos.close();
						} catch (IOException e2) {
							e2.printStackTrace();
						}			
	
				try {
					//��������
					Class.forName("com.mysql.jdbc.Driver");
					//��������
					try {
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
								"root","a");
						//����������
						//Statement statement=con.createStatement();
						//�ַ�����ƴ�� ����Ҫ���ǣ��ñ���������������
						//String sql="select * from snakes where account='"+t+"' or email='"+t+"'";
						String sql="select * from snakes where account=? or email=?";
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setString(1, t);
						ps.setString(2, t);
						//���￪ʼ��һ��
						
						ResultSet rs=ps.executeQuery();//��ѯҪ�õ�
						//���￪ʼ��һ��
						//ResultSet rs=statement.executeQuery(sql);//��ѯҪ�õ�
						//rs.next() �ж�������������û����һ������,����������ֵ
						if(t.equals("")){
							MessageBox mb=new MessageBox(shell);
							mb.setText("�����һ�ʧ��");
							mb.setMessage("�������˺Ż�����");
							mb.open();
						}
						if((rs.next())&&(!(t.equals("")))){
							MessageBox mb=new MessageBox(shell);
							mb.setText("����ɹ��һ�");
							mb.setMessage("������ת�޸��������");
							mb.open();
							shell.dispose();
							PwbackModify pm=new PwbackModify();
							pm.open();
						}else{
							MessageBox mb=new MessageBox(shell);
							mb.setText("�����һ�ʧ��");
							mb.setMessage("û�д��˻�������");
							mb.open();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewUtton.setBounds(199, 153, 64, 27);
		btnNewUtton.setText("\u786E\u5B9A");

	}

}
