import java.util.Arrays;
import java.util.Scanner;
public class ClosestNumbers {
    public static void closestNumber(int[] a){
        Arrays.sort(a);
        int min = Integer.MAX_VALUE;
        int[] res = new int[a.length];
        for(int i = 1; i < a.length; i++){
            res[i] = a[i] - a[i-1];
            if(res[i] < min) min = res[i];
        }
        for(int i = 1; i < a.length; i++){
            if(min == res[i]) {
                System.out.print(a[i-1] + " " + a[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        closestNumber(a);



    }
}
