package com.coderising.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Book {
	
	private String id ;
	
	private int value ;
	private String name;
	
	
	public Book(){
		
	}
	public Book(String id,String name){
		this.id  = id;
		this.name = name;		 
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static void main(String[] args){
		viewClassInfo();
		//createObjectByName();

	}
	private static void createObjectByName(){
		try {
			//根据类的名称装载一个类
			Class clz = Class.forName("com.coderising.reflection.Book");
			//创建一个类的实例
			Object obj = clz.newInstance();
			//得到一个方法的引用
			Method method = clz.getDeclaredMethod("setId", java.lang.String.class);
			//调用该方法
			method.invoke(obj, "100");
			
			Book b = (Book) obj;
			System.out.println(b.getId());
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	private static void viewClassInfo() {
		Book book = new Book("1","Thinking in java");
		Class clz = book.getClass();
		
		System.out.println("包名"+ clz.getPackage().getName());
		System.out.println("超类:"+ clz.getSuperclass());
		
		System.out.println("数组对象:"+ clz.isArray());
		System.out.println("字段:");
		Field[] fields = clz.getDeclaredFields();
		for(int i=0;i<fields.length;i++){
			Class type = fields[i].getType();
			
			System.out.println(type.getName()+" "+ fields[i].getName());			
		}
		System.out.println("构造器的参数类型:");
		Constructor[] constructors = clz.getDeclaredConstructors();
		for(int i=0;i<constructors.length;i++){			
			Class[] types = constructors[i].getParameterTypes();
			for(int j=0;j<types.length;j++){
				System.out.println(types[j].getName());	
			}					
		}
		
		
		System.out.println("方法:");
		Method[] methods = clz.getDeclaredMethods();
		for(int i=0;i<methods.length;i++){
			
			String name = methods[i].getName();
			Class returnType = methods[i].getReturnType();
			Class[] paramTypes = methods[i].getParameterTypes();
			StringBuilder sb = new StringBuilder();
			sb.append(returnType.getName()).append(" ").append(name).append("(");
			for(int j=0;j<paramTypes.length;j++){
				sb.append(paramTypes[j].getName()).append(" ");
			}
			sb.append(")");
			System.out.println(sb.toString());
		}
	}
	
}
