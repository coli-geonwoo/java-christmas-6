package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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

    //차례대로 에피타이저-메인메뉴-디저트-음료 cnt 리스트 반환
    public int[] cntCategory(){
        int [] categoryCnt = {0,0,0,0};

        for(Food food: orderedFoods) {
            if (food.getCategory().equals("APPETIZER")) {
                categoryCnt[0] += 1;
                continue;
            }
            if (food.getCategory().equals("MAIN")) {
                 categoryCnt[1]+= 1;
                 continue;
            }
            if(food.getCategory().equals("DESSERT")){
                categoryCnt[2]+=1;
                continue;
            }
            categoryCnt[3]+=1;

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
