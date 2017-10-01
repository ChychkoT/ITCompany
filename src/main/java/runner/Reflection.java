package runner;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import address.Address;

public class Reflection {

	public static void main(String[] args) {
		
		Class<Address> e = Address.class;
		System.out.println("Superclass: " +  e.getSuperclass());
		
		Field[] fields =  e.getDeclaredFields();
		for(Field f : fields){
		    System.out.println("field= " + f.getName() + ", modifier= "
		                        +  Modifier.toString(f.getModifiers()) + ", type= " + f.getType());
                                
		}
		
		Method[] methods = e.getMethods();

		for(Method method : methods){
		    System.out.println("method = " + method.getName());
		}
		
		
		try {
			System.out.print("\nmethod 'test' : ");	
	    	Method method = e.getDeclaredMethod("test");
		    method.invoke(new Address());

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
