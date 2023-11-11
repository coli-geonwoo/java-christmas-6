package domain;

public enum  Menu {
    MUSHROOMSOUP("양송이수프", 6000, "APPETIZER"),
    TAPAS("타파스", 5500, "APPETIZER"),
    SALAD("시저샐러드", 8000, "APPETIZER"),
    TBORN("티본스테이크",55000, "MAIN"),
    BARBEQUE("바비큐립", 54000, "MAIN"),
    SEAFOODPASTA("해산물파스타", 35000, "MAIN"),
    CHRISTMAXPASTA("크리스마스파스타", 25000, "MAIN"),
    CHOCOCAKE("초코케이크", 15000, "DESSERT"),
    ICECREAM("아이스크림", 5000, "DESSERT"),
    ZEROCOKE("제로콜라", 3000, "DRINK"),
    REDWINE("레드와인", 60000, "DRINK"),
    CHAMPAGNE("샴페인", 25000, "DRINK");

    private static final String ERROR_MESSAGE="[ERROR] [ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    private String name;
    private int price;
    private String category;
    Menu(String name, int price, String category){
        this.name= name;
        this.price=price;
        this.category= category;
    }

    public int getPrice(){return price;}
    public String getCategory(){return category;}
    public String getName(){ return name;}
}
