import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr= new int[9];
		int temp;
		int sum=0;
		for(int i=0;i<9;i++) {
			arr[i]=scan.nextInt();
			sum+=arr[i];
		}
		sum-=100;
		
		for(int i=0;i<9;i++) {
			for(int j=i;j<9;j++) {
				if(arr[i]>arr[j]) {
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		
		int i=0,j=0;
		l:for(i=0;i<8;i++) {
			if(arr[i]>sum)
				break;
			for(j=i+1;j<9;j++) {
				if(arr[i]+arr[j]>sum)
					break;
				else if(arr[i]+arr[j]==sum) {
					break l;
				}
			}
		}
		
		for(int k=0;k<9;k++) {
			if(k!=i&&k!=j)
				System.out.println(arr[k]);
		}
	}
}
