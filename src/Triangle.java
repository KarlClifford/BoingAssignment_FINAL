

/**
 * Triangle.java
 * @version 1.0.0
 * Written by Karl Clifford
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * Rect is a triangle shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of the
 * triangle's bounding triangle
 */
public class Triangle extends ClosedShape {
    //The width and height of the triangle (major and minor axis)
    private int width, height;

    /**
     * Creates a triangle.
     * @param x The display component's x position.
     * @param y The display component's y position.
     * @param vx The display component's x velocity.
     * @param vy The display component's y velocity.
     * @param width The width of the rect (in pixels).
     * @param height The height of the rect (in pixels).
     * @param colour The line colour or fill colour.
     * @param isFilled True if the rect is filled with colour, false if opaque.
     */
    public Triangle (int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled) {
        super (insertionTime, x, y, vx, vy, colour, isFilled);
        this.width = width;
        this.height = height;
    }

    /**
     * Method to convert a triangle to a string.
     */
    public String toString () {
        String result = "This is a triangle\n";
        result += super.toString ();
        result += "Its width is " + this.width + " and its height is " + this.height + "\n";
        return result;
    }

    /**
     * @param width Resets the width.
     */
    public void setWidth (int width) {
        this.width = width;
    }

    /**
     * @param height Resets the height.
     */
    public void setHeight (int height) {
        this.height = height;
    }

    /**
     * @return The width of the triangle.
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return The height of the triangle.
     */
    public int getHeight() {
        return height;
    }

    public double[] getXCoords() {
        return new double[] {x + width, x+ width, x + (width + width)};
    }

    public double[] getYCoords() {
        return new double[] {y + height, y + (height*2), y + (height >> 1)};
    }
    
    

    /**
     * Draw the triangle.
     * @param g The graphics object of the drawable component.
     */
    public void draw (GraphicsContext g) {
        g.setFill (colour);
        g.setStroke( colour );
        if (isFilled) {
            g.fillPolygon(getXCoords(), getYCoords(), 3);
        }
        else {
            g.strokePolygon(getXCoords(), getYCoords(), 3);
        }
    }
}
