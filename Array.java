import java.util.Scanner;
public class Array {
    public static void main(String[] args){
        System.out.println(" Enter n: ");
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.nextLine();
        int[] a = new int[n];
        for (int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1;j++){
                if (a[j] > a[j + 1]){
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1]= temp;
                }
            }
        }
        for (int i = 0; i < n; i++){
            System.out.print(a[i] + ' ');
        }
    }
}
