package View;

import domain.Food;
import domain.Foods;


import static View.Constants.MAX_ORDER_ITEM_CNT;
import static View.NumValidator.checkIsNumber;
import static View.NumValidator.checkDateRange;

public class InputView {

    public int readDate(String input) {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
//        String input = Console.readLine();
        int num= checkIsNumber(input);
        checkDateRange(num);
        return num;
    }

    public Foods readOrder(String input){
        Foods temp= new Foods();
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");

//        String input= Console.readLine();
        String [] orderTokens= input.split(",");

        for(String token : orderTokens){
            String[] order= token.split("-");
            checkOrder(order);
            Food food= new Food(order[0], order[1]);
            temp.appendFood(food);
        }
        checkOrderCnt(temp);
        checkOrderNotOnlyDrink(temp);
        return temp;
    }

    private void checkOrder(String [] order){
        if(order.length!=2){
            throw new IllegalArgumentException("ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void checkOrderCnt(Foods food){
        if(food.gettotalFoodCnt()<MAX_ORDER_ITEM_CNT){
            return;
        }
        throw new IllegalArgumentException("ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    private void checkOrderNotOnlyDrink(Foods food){
        int [] categoryCnt= food.getcategoryCnt();

        if(categoryCnt[0]!=0 || categoryCnt[1]!=0 || categoryCnt[2]!=0){
            return;
        }
        throw new IllegalArgumentException("ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

}
