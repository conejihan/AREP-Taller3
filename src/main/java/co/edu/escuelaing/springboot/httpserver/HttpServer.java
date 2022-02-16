/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.escuelaing.springboot.httpserver;
import java.net.*;
import java.io.*;
/**
 *
 * @author clases
 */



public class HttpServer {
    
  public static void start(String[] args) throws IOException {
   ServerSocket serverSocket = null;
   try { 
      serverSocket = new ServerSocket(36000);
   } catch (IOException e) {
      System.err.println("Could not listen on port: 35000.");
      System.exit(1);
   }
   boolean running = true;
   while(running){
   Socket clientSocket = null;
   try {
       System.out.println("Listo para recibir ...");
       clientSocket = serverSocket.accept();
   } catch (IOException e) {
       System.err.println("Accept failed.");
       System.exit(1);
   }
   PrintWriter out = new PrintWriter(
                         clientSocket.getOutputStream(), true);
   BufferedReader in = new BufferedReader(
                         new InputStreamReader(clientSocket.getInputStream()));
   String inputLine, outputLine;
   boolean primeraLinea = true;
   String file = "";
   while ((inputLine = in.readLine()) != null) {
      System.out.println("Recibí: " + inputLine);
      if(primeraLinea){
          file = inputLine.split(" ")[1];
          System.out.println("File: "+ file);
          primeraLinea = false;
      }
      if (!in.ready()) {break; }
   }
   if(file.startsWith("/Apps/")){
       invokeService(file.substring(4));
   }
   outputLine = 
          "<!DOCTYPE html>" + 
          "<html>" + 
          "<head>" + 
          "<meta charset=\"UTF-8\">" + 
          "<title>Title of the document</title>\n" + 
          "</head>" + 
          "<body>" + 
          "<h1>Mi propio mensaje</h1>" + 
          "</body>" + 
          "</html>" + inputLine; 
    out.println(outputLine);
    out.close(); 
    in.close(); 
    clientSocket.close();
  }
    serverSocket.close(); 
  }



}
