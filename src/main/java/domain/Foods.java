package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Foods {
    private List<Food> orderedFoods = new ArrayList<>();
    private int mainCnt=0;
    private int dessertCnt=0;
    private int totalFoodCnt=0;
    private int totalFoodPrice=0;
    public int gettotalFoodPrice(){
        return totalFoodPrice;
    }
    public int gettotalFoodCnt(){
        return totalFoodCnt;
    }

    public int getmainCnt(){
        return mainCnt;
    }

    public int getDessertCnt(){
        return dessertCnt;
    }

    public void appendFood(Food food){
        checkDuplicateMenu(food.getName());
        cntCategory(food);
        totalFoodPrice+=food.getPrice()*food.getCnt();
        totalFoodCnt+= food.getCnt();
        orderedFoods.add(food);
    }

    private void cntCategory(Food food){
        if(food.getCategory().equals("MAIN")){
            mainCnt+=1;
        }
        if(food.getCategory().equals("DESSERT")){
            dessertCnt+=1;
        }
    }
    private void checkDuplicateMenu(String name){
        List<String> names= orderedFoods.stream().map(Food::getName).collect(Collectors.toList());

        if (names.contains(name)){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

}
