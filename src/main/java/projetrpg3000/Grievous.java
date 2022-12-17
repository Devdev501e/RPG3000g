package projetrpg3000;

public class Grievous extends Enemy{


    Boolean set;
    int observer;

    public Grievous (int Bvie,int Bressistance, int Bdegats ,String Nom,int Observer,Boolean set){
        this.Bvie=Bvie;
        this.Bresistance=Bressistance;
        this.bDegats=Bdegats;
        this.Nom=Nom;
        this.set=set;
        this.observer=Observer;
    }


    @Override
    public String stat1() {

        return this.Nom+"\nVIE = "+this.Bvie+"\nResistance = "+this.Bresistance;
    }




    public void Setobserver0(){
        this.observer=0;
    }
    public void Setobserver(){
        this.observer+=1;
    }
    public int getobserver(){
       return this.observer;
    }
}
