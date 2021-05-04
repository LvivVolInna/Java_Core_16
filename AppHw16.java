package hw16;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

import ua.lviv.lgs.Person;

public class AppHw16 {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Class<FanatasyBook> bookClass = FanatasyBook.class;

		String nameOfClass = bookClass.getName();
		System.out.println("Name of class is: " + bookClass.getName());

		Class<?> nameOfClass1 = Class.forName(nameOfClass);
		System.out.println("Name of " + nameOfClass1);

		System.out.println();
		String simpleName = bookClass.getSimpleName();
		System.out.println("SimpleName of class = " + simpleName);

		System.out.println();
		Package classPackage = bookClass.getPackage();
		System.out.println("Package of current class = " + classPackage);

		System.out.println();
		Class<? super FanatasyBook> superClass = bookClass.getSuperclass();
		System.out.println("Class " + nameOfClass + " extends from " + superClass);

		System.out.println();
		@SuppressWarnings("rawtypes")
		Class[] interfaces = bookClass.getInterfaces();
		System.out.println("Interfaces: " + Arrays.toString(interfaces));

		System.out.println();
		@SuppressWarnings("rawtypes")
		Constructor[] cons = bookClass.getConstructors();
		printList("Constructors: " + cons, cons);

		System.out.println("Constructor size = " + cons.length);

		System.out.println();
		Field[] fields = bookClass.getFields();
		printList("Public fields: " + fields, fields);

		fields = bookClass.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
		}
		System.out.println();
		printList("All declared fields: " + fields, fields);

		System.out.println();
		Constructor<FanatasyBook> constructor = cons[0];

		Class<?>[] parameterTypes = constructor.getParameterTypes();
		for (int i = 0; i < parameterTypes.length; i++) {
			Class<?> class1 = parameterTypes[i];
			System.out.println("Type variable = " + class1);
		}

		// get Constructor by parameters
		System.out.println();
		Constructor<FanatasyBook> singleConstructor = bookClass.getConstructor(int.class, String.class);
		System.out.println("Single Constructor = " + singleConstructor);
		FanatasyBook newInstanceFantasyBook = singleConstructor.newInstance(250, "Polish");
		System.out.println("New instance = reflection fantasyBook = " + newInstanceFantasyBook);

		// field set
		System.out.println();
		Field numberOfPagesField = bookClass.getField("numberOfPages");
		numberOfPagesField.set(newInstanceFantasyBook, 275);
		System.out.println("Book with new number of pages: " + newInstanceFantasyBook);

		System.out.println();
		Field privateBookTitleField = bookClass.getDeclaredField("bookTitle");
		privateBookTitleField.setAccessible(true);
		privateBookTitleField.set(newInstanceFantasyBook, " Harry Potter and the Cursed Child");
		System.out.println("Private value = " + privateBookTitleField.get(newInstanceFantasyBook));
		System.out.println("Book with new title: " + newInstanceFantasyBook);
		
		System.out.println();
		Method[] methods = bookClass.getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			System.out.println("Method: " + method);
		}
		//printList("Methods: " + methods, methods);
		
		
		System.out.println();
		Field privateAuthorField = bookClass.getDeclaredField("author");
		privateAuthorField.setAccessible(true);
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			if(method.equals(bookClass.getMethod("setAuthor", String.class))) {
				methods [i].invoke(newInstanceFantasyBook, "Galbraith");
				System.out.println(newInstanceFantasyBook);
			}	
		}
		
		
		System.out.println();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			if (method.equals(bookClass.getMethod("firstUpperCase", String.class))) {
				System.out.println("Enter author's full name: ");
				Scanner scanner = new Scanner(System.in);
				String author = scanner.nextLine();
				methods[i].invoke(newInstanceFantasyBook, author);
				System.out.println(newInstanceFantasyBook);
			}
		}	
		
		System.out.println();
		Method bookClassMethod1 = bookClass.getMethod("translate", String.class, int.class);
		bookClassMethod1.invoke(newInstanceFantasyBook, "Spanish", 10);
		System.out.println(newInstanceFantasyBook);
		
	}

	private static void printList(String string, Object[] object) {
		System.out.println("*** " + string + " ***");
		for (int i = 0; i < object.length; i++) {
			System.out.println(object[i].toString());

		}

	}

}
