

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
 * triangle's bounding shape.
 */
public class Triangle extends ClosedShape {
    //The width and height of the triangle (major and minor axis).
    private int width;
    private int height;

    //The number of points that will make this polyline.
    private static final int N_POINTS = 3;

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
    public Triangle(int insertionTime, int x, int y, int vx, int vy,
                     int width, int height, Color colour, boolean isFilled) {
        super(insertionTime, x, y, vx, vy, colour, isFilled);
        setWidth(width);
        setHeight(height);
    }

    /**
     * Method to convert a triangle to a string.
     */
    public String toString() {
        String result = "This is a triangle\n";
        result += super.toString();
        result += "Its width is " + this.width + " and its height is " + this.height + "\n";
        return result;
    }

    /**
     * Method to set the width.
     * @param width Resets the width.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Method to set the height.
     * @param height Resets the height.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Method to get the width of this triangle.
     * @return The width of the triangle.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Method to get the height of this triangle.
     * @return The height of the triangle.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Method to get the X coordinates of the 3 edges of this triangle.
     * @return The X coordinates in the format a,b,c.
     */
    public double[] getXCoords() {
        return new double[] {(x + width), (x + width), x};
    }

    /**
     * Method to get the Y coordinates of the 3 edges of this triangle.
     * @return The Y coordinates in the format a,b,c.
     */
    public double[] getYCoords() {
        return new double[] {y, (y + height), (y + (height >> 1))};
    }
    
    

    /**
     * Draw the triangle.
     * @param g The graphics object of the drawable component.
     */
    public void draw(GraphicsContext g) {
        g.setFill(colour);
        g.setStroke(colour);
        if (isFilled) {
            g.fillPolygon(getXCoords(), getYCoords(), N_POINTS);
        } else {
            g.strokePolygon(getXCoords(), getYCoords(), N_POINTS);
        }
    }
}
