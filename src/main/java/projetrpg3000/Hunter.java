package projetrpg3000;


public class Hunter extends Hero{
    int Flèche;
    public Hunter ( int Bvie, int Bressistance, int Flèche,int Bdegats, String nom,boolean h) {

        this.Bvie=Bvie;
        this.Bresistance=Bressistance;
        this.bDegats=Bdegats;
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
            return weapon.getBitem()+this.bDegats;

        }else{

            return 0;}
    }

    @Override
    public String defendre() {
            this.Bresistance = Math.min(this.Bresistance + 5, maxRessistance);
            this.Flèche+=3;
        System.out.println("Vous avez augmenter votre barre de resistance 7 \n et vous avez trouver une flèche");
            return "Votre barre de resistance a augmenter de +7\net vous avez trouver une flèche";


    }

    public void amélioration(){
        this.Flèche+=4;
    }
    @Override
    public String stat1() {
        return Nom+"\n(Hunter)"+"\nVIE = "+Bvie+"/"+maxPointsddevie+"\nResistance = "+Bresistance+"/"+maxRessistance+"\nDégâts = "+bDegats+"\nNombre de flèche = "+Flèche+"\n Arc";
    }

}
