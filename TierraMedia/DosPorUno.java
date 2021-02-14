import java.util.ArrayList;


public class DosPorUno extends Promocion {
	
	DosPorUno(Atraccion atraccionAsociada1, Atraccion atraccionAsociada2, Atraccion atraccionGratis){
		this.atraccionesAsociadas = new ArrayList<Atraccion>();
		atraccionesAsociadas.add(atraccionAsociada1);
		atraccionesAsociadas.add(atraccionAsociada2);
		atraccionesAsociadas.add(atraccionGratis);
		this.tipoDeLaPromocion = "DosPorUno";
		if((atraccionAsociada1.getTipoDeAtraccion() == atraccionAsociada2.getTipoDeAtraccion()) && 
				atraccionAsociada2.getTipoDeAtraccion() == atraccionGratis.getTipoDeAtraccion()){
			this.tipoDeLasAtracciones = atraccionAsociada1.getTipoDeAtraccion();
		}else{
			throw new Error ("promocion no se puede crear ya que deben ser del mismo tipo");
		}
		this.costoTotal = atraccionAsociada1.getCosto()+atraccionAsociada2.getCosto();
		this.tiempoTotal = atraccionAsociada1.getTiempo()+atraccionAsociada2.getTiempo() + atraccionGratis.getTiempo();
	}
}
