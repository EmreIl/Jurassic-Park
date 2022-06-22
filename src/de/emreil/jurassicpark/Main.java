package de.emreil.jurassicpark;

import de.emreil.jurassicpark.dinosaurier.Dino;
import de.emreil.jurassicpark.dinosaurier.Rex;
import de.emreil.jurassicpark.dinosaurier.Stego;
import de.emreil.jurassicpark.dinosaurier.Tri;

import java.util.*;

public class Main {

        // Scanner
        static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {


        // Dinos
        Dino stego = new Dino(35, 6);
        Dino tri = new Dino(31, 10);
        Dino rex = new Dino(28, 13);
        Dino kaempfer= new Dino();
        Dino gegner = new Dino();

        // Spiel Intro
        System.out.println(" ");
        System.out.println("WILLKOMMEN BEI JURASSIC PARK");
        System.out.println("press ENTER to countinue");
        String contine = input.nextLine();


        // Charakter erstellung
        System.out.println("");
        System.out.print("Spielername: ");
        String spielername= input.nextLine();
        System.out.println(" ");

        // Intro des Spieles (Einleitung)
        System.out.println(spielername +" du bist ein Überlebender eines schiefgegangenen Erkundungstrupp");
        System.out.println("Du musst es schaffen den Funkmask auf der anderen Seite der Insel zu erreichen");
        System.out.println("Vor dir sind drei Käfige mit jeweils einem Dino");
        System.out.println("Den Dino den du auswählst wird dich auf deiner Reise unterstützen und für dich Kämpfen");
        System.out.print("(Press ENTER)");
        contine = input.nextLine();
        System.out.println(" ");


        // Dino vorstellung und auswahl (\t steht für abstand)
        System.out.println("\t\t\t\tKäfig 1\t\t\tKäfig 2\t\t\tKäfig 3");
        System.out.println("\t\t\t\tStego\t\t\tTri\t\t\t\tRex");
        System.out.println("Lebenspunkte :  35\t\t\t\t31\t\t\t\t28");
        System.out.println("Angriffskraft:  6 \t\t\t\t10\t\t\t\t13");
        System.out.println(" ");


        // Auswahl abfrage
        System.out.println("Wähle den Käfig aus den du öffnen möchtest");
        System.out.print("> ");
        int zelle = input.nextInt();
        System.out.println(" ");


        // Auswahl eines Dinos
        while(zelle<1 ||zelle>3){
            System.out.println("Ungültige eingabe");
            System.out.println("Wähle den Käfig aus die du öffnen möchtest");
            System.out.print("> ");
            zelle = input.nextInt();
            System.out.println(" ");
        }
        if(zelle == 1){
            System.out.println("Du hast dich für Stego entschieden");
            contine = input.nextLine();
            kaempfer= new Stego(stego.getLebenspunkte(), stego.getAngrifsstaerke());
        }
        if(zelle == 2){
            System.out.println("Du hast dich für Tri entschieden");
            contine = input.nextLine();
            kaempfer= new Tri(tri.getLebenspunkte(), tri.getAngrifsstaerke());
        }
        if(zelle== 3){
            System.out.println("Du hast dich für Rex entschieden");
            contine = input.nextLine();
            kaempfer = new Rex(rex.getLebenspunkte(), rex.getAngrifsstaerke());
        }


        // Strand oder Mitte
        System.out.println(" ");
        System.out.println("Welche weg möchtest du gehen? ");
        System.out.println(" ");
        System.out.println("1 Strand");
        System.out.println("2 Durch die Mitte der Insel? ");


        // Strand oder Mitte antwort
        int strmitte;

        do {
            System.out.print("> ");
            strmitte = input.nextInt();
            if(strmitte==1){
                System.out.println(" ");
                System.out.println("Du läufst den Strand entlang");
                System.out.print("(Press ENTER)");
                contine = input.nextLine();
                contine = input.nextLine();
                break;
            }else if(strmitte==2){
                System.out.println(" ");
                System.out.println("Du läufst durch die Mitte der Insel entlang");
                System.out.print("(Press ENTER)");
                contine = input.nextLine();
                contine = input.nextLine();
                break;
            }
        }while(strmitte != 1 || strmitte !=2);



        System.out.println(" ");
        System.out.println("Du bist im jagdgebiet der Dinos du kannst auswählen ob du kämpfen oder dich anfreunden möchtest");
        System.out.print("(Press ENTER)");
        contine = input.nextLine();




        // Kampf

        for(int x = 1; x<4;x++) {

            gegner = gegnerauswahl(gegner); // Methode für den Gegnerauswahl wird aufgerufen
            System.out.print("> ");


            // Kämpfen oder Wegglaufen?
            int kampfverstecken;
            kampfverstecken = input.nextInt();
            System.out.println(" ");


            if (kampfverstecken==2) {
                System.out.println("Ihr seit Freunde");
                kaempfer.schlafen();
            } else if (kampfverstecken==1) {


                // Werte hinzufügen
                kaempfer.setAktuellAngrif(kaempfer.getAngrifsstaerke());
                kaempfer.setAktuellLeben(kaempfer.getLebenspunkte());

                gegner.setAktuellLeben(gegner.getLebenspunkte());
                gegner.setAktuellAngrif(gegner.getAngrifsstaerke());


                // KAMPF
                int i = 0;
                do {
                    i++;
                    System.out.println("Round " + i);
                    System.out.println(" ");
                    System.out.println("\t\t DU \t\t\tGegner");
                    System.out.println(" ");
                    System.out.print("Leben  : " + kaempfer.getAktuellLeben());
                    System.out.println("\t\t\t\t" + gegner.getAktuellLeben());
                    System.out.print("Angriff: " + kaempfer.getAktuellAngriff());
                    System.out.println("\t\t\t\t" + gegner.getAktuellAngriff());
                    System.out.println(" ");

                    System.out.print("Press Enter to fight");
                    String contine2;
                    if(i>1){
                        contine = input.nextLine();
                    }else{
                        contine2 = input.nextLine();
                        contine2 = input.nextLine();
                    }
                    System.out.println(" ");



                    int kaempferzufall = (int) ((Math.random()) * 20 + 1);
                    int kaempferRunde = kaempferzufall + kaempfer.getAktuellAngriff() + kaempfer.getAktuellLeben();

                    int gegnerzufall = (int) ((Math.random()) * 20 + 1);
                    int gegnerRunde = gegnerzufall + gegner.getAktuellLeben() + gegner.getAktuellAngriff();


                    System.out.println("\t\t\t\tGesamt");
                    System.out.println(" ");
                    System.out.println("Du    : " + "\t\t" + kaempferRunde);
                    System.out.println("Gegner: " + "\t\t" + gegnerRunde);

                    // Wenn ich gewinne
                    if (kaempferRunde > gegnerRunde) {
                        if (kaempfer.getAktuellLeben() > 50 || kaempfer.getAktuellLeben() + 2 > 50) {
                            kaempfer.setAktuellLeben(50);
                            System.out.println(" ");
                            System.out.println("GEWONNEN");
                        } else {
                            System.out.println(" ");
                            System.out.println("GEWONNEN   Leben: "+kaempfer.getAktuellLeben()+" + 2");
                            System.out.println(" ");
                            kaempfer.setAktuellLeben(kaempfer.getAktuellLeben() + 2);
                        }
                        gegner.setAktuellLeben(gegner.getAktuellLeben() - kaempfer.getAktuellAngriff());

                        // Kampf gewonnen oder Verloren
                        if (kaempfer.getAktuellLeben() < 0) {
                            System.out.println("Kampf VERLOREN");
                            break;
                        } else if (gegner.getAktuellLeben() < 0) {
                            System.out.println("Kampf GEWONNEN");
                            break;
                        }

                        System.out.print("(Press ENTER)");
                        String contine4 = input.nextLine();
                        System.out.println(" ");
                    }
                    // Wenn gegner gewinnt
                    else if (kaempferRunde < gegnerRunde) {
                        System.out.println(" ");
                        System.out.println("Verloren   Leben: "+kaempfer.getAktuellLeben()+" - " + gegner.getAktuellAngriff());
                        System.out.println(" ");
                        gegner.setAktuellLeben(gegner.getAktuellLeben() + 2);
                        kaempfer.setAktuellLeben(kaempfer.getAktuellLeben() - gegner.getAktuellAngriff());

                        // Kampf gewonnen oder Verloren
                        if (kaempfer.getAktuellLeben() < 0) {
                            System.out.println("Kampf VERLOREN");
                            break;
                        } else if (gegner.getAktuellLeben() < 0) {
                            System.out.println("Kampf GEWONNEN");
                            break;
                        }

                        System.out.print("(Press ENTER)");
                        String contine5 = input.nextLine();
                        System.out.println(" ");

                    }else{
                        System.out.println(" UNENTSCHIEDEN");
                        System.out.println(" ");
                    }

                    // Kampf gewonnen oder Verloren
                    if (kaempfer.getAktuellLeben() < 0) {
                        System.out.println("Kampf VERLOREN");
                        System.out.println(" ");
                        break;
                    } else if (gegner.getAktuellLeben() < 0) {
                        System.out.println("Kampf GEWONNEN");
                        System.out.println(" ");
                        break;
                    }

                    // Essen oder Schlafen oder wegrennen IM KAMPF
                    System.out.println("1. Essen    (+Angriff)(" +kaempfer.getAktuellAngriff()+")");
                    System.out.println("2. Schalfen (+Leben)(" +kaempfer.getAktuellLeben()+")");
                    System.out.println("3. Wegrennen");
                    System.out.print("> ");
                    int essSch = input.nextInt();
                    System.out.println(" ");
                    if (essSch == 1) {
                        kaempfer.essen();
                    } else if (essSch == 2) {
                        kaempfer.schlafen();
                    }else if(essSch==3){
                        System.out.println("Du bist entkommen");
                        break;
                    }
                    // Gegner Essen Schlafen ausführen
                    gegnerEssenSchlafen(gegner,gegner.getLebenspunkte(),gegner.getAktuellLeben());

                    System.out.print("Press ENTER");
                    String contine5 = input.nextLine();
                    contine5 = input.nextLine();
                    System.out.println(" ");

                } while (kaempfer.getAktuellLeben() > 0 || gegner.getAktuellLeben() > 0);

                // Nach jeden sieg sollen der Angriffswert und Lebenswert um 3 erhöt werden(wie ein Level up)
                if(kaempfer.getAktuellLeben()>0 && gegner.getAktuellLeben()<0){
                    System.out.println(" ");
                    System.out.println("Dein Angriffs- und Lebenswert werden um 3 erhöt");      // Leben und Angriff werden um 3 erhöt
                    System.out.println(" ");
                    kaempfer.setLebenspunkte(kaempfer.getLebenspunkte()+3);
                    kaempfer.setAngrifsstaerke(kaempfer.getAngrifsstaerke()+3);
                    System.out.println("Leben: "+kaempfer.getLebenspunkte() +"  Angriff: "+kaempfer.getAngrifsstaerke());
                    System.out.println("Press ENTER");
                    String contine6 = input.nextLine();
                    System.out.println(" ");
                }else if(kaempfer.getAktuellLeben()<0 && gegner.getAktuellLeben()>0){
                    System.out.println("GAME OVER");
                    break;
                }

                } // Ende von Kampferstecken

            if(x==3){
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("Du hast es geschafft");
                System.out.println(" ");
                System.out.println("Entwickler : Emre Can Il");

            }// End of Else if

        } // End von for
        // Ende von kämpfen




    }// End of Main

