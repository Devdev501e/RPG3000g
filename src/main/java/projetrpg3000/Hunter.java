package projetrpg3000;


public class Hunter extends Hero{
    int Flèche;
    public Hunter ( int Bvie, int Bressistance, int Flèche,int Bdegats, String nom,boolean h) {

        this.Bvie=Bvie;
        this.Bresistance=Bressistance;
        this.Bdegats=Bdegats;
        this.Flèche=Flèche;
        this.Nom=nom;
        this.h=h;
    }






    @Override
    public int attaque1() {
        Item weapon = Item.Createarc();

        if (this.Flèche-1>=0){
            this.Flèche-=1;
            System.out.println("Vous avez utiliser votre " +weapon.getItemNom());
            return weapon.getBitem()+this.Bdegats;

        }else{

            return 0;}
    }
    public void amélioration(){
        this.Flèche+=4;
    }
    @Override
    public String stat1() {
        return Nom+"\n(Hunter)"+"\nVIE = "+Bvie+"\nResistance = "+Bresistance+"\nDégâts = "+Bdegats+"\nNombre de flèche = "+Flèche;
    }

}
