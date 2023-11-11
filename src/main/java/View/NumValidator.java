package View;

public class NumValidator {

    private static final String UNVALID_DATE_MESSAGE= "[ERROR] 유효하지 않은 주문입니다. 다시 입력해주세요";
    private static final int MONTH_START_DATE=1;
    private static final int MONTH_END_DATE=31;

    private static final int minCnt=1;

    public static int checkIsNumber(String input){
        try{
            return Integer.parseInt(input);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException(UNVALID_DATE_MESSAGE);
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
