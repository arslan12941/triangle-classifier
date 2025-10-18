import java.util.Arrays;
import java.util.Scanner;

public class TriangleClassifier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter three sides of the triangle:");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        sc.close();

        // Step 1: Input validation
        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("Invalid input: All sides must be positive.");
            return;
        }

        // Step 2: Triangle inequality check
        if (a + b <= c || a + c <= b || b + c <= a) {
            System.out.println("Invalid triangle: Triangle inequality violated.");
            return;
        }

        // Step 3: Sort sides so c is the largest
        double[] sides = {a, b, c};
        Arrays.sort(sides);
        a = sides[0];
        b = sides[1];
        c = sides[2];

        // Step 4: Side-based classification
        String sideType;
        if (a == b && b == c) {
            sideType = "Equilateral Triangle";
        } else if (a == b || b == c || a == c) {
            sideType = "Isosceles Triangle";
        } else {
            sideType = "Scalene Triangle";
        }

        // Step 5: Angle-based classification
        double lhs = a * a + b * b;
        double rhs = c * c;
        String angleType;

        if (Math.abs(lhs - rhs) < 1e-9) {
            angleType = "Right-angled Triangle";
        } else if (lhs > rhs) {
            angleType = "Acute Triangle";
        } else {
            angleType = "Obtuse Triangle";
        }

        System.out.println("Triangle Type: " + sideType + " and " + angleType);
    }
}
