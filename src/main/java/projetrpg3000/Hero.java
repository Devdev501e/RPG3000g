package projetrpg3000;

public abstract class Hero extends Combatant {
    private Item I;

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
    public abstract int attaque1();
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

    public abstract String defendre();


    public abstract void amélioration();
    public void setFalsebolean() {
        this.h=false;
    }
    public void setruebolean() {
        this.h=true;
    }
    public void ressistanceam() {
        this.Bresistance = Math.min(this.Bresistance + 7, maxRessistance);
    }

    public void degatsAm() {
        this.bDegats = Math.min(this.bDegats + 15, maxRessistance);
    }
}
