package projetrpg3000;

public  abstract class SpellCaster extends Hero {
    int Bmagie;
    int Bprixmana ;

    int magieMax=50;

    public void amélioration(){
        this.Bprixmana-=2;
        System.out.println("Votre cout de magie c'est réduit");
    }

    @Override
    public String defendre() {

        this.Bresistance = Math.min(this.Bresistance + 5, maxRessistance);
        this.Bmagie=Math.min(this.Bmagie + 5,magieMax);
        System.out.println("Vous avez augmenter votre barre de resistance 5 et votre barre de magie de 5 ");
        return "Votre resistance a augmenter de +5\n et votre barre de magie de 5 ";

    }

}

