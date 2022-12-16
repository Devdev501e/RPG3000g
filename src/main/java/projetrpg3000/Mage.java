package projetrpg3000;

public class Mage extends SpellCaster {

    public Mage ( int Bvie, int Bressistance, int Bdegats, int Bprixmana, int Bmagie,String Nom,boolean h) {

        this.Bvie=Bvie;
        this.Bresistance=Bressistance;
        this.bDegats=Bdegats;
        this.Bprixmana=Bprixmana;
        this.Bmagie=Bmagie;
        this.Nom=Nom;
        this.h=h;}

    public void attaque0(){

    }
    @Override
    public int attaque1(){
        if (Bmagie-Bmagie >=0 ){
            this.Bmagie-=Bprixmana;
            System.out.println("Votre barre de magie a dimunuer");
            return this.bDegats;}
        else{
            return 0;}
    }



    @Override
    public String stat1() {
        return Nom+"\n(Mage)"+"\nVIE = "+Bvie+"/"+maxPointsddevie+"\nResistance = "+Bresistance+"/"+maxRessistance+"\nDégâts"+bDegats+"\nBarre de magie"+bDegats;
    }

}

