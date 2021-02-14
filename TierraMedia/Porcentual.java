import java.util.ArrayList;


public class Porcentual extends Promocion {
	
	Porcentual(Atraccion atraccionAsociada1, Atraccion atraccionAsociada2, double descuentoPorcentual){
		this.atraccionesAsociadas = new ArrayList<Atraccion>();
		atraccionesAsociadas.add(atraccionAsociada1);
		atraccionesAsociadas.add(atraccionAsociada2);
		this.tipoDeLaPromocion = "Porcentual";
		if(atraccionAsociada1.getTipoDeAtraccion() == atraccionAsociada2.getTipoDeAtraccion()){
			this.tipoDeLasAtracciones = atraccionAsociada1.getTipoDeAtraccion();
		}else{
			throw new Error ("promocion no se puede crear ya que deben ser del mismo tipo");
		}
		this.costoTotal = (atraccionAsociada1.getCosto() + atraccionAsociada2.getCosto()) * descuentoPorcentual;
		this.tiempoTotal = (atraccionAsociada1.getTiempo() + atraccionAsociada2.getTiempo());
	}
	
}
