package projetrpg3000;
public  class CC_7567 extends Enemy {
    public CC_7567(int Bvie , int Bresistance, int Bdegats){
        this.Bvie=Bvie;
        this.Bresistance=Bresistance;
        this.bDegats=Bdegats;
    }





    @Override
    public String stat1() {
        return "Enemies"+"\nVIE = "+Bvie+"/"+maxPointsddevie+"\nRessistance = "+Bresistance+"/"+maxRessistance+"\nDégats = "+bDegats;
    }


}
