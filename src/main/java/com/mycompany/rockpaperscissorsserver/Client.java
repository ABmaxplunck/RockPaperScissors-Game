/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rockpaperscissorsserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Client {
public static Socket socket = null;
public static void main(String [] args) {
try {
socket = new Socket("localhost", 5050);
System.out.println("Connected to server\n\n");
} catch (IOException e) {
System.out.println("Connection to network couldn't be established");
}
BufferedReader in = null;
PrintWriter out = null;
Scanner scan = new Scanner(System.in);
try {
in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
out = new PrintWriter(socket.getOutputStream(), true);
System.out.println(in.readLine());
System.out.println();
System.out.println("Your Name?: ");
out.println(scan.nextLine());
System.out.println(in.readLine());
while(true) {
System.out.println("\n" + in.readLine());
String choice = scan.nextLine();
int x = Integer.parseInt(choice);
if (x==4) {
System.out.println("GAME OVER!");
break;
}
out.println(choice);
System.out.println(in.readLine());
System.out.println(in.readLine());
System.out.println(in.readLine());
}
} catch(IOException e) {
e.printStackTrace();
scan.close();
}
}
}