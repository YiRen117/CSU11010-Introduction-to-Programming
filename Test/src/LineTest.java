public class LineTest {
    public static void main(String[] args) {
        Line line1 = new Line(new Point(1,2),new Point(3,6));
        System.out.printf("Line1's first endpoint is (%d, %d).%n", line1.getP1().getX(), line1.getP1().getY());
        System.out.printf("Line1's second endpoint is (%d, %d).%n", line1.getP2().getX(), line1.getP2().getY());
        Line line2 = new Line(1,5,3,6);
        System.out.printf("Line2's first endpoint is (%d, %d).%n", line2.getP1().getX(), line2.getP1().getY());
        System.out.printf("Line2's second endpoint is (%d, %d).%n", line2.getP2().getX(), line2.getP2().getY());
        System.out.println("Line2's slope is " + line2.getSlope());
    }
}
