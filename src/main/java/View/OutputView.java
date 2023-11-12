package View;

import domain.Discount;
import domain.Food;
import domain.Foods;

import java.text.DecimalFormat;
import java.util.HashMap;

public class OutputView {

    private static final DecimalFormat formatter = new DecimalFormat("###,###");
    public static void printMenu(Foods foods) {
        System.out.println("<주문 메뉴>");
        for(Food food : foods.getFoodList()){
            System.out.printf("%s %d개%n", food.getName(), food.getCnt());
        }
    }

    public static void printTotalPrice(Foods foods){
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%d원%n", formatter.format(foods.gettotalFoodPrice()));

    }

    public static void printFreeItem(Foods foods){
        System.out.println("<증정 메뉴>");
        if(foods.freeItemEvent()){
            System.out.println("샴페인 1개");
            return;
        }
        System.out.println("없음");
    }
    //전체 혜택내역
    public static void printSalePrices(Foods foods, int day, int itemcost){
        System.out.println("<혜택 내역>");
        if(!foods.saleTrueorFalse()){
            System.out.println("없음");
            return;
        }

        Discount calc = new Discount();
        HashMap<String, Integer> salePrices= calc.getSalePrice(day,foods.getcategoryCnt());
        for(String key : salePrices.keySet()){
            int num= salePrices.get(key);
            if(num!=0){
                System.out.printf("%s: -%d원%n", key, formatter.format(num));
            }
        }

        printFreeItemSale(foods, itemcost);

    }

    private static void printFreeItemSale(Foods foods, int itemcost){
        if(foods.freeItemEvent()){
            System.out.printf("증정 이벤트: -%d원%n", formatter.format(itemcost));
        }
    }

    //총 할인 금액
    public static void printTotalSalePrice(int totalSale){
        System.out.println("총혜택 금액>");
        if(totalSale>0){
            System.out.printf("-");}
        System.out.printf("%d원%n", formatter.format(totalSale));

    }

    public static void printAfterSalePrice(Foods foods, int totalSale){
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%d원%n", formatter.format(foods.gettotalFoodPrice()-totalSale));

    }

    public static void printBadgeEvent(int totalSale){
        System.out.println("<12월 이벤트 배지>");
        if(totalSale>=20000){
            System.out.println("산타");
            return;
        }
        if(totalSale>=10000){
            System.out.println("트리");
            return;
        }
        if(totalSale>=5000){
            System.out.println("별");
            return;
        }
        System.out.println("없음");
    }

}
