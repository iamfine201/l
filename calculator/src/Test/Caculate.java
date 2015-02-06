package Test;

public class Caculate {
	private String name;
	private double money;
	private double actual;

	/**
	 * @param username
	 *            用户名
	 * @param money
	 *            用户税前收入
	 */
	public Caculate(String username, double money) {
		this.name = username;
		this.money = money;
	}

	public double HowMany() {
		// java中switch的case变量只支持int char string，而此处是double,所以不能使用switch
		double shouru = money;// 构造函数中本来已经有this.money了，所以再次使用的使用，用成money即可
		if (shouru <= 1500) {
			System.out.print("不需要缴纳个人所得税");
			this.actual = shouru;
		} else if (1500 < shouru && shouru < 3000) {
			this.actual = shouru * (1 - 0.05);
		}
		if (3000 <= shouru) {
			this.actual = shouru - (shouru - 3000) * 0.1;
		}
		System.out.println("实际收入为：" + this.actual);

		return this.actual;
	}
}

/**
 * @author 码农小江 PersonalFax.java 2012-8-7下午11:28:16
 */
//public class PersonalFax {
//	public static void main(String args[]) {
//		Caculate shiji = new Caculate("码农小江", 1000.2345);
//		double shou = shiji.HowMany();
//		System.out.printf("%.3f", shou);
//
//	}
//}
