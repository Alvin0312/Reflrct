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
     * 反射控制事物
     */  
    public Object invoke(Object proxy, Method method, Object[] args)  
            throws Throwable {  
    	
        Object result=null;  
        
        
        if("addBook".equals(method.getName())){
        	long start = System.currentTimeMillis();
    
        	System.out.println("事物开始"+method); 
        	result=method.invoke(target, args); 
        	System.out.println("事物结束！");
        	
        	System.out.println("运行时间"+(System.currentTimeMillis()-start));
        }
         
        
         
        return result;  
    }  
  
}  