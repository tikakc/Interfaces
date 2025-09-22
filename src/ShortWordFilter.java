/**
 * ShortWordFilter.java - Filter implementation that accepts strings with length < 5
 * Name: Tika Khadka
 */
public class ShortWordFilter implements Filter {
    @Override
    public boolean accept(Object x) {
        if (x instanceof String) {
            String str = (String) x;
            return str.length() < 5;
        }
        return false;
    }
}
