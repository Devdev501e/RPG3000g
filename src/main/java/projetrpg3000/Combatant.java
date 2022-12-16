package projetrpg3000;

public abstract class Combatant {
    int Bvie;
    boolean h;
    int maxPointsddevie = 150;
    int maxRessistance = 50;

    int Bresistance;
    int Bdegats;
    String Nom;


    public Combatant() {
    }

    public boolean moinvie(int degats, int resistance) {
        if (degats > 0 && resistance < degats) {
            this.Bvie -= (degats - resistance);
            return true;
        } else if ( resistance > degats && degats>0){
            this.Bvie-=2;
            return true;
        }
        else {
            System.out.println("Vous ne pouvez pas attaquer1");
            return false;
        }
    }


    public abstract void amélioration();

    public abstract int attaque1();

    public boolean soigner(int attaque1) {
        if (Bvie < maxPointsddevie) {
            this.Bvie = Math.min(this.Bvie + attaque1,
                    maxPointsddevie);
            return true;
        } else {
            System.out.println("la vie de cette hero est deja a fond");
            return false;
        }


    }

    public void ressistanceam() {
        this.Bresistance = Math.min(this.Bresistance + 7, maxRessistance);
    }

    public void Degatsam() {
        this.Bdegats = Math.min(this.Bdegats + 50, maxRessistance);
    }

    public int getVie() {
        return this.Bvie;
    }

    public int getRessistance() {
        return this.Bresistance;
    }

    public int getdegats() {
        return this.Bdegats;
    }

    public String getNom() {
        return this.Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setFalsebolean() {
        this.h = false;
    }

    public void setruebolean() {
        this.h = true;
    }

    public boolean getbolean() {
        return this.h;
    }

    public boolean nourriture(Item n) {
        if (Bvie < maxPointsddevie) {

            this.Bvie += Math.min(this.Bvie + n.getBitem(),
                    maxPointsddevie);
            System.out.println("Vous avez manger un" + n.getItemNom() + "votre vie a augmenter de " + n.getBitem());
            return true;
        } else {
            System.out.println("votre barre de vie est deja a fond");
            return false;
        }
    }

    public boolean potion(Consumable n) {
        if (Bvie < maxPointsddevie) {
            this.Bvie = Math.min(this.Bvie + n.getBitem(),
                    maxPointsddevie);
            if (Bresistance > n.getPV()) {
                this.Bresistance -= n.getPV();
                System.out.println("Votre de vie a augmenter de " + n.getBitem() + "Mais vous avez perdu une ressistance de " + n.getPV());
                return true;
            } else {
                int po = this.Bresistance - 1;
                this.Bresistance -= Bresistance - 1;
                System.out.println("Votre de vie a augmenter de " + n.getBitem() + "Mais vous avez perdu une ressistance de " + po);
                return true;
            }
        } else {
            System.out.println("Vous ne pouvez pas utiliser de " + n.getItemNom());
            return false;
        }

    }

    public void defendre() {
        this.Bresistance = Math.min(this.Bresistance + 3, maxRessistance);
        System.out.println("Vous avez augmenter votre barre de resistance7 ");
    }

    public abstract String stat1();




}
