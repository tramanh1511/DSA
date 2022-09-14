import java.util.Scanner;
public class SherlockAndArray {
    public static String check(int[] a){
        int[] sum = new int[a.length];
        sum[0] = a[0];
        for(int i = 1; i < a.length; i++){
            sum[i] = sum[i-1] + a[i];
        }
        if(sum[a.length-1] - sum[0] == 0) return "YES";
        for(int i = 1; i < a.length; i++)
            if(sum[i-1] == sum[a.length-1] - sum[i]) {
                return "YES";
            }
        return "NO";
    }
    public static void main(String[] args){
        int t, n;
        Scanner sc =  new Scanner(System.in);
        t = sc.nextInt();
        for(int i = 0; i < t; i++){
            n = sc.nextInt();
            int[] a = new int[n];
            for(int j = 0; j < n; j++){
                a[j] = sc.nextInt();
            }
            System.out.println(check(a));

        }


    }


}
