package ucuncuhafta.airport.airlines;

import ucuncuhafta.airport.AirLines;
import ucuncuhafta.airport.interfaces.Calculate;

public class THY extends AirLines implements Calculate {
    private int price=0;


    @Override
    public void calculate(String seatName) {
        if (isAbroad()) {
            price += 1000;
        }
        if (isMeal()) {
            price += 1000;
        }
        if (getSeatTypeByKey(seatName).equals("BUSINESS")) {
            price += 1000;
        }
        price += 750;
        System.out.println("bilet fiyati " + price);

        }

        public THY() {
        super(25,2);
            super.addOrEditBusinessSeat("B1",true);
            super.addOrEditBusinessSeat("B2",true);
        }
        public THY(int economicSeat,int businessSeat) {
        super(economicSeat, businessSeat);
            super.addOrEditBusinessSeat("B1",true);
            super.addOrEditBusinessSeat("B2",true);
        }

    }

