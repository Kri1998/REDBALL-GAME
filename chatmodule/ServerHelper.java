
import java.io.*;
import java.util.Date;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHelper extends Thread{
	private final Socket clientSocket;

	public ServerHelper(Socket clientSocket){
	this.clientSocket = clientSocket;
}

@Override
		public void run(){
			try{
				handleClientSocket();
				}catch(IOException e){
			     e.printStackTrace();
			    }catch(InterruptedException e){
			     e.printStackTrace();
			}
		}

private void handleClientSocket() throws IOException,InterruptedException{
	InputStream inputStream = clientSocket.getInputStream();
	OutputStream outputStream = clientSocket.getOutputStream();

	BufferedReader reader = new BufferedReader(new InputStream(inputStream));
	String line;
	while((line = reader.readLine()) != null){
		if("quit".equalsIgnoreCase(line)){
			break;
		}
		String msg = "You typed:" + line + "\n";
		outputStream.write(msg.getBytes());
	}
	
	clientSocket.close();
}
}