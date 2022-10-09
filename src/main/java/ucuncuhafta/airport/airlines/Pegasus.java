package ucuncuhafta.airport.airlines;


import ucuncuhafta.airport.AirLines;
import ucuncuhafta.airport.interfaces.Calculate;

import java.util.HashMap;
import java.util.Map;


public class Pegasus extends AirLines implements Calculate {
    private int price=0;

    @Override
    public void setMeal(boolean meal) {

        if (isAbroad()) {
            super.setMeal(meal);
        }
        else {
            super.setMeal(false);
        }
    }

    @Override
    public void calculate(String seatName) {

        //ucus yurt disi ise yemek dahildir - ona gore bilet fiyati hesaplanmali
        if (isAbroad()) {
            price += 10000;
            if (getSeatTypeByKey(seatName).equals("BUSINESS"))  {
                price += 1000;
            }
            if (isMeal()) {
                price += 1000;

            }
        }


        price +=750;
        System.out.println("toplam bilet fiyatı " + price);
    }

    public Pegasus(int economicSeat,int businessSeat) {
        super(economicSeat,businessSeat);
        super.addOrEditBusinessSeat("B1",true);
        super.addOrEditBusinessSeat("B2",true);
    }


    public Pegasus() {
        super(25,0);
        super.addOrEditBusinessSeat("B1",true);
        super.addOrEditBusinessSeat("B2",true);

    }



}
