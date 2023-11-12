package domain;

import java.util.*;

import static View.Messages.UNVALID_ORDER_MESSAGE;
import static View.NumValidator.checkCntRange;
import static View.NumValidator.checkIsNumber;

public class Food {

    private int price;
    private String category;
    private String name;
    private int cnt;

    public Food(String name, String cnt){
        Menu menu= findMenu(name);
        this.name= menu.getName();
        this.cnt= checkValidCnt(cnt);
        this.price=menu.getPrice();
        this.category= menu.getCategory();
    }
    public String getName(){
        return name;
    }
    public String getCategory(){
        return category;
    }

    public int getPrice(){
        return price;
    }

    public int getCnt(){
        return cnt;
    }

    private Menu findMenu(String name){
        for(Menu menu :Menu.values()){
            if(name.equals(menu.getName())){
                return menu;
            }
        }
        throw new IllegalArgumentException(UNVALID_ORDER_MESSAGE);
    }
    private int checkValidCnt(String cnt){
        int num = checkIsNumber(cnt,1);
        checkCntRange(num);
        return num;
    }
}
