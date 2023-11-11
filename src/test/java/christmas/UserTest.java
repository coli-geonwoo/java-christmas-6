package christmas;
import View.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class UserTest {
    @DisplayName("날짜입력에 숫자가 아닌 값을 넣었을 때 예외발생")
    @Test
    void date_문자예외_test(){
        assertThrows(IllegalArgumentException.class, () -> {
            InputView view = new InputView();
            view.readDate("a");
        });
    }
    @DisplayName("날짜입력에 범위를 넘는 숫자를 넣었을 때 예외발생")
    @Test
    void date_범위예외_test(){
        assertThrows(IllegalArgumentException.class, () -> {
            InputView view = new InputView();
            view.readDate("32");
        });
    }

    @DisplayName("날짜입력에 정상적인 숫자를 넣었을 때")
    @Test
    void date_test(){
        InputView view = new InputView();
        assertEquals(view.readDate("6"),6);
    }

}
