package lesson3;

/**
 * Created by artem on 29.01.17.
 */

public class GroupFullException extends ArrayIndexOutOfBoundsException {
    @Override
    public String getMessage(){
        return "Exception: GROUP IS FULL.";
    }
}
