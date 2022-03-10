

/**
 * Square.java
 * @version 1.0.0
 * Written by Karl Clifford
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

import java.security.InvalidParameterException;

/**
 *
 * Square is a shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of the
 * rectangle's bounding rectangle
 */
public class Square extends ClosedShape {
    //The width and height of the square (major and minor axis)
    private int side;

    /**
     * Creates a rectangle.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param side The length of the side of the square (in pixels).
     * @param colour The line colour or fill colour.
     * @param isFilled True if the square is filled with colour, false if opaque.
     */
    public Square (int insertionTime, int x, int y, int vx, int vy, int side, Color colour, boolean isFilled) {
        super (insertionTime, x, y, vx, vy, colour, isFilled);
        this.side = side;
    }

    /**
     * Method to convert a square to a string.
     */
    public String toString () {
        String result = "This is an square\n";
        result += super.toString ();
        result += "Its width is " + this.side + " and its height is " + this.side + "\n";
        return result;
    }

    /**
     * @param width Resets the width.
     */
    public void setWidth (int width) {
        this.side = width;
    }

    /**
     * @param height Resets the height.
     */
    public void setHeight (int height) {
        this.side = height;
    }

    /**
     * @return The width of the square.
     */
    public int getWidth() {
        return side;
    }

    /**
     * @return The height of the square.
     */
    public int getHeight() {
        return side;
    }

    /**
     * Draw the square.
     * @param g The graphics object of the drawable component.
     */
    public void draw (GraphicsContext g) {
        g.setFill (colour);
        g.setStroke( colour );
        if (isFilled) {
            g.fillRect( x, y, side, side );
        }
        else {
            g.strokeRect( x, y, side, side );
        }
    }
}
