import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
		int col = scan.nextInt();
		int[][] arr = new int[row][col];
		for(int i=0;i<row;i++) {
			String r = scan.next();
			for(int j=0;j<col;j++) {
				arr[i][j]=Integer.parseInt(r.substring(j,j+1));
				
			}
		}
		search(arr,1);
	}
	static int search(int arr[][],int l) {
		int max,min;
		if(arr.length>arr[0].length) {
			max=arr.length;
			min=arr[0].length;
		}
		else {
			min=arr.length;
			max=arr[0].length;
		}
			
		label:for(int i=min;i>0;i--) {
			for(int j=0;j<arr.length-i+1;j++) {
				for(int k=0;k<arr[0].length-i+1;k++) {
					if(arr[j][k]==arr[j][k+i-1]&&arr[j][k]==arr[j+i-1][k+i-1]&&arr[j][k]==arr[j+i-1][k]) {
						System.out.println(i*i);
						break label;
					}
				}
			}
		}
		return 0;
	}

}
