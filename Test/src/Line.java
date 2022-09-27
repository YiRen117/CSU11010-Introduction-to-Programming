public class Line {
    private Point p1;
    private Point p2;

    public Line(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public Line(int x1, int y1, int x2, int y2){
        this.p1 = new Point(x1, y1);
        this.p2 = new Point(x2, y2);
    }

    public Point getP1(){
        return p1;
    }

    public Point getP2(){
        return p2;
    }

    public double getSlope(){
        double divider = p2.getX() - p1.getX();
        if(divider == 0) {
            throw new ArithmeticException();
        }
        return (p2.getY() - p1.getY())/ divider;
    }
}
