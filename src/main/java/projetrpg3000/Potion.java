package projetrpg3000;

public class Potion extends Consumable {
    public Potion(int Potion,int perte, String nom,int nombre){
        this.BItem=Potion;
        this.nom=nom;
        this.PV= perte;
        this.nombre=nombre;

    }


    @Override
    public int effect(){
        System.out.println("Vous avez augmenter votre Barre de mana ");
        return this.BItem;
    }
}
