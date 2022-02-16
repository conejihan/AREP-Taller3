/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.escuelaing.ecisprigboot.reflectionexamples;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import static java.lang.System.out;

/**
 *
 * @author Nicolas Medina
 */
public class ReflectionExamples {
    
    public static void main(String... args){
        printMembers("Hola".getClass().getDeclaredMethods(), "Methods");
    }

    private static void printMembers(Member[] mbrs, String s) {
        out.format("%s:%n", s);
        for (Member mbr : mbrs) {
            if (mbr instanceof Field)
                out.format(" %s%n", ((Field)mbr).toGenericString());
            else if (mbr instanceof Constructor)
                out.format(" %s%n", ((Constructor)mbr).toGenericString());
            else if (mbr instanceof Method)
                out.format(" %s%n", ((Method)mbr).toGenericString());
        }
        if (mbrs.length == 0)
            out.format(" -- No %s --%n", s);
        out.format("%n");
    }
}
