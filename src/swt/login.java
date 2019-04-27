package swt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class login {

	protected Shell shell;
	private Text text;
	private Text text_1;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			login window = new login();
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
		final int widths=800;
		final int heights=600;
		shell = new Shell();
		
		shell.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		shell.setLocation(new Point(78, 78));
		shell.setBackgroundMode(SWT.INHERIT_FORCE);
		shell.setBackgroundImage(SWTResourceManager.getImage("D:\\\u5783\u573E\u6587\u4EF6\\swt\\src\\com\\yc\\image\\login2.jpg"));
		shell.setImage(SWTResourceManager.getImage("D:\\\u5783\u573E\u6587\u4EF6\\Mysnakes\\src\\com\\yc\\images\\snake.jpg"));
		shell.setSize(widths, heights);
		
		//设置窗口居中
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x/2, Display.getCurrent() 
                .getClientArea().height / 2 - shell.getSize().y/2); 

		shell.setText("\u5B66\u7C4D\u7BA1\u7406\u7CFB\u7EDF");
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			String a=text.getText();
			String b=text_1.getText();
			//加载驱动
			
			try {
				//加载驱动
				Class.forName("com.mysql.jdbc.Driver");
				//建立连接
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
							"root","a");
					String sql="select * from student where account=? and password=?";
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, a);
					ps.setString(2, b);
					//这里开始不一样
					
					ResultSet rs=ps.executeQuery();//查询要用的
					//rs.next() 判断这个结果集，有没有下一个，有,则这里面有值
					if(rs.next()){
						MessageBox mb=new MessageBox(shell);
						mb.setText("Happy World");
						mb.setMessage("登入成功,飞速跳转中");
						mb.open();
						shell.close();
						Book b1=new Book();
						b1.open();
					}else{
						MessageBox mb=new MessageBox(shell);
						mb.setText("Fault World");
						mb.setMessage("密码或账号输入错误");
						mb.open();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
			
			
//			if((a.equals("wan"))&&(b.equals("123"))){
//				MessageBox mb=new MessageBox(shell);
//				mb.setText("Happy World");
//				mb.setMessage("登入成功,飞速跳转中");
//				mb.open();
//				Start s=new Start();
//				shell.dispose();
//				s.open();
//			}else{
//				MessageBox mb=new MessageBox(shell);
//				mb.setText("Fault World");
//				mb.setMessage("密码或账号输入错误");
//				mb.open();
//			}
			}
		});
		btnNewButton.setBounds(306, 331, 80, 27);
		btnNewButton.setText("\u767B\u5165");
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				Register r=new Register();
				r.open();
			}
		});
		button.setText("\u6CE8\u518C");
		button.setBounds(446, 331, 80, 27);
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				PwBack pb=new PwBack();
				shell.dispose();
				pb.open();			
			}
		});
		
		lblNewLabel_1.setBounds(563, 379, 57, 17);
		lblNewLabel_1.setText("\u627E\u56DE\u5BC6\u7801");
		
		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		label.setBounds(300, 178, 29, 17);
		label.setText("\u8D26\u53F7");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		label_1.setBounds(300, 225, 29, 17);
		label_1.setText("\u5BC6\u7801");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(352, 175, 156, 23);
		
		text_1 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(352, 225, 156, 23);

	}
}
