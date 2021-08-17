package Day2Shapes;


public class Square extends Shape{
    private int area;
    private int perimeter;
    
    
    @Override
    public int getArea(){
        return area;
    }
    
    @Override
    public int getPerimeter(){
        return perimeter;
    }
    
    public int getDiagonal(){
        return (int) Math.sqrt(Math.sqrt(2)*perimeter);
    }
}
