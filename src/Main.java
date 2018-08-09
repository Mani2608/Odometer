import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Odometer demo = new Odometer(4);
        System.out.println(demo.findSmallest());
        System.out.println(demo.findLargest());
        System.out.println(demo.findNext(123));
    }

}
