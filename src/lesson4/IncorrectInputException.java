package lesson4;
import java.io.IOException;

/**
 * Created by artem on 29.01.17.
 */

public class IncorrectInputException extends IOException {
    @Override
    public String getMessage(){
        return "Exception: INCORRECT INPUT.";
    }
}
