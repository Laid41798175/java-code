// LSP: Liskov Substitution Principle

public class LSP {

    public static void main(String[] args) {
        Square s = new Square();
        initialize(s);
    }

    static void initialize(Rectangle r) {
        r.setWidth(5);
        r.setHeight(10);

        // r.getArea() == 100
        assert (r.getArea() == 50);
    }
}

class Rectangle {
    private int width;
    private int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height);
    }
}

class Rectangle1 {
    private int width;
    private int height;

    Rectangle1(int w, int h) {
        width = w;
        height = h;
    }

    public int getArea(){
        return width * height;
    }
}

class Square1 extends Rectangle1 {
    Square1(int side) {
        super(side, side);
    }
}

// inheritance gives 2 advantages, code reusing & abstraction
// if abstraction is not plausible, do NOT use inheritance
// Actually any inheritance is NOT recommended -> Use composition instead

interface IShape {
    int getArea();
}

interface IRectangle extends IShape {
    void setWidth(int width);
    void setHeight(int height);
}

class Rectangle2 implements IRectangle {
    private int width;
    private int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea(){
        return width * height;
    }
}

interface ISquare extends IShape {
    void setSide(int side);
}

class Sqaure2 implements ISquare {
    // IRectangle rect is also okay.
    Rectangle2 rect;

    Sqaure2() {
        rect = new Rectangle2();
    }

    public void setSide(int side) {
        rect.setWidth(side);
        rect.setHeight(side);
    }

    public int getArea(){
        return rect.getArea();
    }
}