import java.util.*;

// Rectangle Shape
class Rectangle  implements Comparable<Rectangle> {
  
  protected int width = 0;
  protected int height = 0;
  protected static int rectCount = 0;

  Rectangle() {
    rectCount++;
  }

  Rectangle(int width, int height) {
    this.width = width;
    this.height = height;
    rectCount++;
  }

  public static int numRectangles() {
    return rectCount;
  }

  public int area() {
    return this.width * this.height;
  }

  public int compareTo(Rectangle that) {
    if (this.area() < that.area()) {
      return -1;
    }
    else if (this.area() > that.area()) {
      return 1;
    }
    else {
      return 0;
    }
  }

  public int hashCode (){
system.out.println(this.area());
    return this.area();
  }

  public boolean equals (Rectangle that) {
    return (this.area() == that.area());
  }


}
