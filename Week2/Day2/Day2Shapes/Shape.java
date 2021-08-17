package Day2Shapes;



public abstract class Shape {
    protected String color;
    
    public void setColor(String color)
    {
        this.color=color;
    }
    abstract int getArea();
    abstract int getPerimeter();
}
