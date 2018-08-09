import java.io.*;
import java.util.*;

public class Main {
	 public static void main(String[] args) {
	        Odometer demo = new Odometer(3);
	        System.out.println(demo.findSmallest());
	       System.out.println(demo.findLargest());
	       System.out.println(demo.findNext("348"));
	       System.out.println(demo.nthNext("123",5));
	       System.out.println((demo.findPrevious("123")));
	       System.out.println(demo.nthPrev("123",4));
	       System.out.println(demo.difference("123","128"));
	   }

}
