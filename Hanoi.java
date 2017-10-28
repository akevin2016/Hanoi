import java.util.*;

public class Hanoi {
  private static ArrayList <Integer> a = new ArrayList<Integer>();
  private static ArrayList <Integer> b = new ArrayList<Integer>();
  private static ArrayList <Integer> c = new ArrayList<Integer>();
  
  public static void main(String [] args) {
    for(int i = Integer.parseInt(args[0]); i > 0; i--) {
      a.add(new Integer(i));
    }
    print();
    move(a, b, c, Integer.parseInt(args[0]));
  }

  public static void move(ArrayList <Integer> start, ArrayList <Integer> mid, 
                     ArrayList <Integer> end, int numDisks) {
    if(numDisks == 1) {
      end.add(start.remove(start.size()-1));
      print();
    }
    else if(numDisks == 2) {
      // move #1 to unused position
      mid.add(start.remove(start.size() - 1));
      print();
      // move #2 to end position
      end.add(start.remove(start.size() - 1));
      print();
      // move #1 to end position
      end.add(mid.remove(mid.size() - 1));
      print();
    }
    else {
      // move numDisks - 1 to mid
      move(start, end, mid, numDisks-1);
      // move largest disk to end
      move(start, mid, end, 1);
      // move mid to end
      move(mid, start, end, numDisks-1);
    }
  }
  
  public static void print() {
    System.out.print("a: ");
    for(int i = 0; i < a.size(); i++) {
      System.out.printf("%3d", a.get(i).intValue());
    }
    System.out.print("\nb: ");
    for(int i = 0; i < b.size(); i++) {
      System.out.printf("%3d", b.get(i).intValue());
    }
    System.out.print("\nc: ");
    for(int i = 0; i < c.size(); i++) {
      System.out.printf("%3d", c.get(i).intValue());
    }
    System.out.println("\n");
  }
} 






