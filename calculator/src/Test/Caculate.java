package Test;

public class Caculate {
	private String name;
	private double money;
	private double actual;

	/**
	 * @param username
	 *            �û���
	 * @param money
	 *            �û�˰ǰ����
	 */
	public Caculate(String username, double money) {
		this.name = username;
		this.money = money;
	}

	public double HowMany() {
		// java��switch��case����ֻ֧��int char string�����˴���double,���Բ���ʹ��switch
		double shouru = money;// ���캯���б����Ѿ���this.money�ˣ������ٴ�ʹ�õ�ʹ�ã��ó�money����
		if (shouru <= 1500) {
			System.out.print("����Ҫ���ɸ�������˰");
			this.actual = shouru;
		} else if (1500 < shouru && shouru < 3000) {
			this.actual = shouru * (1 - 0.05);
		}
		if (3000 <= shouru) {
			this.actual = shouru - (shouru - 3000) * 0.1;
		}
		System.out.println("ʵ������Ϊ��" + this.actual);

		return this.actual;
	}
}

/**
 * @author ��ũС�� PersonalFax.java 2012-8-7����11:28:16
 */
//public class PersonalFax {
//	public static void main(String args[]) {
//		Caculate shiji = new Caculate("��ũС��", 1000.2345);
//		double shou = shiji.HowMany();
//		System.out.printf("%.3f", shou);
//
//	}
//}
