package projetrpg3000;

public class Warrior extends Hero{
    public Warrior (int Bvie, int Bressistance,int Bdegats, String Nom,Boolean h) {

        this.Bvie=Bvie;
        this.Bresistance=Bressistance;
        this.Nom=Nom;
        this.bDegats=Bdegats;
        this.h=h;


        ;}

    @Override
    public int attaque1(){
        Item arc = Item.Createarc();
        System.out.println("Vous avez utiliser " +arc.getItemNom());
        return arc.getBitem()+bDegats;

    }

    @Override
    public String defendre() {
        {
            this.Bresistance = Math.min(this.Bresistance + 5, maxRessistance);
            this.bDegats+=1;
            System.out.println("Vous avez augmenter votre barre de resistance 5 et votre dégats de 2");
            return " Votre  resistance a augmenter de +5\n et votre dégats de +1 ";
        }
    }

    @Override
    public String stat1() {
        return Nom+"\n(Warrior)"+"\nVIE = "+Bvie+"/"+maxPointsddevie+"\nResistance = "+Bresistance+"/"+maxRessistance+"\nDégâts = "+bDegats;
    }
    public void amélioration(){

    }

}
