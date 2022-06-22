package de.emreil.jurassicpark.dinosaurier;

public class Dino {

    // Attribute
    protected int lebenspunkte;
    protected int angrifsstaerke;
    protected int aktuellLeben;
    protected int aktuellAngriff;


    // Konstruktoren
    public Dino(){}
    public Dino(int lebenspunkte, int angrifsstaerke){
        this.lebenspunkte=lebenspunkte;
        this.angrifsstaerke=angrifsstaerke;
    }

    // Methoden
    public int getLebenspunkte(){
        return this.lebenspunkte;
    }
    public void setLebenspunkte(int lebenspunkte){
        this.lebenspunkte=lebenspunkte;
    }
    public int getAngrifsstaerke(){
        return this.angrifsstaerke;
    }
    public void setAngrifsstaerke(int angrifsstaerke){
        this.angrifsstaerke=angrifsstaerke;
    }
    public int getAktuellLeben(){ return this.aktuellLeben;}
    public void setAktuellLeben(int aktuellLeben){ this.aktuellLeben = aktuellLeben;}
    public int getAktuellAngriff(){return this.aktuellAngriff;}
    public void setAktuellAngrif(int aktuellAngriff){this.aktuellAngriff=aktuellAngriff;}

    // +4 Leben hinzufügen
    public void schlafen(){
        if((this.aktuellLeben +5)>this.lebenspunkte){
            this.aktuellLeben=this.lebenspunkte;
            System.out.println("Leben +5");
        }else{
            this.aktuellLeben += 5;
            System.out.println("Leben +5");
        }
    }//Ende of Schlafen

    // +2 Angriff
    public void essen(){
    this.aktuellAngriff +=2;
        if(this.aktuellAngriff>=20){
            this.aktuellAngriff=20;
        }
        System.out.println("Angriff +2");
    } // End of Essen

}// End of class
