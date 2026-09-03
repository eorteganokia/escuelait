class Intervalo {
	private double inferior;
	private double superior;
	
	public Intervalo(double inferior, double superior){
		this.inferior = inferior;
		this.superior = superior;
	}
	public Intervalo(double superior){
		this.inferior = 0;
		this.superio = superior;
	}
	public Intervalo(Intervalo intervalo){
		this.inferior = intervalo.puntoMedio() - intervalo.longitud() / 2;
		this.superior = this.inferior + intervalo.longitud();
	}
	public Intervalo(){
		this.inferior = 0;
		this.superior = 0;
	}

	public Intervalo clone(){
		return new Intervalo(this.inferior, this.superior);
	}
	public double longitud(){
		return this.superior - this.inferior;
	}
	public double puntoMedio(){
		return this.inferior + this.longitud() / 2;
	}
	public void desplazar(double desplazamiento){
		this.inferior += desplazamiento;
		this.superior += desplazamiento;
	}
	public Intervalo desplazado(double desplazamiento){
		return new Intervalo(this.inferior + desplazamiento, this.superior + desplazamiento);
	}
	public boolean incluye(double valor){
		return this.inferior <= valor && this.superior >= valor;
	}
	public boolean incluye(Intervalo intervalo){
		return this.longitud() >= intervalo.longitud() && this.incluye(intervalo.puntoMedio());
	}
	public boolean equals(Intervalo intervalo){
		return this.inferior == intervalo.inferior && this.superior == intervalo.superior;
	}
	public Intervalo interseccion(Intervalo intervalo){
		assert this.intersecta(intervalo): "No existe interseccion con este intervalo.";
		double inferior = intervalo.puntoMedio() - intervalo.longitud() / 2;
		double superior = inferior + intervalo.longitud();
	    if(!this.incluye(inferior)){
			inferior = this.inferior;
		}
		if(!this.incluye(superior)){
			superior = this.superior;
		}
		return new Intervalo(inferior, superior);
	}
	public boolean intersecta(Intervalo intervalo){
		double inferior = intervalo.puntoMedio() - intervalo.longitud() / 2;
		double superior = inferior + intervalo.longitud();
		
		return this.incluye(inferior) || this.incluye(superior) || intervalo.incluye(this);
	}
	public void oponer(){
		double inferiorOpuesto = -this.superior;
		this.superior = -this.inferior;
		this.inferior = inferiorOpuesto;
	}
	public void doblar(){
		double incremento = this.longitud() / 2; 
		this.inferior -= incremento;
		this.superior += incremento;
	}
	public void recoger(){}
	public void mostrar(){
		double inferior = this.puntoMedio() - this.longitud() / 2;
		double superior = inferior + this.longitud();
		System.out.println("Intervalo(" + inferior + ", " + superior + ")");
	}
	public Intervalo[] trocear(int trozos){}
	
}
