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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class Book {

	protected Shell shell;
	private Text text;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Book window = new Book();
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
		shell.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		shell.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.BOLD));
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setBackgroundImage(SWTResourceManager.getImage("D:\\\u5783\u573E\u6587\u4EF6\\swt\\src\\com\\yc\\image\\zzpic12234_s.jpg"));
		shell.setImage(SWTResourceManager.getImage("D:\\\u5783\u573E\u6587\u4EF6\\swt\\src\\com\\yc\\image\\Register .png"));
		shell.setSize(785, 534);
		shell.setText("\u5B66\u7C4D\u7BA1\u7406\u7CFB\u7EDF");
		//设置窗口居中
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x/2, Display.getCurrent() 
                .getClientArea().height / 2 - shell.getSize().y/2); 
		// 驱动程序名
		String driver = "com.mysql.jdbc.Driver";

		// URL 指向 访问的数据库名字
		String url = "jdbc:mysql://localhost:3306/test";

		// MySQL 用户名
		String user = "root";

		// MySQL 密码
		String password = "a";
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		btnNewButton.setBounds(52, 79, 116, 82);
		btnNewButton.setText("\u7F16\u8F91");
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(327, 79, 130, 82);
		btnNewButton_1.setText("\u5220\u9664");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					// 加载驱动程序
					Class.forName(driver);

					// 声明 Connection 对象
					Connection con;

					// .getConnection()方法 连接MySQL数据库
					con = DriverManager.getConnection(url, user, password);
					String stt = text.getText();
			//		String sql = "select * from student where concat(Sclass,School,Sno,Grade,Ssex) like ?";
					//模糊查找
					String sql = "select * from student where Sclass like ? or School like ? or Sno like ? or Grade like ? or Ssex like ?";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1,"%"+stt+"%");
					ps.setString(2,"%"+stt+"%");
					ps.setString(3,"%"+stt+"%");
					ps.setString(4,"%"+stt+"%");
					ps.setString(5,"%"+stt+"%");
//					ps.setString(2, stt);
//					ps.setString(1, stt);
//					ps.setString(2, stt);
//					ps.setString(3, stt);
//					ps.setString(4, stt);
//					ps.setString(5, stt);
					table.removeAll();
					ResultSet rs = ps.executeQuery();

					// 循环数值
					//设置值
					while (rs.next()) {
						TableItem ti = new TableItem(table, SWT.NONE);
							ti.setText(new String[] { rs.getString(1), rs.getString(2), rs.getString(3),
									rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)});
					}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();

			}
			}
		});
		lblNewLabel.setBounds(38, 248, 32, 17);
		lblNewLabel.setText("\u67E5\u8BE2");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(100, 245, 290, 23);
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(0, 288, 769, 207);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(102);
		tblclmnNewColumn.setText("姓名");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(132);
		tblclmnNewColumn_1.setText("学号");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(99);
		tblclmnNewColumn_2.setText("性别");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(139);
		tblclmnNewColumn_3.setText("手机号");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(97);
		tblclmnNewColumn_4.setText("班级");
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_5.setWidth(100);
		tblclmnNewColumn_5.setText("\u5E74\u7EA7");
		
		TableColumn tblclmnNewColumn_6 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_6.setWidth(100);
		tblclmnNewColumn_6.setText("\u5B66\u9662");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				Add d=new Add();
				d.open();
			}
		});
		btnNewButton_2.setBounds(589, 79, 102, 82);
		btnNewButton_2.setText("\u6DFB\u52A0");
		
		try {
			// 加载驱动程序
			Class.forName(driver);

			// 声明 Connection 对象
			Connection con;

			// .getConnection()方法 连接MySQL数据库
			con = DriverManager.getConnection(url, user, password);

			// 新建 statement 对象 执行 SQL 语句
			String sql = "select * from student";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			// 循环数值
			while (rs.next()) {
				TableItem ti = new TableItem(table, SWT.NONE);
					ti.setText(
							new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)});
			}
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}
}
