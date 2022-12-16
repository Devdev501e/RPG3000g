package projetrpg3000;

public abstract class Combatant {
    int Bvie;
    boolean h;
    int maxPointsddevie = 100;
    int maxRessistance = 25;

    int Bresistance;
    int bDegats;
    String Nom;


 
    public boolean moinVie(int degats, int resistance) {
        if (degats > 0 && resistance < degats) {
            this.Bvie -= (degats - resistance);
            return true;
        } else if ( resistance > degats && degats>0){
            this.Bvie-=2;
            return true;
        }
        else {
            System.out.println("Vous ne pouvez pas attaquer1");
            return false;
        }
    }




 





    public int getVie() {
        return this.Bvie;
    }

    public int getRessistance() {
        return this.Bresistance;
    }

    public int getDegats() {
        return this.bDegats;
    }

    public String getNom() {
        return this.Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setFalsebolean() {
        this.h = false;
    }

    public void setruebolean() {
        this.h = true;
    }

    public boolean getbolean() {
        return this.h;
    }

   

    public abstract String stat1();




}
