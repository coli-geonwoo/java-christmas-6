package View;

import static View.Messages.UNVALID_DATE_MESSAGE;
import static View.Messages.UNVALID_ORDER_MESSAGE;

public class NumValidator {

    private static final int MONTH_START_DATE=1;
    private static final int MONTH_END_DATE=31;

    private static final int minCnt=1;

    public static int checkIsNumber(String input, int flag){
        try{
            return Integer.parseInt(input);
        }
        catch(NumberFormatException e) {
            if (flag == 0) {
                throw new IllegalArgumentException(UNVALID_DATE_MESSAGE);
            }
            throw new IllegalArgumentException(UNVALID_ORDER_MESSAGE);
        }
    }

    public static void checkDateRange(int input){
        if (input <MONTH_START_DATE || input>MONTH_END_DATE){
            throw new IllegalArgumentException(UNVALID_DATE_MESSAGE);
        }
    }

    public static void checkCntRange(int input){
        if(input<minCnt){
            throw new IllegalArgumentException(UNVALID_DATE_MESSAGE);
        }
    }


}
