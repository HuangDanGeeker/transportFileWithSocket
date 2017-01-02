import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

import javax.swing.JOptionPane;




public class Client {

	public Socket clientSocekt;
	
	public Client(){
		try{
			clientSocekt = new Socket("127.0.0.1", 8989);
			String filePath = JOptionPane.showInputDialog("file path");
			File myFile = new File(filePath);
			System.out.println("client : file got");
			System.out.println("client : file Reader got");
			
			BufferedInputStream dataReader = new BufferedInputStream(new FileInputStream(myFile));
//			System.out.println("fileSize : " + myFile.length());
			
			int fileSize = new Long(myFile.length()).intValue();
			byte[] dataByte = new byte[fileSize];
			
//			System.out.println("caculated fileSize : " +  fileSize);
			
			

//			BufferedOutputStream dataPrinter = new BufferedOutputStream(clientSocekt.getOutputStream());
//			dataPrinter.write(dataByte);
			dataReader.read(dataByte);
			System.out.println("client : bytes.length = " + dataByte.length);
			clientSocekt.getOutputStream().write(dataByte, 0, dataByte.length);
			clientSocekt.getOutputStream().flush();
			System.out.println("client : every thing down");
			dataReader.close();
			clientSocekt.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			
		}
	}
	
	public static void main(String[] args) {
		new Client();;
	}
}
