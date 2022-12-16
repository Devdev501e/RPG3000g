package projetrpg3000;

public class Grievous extends Enemy{


    Boolean set;
    int observer;

    public Grievous (int Bvie,int Bressistance, int Bdegats ,String Nom,int Observer,Boolean set){
        this.Bvie=Bvie;
        this.Bresistance=Bressistance;
        this.Bdegats=Bdegats;
        this.Nom=Nom;
        this.set=set;
        this.observer=Observer;
    }
    @Override
    public void amélioration() {

    }

    @Override
    public String stat1() {
        return null;
    }

    @Override
    public int attaque1() {
        return 0;
    }


    public void Setobserver(){
        this.observer+=1;
    }
}
