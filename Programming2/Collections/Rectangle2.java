import java.awt.*;

class Rectangle {

  private int length = 10;
  private int width = 10;
  private Color color = new Color(255, 180, 40);
  private static int numberOfRectangles = 1;  // counter for instances
  public final int ID = numberOfRectangles;

  /**********************  constructors ***********************/

  // default, just use the pre-initialized instance values
  Rectangle(){
    numberOfRectangles++;
  }
  // width, length, color
  Rectangle(int width, int length, Color color){
    if (invalidDim(length) || invalidDim(width)){
      printError(width, length);
      return;
    }
    this.width = width;
    this.length = length;
    this.color = color;
    numberOfRectangles++;
  }
  // width, length
  Rectangle(int width, int length){
    if (invalidDim(length) || invalidDim(width)){
      printError(width, length);
      return;
    }
    this.width = width;
    this.length = length;
    numberOfRectangles++;
  }
  // width only (square)
  Rectangle(int width){
    if (invalidDim(width)){
      printError(width, width);
      return;
    }
    this.width = this.length = width;
    numberOfRectangles++;
  }

  /**********************  methods ***********************/
  public float computeArea(){
    return (this.width * this.length);
  }

  public void drawAt(Graphics g, int x, int y){
    g.setColor(this.color);
    g.fillRect(x, y, this.width, this.length);
  }

  public boolean equals(Rectangle that){
    return ((this.width == that.width) && (this.length == that.length));
  }

  public void setLength(int length){
    this.length = length;
  }

  public void setWidth(int width){
    this.width = width;
  }

  public int getLength(){
    return this.length;
  }

  public int getWidth(){
    return this.width;
  }

  private boolean invalidDim(int dimension){
    return ((dimension < 10) || (dimension > 100));
  }

  private void printError(int width, int length){
      System.out.print("Rectangle dimensions "+width+"x"+length+" are invalid.  ");
      System.out.println("Valid range is 10-100");
  }

}

/**********************  Rectangle test class ***********************/
class Test{

   public static void main(String a[]){
      Rectangle r1=new Rectangle(30,40);
      Rectangle r2=new Rectangle();
      Rectangle r5=new Rectangle(25);
      Rectangle r3=new Rectangle(35,20);
      Rectangle r4=new Rectangle(35,20);
      Rectangle r6=new Rectangle(9,101);  // invalid inputs
      System.out.println(r1.computeArea()); //1200.
      System.out.println(r2.computeArea()); //100.0
      System.out.println(r2.getWidth());   //10.0
      System.out.println(r2.getLength());  //10.0
      r2.setWidth(20);
      r2.setLength(15);
      System.out.println(r2.computeArea()); //300.0
      System.out.println(r3.computeArea()); //700.0
      System.out.println(r4.computeArea()); //700.0
      System.out.println(r5.computeArea()); //625.0
      System.out.println(r1.ID);      //1
      System.out.println(r3.ID);       //4
      //r2.ID = 99; // will cause error
      System.out.println(r1.equals(r2));   //false
      System.out.println(r3.equals(r4));   //true
  }
}
