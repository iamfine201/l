public class Select {

	//ѡ�������С����
//	public static void main(String[] args) {
//		int[] a = { 23, 22, 10, 4, 2, 0 };
//		int max = 0;
//		int tmp = 0;
//		for (int i = 0; i < a.length; i++) {
//			max = i;
//			for (int j = i + 1; j < a.length; j++) {
//				if (a[max] > a[j]) {//��С����
//					max = j;
//				}
//				if (i != max) {
//					tmp = a[i];
//					a[i] = a[max];
//					a[max] = tmp;
//
//				}
//
//			}
//			
//		}
//		for (int i1 = 0; i1 < a.length; i1++)
//			System.out.print(a[i1] + " ");
//	}
	
	
	//ѡ������Ӵ�С
	public static void main(String[] args) {
		int[] arr = {12,5,1,0,9,25};
		int max = 0;
		int tmp = 0;
		for(int i = 0;i<arr.length;i++){
			max = i;
			for(int j = i+1;j<arr.length;j++){
				if(arr[max]<arr[j]){
					max = j;
				}
				if(i!=max){
					tmp = arr[i];
					arr[i] = arr[max];
					arr[max] = tmp;
				}
			}
			
		
		}
		for(int res=0;res<arr.length;res++){
			System.out.println("�Ӵ�С����"+arr[res]);
		}
	}

}
