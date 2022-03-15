/**
 *
 * Queue.java
 * @version 1.0
 *
 * Created 10/03/2022
 *
 * Last Modified 15/03/2022
 * @author Karl Clifford
 *
 * A class that implements a queue using a linked list of QueueElements.
 */

import java.util.NoSuchElementException;

public class Queue<T> {

	// Create the front and back of the queue to implement a linked list queue.
	private QueueElement<T> front;
	private QueueElement<T> back;

	/**
	 * Constructs an empty Queue.
	 */
	public Queue() {
		front = null;
		back = null;
	}

	/**
	 * Returns true if the queue is empty.
	 */
	public boolean isEmpty() {
		return ((front == null) && (back == null));
	}


	/**
	 * @return the element at the head of the queue.
	 * @throws NoSuchElementException when the queue is empty.
	 */
	public T peek() throws NoSuchElementException {
		// Ensure the queue actually contains some data.
		if (isEmpty()) {
			// Queue is null so throw error.
			throw new NoSuchElementException();
		}
		// The queue has data so return the element.
		return front.getElement();
	}

	/**
	 * Removes the front element of the queue.
	 * @throws NoSuchElementException when the queue is empty.
	 */
	public void dequeue() throws NoSuchElementException {
		// Ensure the queue has some data.
		if (!isEmpty()) {
			// Check the queue has a next element.
			if (front.getNext() == null) {
				// No more elements in queue so empty the queue correctly.
				back = null;
			}
			// Store the next element in the queue.
			front = front.getNext();
		} else {
			// Queue is empty so produce error.
			throw new NoSuchElementException();
		}
	}

	/**
	 * Puts an element on the back of the queue.
	 * @param element the element to be added to the queue.
	 */
	public void enqueue(T element) {
		// Make a new queue element from data and link to the queue.
		QueueElement<T> newElement = new QueueElement<>(element, back);
		// If the queue is empty both front and back need to be set.
		if (isEmpty()) {
			// True, so set front, back will be set outside the if statement.
			front = newElement;
		} else {
			// Queue isn't empty so only set to the back of the queue.
			back.setNext(newElement);
		}
		// Update the queue, so it takes into account the new element in the queue.
		back = newElement;
		back.setNext(null);
	}

	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print() {
		/*
         * Set a temporary QueueElement to the front QueueElement, so we are not
         * overriding data in the queue directly.
		 */
		QueueElement<T> thisElement = front;

		// Iterate over the queue and print out all the elements.
		while (thisElement != null) {
			System.out.println(thisElement.getElement());
			thisElement = thisElement.getNext();
		}
	}
}
