package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Foods {
    private List<Food> orderedFoods = new ArrayList<>();
    private int [] categoryCnt = {0,0,0,0};

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
        cntCategory();
        return categoryCnt;
    }
    //차례대로 에피타이저-메인메뉴-디저트-음료 cnt 리스트 반환
    private int[] cntCategory(){

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
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }




}
