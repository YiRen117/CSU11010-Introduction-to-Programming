public class ResizableCircle extends Circle implements Resizable{
    ResizableCircle(double radius){
        super(radius);
    }

    @Override
    public void resize(int percent) {
        double percentage = 1 - percent / 100.0;
        this.radius = this.radius * percentage;
    }
}
