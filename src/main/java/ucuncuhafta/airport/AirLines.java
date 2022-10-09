package ucuncuhafta.airport;

import ucuncuhafta.airport.interfaces.Air;


import java.awt.image.ImageProducer;
import java.util.HashMap;
import java.util.Map;




public class AirLines implements Air {


    //koltuklar ->
    // key-> koltuk ismi A1,B1
    //value -> true false -> dolu bos
    Map<String,Boolean> seat = new HashMap<>();
    //koltuk tipi -> business ve ekonomik gibi
    //key -> koltuk ismi
    //value -> koltuk tipi - BUSINESS ve ECONOMIC
    Map<String,String> seatType=new HashMap<>();

    //seat ve seatType icin key ayni olmalidir



    //rota - yeni ucus
    //nerden nereye
    //key kismi sehir + tarih(gunayyil - yil son iki rakami) + nereye + ucus saati + havayolu olmalidir
    //elazig icin 23.gun 10.ay 2022 yili saat 17  ucusu icin elazig231022istanbul17thy gibi
    //rotation.put("elazig231022istanbul17thy","istanbul");
    Map<String,String> rotation = new HashMap<>();
    //ucus icin bilet alinabilir mi alinamaz mi
    //rota durumunu kaydetmek icin
    //rotatin.put("elazig231022istanbul17thy","istanbul");
    //rotationState.put("elazig231022istanbul17thy",true); -> true olursa bilet alinabilir false olursa bilet alinamaz
    Map<String,Boolean> rotationState=new HashMap<>();
    //yurtdisi
    boolean isAbroad;


    //yemek var mi
    boolean isMeal;
    public AirLines() { }

    public AirLines(int economic,int business) {
        //koltuk olusturma islemi
        //varsayilan olarak 25 tane normal/economic koltuk olusturuldu
        //business koltuk olusturmak icin flight sinifindaki metotlar kullanilabilir
        Map<String,Boolean> map=new HashMap<>();
        Map<String,String> temp=new HashMap<>();

        for ( int i=1;i<=economic;i++) {
            String s="A" + i;
            map.put(s,true);
            temp.put(s,"ECONOMIC");
            this.setSeat(map);
            this.setSeatType(temp);
        }
        if(business>=1) {
            for(int i=1;i<business;i++) {
                String s="A" + i;
                map.put(s,true);
                temp.put(s,"BUSINESS");
                this.setSeat(map);
                this.setSeatType(temp);
            }
        }

    }


    public Map<String, String> getRotation() {
        return rotation;
    }

    public void setRotation(Map<String, String> rotation) {
        this.rotation = rotation;
    }

    public Map<String, Boolean> getRotationState() {
        return rotationState;
    }

    public void setRotationState(Map<String, Boolean> rotationState) {
        this.rotationState = rotationState;
    }

    public Map<String, Boolean> getSeat() {
        return seat;
    }

    public void setSeat(Map<String, Boolean> seat) {
        this.seat = seat;
    }

    public boolean isAbroad() {
        return isAbroad;
    }

    public void setAbroad(boolean abroad) {
        isAbroad = abroad;
    }



    public boolean isMeal() {
        return isMeal;
    }

    public void setMeal(boolean meal) {
        isMeal = meal;
    }
    public Map<String, String> getSeatType() {
        return seatType;
    }

    public void setSeatType(Map<String, String> seatType) {
        this.seatType = seatType;
    }



    @Override
    public void addOrEditNormalSeat(String seatName, boolean state) {
      Map<String,Boolean> map=new HashMap<>();
      Map<String,String> type=new HashMap<>();

      map.put(seatName,state);
      type.put(seatName,"ECONOMIC");
      setSeat(map);
      setSeatType(type);

    }
    @Override
    public void addOrEditBusinessSeat(String seatName, boolean state) {
        Map<String,Boolean> map=new HashMap<>();
        Map<String,String> type=new HashMap<>();

        map.put(seatName,state);
        type.put(seatName,"BUSINESS");
        setSeat(map);
        setSeatType(type);

    }




    public void addFlying(String fromWhere, String whereTo,int day,int monthy,int year,int clck,String airLines) {
        //yil son iki rakam girilmeli
        //saat 24 saat dilimine gore olmali

        String temp=fromWhere + day + monthy + year + whereTo + clck + airLines ;
        Map<String,String> map=new HashMap<>();
        map.put(temp,whereTo);
        setRotation(map);
    }

    @Override
    public void finishFlying(String fromWhere, String whereTo,int day,int monthy,int year,int clck) {
        String temp=fromWhere + day + monthy + year + whereTo + clck ;
        Map<String,Boolean> map=new HashMap<>();
        map.put(temp,false);
        setRotationState(map);

    }
    public String getSeatTypeByKey(String key) {
        String temp=getSeatType().get(key);
        return temp;


    }

    public boolean verifySeatForBuyingBySeatName(String seat) {


        Boolean aBoolean = getSeat().get(seat);
        if (aBoolean) {
            System.out.println("koltuk alinabilir");

        }
        else {
            System.out.println("bu koltuk doludur.satin alinamaz.");
        }


    }

}