    static Dino gegnerauswahl(Dino gegner){

        // Zufallszahl für gegnerauswahl
        int gegnerfall = (int)((Math.random()) * 3 + 1);
        // Gegner für Kampf aktuelle werte geben
        if(gegnerfall==1){
            System.out.println(" ");
            System.out.println("Ein Stego steht vor dir!!!");
            System.out.println("1.Kämpfen  -   2.anfreunden");
            return gegner = new Stego(35, 6);
        }
        if(gegnerfall==2){
            System.out.println(" ");
            System.out.println("Ein Tri steht vor dir!!!");
            System.out.println("1.Kämpfen  -   2.anfreunden");
            return gegner = new Tri(31, 10);
        }
        if(gegnerfall==3) {
            System.out.println(" ");
            System.out.println("Ein Rex steht vor dir");
            System.out.println("1.Kämpfen  -   2.anfreunden");
            return gegner = new Rex(28, 13);
        }
        return new Dino();
    } // Ende von gegnerauswahl


    
    // Essen oder Schlafen rechnung Gegner
    static void gegnerEssenSchlafen(Dino gegner, int lebenspunkte, int aktuellLeben){

        double prozent = lebenspunkte * 0.50;
        if(aktuellLeben<prozent){
            System.out.print("Gegner: ");
            gegner.schlafen();
            System.out.println(" ");
        }else {
            System.out.print("Gegner: ");
            gegner.essen();
            System.out.println(" ");
        }
    } // Ende von gegnerEssenSchlafen


}// End of Class
