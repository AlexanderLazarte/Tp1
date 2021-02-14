import java.util.ArrayList;


public class Fijo extends Promocion {

	private int descuentoFijo;
	
	Fijo(Atraccion atraccionAsociada1, Atraccion atraccionAsociada2, int descuentoFijo){
		this.atraccionesAsociadas = new ArrayList<Atraccion>();
		atraccionesAsociadas.add(atraccionAsociada1);
		atraccionesAsociadas.add(atraccionAsociada2);
		this.descuentoFijo = descuentoFijo;
		this.tipoDeLaPromocion = "Fijo";
		if(atraccionAsociada1.getTipoDeAtraccion() == atraccionAsociada2.getTipoDeAtraccion()){
			this.tipoDeLasAtracciones = atraccionAsociada1.getTipoDeAtraccion();
		} else{
			throw new Error ("promocion no se puede crear ya que deben ser del mismo tipo");
		}
		this.tiempoTotal = (atraccionAsociada1.getTiempo() + atraccionAsociada2.getTiempo()); 
		this.costoTotal = (atraccionAsociada1.getCosto() + atraccionAsociada2.getCosto()) - this.descuentoFijo;
	}
}
