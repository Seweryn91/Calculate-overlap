import java.util.Scanner;
import java.util.InputMismatchException;
import static java.lang.Math.*;

public class CalculateOverlap{
    Scanner scanner = new Scanner(System.in);

    public void calculation(){
        int[][] corners1 = getFirstRectangleCorners();
        int[][] corners2 = getSecondRectangleCorners();
        double intersection = calculateOverlap(corners1, corners2);
        String intersec = String.format("%.0f", intersection);
        System.out.println("Provided rectangles are intersecting on area of: " + intersec + " square units.");
    }

    private double calculateOverlap(int[][] cornersA, int[][] cornersB)
    /**Calculates area of rectangle that is created by two overlapping rectangles */
    {
        int xa1 = cornersA[0][0]; //rectangle A, coordinate X for bottom-left
        int ya1 = cornersA[0][1]; //rectangle A, coordinate Y, for bottom-left
        int xa2 = cornersA[1][0]; //rectangle A, coordinate X for top-right
        int ya2 = cornersA[1][1]; 
        int xb1 = cornersB[0][0]; //rectangle B, coordinate X for bottom-left and so on...
        int yb1 = cornersB[0][1];
        int xb2 = cornersB[1][0];
        int yb2 = cornersB[1][1];
        double intersectingRectangleArea = max(0, min(xa2, xb2) - max(xa1, xb1)) *
        max(0, min(ya2, yb2) - max(ya1, yb1));
        
        return intersectingRectangleArea;

    }



    private int[] getFirstCornerCoordinate(){
        int[] firstCorner = new int[2]; // [x, y]
        
        System.out.print("Provide X coordinate (bottom-left corner): ");
        
        int bottomLeftX = promptForInt();
        firstCorner[0] = bottomLeftX;
        
        System.out.print("Provide Y coordinate (bottom-left corner): ");
        int bottomLeftY = promptForInt();
        firstCorner[1] = bottomLeftY;
        
        return firstCorner;
    }

    private int[] getSecondCornerCoordinate(){
        int[] secondCorner = new int[2]; // [x, y]
        
        System.out.print("Provide X coordinate (top-right corner): ");
        int topRightX = promptForInt();
        secondCorner[0] = topRightX;
        
        System.out.print("Provide Y coordinate (top-right corner): ");
        int topRightY = promptForInt();
        secondCorner[1] = topRightY;
        
        return secondCorner;
    }

    private int[][] getFirstRectangleCorners(){
        int[][] cornersA = new int[2][2];

        System.out.println("First rectangle:");
        cornersA[0] = getFirstCornerCoordinate();
        cornersA[1] = getSecondCornerCoordinate();

        return cornersA;
    }

    private int[][] getSecondRectangleCorners(){
        int[][] cornersB = new int[2][2]; 
        
        System.out.println("Second rectangle:");
        cornersB[0] = getFirstCornerCoordinate();
        cornersB[1] = getSecondCornerCoordinate();

        return cornersB;
    }

    private int promptForInt() {
        Integer number = null;

        while(number == null){
            try {
                number = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Provided number is not a proper integer! (range -2,147,483,648 to 2,147,483,647)");
                scanner.next();
            }
        }
        return number;
    }

}
