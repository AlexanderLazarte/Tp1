
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class ParqueDeAtraccionesMedievales {

	private LeerDatos lector;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Atraccion> atracciones;
	private ArrayList<Promocion> promociones;
	private ListIterator<Usuario> iteradorDeListaDeUsuarios;
	private Usuario usuarioActual;
	Itinerario itinerarioDelUsuarioActual;

	ParqueDeAtraccionesMedievales(){
		lector = new LeerDatos();
		usuarios = lector.obtenerDatosUsuarios();
		atracciones = lector.obtenerDatosAtracciones();
		promociones = lector.obtenerDatosPromociones(atracciones);
		iteradorDeListaDeUsuarios = usuarios.listIterator();
		usuarioActual = iteradorDeListaDeUsuarios.next();
		itinerarioDelUsuarioActual = usuarioActual.getItinerario();
	}


	public void darSugerencia(){

		try {
			while(usuarioActual != null){
				System.out.println("Usuario " + usuarioActual.getNombre());
				ofrecerPromocionesAcordes();
				ofrecerAtraccionesAcordes();
				ofrecerElRestoDePromociones();
				ofrecerElRestoDeAtracciones();
				if(!itinerarioDelUsuarioActual.estaCerrado()){
					System.out.println("No hay mas atracciones y promociones para ofrecer, se cierra su itinerario y se muestra un resumen de este");
					itinerarioDelUsuarioActual.cerrarItinerario();
				}
				if(this.iteradorDeListaDeUsuarios.hasNext()){
					siguienteUsuario();	
				} else {
					System.out.println("No hay mas usuarios, programa terminado.");
					this.usuarioActual = null;
				}
			}
		

		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	private void ofrecerElRestoDeAtracciones() {
		ListIterator<Atraccion> iteradorDeListaDeAtracciones = atracciones.listIterator();
		while(iteradorDeListaDeAtracciones.hasNext()){
			Atraccion atraccionAOfrecer = iteradorDeListaDeAtracciones.next();
			if(!esDeSuPreferencia(atraccionAOfrecer) && tienePresupuesto(atraccionAOfrecer) &&
					tieneTiempo(atraccionAOfrecer) && 
					hayCupo(atraccionAOfrecer) && !estaEnSuItinerario(atraccionAOfrecer)){
				System.out.println("Se Ofrece la siguiente atraccion : " + atraccionAOfrecer.getNombreDeLaAtraccion() 
						+ "con un costo de: " + atraccionAOfrecer.getCosto() + "y un tiempo necesario para completarla de: " + atraccionAOfrecer.getTiempo());
				System.out.println("por favor ingrese Si o No para confirmar o rechazar la promocion ofrecida");
				if(recibirRespuesta().equals("Si")){
					this.usuarioActual.disminuirPresupuesto(atraccionAOfrecer.getCosto());
					this.usuarioActual.disminuirTiempoDisponible(atraccionAOfrecer.getTiempo());
					this.itinerarioDelUsuarioActual.agregarAtraccion(atraccionAOfrecer);
				}
			}
		}
	}


	private void ofrecerAtraccionesAcordes() {
		ListIterator<Atraccion> iteradorDeListaDeAtracciones = atracciones.listIterator();
		while(iteradorDeListaDeAtracciones.hasNext()){
			Atraccion atraccionAOfrecer = iteradorDeListaDeAtracciones.next();
			if(esDeSuPreferencia(atraccionAOfrecer) && tienePresupuesto(atraccionAOfrecer) &&
					tieneTiempo(atraccionAOfrecer) && 
					hayCupo(atraccionAOfrecer) && !estaEnSuItinerario(atraccionAOfrecer)){
				System.out.println("Se Ofrece, acorde a sus preferencias, la siguiente atraccion : " + atraccionAOfrecer.getNombreDeLaAtraccion() 
						+ "con un costo de: " + atraccionAOfrecer.getCosto() + "y un tiempo necesario para completarla de: " + atraccionAOfrecer.getTiempo());
				System.out.println("por favor ingrese Si o No para confirmar o rechazar la promocion ofrecida");
				if(recibirRespuesta().equals("Si")){
					this.usuarioActual.disminuirPresupuesto(atraccionAOfrecer.getCosto());
					this.usuarioActual.disminuirTiempoDisponible(atraccionAOfrecer.getTiempo());
					this.itinerarioDelUsuarioActual.agregarAtraccion(atraccionAOfrecer);
				}
			}
		}
	}


	private void ofrecerElRestoDePromociones() {
		ListIterator<Promocion> iteradorDeListaDePromociones = promociones.listIterator();
		while(iteradorDeListaDePromociones.hasNext()){
			Promocion promocionAOfrecer = iteradorDeListaDePromociones.next();
			if(!esDeSuPreferenciaLaPromocion(promocionAOfrecer) && tienePresupuestoParaLaPromocion(promocionAOfrecer) &&
					tieneTiempoParaLaPromocion(promocionAOfrecer) && 
					hayCupoDeLasAtraccionesDeLaPromo(promocionAOfrecer) && !estaEnSuItinerario(promocionAOfrecer)){
				System.out.println("Se Ofrece una promocion con las siguientes Atracciones" + promocionAOfrecer.getNombreDeLasAtraccionesAsociadas() 
						+ "con un costo total de: " + promocionAOfrecer.getCostoTotal() + "y un tiempo necesario para completarlas de: " + promocionAOfrecer.getTiempoTotal());
				System.out.println("por favor ingrese Si o No para confirmar o rechazar la promocion ofrecida");
				if(recibirRespuesta().equals("Si")){
					this.usuarioActual.disminuirPresupuesto(promocionAOfrecer.getCostoTotal());
					this.usuarioActual.disminuirTiempoDisponible(promocionAOfrecer.getTiempoTotal());
					this.itinerarioDelUsuarioActual.agregarPromocion(promocionAOfrecer);
				}
			}
		}
	}


	private void ofrecerPromocionesAcordes() {
		ListIterator<Promocion> iteradorDeListaDePromociones = promociones.listIterator();
		while(iteradorDeListaDePromociones.hasNext()){
			Promocion promocionAOfrecer = iteradorDeListaDePromociones.next();
			if(esDeSuPreferenciaLaPromocion(promocionAOfrecer) && tienePresupuestoParaLaPromocion( promocionAOfrecer) &&
					tieneTiempoParaLaPromocion(promocionAOfrecer) && 
					hayCupoDeLasAtraccionesDeLaPromo(promocionAOfrecer) && !estaEnSuItinerario(promocionAOfrecer)){
				System.out.println("Se Ofrece una promocion acorde a  sus preferencias con las siguientes Atracciones" + promocionAOfrecer.getNombreDeLasAtraccionesAsociadas() 
						+ "con un costo total de: " + promocionAOfrecer.getCostoTotal() + "y un tiempo necesario para completarlas de: " + promocionAOfrecer.getTiempoTotal());
				System.out.println("por favor ingrese Si o No para confirmar o rechazar la promocion ofrecida");
				if(recibirRespuesta().equals("Si")){
					this.usuarioActual.disminuirPresupuesto(promocionAOfrecer.getCostoTotal());
					this.usuarioActual.disminuirTiempoDisponible(promocionAOfrecer.getTiempoTotal());
					this.itinerarioDelUsuarioActual.agregarPromocion(promocionAOfrecer);
				}
			}
		}
	}
	private String recibirRespuesta() {
		String respuesta = "";
		BufferedReader ingresoDelUsuario = new BufferedReader(new InputStreamReader (System.in));
		try {
			respuesta = ingresoDelUsuario.readLine();
			if(respuesta.equals("Si") || respuesta.equals("No") )
				return respuesta;
			else{
				System.out.println(" ingreso invalido, por favor ingrese Si para aceptar o No para rechazar");
				recibirRespuesta();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "No se ingreso nada";
	}


	private boolean esDeSuPreferenciaLaPromocion(Promocion promocionAOfrecer) {
		if(this.usuarioActual.getPreferencia().equals(promocionAOfrecer.getTipoDeLasAtracciones()))
			return true;
		return false;
	}


	private void siguienteUsuario(){
		this.usuarioActual = this.iteradorDeListaDeUsuarios.next();
		this.itinerarioDelUsuarioActual = this.usuarioActual.getItinerario();
	}

	private boolean tieneTiempoParaLaPromocion(Promocion promocionAOfrecer){
		if(this.usuarioActual.getTiempo() >= promocionAOfrecer.getTiempoTotal())
			return true;
		return false;
	}

	private boolean tienePresupuestoParaLaPromocion(Promocion promocionAOfrecer){
		if(this.usuarioActual.getPresupuesto() >= promocionAOfrecer.getCostoTotal())
			return true;
		return false;
	}
	private boolean esDeSuPreferencia(Atraccion atraccion){
		if(this.usuarioActual.getPreferencia().equals(atraccion.getTipoDeAtraccion()))
			return true;
		return false;
	}

	private boolean tienePresupuesto(Atraccion atraccion){
		if(this.usuarioActual.getPresupuesto() >= atraccion.getCosto())
			return true;
		return false;
	}

	private boolean tieneTiempo(Atraccion atraccion){
		if(this.usuarioActual.getTiempo() >= atraccion.getTiempo())
			return true;
		return false;
	}

	private boolean hayCupo(Atraccion atraccion){
		String nombreDeLaAtraccion = atraccion.getNombreDeLaAtraccion();
		ListIterator<Atraccion> iteradorDeLaListaDeAtracciones = atracciones.listIterator();
		while(iteradorDeLaListaDeAtracciones.hasNext()){
			Atraccion atraccionActual = iteradorDeLaListaDeAtracciones.next();
			if(nombreDeLaAtraccion.equals(atraccionActual.getNombreDeLaAtraccion()) && atraccionActual.getCupo()>0)
				return true;
		}
		return false;
	}
	private boolean estaEnSuItinerario(Atraccion atraccion){
		String nombreDeLaAtraccion = atraccion.getNombreDeLaAtraccion();
		ArrayList<Atraccion> listaDeAtraccionesDelUsuarioActual = this.itinerarioDelUsuarioActual.getAtraccionesDelUsuario();
		ListIterator<Atraccion> iteradorDeLaListaDeAtraccionesDelUsuarioActual = listaDeAtraccionesDelUsuarioActual.listIterator();
		while(iteradorDeLaListaDeAtraccionesDelUsuarioActual.hasNext()){
			Atraccion atraccionActual = iteradorDeLaListaDeAtraccionesDelUsuarioActual.next();
			if(nombreDeLaAtraccion.equals((atraccionActual.getNombreDeLaAtraccion())))
				return true;
		}
		return false;
	}

	private boolean estaEnSuItinerario(Promocion promocionAOfrecer) {
		String nombresDeLasAtracciones = promocionAOfrecer.getNombreDeLasAtraccionesAsociadas();
		String[] nombresDeCadaAtraccion = nombresDeLasAtracciones.split(", ");
		ArrayList<Atraccion> listaDeAtraccionesDelUsuarioActual = this.itinerarioDelUsuarioActual.getAtraccionesDelUsuario();
		ListIterator<Atraccion> iteradorDeLaListaDeAtraccionesDelUsuarioActual = listaDeAtraccionesDelUsuarioActual.listIterator();
		while(iteradorDeLaListaDeAtraccionesDelUsuarioActual.hasNext()){
			for(int i = 0; i< nombresDeCadaAtraccion.length; i++){
				Atraccion atraccionActual = iteradorDeLaListaDeAtraccionesDelUsuarioActual.next();
				if(nombresDeCadaAtraccion[i].equals((atraccionActual.getNombreDeLaAtraccion()))){
					return true;
				}
			}
		}
		return false;
	}


	private boolean hayCupoDeLasAtraccionesDeLaPromo(Promocion promocion){
		String nombresDeLasAtracciones = promocion.getNombreDeLasAtraccionesAsociadas();
		String[] nombresDeCadaAtraccion = nombresDeLasAtracciones.split(", ");
		ListIterator<Atraccion> iteradorDeLaListaDeAtracciones = atracciones.listIterator();
		while(iteradorDeLaListaDeAtracciones.hasNext()){
			for(int i = 0; i< nombresDeCadaAtraccion.length; i++){
				Atraccion atraccion = iteradorDeLaListaDeAtracciones.next();
				if(nombresDeCadaAtraccion[i].equals(atraccion.getNombreDeLaAtraccion()) && atraccion.getCupo()>0){
					return true;
				}
			}
		}
		return false;
	}
}