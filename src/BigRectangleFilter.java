/**
 * BigRectangleFilter.java - Filter implementation that accepts Rectangle objects with perimeter > 10
 * Name: Tika Khadka
 */
import java.awt.Rectangle;

public class BigRectangleFilter implements Filter {
    @Override
    public boolean accept(Object x) {
        if (x instanceof Rectangle) {
            Rectangle rect = (Rectangle) x;
            // Calculate perimeter: 2 * (width + height)
            double perimeter = 2 * (rect.width + rect.height);
            return perimeter > 10;
        }
        return false;
    }
}
