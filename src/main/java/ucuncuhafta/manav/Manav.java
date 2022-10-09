package ucuncuhafta.manav;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Manav {




    //TURKCE


    public static void main(String[] args) {

        //elma,armut,kiraz
        Map<String,Integer> depo=new HashMap<>();
        depo.put("elma",25);
        depo.put("armut",25);
        depo.put("kiraz",25);

        Scanner sc=new Scanner(System.in);
        System.out.println("hangi urun alinacak? ");
        String urun=sc.nextLine();
        System.out.println("kac kilo alinacak? ");
        int kg=sc.nextInt();
        //Integer kg=Integer.valueOf(m);


        if (depo.containsKey(urun)) {
            if (depo.get(urun) < kg) {
                System.out.println("depodaki " + depo.get(urun) + " kg bulunuyor.daha fazla alamazsiniz");

            }
            depo.put(urun,depo.get(urun)-kg);

        }
        else {
            System.out.println("urun bulunmamaktadir.");
        }






    }

}
