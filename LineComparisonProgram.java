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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Line line = (Line) obj;
        return Double.compare(calculateLength(), line.calculateLength()) == 0;
    }
}

public class LineComparisonProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Line Comparison Computation Program - UC2");

        Line line1 = createLine(scanner, "first");
        Line line2 = createLine(scanner, "second");

        double length1 = line1.calculateLength();
        double length2 = line2.calculateLength();

        System.out.println("Length of the first line: " + length1);
        System.out.println("Length of the second line: " + length2);

        if (line1.equals(line2)) {
            System.out.println("The two lines are equal in length.");
        } else {
            System.out.println("The two lines are not equal in length.");
        }

        scanner.close();
    }

    private static Line createLine(Scanner scanner, String lineOrder) {
        System.out.println("Enter x1 and y1 for the " + lineOrder + " line:");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        System.out.println("Enter x2 and y2 for the " + lineOrder + " line:");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        return new Line(new Point(x1, y1), new Point(x2, y2));
    }
}