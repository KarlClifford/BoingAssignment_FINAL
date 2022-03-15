/**
 * ReadShapeFile
 * @version 1.0
 *
 * Created 10/03/2022
 *
 * Last Modified 15/03/2022
 * @author Karl Clifford
 *
 * No Copyright
 *
 * This class reads a shape file. For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 */

import javafx.scene.paint.Color;

import javax.lang.model.type.UnknownTypeException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class ReadShapeFile {

	// These variables dictate the order of columns in a row and should not be modified.
	private static final int COLUMN_ONE = 1;
	private static final int COLUMN_TWO = 2;
	private static final int COLUMN_THREE = 3;
	private static final int COLUMN_FOUR = 4;
	private static final int COLUMN_FIVE = 5;
	private static final int COLUMN_SIX = 6;
	private static final int COLUMN_SEVEN = 7;
	private static final int COLUMN_EIGHT = 8;
	private static final int COLUMN_NINE = 9;
	private static final int COLUMN_TEN = 10;
	private static final int COLUMN_ELEVEN = 11;

	/**
	 * Constructs a circle shape using read file data.
	 * @param row is the read line passed in from readLineByLine() method.
	 * @return a Circle object.
	 */
	private static ClosedShape constructShapeCircle(String[] row) {

		final int insertionTime = Integer.parseInt(row[COLUMN_ONE]);
		final int x = Integer.parseInt(row[COLUMN_TWO]);
		final int y = Integer.parseInt(row[COLUMN_THREE]);
		final int vx = Integer.parseInt(row[COLUMN_FOUR]);
		final int vy = Integer.parseInt(row[COLUMN_FIVE]);
		final int diameter = Integer.parseInt(row[COLUMN_SEVEN]);
		final int r = Integer.parseInt(row[COLUMN_EIGHT]);
		final int g = Integer.parseInt(row[COLUMN_NINE]);
		final int b = Integer.parseInt(row[COLUMN_TEN]);
		final Color colour = Color.rgb(r, g, b);
		final boolean isFilled = Boolean.parseBoolean(row[COLUMN_SIX]);


		return new Circle(insertionTime, x, y, vx, vy, diameter, colour, isFilled);
	}

	/**
	 * Constructs an oval shape using read file data.
	 * @param row is the read line passed in from readLineByLine() method.
	 * @return an Oval object.
	 */
	private static ClosedShape constructShapeOval(String[] row) {

		final int insertionTime = Integer.parseInt(row[COLUMN_ONE]);
		final int x = Integer.parseInt(row[COLUMN_TWO]);
		final int y = Integer.parseInt(row[COLUMN_THREE]);
		final int vx = Integer.parseInt(row[COLUMN_FOUR]);
		final int vy = Integer.parseInt(row[COLUMN_FIVE]);
		final int width = Integer.parseInt(row[COLUMN_SEVEN]);
		final int height = Integer.parseInt(row[COLUMN_EIGHT]);
		final int r = Integer.parseInt(row[COLUMN_NINE]);
		final int g = Integer.parseInt(row[COLUMN_TEN]);
		final int b = Integer.parseInt(row[COLUMN_ELEVEN]);
		final Color colour = Color.rgb(r, g, b);
		final boolean isFilled = Boolean.parseBoolean(row[COLUMN_SIX]);


		return new Oval(insertionTime, x, y, vx, vy, width, height, colour, isFilled);
	}

	/**
	 * Constructs a rectangle shape using read file data.
	 * @param row is the read line passed in from readLineByLine() method.
	 * @return a Rect object.
	 */
	private static ClosedShape constructShapeRect(String[] row) {

		final int insertionTime = Integer.parseInt(row[COLUMN_ONE]);
		final int x = Integer.parseInt(row[COLUMN_TWO]);
		final int y = Integer.parseInt(row[COLUMN_THREE]);
		final int vx = Integer.parseInt(row[COLUMN_FOUR]);
		final int vy = Integer.parseInt(row[COLUMN_FIVE]);
		final int width = Integer.parseInt(row[COLUMN_SEVEN]);
		final int height = Integer.parseInt(row[COLUMN_EIGHT]);
		final int r = Integer.parseInt(row[COLUMN_NINE]);
		final int g = Integer.parseInt(row[COLUMN_TEN]);
		final int b = Integer.parseInt(row[COLUMN_ELEVEN]);
		final Color colour = Color.rgb(r, g, b);
		final boolean isFilled = Boolean.parseBoolean(row[COLUMN_SIX]);


		return new Rect(insertionTime, x, y, vx, vy, width, height, colour, isFilled);
	}

	/**
	 * Constructs a rectangle shape using read file data.
	 * @param row is the read line passed in from readLineByLine() method.
	 * @return a Rect object.
	 */
	private static ClosedShape constructShapeSquare(String[] row) {

		final int insertionTime = Integer.parseInt(row[COLUMN_ONE]);
		final int x = Integer.parseInt(row[COLUMN_TWO]);
		final int y = Integer.parseInt(row[COLUMN_THREE]);
		final int vx = Integer.parseInt(row[COLUMN_FOUR]);
		final int vy = Integer.parseInt(row[COLUMN_FIVE]);
		final int side = Integer.parseInt(row[COLUMN_SEVEN]);
		final int r = Integer.parseInt(row[COLUMN_EIGHT]);
		final int g = Integer.parseInt(row[COLUMN_NINE]);
		final int b = Integer.parseInt(row[COLUMN_TEN]);
		final Color colour = Color.rgb(r, g, b);
		final boolean isFilled = Boolean.parseBoolean(row[COLUMN_SIX]);


		return new Square(insertionTime, x, y, vx, vy, side, colour, isFilled);
	}

	/**
	 * Constructs a rectangle shape using read file data.
	 * @param row is the read line passed in from readLineByLine() method.
	 * @return a Rect object.
	 */
	private static ClosedShape constructShapeTriangle(String[] row) {

		final int insertionTime = Integer.parseInt(row[COLUMN_ONE]);
		final int x = Integer.parseInt(row[COLUMN_TWO]);
		final int y = Integer.parseInt(row[COLUMN_THREE]);
		final int vx = Integer.parseInt(row[COLUMN_FOUR]);
		final int vy = Integer.parseInt(row[COLUMN_FIVE]);
		final int width = Integer.parseInt(row[COLUMN_SEVEN]);
		final int height = Integer.parseInt(row[COLUMN_EIGHT]);
		final int r = Integer.parseInt(row[COLUMN_NINE]);
		final int g = Integer.parseInt(row[COLUMN_TEN]);
		final int b = Integer.parseInt(row[COLUMN_ELEVEN]);
		final Color colour = Color.rgb(r, g, b);
		final boolean isFilled = Boolean.parseBoolean(row[COLUMN_SIX]);


		return new Triangle(insertionTime, x, y, vx, vy, width, height, colour, isFilled);
	}

	/**
	 * Identifies the type of shape to be created then calls the complementary construct
	 * shape method.
	 * @param shapeType String value containing the shape name circle, oval, rect or square.
	 * @param row Array consisting of values to be passed into ClosedShape constructor.
	 * @return a ClosedShape object.
	 */
	private static ClosedShape chooseConstructor(String shapeType, String[] row) {
		return switch (shapeType.toLowerCase(Locale.ROOT)) {
			// First element of row is circle so pass row to circle constructor.
			case "circle" -> constructShapeCircle(row);
			// First element of row is oval so pass row to oval constructor.
			case "oval" -> constructShapeOval(row);
			// First element of row is rect so pass row to rectangle constructor.
			case "rect" -> constructShapeRect(row);
			// First element of row is square so pass row to square constructor.
			case "square" -> constructShapeSquare(row);
			// First element of row is triangle so pass row to triangle constructor.
			case "triangle" -> constructShapeTriangle(row);
			// Shape file contains an unknown shape so throw an error.
			default -> throw new IllegalArgumentException("Unexpected value: "
					+ shapeType.toLowerCase(Locale.ROOT));
		};
	}

	/**
	 * Reads the data file used by the program and returns the constructed queue.
	 * @param in the scanner of the file.
	 * @return the queue represented by the shape data file.
	 */
	private static Queue<ClosedShape> readLineByLine(Scanner in) {
		Queue<ClosedShape> shapeQueue = new Queue<>();

		// Read in the shape files and place them on the Queue
		while (in.hasNext()) {
			String readLine = in.nextLine();
			String[] row = readLine.split(" ");

			// Construct the shape and enqueue to shapeQueue
			ClosedShape shape = chooseConstructor(row[0], row);
			shapeQueue.enqueue(shape);
		}

		// Right now, returning an empty Queue.  You need to change this.
		return shapeQueue;
	}





	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * @param filename the name of the file.
	 * @return the queue of shapes from the file.
	 */
	public static Queue<ClosedShape> readDataFile(String filename) {
		// This file contains the shapes to generate.
		File inputFile = new File(filename);

	    Scanner in = null;

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
