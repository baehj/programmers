package Do_it_알고리즘코테_핵심3일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p08 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int Result = 0;
		long A[] = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i =0; i<n; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(A);
		for (int k=0; k<n; k++) {
			long find = A[k]; // 찾을 좋은 수
			int i = 0;
			int j = n - 1;
			while(i < j) { // i와 j가 같을 수도 i > j일 수도 없으니 i < j까지만
				if(A[i]+A[j] == find) { // 더해서 좋은 수가 된다면?
					if( i != k && j != k) { //  
						Result++;
						break;
					} else if (i == k) { // 다른 두 수의 합으로 표현되는 수 이기때문에 i,j는 != k 가 되어야함
						i++;
					} else if (j == k) {
						j--;
					}
				} else if (A[i] + A[j] < find) { 
					i++;
				} else {
					j--;
				}
			}
		}
		System.out.println(Result);
		br.close();
	}
}
