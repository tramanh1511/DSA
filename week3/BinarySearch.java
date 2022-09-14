import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
   public static int binarySearch(int[] a, int number){
       Arrays.sort(a);
       int lo = 0;
       int hi = a.length - 1;
       while(lo <= hi){
           int mid = lo + (hi-lo)/2;
           if(number < a[mid]) hi = mid - 1;
           else if(number > a[mid]) lo = mid + 1;
           else return mid;
       }
       return -1;
   }

    public static void main(String[] args) {
      Random rand = new Random();
      int n = rand.nextInt(1000)+1;
      int[] a = new int[n];
      for(int i = 0; i < n; i++){
         /* Random randa = new Random();*/
          a[i] = i;
      }
      System.out.println(binarySearch(a, 567));
    }
}
