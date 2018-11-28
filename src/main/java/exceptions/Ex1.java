package exceptions;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.DateTimeException;

public class Ex1 {
  public void doStuff() {
    try {
      FileReader fr = new FileReader("bad.txt");
      if (Math.random() > 0.5) throw new JAXBException("Secret!");
      if (Math.random() > 0.5) throw new IOException("Hahaha");
      if (Math.random() > 0.5) throw new NullPointerException("??");
    } catch (JAXBException je) {

    } catch (FileNotFoundException fnfe) {
      System.out.println("fnfe");
    } catch (IOException ioe) {
      System.out.println("ioe " + ioe.getMessage());
    }
  }

  public void doStuff2() throws JAXBException {
    try {
      FileReader fr = new FileReader("bad.txt");
      if (Math.random() > 0.5) throw new JAXBException("Secret!");
      if (Math.random() > 0.5) throw new IOException("Hahaha");
      if (Math.random() > 0.5) throw new NullPointerException("??");
    } catch (FileNotFoundException fnfe) {
      System.out.println("fnfe");
    } catch (IOException ioe) {
      System.out.println("ioe " + ioe.getMessage());
    }
  }

  public void doStuff3() {
    try {
      doStuff2();
    } catch (JAXBException e) {
      e.printStackTrace();
    } finally {

    }
  }

  public void readAFile(String name)
      throws FileNotFoundException, IOException {
    try (FileReader fr = new FileReader(name);
         BufferedReader br = new BufferedReader(fr);) {
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println("> " +line);
      }
    } // compiler generated finally will close fr and br.
  }
}
