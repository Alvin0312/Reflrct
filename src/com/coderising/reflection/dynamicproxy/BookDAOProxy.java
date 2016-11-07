package com.coderising.reflection.dynamicproxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BookDAOProxy implements InvocationHandler {  
    private Object target;  
    
    public Object bind(Object target) {  
        this.target = target;  
         
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),  
                target.getClass().getInterfaces(), this);   
    }  
  
    @Override  
    /** 
     * �����������
     */  
    public Object invoke(Object proxy, Method method, Object[] args)  
            throws Throwable {  
    	
        Object result=null;  
        
        
        if("addBook".equals(method.getName())){
        	long start = System.currentTimeMillis();
    
        	System.out.println("���￪ʼ��"+method); 
        	result=method.invoke(target, args); 
        	System.out.println("���������");
        	
        	System.out.println("����ʱ��"+(System.currentTimeMillis()-start));
        }
         
        
         
        return result;  
    }  
  
}  