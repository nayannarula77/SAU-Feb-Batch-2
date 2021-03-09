package defaultpackage;

public class App 
{
	int age;
	String name;
	static String city = "city";      
	String empty = ""; 
	public static String state = "A    B";
	public static int count = 0;
	
    public static void main( String[] args ) throws Exception
    {
    	Object obj = null;
        App object = new App();
        Object app = object.printClass(object.getClass());
        try {
        int n =  object.getNum();
        int div = n/10;
        }
        catch(Exception e) {
        	// doNothing
        }
        
        Object o = object.clone();
        System.out.println(o);
        Boolean isValid = isValid(city);
    }

	private static Boolean isValid(String city) {
		return null;
	}

	private int getNum() {
		count++;
		int a =0;
		int b = 12;
		  if (a == (b-count)) {
		    return b;
		  }
		  if(a==0 | a==2) {
			  return b;
		  }
		  if(a==5)
		return b;	  
		  switch (a) {
		  case 1:
		    b =1;
		    break;
		  case 0:  
		    b=0;
		  default:
		    b = 12;
		    break;
		  case 5:
			  foo:for(int i = 0 ; i < 10 ; i++) {  
			         b = 5;
			         if(i==5)
			        break foo; 
			  }  
		}
		  return b; 
	}

	private Class<? extends App> printClass(Class<? extends App> app) {
		int[] arrayInt = new int[5];
		for(int i =0;i<arrayInt.length;i++) {
			System.out.println(i);
			if(i==2) break;
			if(i>4) continue;
		}
		System.out.println(app);
		return app;
	}
	
	@Override
	public Object clone() {
		int beginIndex = 1;
		char char1 = 'a';
		String init = "Bob is a Bird... Bob is a Plane... Bob is Superman!";
		String changed = init.replaceAll("Bob is", "It's");
		changed = changed.replaceAll("\\.\\.\\.", ";"); 
		int index=changed.substring(beginIndex).indexOf(char1);
		return index;
	  }
	
}
