package domain;

import View.NumValidator;

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
        try {
            Menu menu = findMenu(name);
            this.name = menu.getName();
            this.cnt = checkValidCnt(cnt);
            this.price = menu.getPrice();
            this.category = menu.getCategory();
        }
        catch(IllegalArgumentException e){
            throw new IllegalArgumentException(UNVALID_ORDER_MESSAGE);
        }
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
        int num = NumValidator.checkIsNumber(cnt,1);
        NumValidator.checkCntRange(num);
        return num;
    }
}
