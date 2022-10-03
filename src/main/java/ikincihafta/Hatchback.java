package ikincihafta;

public class Hatchback extends Car {


    @Override
    public int dailyRent(int day) {
        return day * super.getDailyRentPrice();
    }


}
