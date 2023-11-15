package View;

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
                Messages.isNotNumberException_1();
                throw new IllegalArgumentException();
            }
            Messages.isNotNumberException_2();
            throw new IllegalArgumentException();
        }
    }

    public static void checkDateRange(int input){
        if (input <MONTH_START_DATE || input>MONTH_END_DATE){
            Messages.rangeException();
            throw new IllegalArgumentException();
        }
    }

    public static void checkCntRange(int input){
        if(input<minCnt){
            Messages.rangeException();
            throw new IllegalArgumentException();
        }
    }


}
