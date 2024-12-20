package View;

public class Messages {

    public static final String UNVALID_DATE_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    public static final String UNVALID_ORDER_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    public static final String FIRST_MENT="안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    public static final String ORDER_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";
    public static final String INPUT_DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    public static final String FREEITEM_EVENT_MESSAGE = "샴페인 1개";
    public static final String NOTHING = "없음\n\n";

    public static void isNotNumberException_1() {
        System.out.println(UNVALID_DATE_MESSAGE);
    }

    public static void rangeException() {
        System.out.println(UNVALID_DATE_MESSAGE);
    }

    public static void isNotNumberException_2() {
        System.out.println(UNVALID_ORDER_MESSAGE);
    }

    public static void unValidOrderException() {
        System.out.println(UNVALID_ORDER_MESSAGE);
    }

    public static void notEnoughMenuExcepiton() {
        System.out.println(UNVALID_ORDER_MESSAGE);
    }

    public static void tooMuchMenuException() {
        System.out.println(UNVALID_ORDER_MESSAGE);
    }

    public static void cannotFindMenuException() {
        System.out.println(UNVALID_ORDER_MESSAGE);
    }

    public static void duplicatedException() {
        System.out.println(UNVALID_ORDER_MESSAGE);
    }
}
