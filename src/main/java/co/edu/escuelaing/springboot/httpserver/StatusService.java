/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.escuelaing.springboot.httpserver;

/**
 *
 * @author clases
 */
public class StatusService {
    
    @Service("/status")
    public static String status(){
        return "HTTP  /1.1 200 OK\r\n"
                +"<!DOCTYPE html>" + 
          "<html>" + 
          "<head>" + 
          "<meta charset=\"UTF-8\">" + 
          "<title>Title of the document</title>\n" + 
          "</head>" + 
          "<body>" + 
          "<h1>Mi propio mensaje</h1>" + 
          "</body>" + 
          "</html>";
    }
}