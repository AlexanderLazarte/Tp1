import java.util.ArrayList;
import java.util.ListIterator;


public abstract class Promocion {
	
	protected double costoTotal;
	protected String tipoDeLaPromocion;
	protected double tiempoTotal;
	protected TipoDeAtraccion tipoDeLasAtracciones;
	protected ArrayList<Atraccion> atraccionesAsociadas;

	public TipoDeAtraccion getTipoDeLasAtracciones() {
		return tipoDeLasAtracciones;
	}	
	
	public double getCostoTotal() {
		return costoTotal;
	}

	public double getTiempoTotal() {
		return tiempoTotal;
	}
	
	public String getTipoDeLaPromocion(){
		return tipoDeLaPromocion;
	}
	
	public ArrayList<Atraccion> getAtraccionesAsociadas() {
		return atraccionesAsociadas;
	}
	
	public String getNombreDeLasAtraccionesAsociadas(){
		String nombres = ": ";
		ListIterator<Atraccion> iteradorDeAtraccionesAsociadas = atraccionesAsociadas.listIterator();
		while(iteradorDeAtraccionesAsociadas.hasNext()){
			Atraccion atraccionAsociada = iteradorDeAtraccionesAsociadas.next();
			nombres += atraccionAsociada.getNombreDeLaAtraccion() + ", ";
		}
		return nombres;
	}
		
}
