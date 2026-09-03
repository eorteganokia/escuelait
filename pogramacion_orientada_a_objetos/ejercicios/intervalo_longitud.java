class Intervalo {
	private double longitud;
	private double puntoMedio;
	
	public Intervalo(double inferior, double superior){
		this.longitud = superior - inferior;
		this.puntoMedio = inferior + this.longitud / 2;
	}
	public Intervalo(double superior){
		this.longitud = superior;
		this.puntoMedio = this.longitud / 2;
	}
	public Intervalo(Intervalo intervalo){
		this.longitud = intervalo.longitud();
		this.puntoMedio = intervalo.puntoMedio();
	}
	public Intervalo(){
		this.longitud = 0;
		this.puntoMedio = 0;
	}

	public Intervalo clone(){
		double inferior = this.puntoMedio - this.longitud / 2;
		double superior = inferior + this.longitud;
		return new Intervalo(inferior, superior);
	}
	public double longitud(){
		return this.longitud;
	}
	public double puntoMedio(){
		return this.puntoMedio;
	}
	public void desplazar(double desplazamiento){
		this.puntoMedio += desplazamiento;
	}
	public Intervalo desplazado(double desplazamiento){
		double inferior = this.puntoMedio - this.longitud / 2 + desplazamiento;
		double superior = inferior + this.longitud;
		return new Intervalo(inferior, superior);
	}
	public boolean incluye(double valor){
		return Math.abs(valor - this.puntoMedio) * 2 <= this.longitud;
	}
	public boolean incluye(Intervalo intervalo){
		return this.longitud >= intervalo.longitud() && this.incluye(intervalo.puntoMedio());
	}
	public boolean equals(Intervalo intervalo){
		return this.longitud == intervalo.longitud && this.puntoMedio == intervalo.puntoMedio;
	}
	public Intervalo interseccion(Intervalo intervalo){
		assert this.intersecta(intervalo): "No existe interseccion con este intervalo.";
		double inferior = intervalo.puntoMedio() - intervalo.longitud() / 2;
		double superior = inferior + intervalo.longitud();
	    if(!this.incluye(inferior)){
			inferior = this.puntoMedio - this.longitud / 2;
		}
		if(!this.incluye(superior)){
			superior = this.puntoMedio + this.longitud / 2;
		}
		return new Intervalo(inferior, superior);
	}
	public boolean intersecta(Intervalo intervalo){
		double inferior = intervalo.puntoMedio() - intervalo.longitud() / 2;
		double superior = inferior + intervalo.longitud();
		
		return this.incluye(inferior) || this.incluye(superior) || intervalo.incluye(this);
	}
	public void oponer(){
		this.puntoMedio = -this.puntoMedio;
	}
	public void doblar(){
		this.longitud *= 2;
	}
	public void recoger(){
		// leer datos por consola para construir intervalo
	}
	public void mostrar(){
		double inferior = this.puntoMedio - this.longitud / 2;
		double superior = inferior + this.longitud;
		System.out.println("Intervalo(" + inferior + ", " + superior + ")");
	}
	public Intervalo[] trocear(int trozos){
		Intervalo[] intervalos = new Intervalo[trozos];
		double inferior = this.puntoMedio - this.longitud / 2;
		double longitudTrozo = this.longitud / trozos;
		for(int i = 0; i < trozos; i++){
			intervalos[i] = new Intervalo(inferior, inferior + longitudTrozo);
			inferior += longitudTrozo;
		}
		return intervalos;
	}
	


	public static void main(String[] args) {
		Intervalo intervalo = new Intervalo(10, 20);
        intervalo.mostrar();
		System.out.println("Incluye 19 = " + intervalo.incluye(19));
		
		int trozos = 4;
		System.out.println("Trozos " + trozos);
		Intervalo[] intervalos = intervalo.trocear(trozos);
		for(int i = 0; i < trozos; i++){
			intervalos[i].mostrar();
		}
		System.out.println("----------------------- ");
		Intervalo interseccion = intervalo.interseccion(new Intervalo(17, 19));
		interseccion.mostrar();
  	}

}
