package swt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class Delete {

	protected Shell shell;
	String s=null;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Delete window = new Delete();
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
	    public void createContents() {
		shell = new Shell();
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setBackgroundImage(SWTResourceManager.getImage("D:\\\u5783\u573E\u6587\u4EF6\\swt\\src\\com\\yc\\image\\Registerbg.jpg"));
		shell.setImage(SWTResourceManager.getImage("D:\\\u5783\u573E\u6587\u4EF6\\swt\\src\\com\\yc\\image\\Register .png"));
		shell.setSize(785, 534);
		shell.setText("\u7528\u6237\u5220\u9664");
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x/2, Display.getCurrent() 
                .getClientArea().height / 2 - shell.getSize().y/2);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		
		btnNewButton.setBounds(378, 337, 80, 27);
		btnNewButton.setText("\u5220\u9664");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(277, 90, 61, 17);
		lblNewLabel_1.setText("\u59D3\u540D");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(277, 145, 61, 17);
		lblNewLabel_2.setText("\u5B66\u53F7");
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setText("\u6027\u522B");
		lblNewLabel_4.setBounds(277, 199, 61, 17);
		
		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setBounds(277, 257, 61, 17);
		lblNewLabel_5.setText("\u73ED\u7EA7");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(344, 87, 150, 17);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(344, 142, 150, 17);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(345, 196, 148, 17);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(344, 254, 150, 17);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String t1=text_1.getText();
				String t2=text_2.getText();
				String t3=text_3.getText();
				String t4=text_4.getText();
				if(t1.equals("")){
					MessageBox mb=new MessageBox(shell);
					mb.setText("ɾ��ʧ��");
					mb.setMessage("����������");
					mb.open();
				}else if(t2.equals("")){
					MessageBox mb=new MessageBox(shell);
					mb.setText("ɾ��ʧ��");
					mb.setMessage("������ѧ��");
					mb.open();
				}else if(t3.equals("")){
					MessageBox mb=new MessageBox(shell);
					mb.setText("ɾ��ʧ��");
					mb.setMessage("�������Ա�");
					mb.open();
				}
				else if(t4.equals("")){
					MessageBox mb=new MessageBox(shell);
					mb.setText("ɾ��ʧ��");
					mb.setMessage("������༶");
					mb.open();
				}
//				if(!((t1.equals(""))&&(t.equals(""))&&(t2.equals(""))&&(t3.equals(""))&&(t4.equals(""))&&(!(t4.equals(vCode.getCode()))))){
					if(!(t1.equals(""))){
						if(!(t2.equals(""))){
							if(!(t3.equals(""))){
								if(!(t4.equals(""))){
											try {
												//��������
												Class.forName("com.mysql.jdbc.Driver");
												//��������
												try {
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
															"root","a");
					
													//�ַ�����ƴ�� ����Ҫ���ǣ��ñ���������������
													
													String sql="delete from student where Sname=? and Sno=? and Ssex=? and Sclass=?";
													PreparedStatement ps = con.prepareStatement(sql);
													ps.setString(1,t1);
													ps.setString(2,t2);
													ps.setString(3,t3);
													ps.setString(4,t4);
													//����������,ɾ�����治��Ҫsql
													int result=ps.executeUpdate();
													if(result>0){
														MessageBox mb=new MessageBox(shell);
														mb.setText("ɾ��");
														mb.setMessage("ɾ��ע��,������ת��");
														mb.open();
														shell.dispose();
														Book b=new Book();
														b.open();
													}else{
														MessageBox mb=new MessageBox(shell);
														mb.setText("ɾ��ʧ��");
														mb.setMessage("��������ɾ��");
														mb.open();
													}
												} catch (SQLException e1) {
													e1.printStackTrace();
												}
											} catch (ClassNotFoundException e1) {
												e1.printStackTrace();
											}
										}
									}
								}
							}
						}				
		});

	}
}
