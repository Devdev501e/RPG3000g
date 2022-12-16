package projetrpg3000;

public class Food extends Consumable{

    public Food (int nouriture, String nom,int nombre){
        this.BItem=nouriture;
        this.nom= nom;
        this.nombre=nombre;

    }
    @Override
    public int effect(){

        return this.BItem;}


}

