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
				//建立一个文件
						//建立一个文件不覆盖原来的内容,true代表覆盖
						//而false表示覆盖,关键解决了文件不存在时的IO异常
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
					//加载驱动
					Class.forName("com.mysql.jdbc.Driver");
					//建立连接
					try {
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test",
								"root","a");
						//创建语句对象
						//Statement statement=con.createStatement();
						//字符串的拼接 最重要的是：让变量不在引号里面
						//String sql="select * from snakes where account='"+t+"' or email='"+t+"'";
						String sql="select * from snakes where account=? or email=?";
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setString(1, t);
						ps.setString(2, t);
						//这里开始不一样
						
						ResultSet rs=ps.executeQuery();//查询要用的
						//这里开始不一样
						//ResultSet rs=statement.executeQuery(sql);//查询要用的
						//rs.next() 判断这个结果集，有没有下一个，有,则这里面有值
						if(t.equals("")){
							MessageBox mb=new MessageBox(shell);
							mb.setText("密码找回失败");
							mb.setMessage("请输入账号或邮箱");
							mb.open();
						}
						if((rs.next())&&(!(t.equals("")))){
							MessageBox mb=new MessageBox(shell);
							mb.setText("密码成功找回");
							mb.setMessage("飞速跳转修改密码界面");
							mb.open();
							shell.dispose();
							PwbackModify pm=new PwbackModify();
							pm.open();
						}else{
							MessageBox mb=new MessageBox(shell);
							mb.setText("密码找回失败");
							mb.setMessage("没有此账户或邮箱");
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
