/**
 * BigRectLister.java - Main program that uses BigRectangleFilter to display rectangles with large perimeters
 * Name: Tika Khadka
 * 
 * INPUT: Program creates 10 Rectangle objects with various dimensions (5 small, 5 large perimeters)
 * OUTPUT: Console display of all rectangles, then filtered big rectangles with summary statistics
 */
import java.awt.Rectangle;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String[] args) {
        // Create an ArrayList of 10 Rectangles
        ArrayList<Rectangle> rectangles = new ArrayList<>();
        
        // Add rectangles with small perimeters (perimeter <= 10)
        rectangles.add(new Rectangle(0, 0, 1, 1));      // perimeter = 4
        rectangles.add(new Rectangle(0, 0, 2, 1));      // perimeter = 6
        rectangles.add(new Rectangle(0, 0, 1, 2));      // perimeter = 6
        rectangles.add(new Rectangle(0, 0, 2, 2));      // perimeter = 8
        rectangles.add(new Rectangle(0, 0, 3, 2));      // perimeter = 10
        
        // Add rectangles with big perimeters (perimeter > 10)
        rectangles.add(new Rectangle(0, 0, 4, 2));      // perimeter = 12
        rectangles.add(new Rectangle(0, 0, 5, 3));      // perimeter = 16
        rectangles.add(new Rectangle(0, 0, 6, 4));      // perimeter = 20
        rectangles.add(new Rectangle(0, 0, 7, 5));      // perimeter = 24
        rectangles.add(new Rectangle(0, 0, 10, 8));     // perimeter = 36
        
        // Create the filter
        BigRectangleFilter filter = new BigRectangleFilter();
        
        System.out.println("All Rectangles:");
        System.out.println("================");
        for (int i = 0; i < rectangles.size(); i++) {
            Rectangle rect = rectangles.get(i);
            double perimeter = 2 * (rect.width + rect.height);
            System.out.printf("Rectangle %d: width=%d, height=%d, perimeter=%.1f%n", 
                            i + 1, rect.width, rect.height, perimeter);
        }
        
        System.out.println("\nBig Rectangles (perimeter > 10):");
        System.out.println("=================================");
        
        ArrayList<Rectangle> bigRectangles = new ArrayList<>();
        for (Rectangle rect : rectangles) {
            if (filter.accept(rect)) {
                bigRectangles.add(rect);
            }
        }
        
        if (bigRectangles.isEmpty()) {
            System.out.println("No big rectangles found.");
        } else {
            for (int i = 0; i < bigRectangles.size(); i++) {
                Rectangle rect = bigRectangles.get(i);
                double perimeter = 2 * (rect.width + rect.height);
                System.out.printf("Big Rectangle %d: width=%d, height=%d, perimeter=%.1f%n", 
                                i + 1, rect.width, rect.height, perimeter);
            }
            System.out.println("\nTotal big rectangles found: " + bigRectangles.size());
        }
        
        System.out.println("\nFilter Test Summary:");
        System.out.println("===================");
        System.out.println("Total rectangles: " + rectangles.size());
        System.out.println("Rectangles with perimeter > 10: " + bigRectangles.size());
        System.out.println("Rectangles with perimeter <= 10: " + (rectangles.size() - bigRectangles.size()));
    }
}
