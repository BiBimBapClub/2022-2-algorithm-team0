import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int input=scan.nextInt();
		for(int i=0;i<input;i++) {
				if(sum(i)+i==input) {
					System.out.println(i);
					return;
				}
		}
		System.out.println("0");
	}
	static int sum(int input) {
		if(input<10)
			return input;
		else
			return sum(input/10)+input%10;
	}
}
