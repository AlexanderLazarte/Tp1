


public class Atraccion {

	private double costo;
	private double tiempo;
	private int cupo;
	private TipoDeAtraccion tipoDeAtraccion;
	private String nombreDeLaAtraccion;

	Atraccion(String nombre,double costo,double tiempo, int cupo, TipoDeAtraccion tipo){
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipoDeAtraccion = tipo;
		this.nombreDeLaAtraccion = nombre;
		}

	public int getCupo() {
		return cupo;
	}
	

	public double getCosto() {
		return costo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public TipoDeAtraccion getTipoDeAtraccion() {
		return tipoDeAtraccion;
	}

	public String getNombreDeLaAtraccion() {
		return nombreDeLaAtraccion;	
	}
}
