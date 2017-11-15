package model.dec;

public enum Tarif{
	illimite("Tarif illimité"),
	illimite5("Tarif illimité 5"), 
	reduit("Tarif réduit"),
	reduit5("Tarif réduit 5");
      
	private String nom;	
      
	Tarif(String nom) {  
		 this.nom=nom;
    }  
	
	public String getNom(){
		return this.nom;
	}
}