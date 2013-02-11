import java.util.*;

class Collections {

   public static void main(String args[]) throws Exception{
      // use Random to generate 1000 Rectangles
      // and store them in an ArrayList
      ArrayList<Rectangle> alist = new ArrayList<Rectangle>(1000);
      Random rgen = new Random();
      for (int i = 0; i<1000; i++) {
        int height = rgen.nextInt(9) + 11; 
        int width = rgen.nextInt(9) + 11;
        Rectangle r = new Rectangle(width, height);
        alist.add(r);
      }
      
      // now put alist into other required collections
      HashSet<Rectangle> hset = new HashSet<Rectangle>();
      TreeSet<Rectangle> tset = new TreeSet<Rectangle>();

     Iterator at = alist.iterator();
     while(at. hasNext()) {
        Rectangle r = (Rectangle)at.next();
        hset.add(r);
        tset.add(r);
     }

      // print some results!
      System.out.println("ArrayList elements: " + alist.size());
      System.out.println("HashSet elements: " + hset.size());
      System.out.println("TreeSet elements: " + tset.size());
      System.out.println();
      Iterator it = alist.iterator();
      for (int i = 0; i < 5; i++) {
        Rectangle r = (Rectangle)it.next();
        System.out.println("ArrayList Item " + i + " area: " + r.area() + " width:  " + r.width + " height:  " + r.height);
      }
      System.out.println("\n");
      it = hset.iterator();
      for (int i = 0; i < 5; i++) {
        Rectangle r = (Rectangle)it.next();
        System.out.println("HashSet Item " + i + " area: " + r.area() + " width:  " + r.width + " height:  " + r.height);
      }
      System.out.println("\n");
      it = tset.iterator();
      for (int i = 0; i < 5; i++) {
      //while(tset.hasNext()) {
        Rectangle r = (Rectangle)it.next();
        System.out.println("TreeSet Item " + i + " area: " + r.area()  + " width:  " + r.width + " height:  " + r.height);
      }

   }

}
