
import java.io.*;
import java.util.Date;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain{
public static void main(String[] args){
	int port = 8818;
	try{
	ServerSocket serverSocket = new ServerSocket(port);
	while(true){
	System.out.println("Line is started and open to accept client connection .. .");
	Socket clientSocket = serverSocket.accept();
	System.out.println("Accepted Connection from" + clientSocket);
	ServerHelper helper = new ServerHelper(clientSocket);
	helper.start();
}
	
}catch(IOException e){
	e.printStackTrace();
}
}
}