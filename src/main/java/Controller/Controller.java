package Controller;
import View.InputView;
import View.OutputView;
import domain.*;
public class Controller {
    private static int day;
    private static Foods foods;
    public static void play(){
        readDayandMenu();
        printResult();
    }

    private static void readDayandMenu(){
        day=InputView.readDate();
        foods= InputView.readOrder();
    }

    private static void printResult(){
        Discount calc = new Discount();
        OutputView.printInstructions(day);
        OutputView.printMenu(foods);
        OutputView.printTotalPrice(foods);
        OutputView.printFreeItem(foods);
        int totalSale=OutputView.printSalePrices(foods, day, 25000);
        OutputView.printTotalSalePrice(totalSale);
        OutputView.printAfterSalePrice(foods, totalSale);
        OutputView.printBadgeEvent(totalSale);
    }



}
