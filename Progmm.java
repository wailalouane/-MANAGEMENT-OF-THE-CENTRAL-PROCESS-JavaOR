public class Progmm {
    protected String nom;
    protected int duree;protected int arriv;protected int priority;
    public Progmm(String nom,int duree,int arriv){
        this.nom=nom;this.duree=duree;this.arriv=arriv;
    }
    public Progmm(String nom,int duree,int arriv,int priority){
        this.nom=nom;this.duree=duree;this.arriv=arriv;this.priority=priority;
    }
    void affiche(){
        System.out.print(nom);
    }



}
