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

/**
 * Tester class for PathUtils
 */
public class PathUtilsTester extends Object {
    /**
     * Constructor for PathUtilsTester
     */
    public PathUtilsTester() {
    }

    /**
     * Tests the case of countPaths() when there are no valid Paths. For example, when the
     * start position is Intersection(1, 1) and the ending position is Intersection(0, 1),
     * there should be no valid Paths, so countPaths() should return 0.
     *
     * @return true if all test cases are passed
     */
    public static boolean testCountPathsNoPath() {
        Intersection start = new Intersection(1, 1);
        Intersection end = new Intersection(0, 1);
        //if the start is north or east of end, then thhis method shouldnt work
        if (PathUtils.countPaths(start, end) != 0) {
            System.out.println("testCountPathsNoPath fails");
            return false;
        }
        return true;
    }

    /**
     * Tests the case of countPaths() when there is a single valid Path. For example, when the
     * start position is Intersection(1, 1) and the ending position is Intersection(1, 2), there
     * should be a single Path, so countPaths() should return 1.
     *
     * @return true if all test cases are passed
     */
    public static boolean testCountPathsOnePath() {
        Intersection start = new Intersection(1, 1);
        Intersection end = new Intersection(1, 2);
        // only one possible path, which moves one way, if countpaths is wrong, than the method
        // returns false
        if (PathUtils.countPaths(start, end) != 1) {
            System.out.println("testCountPathsOnePath fails");
            return false;
        }
        return true;
    }

    /**
     * Tests the case of countPaths() when there are multiple possible paths. For example, when
     * the start position is Intersection(0, 0) and the ending position is Intersection(1, 2),
     * there should be three possible Paths, so countPaths() should return 3.
     *
     * @return true if all test cases are passed
     */
    public static boolean testCountPathsRecursive() {
        Intersection start = new Intersection(0, 0);
        Intersection end = new Intersection(1, 2);
        //checks if the number of paths should return 3, and if it doesn't, then countPaths method
        //is implemented wrong
        if (PathUtils.countPaths(start, end) != 3) {
            System.out.println("testCountPathsRecursive fails");
            return false;
        }
        return true;
    }

    /**
     * Tests the case of findAllPaths() when there are no valid Paths. For example, when the
     * start position is Intersection(1, 1) and the ending position is Intersection(0, 1),
     * there should be no valid Paths, so findAllPaths() should return an empty ArrayList.
     *
     * @return true if all test cases are passed
     */
    public static boolean testFindAllPathsNoPath() {
        Intersection start = new Intersection(1, 1);
        Intersection end = new Intersection(0, 1);
        // should return an empty arraylist, since the start is east of the end.
        return PathUtils.findAllPaths(start, end).isEmpty();
    }

    /**
     * Tests the case of findAllPaths() when there is a single valid Path. For example, when the
     * start position is Intersection(1, 1) and the ending position is Intersection(1, 2), there
     * should be a single Path. For each of your cases, ensure that there is only a single path,
     * and that the Path exactly matches what you expect to see.
     *
     * @return true if all test cases are passed
     */
    public static boolean testFindAllPathsOnePath() {
        Intersection start = new Intersection(1, 1);
        Intersection end = new Intersection(1, 2);
        ArrayList<Path> p = PathUtils.findAllPaths(start, end);
        //checks if the size is 1, since if there are more, then it is wrong
        if (p.size() != 1) {
            return false;
        }
        //returns a boolean value which is whether the first element equals the expected output.
        return p.get(0).toString().equals("(1,1)->(1,2)");
    }

    /**
     * Tests the case of findAllPaths() when there are multiple possible paths. For example,
     * when the start position is Intersection(0, 0) and the ending position is Intersection(1, 2),
     * there should be three possible Paths. For each of your cases, ensure that there is both the
     * correct number of Paths, and that the returned Paths exactly match what you expect to see.
     * Remember: The order the Paths appear in the output of findAllPaths() will not necessarily
     * match your own implementation.
     *
     * @return true if all test cases are passed
     */
    public static boolean testFindAllPathsRecursive() {
        Intersection start = new Intersection(0, 0);
        Intersection end = new Intersection(1, 2);
        ArrayList<Path> p = PathUtils.findAllPaths(start, end);
        String path1 = "(0,0)->(0,1)->(0,2)->(1,2)";
        String path2 = "(0,0)->(0,1)->(1,1)->(1,2)";
        String path3 = "(0,0)->(1,0)->(1,1)->(1,2)";
        //checks  if size is 3, since it would be wrong if there are more or less
        if (p.size() != 3) {
            return false;
        }
        // uses for loop to check and return a boolean value which is whether each element equals
        // the expected output.
        for (int i = 0; i < p.size(); i++) {
            if (!(p.get(i).toString().equals(path1) || p.get(i).toString().equals(path2) || p.get(i)
                .toString().equals(path3))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Main method executes all the tester methods, reveals which method is incorrect or correct
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(testCountPathsNoPath());
        System.out.println(testCountPathsOnePath());
        System.out.println(testCountPathsRecursive());
        System.out.println(testFindAllPathsNoPath());
        System.out.println(testFindAllPathsOnePath());
        System.out.println(testFindAllPathsRecursive());
    }
}
