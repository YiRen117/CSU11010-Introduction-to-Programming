public class TestResizableCircle {
    public static void main(String[] args) {
        ResizableCircle resized = new ResizableCircle(100);
        resized.resize(10);
        System.out.println("Perimeter of the circle is " + resized.getPerimeter());
        System.out.println("Area of the circle is " + resized.getArea());
    }
}
