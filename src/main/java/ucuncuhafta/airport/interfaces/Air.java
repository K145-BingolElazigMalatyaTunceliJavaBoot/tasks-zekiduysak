package ucuncuhafta.airport.interfaces;

public interface Air {
    void addOrEditNormalSeat(String seatName,boolean state);
    void addOrEditBusinessSeat(String seatName,boolean state);
    //nerden nereye
    void addFlying(String fromWhere, String whereTo,int day,int monthy,int year,int clck,String airLines);
    void finishFlying(String fromWhere, String whereTo,int day,int monthy,int year,int clck);
    //void buySeatByRotate(String seatName,String fromWhere, String whereTo,int day,int monthy,int year,int clck);
}
