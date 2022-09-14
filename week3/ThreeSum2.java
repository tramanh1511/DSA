import java.util.*;
public class ThreeSum2 {
    public static void ThreeSum(int[] a){
        Arrays.sort(a);
        for(int i = 0; i < a.length - 2; i++){
            int lo = i+1, hi = a.length-1;
            while(lo < hi){
                if(a[lo] + a[hi] + a[i] == 0){
                    System.out.println(a[lo] + " " + a[i] + " " + a[hi]);
                    lo++;
                    hi--;
                }
                else if(a[lo] + a[hi] + a[i] < 0) lo ++;
                else hi--;
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
        ThreeSum(a);
    }
}
