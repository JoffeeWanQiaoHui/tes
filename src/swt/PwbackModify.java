package swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class PwbackModify {

	protected Shell shell;
	private Text text;
	private Label label;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PwbackModify window = new PwbackModify();
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
		shell.setBackgroundImage(SWTResourceManager.getImage("D:\\\u5783\u573E\u6587\u4EF6\\swt\\src\\com\\yc\\image\\pwdmodify.jpg"));
		shell.setImage(SWTResourceManager.getImage("D:\\\u5783\u573E\u6587\u4EF6\\swt\\src\\com\\yc\\image\\pwback.jpg"));
		shell.setSize(579, 408);
		shell.setText("\u5BC6\u7801\u4FEE\u6539");
		//设置窗口居中
				shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x/2, Display.getCurrent() 
		                .getClientArea().height / 2 - shell.getSize().y/2); 

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		lblNewLabel.setBounds(193, 98, 35, 17);
		lblNewLabel.setText("\u5BC6\u7801");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(249, 97, 157, 23);
		
		label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		label.setBounds(184, 149, 61, 17);
		label.setText("\u786E\u5B9A\u5BC6\u7801");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(249, 148, 157, 23);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String t=text.getText();
				String t1=text_1.getText();
				if(t.equals("")){
					MessageBox mb=new MessageBox(shell);
					mb.setText("修改失败");
					mb.setMessage("请输入密码");
					mb.open();
				}else if(t1.equals("")){
					MessageBox mb=new MessageBox(shell);
					mb.setText("修改失败");
					mb.setMessage("请输入确定密码");
					mb.open();
				}else if(!(t.equals(t1))){
					MessageBox mb=new MessageBox(shell);
					mb.setText("修改失败");
					mb.setMessage("密码不一致");
					mb.open();
				}else if(!(t.equals(""))){
					if(!(t1.equals(""))){
						if((t.equals(t1))){
							try {
							//加载驱动
							Class.forName("com.mysql.jdbc.Driver");
							//建立连接
							try {
								Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
										"root","a");
								//创建语句对象
								Statement statement=con.createStatement();
								FileInputStream fis=new FileInputStream("D:/a.txt");
								BufferedInputStream bis=new BufferedInputStream(fis);
								DataInputStream dis=new DataInputStream(bis);
								String aa=dis.readUTF();
								//字符串的拼接 最重要的是：让变量不在引号里面
								String sql="update snakes set password='"+t1+"'where account='"+aa+"'or email='"+aa+"'";
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
							} catch (Exception e1) {
								e1.printStackTrace();
							}
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						}
						
							
							
							
							
							
							
//							MessageBox mb=new MessageBox(shell);
//							mb.setText("修改成功");
//							mb.setMessage("密码修改成功,飞速跳转主界面");
//							mb.open();
//							shell.dispose();
//							login l3=new login();
//							l3.open();
						}
					}
				}
			}
		});
		btnNewButton.setBounds(276, 202, 80, 27);
		btnNewButton.setText("\u786E\u5B9A");

	}
}
