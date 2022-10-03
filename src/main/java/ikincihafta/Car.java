package ikincihafta;

public class Car implements Rentable {
    private String color;
    private int dailyRentPrice;
    private int monthlyRentPrice;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDailyRentPrice() {
        return dailyRentPrice;
    }

    public void setDailyRentPrice(int dailyRentPrice) {
        this.dailyRentPrice = dailyRentPrice;
    }

    public int getMonthlyRentPrice() {
        return monthlyRentPrice;
    }

    public void setMonthlyRentPrice(int monthlyRentPrice) {
        this.monthlyRentPrice = monthlyRentPrice;
    }

    @Override
    public int dailyRent(int day) {
        return day * dailyRentPrice;
    }


}
