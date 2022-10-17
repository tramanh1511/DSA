import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> nameList = new ArrayList<>();
        Set<String> hashSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            nameList.add(name);
            hashSet.add(name);
            System.out.println(hashSet.size());
        }
    }
}