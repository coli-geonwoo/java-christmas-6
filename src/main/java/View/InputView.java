package View;

import camp.nextstep.edu.missionutils.Console;

import static View.DateValidator.checkIsNumber;
import static View.DateValidator.checkRange;

public class InputView {

    public int readDate(String input) {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
//        String input = Console.readLine();
        int num= checkIsNumber(input);
        checkRange(num);
        return num;
    }

}
