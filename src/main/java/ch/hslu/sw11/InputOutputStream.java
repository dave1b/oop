package ch.hslu.sw11;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;







public class InputOutputStream {

	static private final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(InputOutputStream.class);









	public void read() {

		try(final DataInputStream dis = new DataInputStream(new FileInputStream("C:\\Users\\Dave\\myCloud\\HSLU\\Module\\OOP\\IO-Files\\demo.dat"))) {

			final int value = dis.readInt();
			final String value2 = dis.readUTF();
			final double value3 = dis.readDouble();
			final byte value4 = dis.readByte();
      
			System.out.println(value +"\n"+ value2 +"\n"+ value3 +"\n"+ value4  );
		} catch (IOException e) {
			LOG.error("Problem aufgetaucht: 1" + e.getMessage());
		}
	}



	public void write() {
		final int value = 825373492;
		final String value2 = "Studieren Sie die Codebeispiele im Input für die Klassen DataInputStream und DataOutputStream. Werfen Sie auch einen Blick in die JavaDoc.";
		final double value3 = 2000.44;
		final byte value4 = 127;

		try(final DataOutputStream dis = new DataOutputStream(new FileOutputStream("C:\\Users\\Dave\\myCloud\\HSLU\\Module\\OOP\\IO-Files\\demo.dat"))) {
			dis.writeInt(value);
			dis.writeUTF(value2);
			dis.writeDouble(value3);
			dis.writeByte(value4);
			LOG.info("Datei geschrieben.");
//			Byte[] values = {11,22,33,44};
//			final String value2 = "öäüéàè#°§§¬|¢90Dave";			
//			dis.writeDouble(65);
//			dis.close();
//			System.out.println(value);
		} catch (IOException e) {
			LOG.error("Problem aufgetaucht: 2" + e.getMessage());
		}
	}






	public static void main(String[] args) {

		InputOutputStream ins = new InputOutputStream();
		ins.write();
		ins.read();

	}





















}
