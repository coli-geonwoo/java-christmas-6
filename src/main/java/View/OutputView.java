package View;

import domain.Discount;
import domain.Food;
import domain.Foods;

import java.text.DecimalFormat;

public class OutputView {

    private final DecimalFormat formatter = new DecimalFormat("###,###");
    public void printMenu(Foods foods) {
        System.out.println("<주문 메뉴>");
        for(Food food : foods.getFoodList()){
            System.out.printf("%s %d개%n", food.getName(), food.getCnt());
        }
    }

    public void printTotalPrice(Foods foods){
        System.out.println("<할인 전 총주문 금액>");
        System.out.printf("%d원%n", formatter.format(foods.gettotalFoodPrice()));

    }

    public void printFreeItem(Foods foods){
        System.out.println("<증정 메뉴>");
        if(foods.freeItemEvent()){
            System.out.println("샴페인 1개");
            return;
        }
        System.out.println("없음");
    }

    //총 할인 금액
    public int printTotalSalePrice(Foods foods, int day){
        Discount calc= new Discount();
        int totalSale= calc.calcTotalSale(day,foods.getcategoryCnt());
        System.out.println("총혜택 금액>");
        System.out.printf("-%d원%n", formatter.format(totalSale));

        return totalSale;
    }

    public void printAfterSalePrice(Foods foods, int totalSale){
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.printf("%d원%n", formatter.format(foods.gettotalFoodPrice()-totalSale));

    }

    public void printBadgeEvent(int totalSale){
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
