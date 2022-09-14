import java.util.*;
import static java.lang.Math.abs;

public class NewYearChaos {
    public static void Chaos(List<Integer> a){
        int res = 0;
        for(int i = a.size(); i > 0; i--){
            if (a.get(i - 1) != i) {
                if (a.get(i - 2) == i && (i - 1) >= 0) {
                    res++;
                    Collections.swap(a, i - 2, i - 1);
                }
                else if (a.get(i - 3) == i && (i - 2) >= 0) {
                    res += 2;
                    Collections.swap(a, i - 3, i - 2);
                    Collections.swap(a, i - 2, i - 1);
                }
                else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        int t, n;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
       for(int x = 0; x < t; x++){
            n = sc.nextInt();
            List<Integer> a = new ArrayList<Integer>(n);
            for(int i = 0; i < n; i++)
            {
                int temp = sc.nextInt();
                a.add(temp);
            }
            Chaos(a);
        }


    }
}
