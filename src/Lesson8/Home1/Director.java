package Lesson8.Home1;

public class Director implements JobMethod {
   private String metaDescription = "Директор";

   @Override
   public void printJobTitle() {
      System.out.println(metaDescription);
   }
}
