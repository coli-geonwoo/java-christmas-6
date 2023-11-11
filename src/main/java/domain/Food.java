package domain;

import java.util.*;

public class Food {

    private int price;
    private String category;
    private String name;
    private int cnt;

    Food(String name, int cnt){
        Menu menu= findMenu(name);
        this.name= menu.getName();
        this.cnt= cnt;
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
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해주세요");
    }
}
