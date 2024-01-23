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

import java.util.ArrayList;

public class PathUtils extends Object {
    public PathUtils() {
    }

    /**
     * Finds the number of valid Paths between the given start and end Intersections. If it is not
     * possible to get from the start to the end intersection by moving up or right, then 0 should
     * be returned. For example, if start is Intersection(0, 0) and end is Intersection(2, 1),
     * this method should return 3. If start is Intersection(1, 0) and end is Intersection(0, 0),
     * this method should return 0.
     *
     * @param start Intersection to start at
     * @param end   Intersection to end at
     * @return the number of valid Paths which start and end at the given Intersections
     */
    public static int countPaths(Intersection start, Intersection end) {
        //base case 1, checks if the start is north or east from the end, returns 0 since you
        // cant move south or west
        if (start.getX() > end.getX() || start.getY() > end.getY()) {
            return 0;
        }
        //base case 2, if start and end are the same then there is one path
        if (start.getX() == end.getX() || start.getY() == end.getY()) {
            return 1;
        }
        //recursively make and count paths by stepping east and north
        return countPaths(start.goNorth(), end) + countPaths(start.goEast(), end);
    }

    /**
     * Finds all valid Paths between the given start and end Intersections. If it is not possible
     * to get from the start to the end intersection by moving up or right, then an empty ArrayList
     * should be returned.
     *
     * @param start Intersection to start at
     * @param end   Intersection to end at
     * @return an ArrayList containing all valid Paths which start and end at the given
     * Intersections
     */
    public static ArrayList<Path> findAllPaths(Intersection start, Intersection end) {
        ArrayList<Path> allPaths = new ArrayList<Path>();
        //base case 1, if start and end are equal then you return arraylist with the start/end
        if (start.equals(end)) {
            Path temp = new Path();
            temp.addTail(start);
            allPaths.add(temp);
            return allPaths;
        }
        // base case 2, if startX is greater than endX, return blank arraylist
        if (start.getX() > end.getX()) {
            return allPaths;
        }
        //base case 3, if startY is greater than endY, return blank arraylist
        if (start.getY() > end.getY()) {
            return allPaths;
        }
        // if start Y is less than end Y, create arraylist and findAllPaths from one point north
        // of start, add to the new arraylist, and then add new arraylist of paths to the main
        // arraylist
        if (start.getY() < end.getY()) {
            ArrayList<Path> vertPaths = findAllPaths(start.goNorth(), end);
            for (int i = 0; i < vertPaths.size(); i++) {
                vertPaths.get(i).addHead(start);
                allPaths.add(vertPaths.get(i));
            }
        }
        // if start x is less than endx, create arraylist and findAllPaths from one point east
        // of start, add to the new arraylist, and then add new arraylist of paths to the main
        // arraylist
        if (start.getX() < end.getX()) {
            ArrayList<Path> horizPaths = findAllPaths(start.goEast(), end);
            for (int i = 0; i < horizPaths.size(); i++) {
                horizPaths.get(i).addHead(start);
                allPaths.add(horizPaths.get(i));
            }
        }
        return allPaths;
    }
}
