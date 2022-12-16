package projetrpg3000;

public  abstract class SpellCaster extends Hero {
    int Bmagie;
    int Bprixmana;

    public void amélioration(){
        this.Bprixmana-=2;
        System.out.println("Votre cout de magie c'est réduit");
    }

    public void reducB(){
        this.Bmagie-=Bprixmana;
    }

    public void Vcoutmana(){
        this.Bprixmana-=1;
    }


}

