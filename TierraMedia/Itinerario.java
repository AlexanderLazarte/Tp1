import java.util.ArrayList;
import java.util.ListIterator;

public class Itinerario {
	private Usuario usuario;
	private double tiempoTotal;
	private double costoTotal;
	private ArrayList <Atraccion> atraccionesDelUsuario;
	private boolean estaCerrado;
	private Escritor escritor;
	
	Itinerario(Usuario usuarioActual){
		this.atraccionesDelUsuario = new ArrayList<Atraccion>();
		this.costoTotal = 0;
		this.tiempoTotal = 0;
		this.usuario = usuarioActual;
		this.estaCerrado = false;
		this.escritor = new Escritor();
	}

	public String devolverItinerarioParcial(){
		if(this.atraccionesDelUsuario.isEmpty())
			return "El itinerario del usuario :" + usuario.getNombre() + " se encuentra vacío";
		return "El itinerario del usuario : " + usuario.getNombre() + ", tiene un gasto total de :" + this.costoTotal
				+ ", le va a llevar " + this.tiempoTotal + "hs , y visitara las siguientes atracciones :" + nombreDeLasAtracciones();
	}
	
	public void cerrarItinerario(){
		this.estaCerrado = true;
		System.out.println(devolverItinerarioParcial());
		escritor.escribirEnArchivo(devolverItinerarioParcial());
	}
	
	public ArrayList<Atraccion> getAtraccionesDelUsuario(){
		return this.atraccionesDelUsuario;
	}
	
	public void agregarAtraccion(Atraccion atraccionAAgregar){
		if(!this.estaCerrado){
			this.costoTotal += atraccionAAgregar.getCosto();
			this.tiempoTotal += atraccionAAgregar.getTiempo();
			this.atraccionesDelUsuario.add(atraccionAAgregar);
			System.out.println ("Se ah agregado de manera exitosa la atraccion a su itinerario");
		}else
			System.out.println("El Itinerario ya esta cerrado");
	}

	public void agregarPromocion(Promocion promocionAAgregar){
		if(!this.estaCerrado){
			this.atraccionesDelUsuario.addAll(promocionAAgregar.getAtraccionesAsociadas());
			this.costoTotal += promocionAAgregar.getCostoTotal();
			this.tiempoTotal += promocionAAgregar.getTiempoTotal();
			System.out.println ("Se ah agregado de manera exitosa la atraccion a su itinerario");
		}else
			System.out.println("El Itinerario ya esta cerrado");
	}
	
	public boolean estaCerrado(){
		return this.estaCerrado;
	}

	private String nombreDeLasAtracciones() {
		String nombreDeLasAtracciones = "";
		ListIterator<Atraccion> iteradorDeLasAtraccionesDelUsuario = this.atraccionesDelUsuario.listIterator();
		while(iteradorDeLasAtraccionesDelUsuario.hasNext()){
			nombreDeLasAtracciones +=  (iteradorDeLasAtraccionesDelUsuario.next().getNombreDeLaAtraccion()) + ", ";
		}
		return nombreDeLasAtracciones;
	}

	


}
