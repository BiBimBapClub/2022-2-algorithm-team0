import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int l = scan.nextInt();
		while(l--!=0){
			int c = scan.nextInt();
			label:for(int i=1;i<=c;i++) {
				if(eureka(i)>=c) {
					System.out.println(0);
					break;
				}
				for(int j=1;j<=c;j++) {
					if(eureka(i)+eureka(j)>=c) 
						break;
					for(int k=1;k<c;k++) {
						if(eureka(i)+eureka(j)+eureka(k)==c) {
							System.out.println(1);
							break label;
						}
						else if(eureka(i)+eureka(j)+eureka(k)>c) {
							break;
						}
					}
				}
			}
		}
	}
	static int eureka(int in) {
		return in*(in+1)/2;
	}
}
