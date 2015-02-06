package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame {
	double a;
	double b;
	double c;
	double d;
	int ee;
	double f;
	double g;
	double m;
	double n;
	double o;
	double h;
	static double x;
	static int y;
	double z;
	String s1;
	String s2;

	JFrame jf = new JFrame("Counter");

	// JPanel jp1=new JPanel();
	JPanel jp2 = new JPanel();
	JPanel jp3 = new JPanel();
	JPanel jp4 = new JPanel();
	JPanel jp5 = new JPanel();
	JPanel jp6 = new JPanel();
	JPanel jp7 = new JPanel();
	JPanel jp8 = new JPanel();
	JPanel jp10 = new JPanel();
	JPanel jp11 = new JPanel();
	JPanel jp12 = new JPanel();

	JLabel jl1 = new JLabel("计算器");
	JLabel jl2 = new JLabel("房屋单价(元/平):");
	JLabel jl3 = new JLabel("房屋面积(平方):");
	JLabel jl4 = new JLabel("首付金额(元):");
	JLabel jl5 = new JLabel("年利率(万分之):");
	JLabel jl6 = new JLabel("月还款额(元):");
	JLabel jl7 = new JLabel("总还款额(元):");
	JLabel jl10 = new JLabel("还款年限(年):");
	JLabel jl11 = new JLabel("本金(元):");
	JLabel jl12 = new JLabel("利息(元):");

	JTextField jt1 = new JTextField("", 10);
	JTextField jt2 = new JTextField("", 10);
	JTextField jt3 = new JTextField("", 10);
	JTextField jt4 = new JTextField("", 10);
	JTextField jt5 = new JTextField("0", 15);
	JTextField jt6 = new JTextField("0", 15);
	JTextField jt10 = new JTextField("", 10);
	JTextField jt11 = new JTextField("0", 15);
	JTextField jt12 = new JTextField("0", 15);

	JButton b1 = new JButton("计算");
	JButton b2 = new JButton("清空");

	MyFrame() {
		jf.setLayout(new GridLayout(10, 1));

		// jp1.add(jl1);
		// jf.add(jp1);

		jp2.add(jl2);
		jp2.add(jt1);
		jf.add(jp2);

		jp3.add(jl3);
		jp3.add(jt2);
		jf.add(jp3);

		jp4.add(jl4);
		jp4.add(jt3);
		jf.add(jp4);

		jp5.add(jl5);
		jp5.add(jt4);
		jf.add(jp5);

		jp10.add(jl10);
		jp10.add(jt10);
		jf.add(jp10);

		jp6.add(b1);
		jp6.add(b2);
		jf.add(jp6);

		jp7.add(jl6);
		jt5.setEditable(false);
		jp7.add(jt5);
		jf.add(jp7);

		jp8.add(jl7);
		jt6.setEditable(false);
		jp8.add(jt6);
		jf.add(jp8);

		jp11.add(jl11);
		jp11.add(jt11);
		jt11.setEditable(false);
		jf.add(jp11);

		jp12.add(jl12);
		jp12.add(jt12);
		jt12.setEditable(false);
		jf.add(jp12);

		jf.setSize(300, 400);
		jf.setResizable(false);
		jf.setVisible(true);

		// 窗口监听
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// 键盘监听
		jt1.addKeyListener(new MyKeyAdapter());
		jt2.addKeyListener(new MyKeyAdapter());
		jt3.addKeyListener(new MyKeyAdapter());
		jt4.addKeyListener(new MyKeyAdapter());

		// 按键监听
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Double.parseDouble(jt1.getText());
				b = Double.parseDouble(jt2.getText());
				c = Double.parseDouble(jt3.getText());
				d = Double.parseDouble(jt4.getText());
				ee = Integer.parseInt(jt10.getText());
				// 具体的计算方法
				m = 1 + (d / 120000);
				n = MyFrame.nPower(m, ee * 12);
				o = MyFrame.nPower(m, (ee * 12 - 1));
				f = ((a * b - c) * d / 120000 * n) / o;
				g = f * ee * 12;
				h = a * b - c;

				jt5.setText(Double.toString(f));
				jt6.setText(Double.toString(g));
				jt11.setText(Double.toString(h));
				jt12.setText(Double.toString((g - h)));
			}
		});

		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jt1.setText("");
				jt2.setText("");
				jt3.setText("");
				jt4.setText("");
				jt10.setText("");
				jt5.setText("0");
				jt6.setText("0");
				jt11.setText("0");
				jt12.setText("0");
			}
		});
	}

	class MyKeyAdapter extends KeyAdapter {
		public void keyTyped(KeyEvent e) {
			char ch = e.getKeyChar();
			if (ch < '0' || ch > '9') {
				e.consume();
			}

		}
	}

	static double nPower(double _x, int _y) {
		x = _x;
		y = _y;
		double z = x;
		for (int i = 1; i < y; i++) {
			x = x * z;
		}
		return x;
	}
}
