package projetrpg3000;

public abstract class Item  {
    private Hero H;
    int BItem;
    String nom;

    public abstract int effect();
    public void setname(String nom){
        this.nom=nom;

    }
    public int getBitem(){
        return this.BItem;}
    public String getItemNom(){
        return this.nom;}

    private static final Weapon épée=new Weapon(12,"épée");
    private static final Weapon arc=new Weapon(9,"arc");
    public static Item Createépée(){return épée;}
    public static Item Createarc(){return arc;}
    private static final Food Lembas=new Food(12,"Lembas",0);
    public static Consumable creatLembas(){return Lembas;}
    private static final Potion potion=new Potion(45,10,"Potion",0);
    public static Consumable creatpotion(){return potion;}



}

