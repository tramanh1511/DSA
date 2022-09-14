import java.util.Scanner;
import java.util.Arrays;
public class Pairs {
    public static int check(int[] a, int k){
        int res = 0;
        Arrays.sort(a);
        for(int i = 0; i < a.length-1; i++){
            if(Arrays.binarySearch(a,i+1, a.length, a[i]+k) > 0) {
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int n, k;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        System.out.println(check(a,k));
    }
}
