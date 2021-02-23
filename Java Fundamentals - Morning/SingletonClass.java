
package singletonclass;


 class SingleObject {

   private static SingleObject instance = new SingleObject();


   private SingleObject(){}

   public static SingleObject getInstance(){
      return instance;
   }

   public void myfunction(){
      System.out.println("Nayan");
   }
}
public class SingletonClass {

   
    public static void main(String[] args) {
        
        SingleObject object = SingleObject.getInstance();

      object.myfunction();
        
    }
    
}
