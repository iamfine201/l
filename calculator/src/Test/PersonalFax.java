package Test;

public class PersonalFax {
	public static void main(String args[]) {
		Caculate shiji = new Caculate("��ũС��", 6000);
		double shou = shiji.HowMany();
		System.out.printf("%.3f", shou);
	}
}