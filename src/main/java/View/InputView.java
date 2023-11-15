package View;

import camp.nextstep.edu.missionutils.Console;
import domain.Food;
import domain.Foods;


import static View.Constants.MAX_ORDER_ITEM_CNT;
import static View.Messages.*;
import static View.NumValidator.checkIsNumber;
import static View.NumValidator.checkDateRange;

public class InputView {

    public static int readDate() {
        System.out.println(INPUT_DATE_MESSAGE);
        String input = Console.readLine();
        try {
            int num = checkIsNumber(input.strip(), 0);
            checkDateRange(num);
            return num;
        } catch (IllegalArgumentException e) {
            return readDate();
        }
    }

    public static Foods readOrder() {
        Foods temp = new Foods();
        System.out.println(ORDER_MESSAGE);

        String input = Console.readLine();
        String[] orderTokens = input.strip().split(",");
        try {
            for (String token : orderTokens) {
                String[] order = token.split("-");
                temp.appendFood(makeFoodobj(order));
            }
            checkAllOrder(temp);
            return temp;
        } catch (IllegalArgumentException e) {
            return readOrder();
        }
    }

    private static Food makeFoodobj(String [] order){
        checkOrderForm(order);
        Food food= new Food(order[0], order[1]);
        return food;
    }

    private static void checkOrderForm(String[] order) {
        if (order.length != 2) {
            Messages.unValidOrderException();
            throw new IllegalArgumentException();
        }
    }

    private static void checkAllOrder(Foods foods){
        checkOrderCnt(foods);
        checkOrderNotOnlyDrink(foods);
    }
    private static void checkOrderCnt(Foods food) {
        if (food.gettotalFoodCnt() < MAX_ORDER_ITEM_CNT) {
            return;
        }
        Messages.tooMuchMenuException();
        throw new IllegalArgumentException();
    }

    private static void checkOrderNotOnlyDrink(Foods food) {
        int[] categoryCnt = food.getcategoryCnt();

        if (categoryCnt[0] != 0 || categoryCnt[1] != 0 || categoryCnt[2] != 0) {
            return;
        }
        Messages.notEnoughMenuExcepiton();
        throw new IllegalArgumentException();
    }

}
