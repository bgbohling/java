import java.util.*;

class Collections {

   public static void main(String args[]) throws Exception{
      // use Random to generate 1000 Rectangles
      // and store them in an ArrayList
      ArrayList alist = new ArrayList(1000);
      Random rgen = new Random();
      for (int i = 0; i<1000; i++) {
        int height = rgen.nextInt(9) + 11; 
        int widtth = rgen.nextInt(9) + 11;
        Rectangle r = new Rectangle(width, height);
        alist.add(r);
      }
      
      // now put alist into other required collections
      HashSet hset = new HashSet(alist);
      TreeSet tset = new TreeSet(alist);

   }

}
