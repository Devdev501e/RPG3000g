package projetrpg3000;

public abstract class Consumable extends Item{
    int PV;
    int nombre;

    public abstract int effect();

    public int getPV(){return this.PV;}
    public int getnombre(){return this.nombre;}
    public void Addnombre(){this.nombre+=2;}
    public void moinnombre(){this.nombre--;}




}
