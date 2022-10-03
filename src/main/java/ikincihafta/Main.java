package ikincihafta;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Hatchback hatchback=new Hatchback();
        System.out.println("kaç gün kiralanacak: ");
        int day=sc.nextInt();

        System.out.println("bireysel kulllanıcı sadece hatchback kiralayabilir. bireysel için 1 şirket için 2: ");
        int customer=sc.nextInt();
        hatchback.setDailyRentPrice(15);
        hatchback.setMonthlyRentPrice(10);
        if(customer==1) {
            System.out.println(hatchback.dailyRent(15));

        }
        else {
            SUV suv=new SUV();
            Sedan sedan=new Sedan();
            suv.setDailyRentPrice(15);
            suv.setMonthlyRentPrice(10);
            sedan.setDailyRentPrice(15);
            sedan.setMonthlyRentPrice(10);
            System.out.println("suv gunluk:" + suv.dailyRent(10));
            System.out.println(suv.monthlyRent(15));
        }

    }


}
