package projetrpg3000;

public class Warrior extends Hero{
    public Warrior (int Bvie, int Bressistance,int Bdegats, String Nom,Boolean h) {

        this.Bvie=Bvie;
        this.Bresistance=Bressistance;
        this.Nom=Nom;
        this.Bdegats=Bdegats;
        this.h=h;


        ;}

    @Override
    public int attaque1(){
        Item arc = Item.Createarc();
        System.out.println("Vous avez utiliser " +arc.getItemNom());
        return arc.getBitem()+Bdegats;

    }
    @Override
    public String stat1() {
        return Nom+"\n(Warrior)"+"\nVIE = "+Bvie+"\nResistance = "+Bresistance+"\nDégâts = "+Bdegats;
    }
    public void amélioration(){

    }

}
