public class Odometer {

   int noOfDigits;

   Odometer(int n){
       this.noOfDigits = n;
   }

   String findSmallest(){
       String temp = "";
       for(int i = 1;i<=noOfDigits;i++){
           temp +=i;
       }
       return temp;
   }

   String findLargest(){
       String temp="";
       for(int i=9;i>9-noOfDigits;i--) {
           temp = i + temp;
       }
       return temp;
   }

   String findNext(String currentReading){

       StringBuilder temp = new StringBuilder();
       temp.append(currentReading);
       temp= temp.reverse();
       String nextReading = "";

       for(int i=0;i<temp.length();i++){

           int dig = Integer.parseInt(String.valueOf(temp.charAt(i)));
           //System.out.println(dig);
           if(dig<9-i){

               for(int j=i;j>=0;j--){
                   dig++;
                   temp = temp.replace(j,j+1,Integer.toString(dig));
               }
               nextReading = temp.reverse().toString();
               break;
           }
           if(i==temp.length()-1){
               nextReading = findSmallest();
           }
       }

       return nextReading;
   }

   int strictIncrSize(StringBuilder rev_reading, int index) {
       if(index>=rev_reading.length()-1 || rev_reading.charAt(index)!=rev_reading.charAt(index+1)+1) {
           return index+1;
       }
       else {
           return strictIncrSize(rev_reading,index+1);
       }

   }

   String findPrevious(String reading) {
       if(reading.equals(findSmallest()))
           return findLargest();
       StringBuilder rev_reading = new StringBuilder(getReversedString(reading));
       int strict_incr_size = strictIncrSize(rev_reading, 0);
       rev_reading.setCharAt(strict_incr_size-1, (char) (rev_reading.charAt(strict_incr_size-1)-1));
       rev_reading.replace(0, strict_incr_size-1, getReversedString(new Odometer(strict_incr_size-1).findLargest()));
       return rev_reading.reverse().toString();

   }
   String getReversedString(String st) {
	   return new StringBuilder(st).reverse().toString();
   }

   String nthNext(String currentReading, int noOfTimes){
       String result = currentReading;
       for(int i = 0;i<noOfTimes;i++){
           result = findNext(result);
       }
       return result;
   }

   String nthPrev(String currentReading, int noOfTimes){
       String result = currentReading;
       for(int i = 0;i<noOfTimes;i++){
           result = findPrevious(result);
       }

       return result;
   }

   int difference(String reading1, String reading2){
       int diff =0;
       String temp = reading1;
       while(!temp.equals(reading2)){
           temp = findNext(temp);
           diff++;
       }
       return diff;
   }
}