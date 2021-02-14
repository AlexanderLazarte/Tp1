import java.io.FileWriter;
import java.io.IOException;


public class Escritor {

	public void escribirEnArchivo(String datosAEscribir){
		try {
			FileWriter escritorDeArchivo = new FileWriter("itinerarios.txt", true);
			escritorDeArchivo.write(datosAEscribir + "\n");
			escritorDeArchivo.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
}
