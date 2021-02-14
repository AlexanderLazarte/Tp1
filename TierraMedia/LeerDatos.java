import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeerDatos {
	
	public ArrayList<Usuario> obtenerDatosUsuarios(){
		FileReader archivo;
		ArrayList<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
		try {
			archivo = new FileReader("usuarios.txt");
			BufferedReader lector = new BufferedReader(archivo);
			String oneLine = lector.readLine();
			while(oneLine != null){
			
				String [] datos = oneLine.split(",");
				
				listaDeUsuarios.add(new Usuario(datos[0], Double.parseDouble(datos[1]), Double.parseDouble(datos[2]),
									TipoDeAtraccion.valueOf(datos[3])));
				
				oneLine = lector.readLine();
			}
			lector.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaDeUsuarios;
	}
	
	public ArrayList<Atraccion> obtenerDatosAtracciones(){
		FileReader archivo;
		ArrayList<Atraccion> listaDeAtracciones = new ArrayList<Atraccion>();
		try {
			archivo = new FileReader("atracciones.txt");
			BufferedReader lector = new BufferedReader(archivo);
			String oneLine = lector.readLine();
			while(oneLine != null){
			
				String [] datos = oneLine.split(",");
				
				listaDeAtracciones.add(new Atraccion(datos[0], Double.parseDouble(datos[1]), Double.parseDouble(datos[2]),
									Integer.parseInt(datos[3]),TipoDeAtraccion.valueOf(datos[4])));
				
				oneLine = lector.readLine();
			}
			lector.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return listaDeAtracciones;
	}
	
	//Pre-condicion : debe haber sido creada la lista de Atracciones previamente.
	//Post-condicion : devuelve una lista con las promociones
	public ArrayList<Promocion> obtenerDatosPromociones(ArrayList<Atraccion> listaDeAtracciones) {
		FileReader archivo;
		ArrayList<Promocion> listaDePromociones = new ArrayList<Promocion>();

		try {
			archivo = new FileReader("promociones.txt");
			BufferedReader lector = new BufferedReader(archivo);
			String oneLine = lector.readLine();
			while(oneLine != null){

				String [] datos = oneLine.split(",");

				if(datos[0].equals("DosPorUno")  ){

					Atraccion atraccion1 = null;
					Atraccion atraccion2 = null;
					Atraccion atraccionGratis = null;

					for(int i = 0 ; i<listaDeAtracciones.size()  ; i++ ){
						if(listaDeAtracciones.get(i).getNombreDeLaAtraccion().equals(datos[1]) )
							atraccion1 = listaDeAtracciones.get(i);
					}
					for(int i = 0 ; i<listaDeAtracciones.size() ; i++ ){
						if(listaDeAtracciones.get(i).getNombreDeLaAtraccion().equals(datos[2]))
							atraccion2 = listaDeAtracciones.get(i);
					}
					for(int i = 0 ; i<listaDeAtracciones.size() ; i++ ){
						if(listaDeAtracciones.get(i).getNombreDeLaAtraccion().equals(datos[3]))
							atraccionGratis = listaDeAtracciones.get(i);
					}

					listaDePromociones.add(new DosPorUno (atraccion1, atraccion2, atraccionGratis));

				} else if(datos[0].equals("Fijo") ){
					
					Atraccion atraccion1 = null;
					Atraccion atraccion2 = null;

					for(int i = 0 ; i<listaDeAtracciones.size() ; i++ ){
						if(listaDeAtracciones.get(i).getNombreDeLaAtraccion().equals(datos[1]))
							atraccion1 = listaDeAtracciones.get(i);
					}
					for(int i = 0 ; i<listaDeAtracciones.size() ; i++ ){
						if(listaDeAtracciones.get(i).getNombreDeLaAtraccion().equals(datos[2]))
							atraccion2 = listaDeAtracciones.get(i);
					}

					listaDePromociones.add(new Fijo (atraccion1, atraccion2, Integer.parseInt(datos[3])));

				}else if(datos[0].equals("Porcentual") ){

					Atraccion atraccion1 = null;
					Atraccion atraccion2 = null;
					
					for(int i = 0 ; i<listaDeAtracciones.size(); i++ ){
						if(listaDeAtracciones.get(i).getNombreDeLaAtraccion().equals(datos[1]))
							atraccion1 = listaDeAtracciones.get(i);
					}

					for(int i = 0 ; i<listaDeAtracciones.size(); i++ ){
						if(listaDeAtracciones.get(i).getNombreDeLaAtraccion().equals(datos[2]))
							atraccion2 = listaDeAtracciones.get(i);
					}


					listaDePromociones.add(new Porcentual (atraccion1, atraccion2, Double.parseDouble(datos[3])));

				}
				oneLine = lector.readLine();
			}
			lector.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return listaDePromociones;
	}
	
}
