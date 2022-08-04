/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rockpaperscissorsserver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;


public class Server {
private static ServerSocket server = null;
private static Socket socket = null;
private static final int port = 5050;
public static void main(String [] args) {
Scanner scan = new Scanner(System.in);
BufferedReader in = null;
PrintWriter out = null;
try {
System.out.println("Starting the Server. . .");
server = new ServerSocket(port);
System.out.println("Server has started!");
} catch(IOException e) {
System.out.println("Cannot connect to the port: " + port);
System.exit(-1);
}
while(true) {
try {
socket = server.accept();
System.out.println("Player connected!");
} catch (IOException e) {
System.out.println("Connection error with Player!");
System.exit(-1);
}
try {
in = new BufferedReader(new InputStreamReader (socket.getInputStream()));
out = new PrintWriter(socket.getOutputStream(), true);
out.println("Rock Paper Scissors Game!");
String s = in.readLine();
System.out.println("Player Name: " + s);
out.println("Welcome, " + s + "!");
while(socket.isConnected()) {
out.println("Select your move ENTER 1 to select ROCK or ENTER 2 to select PAPER or ENTER 3 to select SCISSOR or Enter 4 to Exit");
String playerChoice = in.readLine();
int x = Integer.parseInt(playerChoice);
if (x == 1)
out.println("You chose ROCK");
else if (x == 2)
out.println("You chose PAPER");
else if (x == 3)
out.println("You chose SCISSORS");
else if (x == 4)
break;
else
out.println("Wrong Input");
int min = 1, max = 3;
Random rand = new Random();
int y = rand.nextInt((max - min) + 1) + min;
if (y == 1)
out.println("Computer chose ROCK");
else if (y == 2)
out.println("Computer chose PAPER");
else
out.println("Computer chose SCISSORS");
if(x==y)
out.println("Result: It's a Draw, " + s + "!");
else if((x==1 && y==3) || (x==2 && y==1) || (x==3 &&
y==2))
out.println("Result: You Win, " + s + "!");
else
out.println("Result: You Lose, " + s + "!");
}
} catch (IOException e) { System.out.println("Player left");
scan.close();
}
}
}
}