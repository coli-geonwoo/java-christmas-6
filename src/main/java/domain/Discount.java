package domain;

import java.util.HashMap;

import static View.Constants.*;

public class Discount {
    private int totalSale=0;
    private int christMasSale=0;
    private int weekendSale=0;
    private int weekdaySale=0;
    private int specialSale=0;


    public HashMap<String, Integer> getSalePrice(int day, int [] categoryCnt){
        calcTotalSale(day, categoryCnt);
        HashMap<String, Integer> salePrices= new HashMap<String, Integer>(){{
            put("크리스마스 디데이 할인", christMasSale);
            put("주말 할인", weekendSale);
            put("평일 할인", weekdaySale);
            put("특별 할인", specialSale);
        }};
        return salePrices;

    }
    public int getTotalSale(){
        return totalSale;
    }
    private void calcTotalSale(int day, int[] categoryCnt){
        christMasSale=cntChristmasSale(day);
        weekendSale=cntWeekendDaySale(day, categoryCnt[1]);
        weekdaySale=cntWeekDaySale(day, categoryCnt[2]);
        specialSale=cntSpecialSale(day);
        totalSale= (christMasSale+weekendSale+weekdaySale+specialSale);
    }

    private int cntWeekDaySale(int day, int dessertCnt){
        int num= day%7;
        if(WEEKDAY_NUM_LIST.contains(num)){
            return dessertCnt*2023;
        }

        return 0;
    }

    private int cntWeekendDaySale(int day, int mainCnt){
        int num = day%7;
        if(WEEKEND_NUM_LIST.contains(num)){
            return mainCnt*2023;
        }
        return 0;
    }

    private int cntSpecialSale(int day){
        if(day%7==STARDAY_NUM || day==CHRISTMAS){
            return 1000;
        }
        return 0;
    }
    private int cntChristmasSale(int day){
        if(day>CHRISTMAS){
            return 0;
        }
        return (900+day*100);
    }






}
