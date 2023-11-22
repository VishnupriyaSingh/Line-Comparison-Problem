import java.util.Scanner;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Line {
    Point point1, point2;

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public double calculateLength() {
        return Math.sqrt(Math.pow(point2.x - point1.x, 2) + Math.pow(point2.y - point1.y, 2));
    }

    public int compareTo(Line otherLine) {
        return Double.compare(this.calculateLength(), otherLine.calculateLength());
    }
}

public class LineComparisonProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Line Comparison Computation Program - UC3");

        System.out.println("Enter details for the first line:");
        Line line1 = createLine(scanner);

        System.out.println("Enter details for the second line:");
        Line line2 = createLine(scanner);

        double length1 = line1.calculateLength();
        double length2 = line2.calculateLength();
        System.out.println("Length of the first line: " + length1);
        System.out.println("Length of the second line: " + length2);

        int comparisonResult = line1.compareTo(line2);
        if (comparisonResult > 0) {
            System.out.println("The first line is longer than the second line.");
        } else if (comparisonResult < 0) {
            System.out.println("The first line is shorter than the second line.");
        } else {
            System.out.println("Both lines are equal in length.");
        }

        scanner.close();
    }

    private static Line createLine(Scanner scanner) {
        System.out.println("Enter x1, y1 (coordinates of the first point):");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        System.out.println("Enter x2, y2 (coordinates of the second point):");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        return new Line(new Point(x1, y1), new Point(x2, y2));
    }
}