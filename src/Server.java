import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public ServerSocket serverSocket;
	
	
	public Server(){
		try{
			serverSocket = new ServerSocket(8989);
			System.out.println("server : start sccessful");
			Socket socketFromClient = serverSocket.accept();
			System.out.println("server : socket received");
			
			
			
			
			File target = new File("D://downloadFile.jpg");
			if(target.exists() && !target.isDirectory()){
				target.delete();
			}
			BufferedInputStream dataReader = new BufferedInputStream(socketFromClient.getInputStream());
			System.out.println("server : bufferedInoutStream got");
			
			FileOutputStream fileWriter = new FileOutputStream(target);
			System.out.println("server : fileOutStream got");
			
			byte[] dataBytes = new byte[135277];
			
//			dataReader.read(dataBytes);
			socketFromClient.getInputStream().read(dataBytes);
//			System.out.println("server : bytes.length = " + dataBytes.length);
			fileWriter.write(dataBytes);
//			fileWriter.flush();
			
			System.out.println("server : file write done");
			System.out.println("server : every thing done");
			dataReader.close();
			fileWriter.close();
			serverSocket.close();
		}catch(Exception e){
			//e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Server();
	}
}
