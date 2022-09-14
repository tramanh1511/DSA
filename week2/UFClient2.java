import edu.princeton.cs.algs4.*;
public class UFClient2 {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        UF uf = new UF(n);
        int count = 0;
        while (uf.count() != 1 && !StdIn.isEmpty()){
            count++;
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.find(p) != uf.find(q)) {
                uf.union(p, q);
            }
            if (uf.count() == 1) {
                StdOut.println(count);
            }
        }
        if (uf.count() != 1) {
            StdOut.println("FAILED");
        }
    }
}
