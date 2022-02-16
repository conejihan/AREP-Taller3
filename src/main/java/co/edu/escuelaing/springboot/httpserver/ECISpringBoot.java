/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.escuelaing.springboot.httpserver;
import co.edu.escuelaing.springboot.httpserver.HttpServer;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author clases
 */
public class ECISpringBoot {
    
    private Map<String, Method> services = new HashMap();
    private static ECISpringBoot _instance = new ECISpringBoot();
    
    private ECISpringBoot(){     
    }
    
    public ECISpringBoot getInstance(){
        return _instance;
    }
    
    public void startServer(){
        loadComponenets();
        HttpServer httpServer = new HttpServer();
        httpServer.start();
    }

    private void loadComponenets() {
        String[] componentList = searchComponentList();   
        for(String componentName: componentList){
            loadServices(componentName);
        }
    }

    private String[] searchComponentList() {
        return new String[]{"httpServer.StatusService"};
    }

    private void loadServices(String componentName) {
        try {
            Class c = Class.forName(componentName);
            Method[] declaredMethods = c.getDeclaredMethod();
            for(Method m: declaredMethods){
                if(m.isAnnotationPresent(Service.class)){
                    Service a = m.getAnnotation(Service.class);
                    services.put(a.value(), m);
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ECISpringBoot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String invokeService(String serviceName){
        Method serviceMethod = services.get(serviceName);
        return (String) serviceMethod.invoke(null);
    }
}
