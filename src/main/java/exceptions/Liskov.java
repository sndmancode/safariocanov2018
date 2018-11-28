package exceptions;

import java.io.IOException;

class Base2 {
  void doBaseStuff() throws Exception {
    System.out.println("doBaseStuff");
    Object o = null;
    o.equals(null);
  }
}

class Sub2 extends Base2 {
  //  @Override
  void doBaseStuff() throws IOException {
    System.out.println("doSubStuff");
//    if (Math.random() > 0.5) throw new IOException();
  }
}

public class Liskov {
  public static void main(String[] args) {
    Base2 b = new Sub2();
    try {
      b.doBaseStuff();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
