package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Sovellus {

    private static IntJoukko A, B, C;

    private static int lueLuku(String teksti, Scanner lukija) {
        System.out.print(teksti);
        return lukija.nextInt();
    }
    
    private static IntJoukko lueJoukko(String teksti, Scanner lukija) {
        System.out.print(teksti);
        
        while (true) {
            String luettu = lukija.nextLine();
            if (luettu.equalsIgnoreCase("A")) {
                return A;
            } else if (luettu.equalsIgnoreCase("B")) {
                return B;
            } else if (luettu.equalsIgnoreCase("C")) {
                return C;
            } else {
                System.out.println("Virheellinen joukko! " + luettu);
                System.out.println("Yritä uudelleen!");
            }
        }
    }

    private static void lisaa(Scanner lukija) {
        IntJoukko joukko;
        int luku;
        
        joukko = lueJoukko("Mihin joukkoon? ", lukija);
        luku = lueLuku("Mikä luku lisätään? ", lukija);
        joukko.lisaa(luku);
    }
    
    private static void operaatio(String operaatio, Scanner lukija) {
        IntJoukko eka, toka, tulos;
        
        eka = lueJoukko("1. joukko? ", lukija);
        toka = lueJoukko("2. joukko? ", lukija);
        
        switch (operaatio) {
            case "yhdiste":
                tulos = IntJoukko.yhdiste(eka, toka);
                break;
            case "leikkaus":
                tulos = IntJoukko.leikkaus(eka, toka);
                break;
            default:
                tulos = IntJoukko.erotus(eka, toka);
                break;
        }
        System.out.println("A " + operaatio + " B = " + tulos.toString());
    }
   
    private static void poista(Scanner lukija) {
        IntJoukko joukko;
        int luku;
        
        joukko = lueJoukko("Mistä joukosta? ", lukija);
        luku = lueLuku("Mikä luku poistetaan? ", lukija);
        joukko.poista(luku);
    }

    private static void kuuluu(Scanner lukija) {
        IntJoukko joukko;
        int luku;

        joukko = lueJoukko("Mihin joukkoon? ", lukija);
        luku = lueLuku("Mikä luku? ", lukija);
        
        boolean kuuluuko = joukko.kuuluu(luku);
        if (kuuluuko) {
            System.out.println(luku + " kuuluu joukkoon ");
        } else {
            System.out.println(luku + " ei kuulu joukkoon ");
        }
    }
    
    private static void tulostaOhjeet() {
        System.out.println("Tervetuloa joukkolaboratorioon!");
        System.out.println("Käytössäsi ovat joukot A, B ja C.");
        System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e), leikkaus(le) ja lopetus(quit)(q).");
        System.out.println("Joukon nimi komentona tarkoittaa pyyntöä tulostaa joukko.");
    }
    
    private static void tekstikayttoliittyma(Scanner lukija) {
        String luettu;
        
        while (true) {
            luettu = lukija.nextLine();
            if (luettu.equals("lisää") || luettu.equals("li")) {
                lisaa(lukija);
            } else if (luettu.equalsIgnoreCase("poista") || luettu.equalsIgnoreCase("p")) {
                poista(lukija);
            } else if (luettu.equalsIgnoreCase("kuuluu") || luettu.equalsIgnoreCase("k")) {
                kuuluu(lukija);
            } else if (luettu.equalsIgnoreCase("yhdiste") || luettu.equalsIgnoreCase("y")) {
                operaatio("yhdiste", lukija);
            } else if (luettu.equalsIgnoreCase("leikkaus") || luettu.equalsIgnoreCase("le")) {
                operaatio("leikkaus", lukija);
            } else if (luettu.equalsIgnoreCase("erotus") || luettu.equalsIgnoreCase("e")) {
                operaatio("erotus", lukija);
            } else if (luettu.equalsIgnoreCase("A")) {
                System.out.println(A);
            } else if (luettu.equalsIgnoreCase("B")) {
                System.out.println(B);
            } else if (luettu.equalsIgnoreCase("C")) {
                System.out.println(C);
            } else if (luettu.equalsIgnoreCase("lopeta") || luettu.equalsIgnoreCase("quit") || luettu.equalsIgnoreCase("q")) {
                System.out.println("Lopetetaan, moikka!");
                break;
            } else {
                System.out.println("Virheellinen komento! " + luettu);
            }
            System.out.println("Komennot ovat lisää(li), poista(p), kuuluu(k), yhdiste(y), erotus(e) ja leikkaus(le).");
        }
    }

    public static void main(String[] args) {
        A = new IntJoukko();
        B = new IntJoukko();
        C = new IntJoukko();
        Scanner lukija = new Scanner(System.in);
        
        tulostaOhjeet();
        tekstikayttoliittyma(lukija);
    }
}
