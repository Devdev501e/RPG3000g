package projetrpg3000;
public  class CC_7567 extends Enemy {
    public CC_7567(int Bvie , int Bresistance, int Bdegats){
        this.Bvie=Bvie;
        this.Bresistance=Bresistance;
        this.Bdegats=Bdegats;
    }

    @Override
    public void amélioration() {

    }

    @Override
    public int attaque1() {

        return 0;
    }

    @Override
    public String stat1() {
        return "Enemies"+"\nVIE = "+Bvie+"\nRessistance = "+Bresistance+"\nDégats"+Bdegats;
    }


}
