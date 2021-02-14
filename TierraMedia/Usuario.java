
public class Usuario {
	
	private String nombre;
	private double presupuesto;
	private double tiempo;
	private TipoDeAtraccion preferencia;
	private Itinerario itinerario;
	

	Usuario(String nombre, double presupuesto, double tiempo, TipoDeAtraccion preferencia){
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempo = tiempo;
		this.preferencia = preferencia;
		itinerario = new Itinerario(this);
	}
	
	public Double getPresupuesto() {
		return presupuesto;
	}
	
	public Itinerario getItinerario(){
		return itinerario;
	}


	public void disminuirPresupuesto(Double costeDeLaAtraccion) {
		if(this.presupuesto >= costeDeLaAtraccion)
			this.presupuesto -= costeDeLaAtraccion;
	}


	public double getTiempo() {
		return tiempo;
	}


	public void disminuirTiempoDisponible(double tiempoRequeridoDeLaAtraccion) {
		if(this.tiempo >= tiempoRequeridoDeLaAtraccion)
			this.tiempo -= tiempoRequeridoDeLaAtraccion;
	}
	public String getNombre() {
		return nombre;
	}

	public TipoDeAtraccion getPreferencia() {
		return preferencia;
	}
}
