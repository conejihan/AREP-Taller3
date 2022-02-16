/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.escuelaing.ecisprigboot.reflectionexamples;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.lang.reflect.InvocationTargetException;
/**
 *
 * @author Nicolas Medina
 */
public class InvokeMain {
    
    public static void main(String... args) {
        try {
            Class<?> c = Class.forName(args[0]);
            Class[] argTypes = new Class[] { String[].class };
            Method main = c.getDeclaredMethod("main", argTypes);
            String[] mainArgs = Arrays.copyOfRange(args, 1, args.length);
            System.out.format("invoking %s.main()%n", c.getName());
            main.invoke(null, (Object)mainArgs);
            
            // production code should handle these exceptions more gracefully
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        } catch (NoSuchMethodException x) {
            x.printStackTrace();
        } catch(IllegalAccessException x){
            x.printStackTrace();
        } catch(InvocationTargetException x){
            x.printStackTrace();
        }
    } 
}
    

