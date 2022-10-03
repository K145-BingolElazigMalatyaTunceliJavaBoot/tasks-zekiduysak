package ikincihafta;

public class Sedan extends Car implements MonthlyRentable{
    private int katsayi;

    @Override
    public int monthlyRent(int day) {
        super.setDailyRentPrice(100);
        return super.getMonthlyRentPrice() * day * katsayi;
    }
    @Override
    public int dailyRent(int day) {
        return day * super.getDailyRentPrice() * katsayi;
    }




}
