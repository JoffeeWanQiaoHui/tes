package swt;

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
import org.omg.CORBA.PUBLIC_MEMBER;

import com.utils.ValidateCode;

public class Register {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Label label_3;
	String s=null;
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
			Register window = new Register();
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

	//创建一个方法，返回验证码
	public void code() {
		ValidateCode vCode = new ValidateCode(160,40,5,150);  
		label_3.setText(vCode.getCode());
		s=vCode.getCode();
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
		shell.setText("\u7528\u6237\u6CE8\u518C");
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x/2, Display.getCurrent() 
                .getClientArea().height / 2 - shell.getSize().y/2); 

		Label label = new Label(shell, SWT.NONE);
		label.setBounds(277, 42, 41, 17);
		label.setText("\u8D26\u53F7");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(343, 39, 150, 17);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("\u5BC6\u7801");
		label_1.setBounds(277, 78, 41, 17);
		
		text_1 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(343, 75, 150, 17);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		
		btnNewButton.setBounds(365, 425, 80, 27);
		btnNewButton.setText("\u6CE8\u518C");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(277, 116, 55, 17);
		lblNewLabel.setText("\u786E\u5B9A\u5BC6\u7801");
		
		text_2 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_2.setBounds(343, 113, 150, 17);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(277, 368, 32, 17);
		label_2.setText("\u90AE\u7BB1");
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(343, 365, 150, 17);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(343, 402, 91, 17);
		//ValidateCode vCode = new ValidateCode(160,40,5,150);
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				ValidateCode vCode = new ValidateCode(160,40,5,150);  
//				label_3.setText(vCode.getCode());
				code();
			}
		});
		btnNewButton_1.setBounds(444, 402, 80, 17);
		btnNewButton_1.setText("\u83B7\u53D6\u9A8C\u8BC1\u7801");
		
		label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(276, 405, 61, 20);
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(277, 157, 61, 17);
		lblNewLabel_1.setText("\u59D3\u540D");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(276, 201, 61, 17);
		lblNewLabel_2.setText("\u5B66\u53F7");
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setBounds(276, 286, 61, 17);
		lblNewLabel_3.setText("\u7535\u8BDD");
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setText("\u6027\u522B");
		lblNewLabel_4.setBounds(277, 242, 61, 17);
		
		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setBounds(276, 325, 61, 17);
		lblNewLabel_5.setText("\u73ED\u7EA7");
		
		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBounds(343, 157, 150, 17);
		
		text_6 = new Text(shell, SWT.BORDER);
		text_6.setBounds(343, 201, 150, 17);
		
		text_7 = new Text(shell, SWT.BORDER);
		text_7.setBounds(345, 242, 148, 17);
		
		text_8 = new Text(shell, SWT.BORDER);
		text_8.setBounds(343, 286, 150, 17);
		
		text_9 = new Text(shell, SWT.BORDER);
		text_9.setBounds(343, 322, 150, 17);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String t=text.getText();
				String t1=text_1.getText();
				String t2=text_2.getText();
				String t3=text_3.getText();
				String t4=text_4.getText();
				String t5=text_5.getText();
				String t6=text_6.getText();
				String t7=text_7.getText();
				String t8=text_8.getText();
				String t9=text_9.getText();
				if(t.equals("")){
					MessageBox mb=new MessageBox(shell);
					mb.setText("注册失败");
					mb.setMessage("请输入账号");
					mb.open();
				}else if(t1.equals("")){
					MessageBox mb=new MessageBox(shell);
					mb.setText("注册失败");
					mb.setMessage("请输入密码");
					mb.open();
				}else if(t2.equals("")){
					MessageBox mb=new MessageBox(shell);
					mb.setText("注册失败");
					mb.setMessage("请输入确认密码");
					mb.open();
				}
				else if(t3.equals("")){
					MessageBox mb=new MessageBox(shell);
					mb.setText("注册失败");
					mb.setMessage("请你输入邮箱");
					mb.open();
				}else if(t4.equals("")){
					MessageBox mb=new MessageBox(shell);
					mb.setText("注册失败");
					mb.setMessage("请你输入验证码");
					mb.open();
				}if(!(t1.equals(t2))){
					MessageBox mb=new MessageBox(shell);
					mb.setText("注册失败");
					mb.setMessage("密码不一致");
					mb.open();
				}if(!(t4.equals(s))){
					MessageBox mb=new MessageBox(shell);
					mb.setText("注册失败");
					mb.setMessage("验证码错误");
					mb.open();
				}
//				if(!((t1.equals(""))&&(t.equals(""))&&(t2.equals(""))&&(t3.equals(""))&&(t4.equals(""))&&(!(t4.equals(vCode.getCode()))))){
					if(!(t.equals(""))){
						if(!(t1.equals(""))){
							if(!(t2.equals(""))){
								if(!(t3.equals(""))){
									if(!(t4.equals(""))){
										if(((t4.equals(s)))){
											try {
												//加载驱动
												Class.forName("com.mysql.jdbc.Driver");
												//建立连接
												try {
													Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
															"root","a");
													//创建语句对象
													Statement statement=con.createStatement();
													//字符串的拼接 最重要的是：让变量不在引号里面
													String sql="insert into student values('"+t5+"','"+t6+"','"+t7+"','"+t8+"'"
															+ ",'"+t9+"','"+t+"','"+t1+"','"+t3+"')";
													int result=statement.executeUpdate(sql);
													if(result>0){
														MessageBox mb=new MessageBox(shell);
														mb.setText("注册");
														mb.setMessage("成功注册,飞速跳转主界面");
														mb.open();
														shell.dispose();
														login l=new login();
														l.open();
													}else{
														MessageBox mb=new MessageBox(shell);
														mb.setText("注册失败");
														mb.setMessage("请你重新注册");
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
					}
//					try {
//						//加载驱动
//						Class.forName("com.mysql.jdbc.Driver");
//						//建立连接
//						try {
//							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
//									"root","a");
//							//创建语句对象
//							Statement statement=con.createStatement();
//							//字符串的拼接 最重要的是：让变量不在引号里面
//							String sql="insert into snakes values(null,"
//									+ "'"+t+"','"+t1+"','"+t3+"')";
//							int result=statement.executeUpdate(sql);
//							if(result>0){
//								MessageBox mb=new MessageBox(shell);
//								mb.setText("注册");
//								mb.setMessage("成功注册,飞速跳转主界面");
//								mb.open();
//								shell.dispose();
//								login l=new login();
//								l.open();
//							}else{
//								MessageBox mb=new MessageBox(shell);
//								mb.setText("注册失败");
//								mb.setMessage("请你重新注册");
//								mb.open();
//							}
//						} catch (SQLException e1) {
//							e1.printStackTrace();
//						}
//					} catch (ClassNotFoundException e1) {
//						e1.printStackTrace();
//					}
					
//				}
				
			}
		});

	}
}
