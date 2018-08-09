
public class Odometer {
	int noOfDigits;
    Odometer(int n){
        this.noOfDigits = n;
    }
    int findSmallest(){
        String temp = "";
        for(int i = 1;i<=noOfDigits;i++){
            temp +=i;
        }
        return Integer.parseInt(temp);
    }
    int findLargest(){
        String temp="";
        for(int i=9;i>9-noOfDigits;i--) {
            temp = i + temp;
        }
        return Integer.parseInt(temp);
    }
    int findNext(int currentReading){
        //String temp = Integer.toString(currentReading);
        StringBuilder temp = new StringBuilder();
        temp.append(currentReading);
        temp= temp.reverse();
        //System.out.println(temp);
        for(int i=0;i<temp.length();i++){
            int dig = Integer.parseInt(String.valueOf(temp.charAt(i)));
            System.out.println(dig);
            if(dig<9-i){
    
                //int dig = Integer.parseInt(String.valueOf(temp.charAt(i)))++;
                //System.out.println(dig);
                //temp.replace(i,i+1,) = (char)dig;
                for(int j=i-1;j>=0;j--){
                    //temp.charAt(j) = (char)++dig;
                }
            }
        }
        return Integer.parseInt(temp.reverse().toString());
    }
    String findPrevious(String reading) {
		StringBuilder rev_reading = new StringBuilder(reading).reverse();
		int strict_incr_size = strictIncrSize(rev_reading, 0);
		rev_reading.setCharAt(strict_incr_size-1, (char) (rev_reading.charAt(strict_incr_size-1)-1));
		return rev_reading.reverse().toString();
		
	}
	int strictIncrSize(StringBuilder rev_reading, int index) {
		if(index>=rev_reading.length()-1 || rev_reading.charAt(index)!=rev_reading.charAt(index+1)+1) {
			return index+1;
		}
		else {
			return strictIncrSize(rev_reading,index+1);
		}
		
	}

}
