package christmas;
import View.InputView;
import domain.Discount;
import domain.Food;
import domain.Foods;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class UserTest {
    @DisplayName("날짜입력에 숫자가 아닌 값을 넣었을 때 예외발생")
    @Test
    void date_문자예외_test(){
        assertThrows(IllegalArgumentException.class, () -> {
            InputView view = new InputView();
            view.readDate("a");
        });
    }
    @DisplayName("날짜입력에 범위를 넘는 숫자를 넣었을 때 예외발생")
    @Test
    void date_범위예외_test(){
        assertThrows(IllegalArgumentException.class, () -> {
            InputView view = new InputView();
            view.readDate("32");
        });
    }

    @DisplayName("날짜입력에 정상적인 숫자를 넣었을 때")
    @Test
    void date_test(){
        InputView view = new InputView();
        assertEquals(view.readDate("6"),6);
    }

    @DisplayName("Food객체에 알맞은 이름을 넣었을 때")
    void food_test1(){
        Food food= new Food("크리스마스파스타","2");
        assertEquals(food.getName(), "크리스마스파스타");
        assertEquals(food.getPrice(), 25000);
        assertEquals(food.getCategory(),"MAIN");
    }


    @Test
    @DisplayName("Food객체에 메뉴판에 없는 이름을 넣었을 때")
    void food_test2(){
        assertThrows(IllegalArgumentException.class, () -> {
            Food food= new Food("봉골레파스타","2");
        });
    }

    @Test
    @DisplayName("Food객체에 잘못된 범위의 cnt값이 들어왔을 때")
    void food_test3(){
        assertThrows(IllegalArgumentException.class, () -> {
            Food food= new Food("봉골레파스타","-2");
        });
    }

    @Test
    @DisplayName("중복된 food를 list에 넣으려 할 때")
    void duplicate_check(){
        assertThrows(IllegalArgumentException.class, () -> {
            Food food1= new Food("봉골레파스타","2");
            Food food2= new Food("봉골레파스타","2");
            Foods foods= new Foods();
            foods.appendFood(food1);
            foods.appendFood(food2);
        });
    }

    @DisplayName("readOrder이 잘작동하는지 확인")
    @Test
    void readOrder_test1(){
        InputView view= new InputView();
        Foods foods= view.readOrder("해산물파스타-2,레드와인-1");
        assertEquals(foods.gettotalFoodPrice(), 130000);
        int [] categoryCnt= foods.getcategoryCnt();
        assertEquals(foods.gettotalFoodCnt(), 3);
        assertEquals(categoryCnt[1],2);
    }

    @Test
    @DisplayName("20개를 넘는 주문을 했을 경우")
    void readOrder_test2(){
        assertThrows(IllegalArgumentException.class, () -> {
            InputView view= new InputView();
            Foods foods= view.readOrder("해산물파스타-2,레드와인-22");
        });
    }
    
    @DisplayName("할인금액이 잘 나오는지 확인")
    @Test
    void salePrice_test(){
        Discount discount= new Discount();
        int [] t1={0,1,0,0};
        int [] t2={0,0,1,0};
        int [] t3={0,0,0,0};
        discount.getSalePrice(1, t1);
        assertEquals(discount.getTotalSale(), 3023);
        discount.getSalePrice(25,t2);
        assertEquals(discount.getTotalSale(),6423);
        discount.getSalePrice(31, t3);
        assertEquals(discount.getTotalSale(),1000);
    }

}
