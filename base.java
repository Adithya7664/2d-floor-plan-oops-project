
import java.util.*;

public class base {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Scanner sc = new Scanner(System.in);
        System.out.println("if your base is in shape of rectangle please press 1 or press 0");
        int n = sc.nextInt();
        if (n == 1) {
            System.out.println("Enter your base dimentions");
            System.out.println("length = ");
            int length = sc.nextInt();
            System.out.println("width = ");
            int width = sc.nextInt();
            System.out.println("height = ");
            int height = sc.nextInt();
            int volume = length * width * height;
        } else if (n == 0) {
            System.out.println("Enter n.o of  base sides");
            int n1 = sc.nextInt();
            double[] dim = new double[n1 + 10];
            double[] angle = new double[n1 + 10];
            double[] height = new double[n1 + 10];
            for (int i = 0; i < n1; i++) {
                System.out.println("enter the length of the base side in meters:  " + (i + 1));
                dim[i] = sc.nextDouble();
                System.out.println("enter the angle of the side with respecrive the previous side");
                angle[i] = sc.nextDouble();
                System.out.println("enter the height of the side in meters");
                height[i] = sc.nextDouble();
            }
        }

    }

}
