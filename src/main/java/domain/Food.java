package domain;

public class Food {

    private int price;
    private String category;
    private String name;

    Food(int price, String category, String name){
        this.price= price;
        this.category= category;
        this.name= name;
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
}
