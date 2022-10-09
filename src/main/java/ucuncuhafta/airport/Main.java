package ucuncuhafta.airport;

import ucuncuhafta.airport.airlines.Pegasus;
import ucuncuhafta.airport.airlines.THY;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static Pegasus pegasus = new Pegasus(10,0);
    public static THY thy=new THY(25,0);
    public static void create() {


        //pegasus yurticin yemek yok

        //yurtici yemek true olsa bile arka tarafta false olacaktir

        pegasus.setMeal(true);
        pegasus.addFlying("elazig","istanbul",23,10,22,17,"pegasus");
        pegasus.setAbroad(false);
        Map<String,String> business=new HashMap<>();
        Map<String,String> economic=new HashMap<>();
        business.put("B1","BUSINESS");
        economic.put("A1","ECONOMIC");
        pegasus.setSeatType(business);
        pegasus.setSeatType(economic);




        thy.setMeal(true);
        thy.setAbroad(true);
        thy.addFlying("istanbul","elazig",23,10,22,18,"thy");




    }
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("nerden? ");
        String nerden=scanner.nextLine();
        System.out.println("nereye? ");
        String nereye=scanner.nextLine();
        System.out.println("hangi gun 1-30 arasi? ");
        int gun=scanner.nextInt();
        System.out.println("hangi ay 1-12 arasi? ");
        int ay=scanner.nextInt();
        System.out.println("hangi yil - yilin son iki rakami 2022 icin 22 ya da 2023 icin 23 yazin? ");
        int yil=scanner.nextInt();
        System.out.println("hangi saat 0-23 arasi? ");
        int saat=scanner.nextInt();

        System.out.println("hangi havayolu thy icin 1 pegasus icin 2? ");
        int havaYolu=scanner.nextInt();

        if (havaYolu == 1) {


        }
        else {


        }




    }
}
