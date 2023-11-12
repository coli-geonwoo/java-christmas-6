package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static View.Constants.FREEITEM_EVENT_PRICE;
import static View.Messages.UNVALID_ORDER_MESSAGE;


public class Foods {
    private List<Food> orderedFoods = new ArrayList<>();

    public int gettotalFoodPrice(){
        int sum=0;
        for(Food food : orderedFoods){
            sum+=food.getPrice()*food.getCnt();
        }
        return sum;
    }
    public int gettotalFoodCnt(){
        int sum=0;
        for(Food food : orderedFoods){
            sum+=food.getCnt();
        }
        return sum;
    }


    public void appendFood(Food food){
        checkDuplicateMenu(food.getName());
        orderedFoods.add(food);
    }
    public int [] getcategoryCnt(){
        return  cntCategory();

    }

    public List<Food> getFoodList(){
        return orderedFoods;
    }
    public boolean freeItemEvent(){
        int sum= gettotalFoodPrice();
        return (sum>=FREEITEM_EVENT_PRICE);
    }

    public boolean saleTrueorFalse(){
        int sum= gettotalFoodPrice();
        if(sum<10000){return false;}

        return true;
    }


    //차례대로 에피타이저-메인메뉴-디저트-음료 cnt 리스트 반환
    private int[] cntCategory(){
        int [] categoryCnt={0,0,0,0};

        for(Food food: orderedFoods) {
            if (food.getCategory().equals("APPETIZER")) {
                categoryCnt[0] += food.getCnt();
                continue;
            }
            if (food.getCategory().equals("MAIN")) {
                 categoryCnt[1]+= food.getCnt();
                 continue;
            }
            if(food.getCategory().equals("DESSERT")){
                categoryCnt[2]+=food.getCnt();
                continue;
            }
            categoryCnt[3]+=food.getCnt();

        }

        return categoryCnt;
    }
    private void checkDuplicateMenu(String name){
        List<String> names= orderedFoods.stream().map(Food::getName).collect(Collectors.toList());

        if (names.contains(name)){
            throw new IllegalArgumentException(UNVALID_ORDER_MESSAGE);
        }
    }




}
