package View;

import domain.Discount;
import domain.Food;
import domain.Foods;

import java.text.DecimalFormat;
import java.util.HashMap;

public class OutputView {

    public static void printInstructions(int day){
        System.out.printf("12월 %d일에 우테코 식당에서 받을 이벤트 미리보기!%n%n", day);
    }
    public static void printMenu(Foods foods) {
        System.out.println("<주문 메뉴>");
        for(Food food : foods.getFoodList()){
            System.out.printf("%s %d개%n", food.getName(), food.getCnt());
        }
        System.out.println();
    }

    public static void printTotalPrice(Foods foods){
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%,d원%n%n", foods.gettotalFoodPrice());

    }

    public static void printFreeItem(Foods foods){
        System.out.println("<증정 메뉴>");
        if(foods.freeItemEvent()){
            System.out.printf("샴페인 1개%n%n");
            return;
        }
        System.out.printf("없음%n%n");
    }
    //전체 혜택내역
    public static int printSalePrices(Foods foods, int day, int itemcost){
        System.out.println("<혜택 내역>");
        if(!foods.saleTrueorFalse()){
            System.out.printf("없음%n%n");
            return 0;
        }

        Discount calc = new Discount();
        HashMap<String, Integer> salePrices= calc.getSalePrice(day,foods.getcategoryCnt());
        for(String key : salePrices.keySet()){
            int num= salePrices.get(key);
            if(num!=0){
                System.out.printf("%s: -%,d원%n", key, num);
            }
        }
        printFreeItemSale(foods, itemcost);
        return calc.getTotalSale();

    }

    private static int printFreeItemSale(Foods foods, int itemcost){
        if(foods.freeItemEvent()){
            System.out.printf("증정 이벤트: -%,d원%n%n", itemcost);
            return itemcost;
        }
        System.out.println();
        return 0;
    }

    //총 할인 금액
    public static int printTotalBenefitPrice(Foods foods, int totalSale, int itemCost){
        if(foods.freeItemEvent()){
            totalSale+=itemCost;
        }
        System.out.println("<총혜택 금액>");
        if(totalSale>0){
            System.out.printf("-");}
        System.out.printf("%,d원%n%n", totalSale);
        return totalSale;
    }

    public static void printAfterSalePrice(Foods foods, int totalSale){
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%,d원%n%n", foods.gettotalFoodPrice()-totalSale);

    }

    public static void printBadgeEvent(int totalBenefit){
        System.out.println("<12월 이벤트 배지>");
        if(totalBenefit>=20000){
            System.out.println("산타");
            return;
        }
        if(totalBenefit>=10000){
            System.out.println("트리");
            return;
        }
        if(totalBenefit>=5000){
            System.out.println("별");
            return;
        }
        System.out.println("없음");
    }

}
