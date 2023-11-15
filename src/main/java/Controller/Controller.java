package Controller;

import View.InputView;
import View.OutputView;
import domain.*;

import static View.Constants.FREEITEM_COST;
import static View.Messages.FIRST_MENT;

public class Controller {
    private static int day;
    private static Foods foods;

    public static void play() {
        readDayandMenu();
        printResult();
    }

    private static void readDayandMenu() {
        System.out.println(FIRST_MENT);
        day = InputView.readDate();
        foods = InputView.readOrder();
    }

    private static void printResult() {
        OutputView.printInstructions(day);
        OutputView.printMenu(foods);
        OutputView.printTotalPrice(foods);
        OutputView.printFreeItem(foods);
        int totalSale = OutputView.printSalePrices(foods, day, FREEITEM_COST);
        int totalBenefit = OutputView.printTotalBenefitPrice(foods, totalSale, FREEITEM_COST);
        OutputView.printAfterSalePrice(foods, totalSale);
        OutputView.printBadgeEvent(totalBenefit);
    }


}
