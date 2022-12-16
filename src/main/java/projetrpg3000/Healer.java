package projetrpg3000;

public class Healer extends SpellCaster{


    public Healer ( int Bvie, int Bressistance, int Bdegats, int Bprixmana, int Bmagie,String Nom,boolean h) {

        this.Bvie=Bvie;
        this.Bresistance=Bressistance;
        this.Bdegats=Bdegats;
        this.Bprixmana=Bprixmana;
        this.Bmagie=Bmagie;
        this.Nom=Nom;
        this.h=h;
    }


    @Override
    public int attaque1(){
        if (Bmagie-Bprixmana >=0 ){
            return this.Bdegats;

        }else{ return 0;}
    }

    @Override
    public String stat1() {
        return Nom+"\n(Healer)"+"\nVIE = "+Bvie+"\nResistance = "+Bresistance+"\nDégâts = "+Bdegats+"\nBarre de magie = "+Bmagie;
    }
}
