//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    P06 City Route Planner
// Course:   CS 300 Fall 2022
//
// Author:   Akshay Gona
// Email:    gona@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:   Varun Munagala, Rishit Patil, Aitegin Akmatbekov, helped debug my code
// Online Sources:  github, stackoverflow, youtube videos on recursion
//
///////////////////////////////////////////////////////////////////////////////


/**
 * This class represents a single intersection point where two streets laid out on a grid plan
 * cross at specified x and y coordinate positions.
 */
public class Intersection extends Object {
    private final int x; //X-axis coordinate of this intersection
    private final int y; //Y-axis coordinate of this intersection

    /**
     * Initializes this intersection with the given coordinates
     *
     * @param x Horizontal position of this Intersection
     * @param y Vertical position of this Intersection
     */
    public Intersection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the horizontal position of this Intersection
     *
     * @return the horizontal position of this Intersection
     */
    public int getX() {
        return x;
    }

    /**
     * Returns the vertical position of this Intersection
     *
     * @return the vertical position of this Intersection
     */
    public int getY() {
        return y;
    }

    /**
     * Returns a coordinate-pair representation of this Intersection in the form "(x,y)"
     *
     * @return a coordinate-pair representation of this Intersection
     */
    @Override public String toString() {
        return "(" + x + "," + y + ")";
    }

    /**
     * Returns true if the given Object is identical to this Intersection
     *
     * @param o object to compare for equality
     * @return true if the given Object is an Intersection object which has the same x and y
     * coordinates as this Intersection
     */
    @Override public boolean equals(Object o) {
        return o instanceof Intersection && (((Intersection) o).getX() == this.getX()) && (
            ((Intersection) o).getY() == this.getY());
        //checks if o is an instance of intersection and also compares the x and y values of o when
        //casted to an intersection
    }

    /**
     * Creates a new Intersection instance which is one step directly above this Intersection.
     * Should not modify the original Intersection object.
     *
     * @return a new Intersection instance which is one step directly above this Intersection
     */
    public Intersection goNorth() {
        Intersection x1 = new Intersection(x, y + 1);
        return x1;
    }

    /**
     * Creates a new Intersection instance which is one step directly below this Intersection.
     * Should not modify the original Intersection object.
     *
     * @return a new Intersection instance which is one step directly below this Intersection
     */
    public Intersection goSouth() {
        Intersection x2 = new Intersection((x), y - 1);
        return x2;
    }

    /**
     * Creates a new Intersection instance which is one step directly to the right of this
     * Intersection object. Should not modify the original Intersection object.
     *
     * @return a new Intersection instance which is one step directly to the right of this
     * Intersection
     */
    public Intersection goEast() {
        Intersection x3 = new Intersection((x + 1), y);
        return x3;
    }

    /**
     * Creates a new Intersection instance which is one step directly to the left of this
     * Intersection. Should not modify the original Intersection object.
     *
     * @return a new Intersection instance which is one step directly to the left of this
     * Intersection
     */
    public Intersection goWest() {
        Intersection x4 = new Intersection((x - 1), y);
        return x4;
    }
}
