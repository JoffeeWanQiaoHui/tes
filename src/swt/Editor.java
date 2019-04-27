package swt;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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

public class Editor {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_10;
	String s=null;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Editor window = new Editor();
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
		shell.setText("\u7528\u6237\u7F16\u8F91");
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x/2, Display.getCurrent() 
                .getClientArea().height / 2 - shell.getSize().y/2); 

		Label label = new Label(shell, SWT.NONE);
		label.setBounds(277, 10, 41, 17);
		label.setText("\u8D26\u53F7");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(343, 10, 150, 17);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("\u5BC6\u7801");
		label_1.setBounds(277, 50, 41, 17);
		
		text_1 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(343, 50, 150, 17);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		
		btnNewButton.setBounds(362, 432, 80, 27);
		btnNewButton.setText("\u7F16\u8F91");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(277, 88, 55, 17);
		lblNewLabel.setText("\u786E\u5B9A\u5BC6\u7801");
		
		text_2 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_2.setBounds(343, 85, 150, 17);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(277, 387, 32, 17);
		label_2.setText("\u90AE\u7BB1");
		
		text_10 = new Text(shell, SWT.BORDER);
		text_10.setBounds(343, 384, 150, 17);
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(277, 122, 61, 17);
		lblNewLabel_1.setText("\u59D3\u540D");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(277, 163, 61, 17);
		lblNewLabel_2.setText("\u5B66\u53F7");
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setBounds(276, 243, 61, 17);
		lblNewLabel_3.setText("\u7535\u8BDD");
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setText("\u6027\u522B");
		lblNewLabel_4.setBounds(276, 201, 61, 17);
		
		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setBounds(276, 286, 61, 17);
		lblNewLabel_5.setText("\u73ED\u7EA7");
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(343, 119, 150, 17);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(343, 160, 150, 17);
		
		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBounds(345, 198, 148, 17);
		
		text_6 = new Text(shell, SWT.BORDER);
		text_6.setBounds(343, 240, 150, 17);
		
		text_7 = new Text(shell, SWT.BORDER);
		text_7.setBounds(343, 283, 150, 17);
		
		Label lblNewLabel_6 = new Label(shell, SWT.NONE);
		lblNewLabel_6.setBounds(277, 318, 61, 17);
		lblNewLabel_6.setText("\u5E74\u7EA7");
		
		Label lblNewLabel_7 = new Label(shell, SWT.NONE);
		lblNewLabel_7.setBounds(277, 356, 61, 17);
		lblNewLabel_7.setText("\u5B66\u9662");
		
		text_8 = new Text(shell, SWT.BORDER);
		text_8.setBounds(343, 316, 150, 17);
		
		text_9 = new Text(shell, SWT.BORDER);
		text_9.setBounds(343, 353, 150, 17);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			private DataInputStream dis;

			@Override
			public void widgetSelected(SelectionEvent e) {
				//账号
				String t=text.getText();
				//密码
				String t1=text_1.getText();
				//确定密码
				String t2=text_2.getText();
				//姓名
				String t3=text_3.getText();
				//学号
				String t4=text_4.getText();
				//性别
				String t5=text_5.getText();
				//电话
				String t6=text_6.getText();
				//班级
				String t7=text_7.getText();
				//年级
				String t8=text_8.getText();
				//学院
				String t9=text_9.getText();
				//邮箱
				String t10=text_10.getText();
				if(t.equals("")){
					MessageBox mb=new MessageBox(shell);
					mb.setText("编辑失败");
					mb.setMessage("请输入账号");
					mb.open();
				}else if(t1.equals("")){
					MessageBox mb=new MessageBox(shell);
					mb.setText("编辑失败");
					mb.setMessage("请输入密码");
					mb.open();
				}else if(t2.equals("")){
					MessageBox mb=new MessageBox(shell);
					mb.setText("编辑失败");
					mb.setMessage("请输入确认密码");
					mb.open();
				}
				else if(t3.equals("")){
					MessageBox mb=new MessageBox(shell);
					mb.setText("编辑失败");
					mb.setMessage("请你输入邮箱");
					mb.open();
				}if(!(t1.equals(t2))){
					MessageBox mb=new MessageBox(shell);
					mb.setText("编辑失败");
					mb.setMessage("密码不一致");
					mb.open();
				}
//				if(!((t1.equals(""))&&(t.equals(""))&&(t2.equals(""))&&(t3.equals(""))&&(t4.equals(""))&&(!(t4.equals(vCode.getCode()))))){
					if(!(t.equals(""))){
						if(!(t1.equals(""))){
							if(!(t2.equals(""))){
								if(!(t3.equals(""))){
											try {
												//加载驱动
												Class.forName("com.mysql.jdbc.Driver");
												//建立连接
												try {
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
															"root","a");
													//创建语句对象
													Statement statement=con.createStatement();
													FileInputStream fis=new FileInputStream("D:/b.txt");
													BufferedInputStream bis=new BufferedInputStream(fis);
													dis = new DataInputStream(bis);
													String aa=dis.readUTF();
													//字符串的拼接 最重要的是：让变量不在引号里面
													//String sql="update student set password='"+t1+"'where account='"+aa+"'or email='"+aa+"'";
													String sql="update student set Sname='"+t3+"',Sno='"+t4+"',Ssex='"+t5+"',Sphone='"+t6+"'"
														+ ",Sclass='"+t7+"',Grade='"+t8+"',School='"+t9+"',account='"+t+"',password='"+t1+"',email='"+t10+"'where account='"+aa+"'or email='"+aa+"'";
													int result=statement.executeUpdate(sql);
													if(result>0){
														MessageBox mb=new MessageBox(shell);
														mb.setText("编辑");
														mb.setMessage("成功编辑,飞速跳转中");
														mb.open();
														shell.dispose();
														Book b=new Book();
														b.open();
													}else{
														MessageBox mb=new MessageBox(shell);
														mb.setText("编辑失败");
														mb.setMessage("请你重新编辑");
														mb.open();
													}
												} catch (SQLException e1) {
													e1.printStackTrace();
												} catch (FileNotFoundException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												} catch (IOException e1) {
													// TODO Auto-generated catch block
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




