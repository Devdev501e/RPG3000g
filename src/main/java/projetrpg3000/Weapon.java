package projetrpg3000;

public class Weapon extends Item {
    public Weapon(){}

    public Weapon(int BItem, String nom) {
        this.BItem = BItem;
        this.nom = nom;
    }

    @Override
    public int effect() {
        Weapon weapon = new Weapon(12, "épée");
        System.out.println("vous avez utilisez votre"+weapon.getItemNom());
        return weapon.BItem;
    }


}