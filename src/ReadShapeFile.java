/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author you
 *
 */

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class ReadShapeFile {


	// TODO: You will likely need to write four methods here. One method to
	// construct each shape
	// given the Scanner passed as a parameter. I would suggest static
	// methods in this case.

	/**
	 * Constructs a circle shape using read file data.
	 * @param lineElement is the read line passed in from readLineByLine() method.
	 * @return a Circle object.
	 */
	private static ClosedShape constructShapeCircle(String[] lineElement) {

		final int insertionTime = Integer.parseInt(lineElement[1]);
		final int x = Integer.parseInt(lineElement[2]);
		final int y = Integer.parseInt(lineElement[3]);
		final int vx = Integer.parseInt(lineElement[4]);
		final int vy = Integer.parseInt(lineElement[5]);
		final int diameter = Integer.parseInt(lineElement[7]);
		final int r = Integer.parseInt(lineElement[8]);
		final int g = Integer.parseInt(lineElement[9]);
		final int b = Integer.parseInt(lineElement[10]);
		final Color colour = Color.rgb(r,g, b);
		final boolean isFilled = Boolean.parseBoolean(lineElement[6]);


		return new Circle(insertionTime, x, y, vx, vy, diameter, colour, isFilled);
	}

	/**
	 * Constructs an oval shape using read file data.
	 * @param lineElement is the read line passed in from readLineByLine() method.
	 * @return an Oval object.
	 */
	private static ClosedShape constructShapeOval(String[] lineElement) {

		final int insertionTime = Integer.parseInt(lineElement[1]);
		final int x = Integer.parseInt(lineElement[2]);
		final int y = Integer.parseInt(lineElement[3]);
		final int vx = Integer.parseInt(lineElement[4]);
		final int vy = Integer.parseInt(lineElement[5]);
		final int width = Integer.parseInt(lineElement[7]);
		final int height = Integer.parseInt(lineElement[8]);
		final int r = Integer.parseInt(lineElement[9]);
		final int g = Integer.parseInt(lineElement[10]);
		final int b = Integer.parseInt(lineElement[11]);
		final Color colour = Color.rgb(r,g, b);
		final boolean isFilled = Boolean.parseBoolean(lineElement[6]);


		return new Oval(insertionTime, x, y, vx, vy, width, height, colour, isFilled);
	}

	//TODO: Implement RECT and change lineElement configurations to suite this shape
	/**
	 * Constructs a rectangle shape using read file data.
	 * @param lineElement is the read line passed in from readLineByLine() method.
	 * @return a Rect object.
	 */
	private static ClosedShape constructShapeRect(String[] lineElement) {

		final int insertionTime = Integer.parseInt(lineElement[1]);
		final int x = Integer.parseInt(lineElement[2]);
		final int y = Integer.parseInt(lineElement[3]);
		final int vx = Integer.parseInt(lineElement[4]);
		final int vy = Integer.parseInt(lineElement[5]);
		final int width = Integer.parseInt(lineElement[7]);
		final int height = Integer.parseInt(lineElement[8]);
		final int r = Integer.parseInt(lineElement[9]);
		final int g = Integer.parseInt(lineElement[10]);
		final int b = Integer.parseInt(lineElement[11]);
		final Color colour = Color.rgb(r,g, b);
		final boolean isFilled = Boolean.parseBoolean(lineElement[6]);


		return new Rect(insertionTime, x, y, vx, vy, width, height, colour, isFilled);
	}

	//TODO: Implement SQUARE and change lineElement configurations to suite this shape
	/**
	 * Constructs a rectangle shape using read file data.
	 * @param lineElement is the read line passed in from readLineByLine() method.
	 * @return a Rect object.
	 */
	private static ClosedShape constructShapeSquare(String[] lineElement) {

		final int insertionTime = Integer.parseInt(lineElement[1]);
		final int x = Integer.parseInt(lineElement[2]);
		final int y = Integer.parseInt(lineElement[3]);
		final int vx = Integer.parseInt(lineElement[4]);
		final int vy = Integer.parseInt(lineElement[5]);
		final int side = Integer.parseInt(lineElement[7]);
		final int r = Integer.parseInt(lineElement[8]);
		final int g = Integer.parseInt(lineElement[9]);
		final int b = Integer.parseInt(lineElement[10]);
		final Color colour = Color.rgb(r,g, b);
		final boolean isFilled = Boolean.parseBoolean(lineElement[6]);


		return new Square(insertionTime, x, y, vx, vy, side, colour, isFilled);
	}

	//TODO: Implement RECT and change lineElement configurations to suite this shape
	/**
	 * Constructs a rectangle shape using read file data.
	 * @param lineElement is the read line passed in from readLineByLine() method.
	 * @return a Rect object.
	 */
	private static ClosedShape constructShapeTriangle(String[] lineElement) {

		final int insertionTime = Integer.parseInt(lineElement[1]);
		final int x = Integer.parseInt(lineElement[2]);
		final int y = Integer.parseInt(lineElement[3]);
		final int vx = Integer.parseInt(lineElement[4]);
		final int vy = Integer.parseInt(lineElement[5]);
		final int width = Integer.parseInt(lineElement[7]);
		final int height = Integer.parseInt(lineElement[8]);
		final int r = Integer.parseInt(lineElement[9]);
		final int g = Integer.parseInt(lineElement[10]);
		final int b = Integer.parseInt(lineElement[11]);
		final Color colour = Color.rgb(r,g, b);
		final boolean isFilled = Boolean.parseBoolean(lineElement[6]);


		return new Triangle(insertionTime, x, y, vx, vy, width, height, colour, isFilled);
	}
	//TODO: Add branching comments

	/**
	 * Identifies the type of shape to be created then calls the complementary construct
	 * shape method.
	 * @param shapeType String value containing the shape name circle, oval, rect or square.
	 * @param lineElement Array consisting of values to be passed into ClosedShape constructor.
	 * @return a ClosedShape object.
	 */
	private static ClosedShape chooseConstructor(String shapeType, String[] lineElement) {
		ClosedShape shape;
		switch (shapeType.toLowerCase(Locale.ROOT)) {
			case "circle":
				shape = constructShapeCircle(lineElement);
				break;
			case "oval":
				shape = constructShapeOval(lineElement);
				break;
			case "rect":
				shape = constructShapeRect(lineElement);
				break;
			case "square":
				shape = constructShapeSquare(lineElement);
				break;
			case "triangle":
				shape = constructShapeTriangle(lineElement);
				break;
			default:
				throw new IllegalStateException("Unexpected value: "
						+ shapeType.toLowerCase(Locale.ROOT));

		}
		return shape;
	}

	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * 
	 * @param in
	 *            the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Queue<ClosedShape> readLineByLine(Scanner in) {
		Queue<ClosedShape> shapeQueue = new Queue<>();

		// Read in the shape files and place them on the Queue
		while(in.hasNext()) {
			String readLine = in.nextLine();
			String[] lineElement = readLine.split(" ");

			// Construct the shape and enqueue to shapeQueue
			ClosedShape shape = chooseConstructor(lineElement[0], lineElement);
			shapeQueue.enqueue(shape);
		}

		// Right now, returning an empty Queue.  You need to change this.
		return shapeQueue;
	}





	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename
	 *            the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue<ClosedShape> readDataFile(String filename) {
		//TODO: Comment here?
		File inputFile = new File(filename);

	    Scanner in = null; // null is not sensible. Please change

		// Try to read file if the file is not found exit gracefully.
		try {
			in = new Scanner(inputFile);

		} catch (FileNotFoundException e) {
			System.out.println("Could not find " + filename);
			System.exit(1);
		}

		return ReadShapeFile.readLineByLine(in);
	    
	}
}
