public class Binary implements Comparable {

    private int _decNum;
    private String _binNum;

    public Binary() {
        _decNum = 0;
        _binNum = "0";}

    public Binary( int n ) {
        _decNum = n;
        _binNum = decToBinR(n);}

    public Binary( String s ) {
            _binNum = s;
            _decNum = binToDecR(s);}

    public String toString() {return _binNum;}

    public int getDec(){return _decNum;}

    public String getBin(){return _binNum;}

    public static String decToBin( int n ) {
  	String ans = "";
  	for (; n > 0; n/=2) {ans = (n%2) + ans;}
    return ans;}

    public static String decToBinR( int n ) {
        String ans = "";
        if (n != 0) {ans += decToBinR(n / 2)+(n % 2) ;}
        return ans;}

    public static int binToDec(String s){
      int a = 0;
      for (int i = 0;i< s.length();i++){
        a+= Integer.parseInt(s.substring(i,i+1))*Math.pow(2, s.length()-i-1);}
      return a;}

    public static int binToDecR( String s ) {
        int ans = 0;
        if (s.length() != 0) {ans += (Integer.parseInt(s.substring(0,1)) * Math.pow(2, s.length() - 1)) + binToDecR(s.substring(1));}
        return ans;}

    public boolean equals( Object other ) { return( this == other || compareTo(other) == 0 );}

    public int compareTo( Object other ) {
     if (other instanceof Comparable) {
         if (other instanceof Binary) {
       return _decNum - ((Binary)other).getDec();
     }
         else if (other instanceof Hexadecimal) {
       return _decNum - ((Hexadecimal)other).getDec();
         }
         else if (other instanceof Rational) {
           return _decNum * ((Rational)other).getD() -((Rational)other).getN();
       }
         }
     throw new ClassCastException("\ncompareTo() input not comparable\n");
       }

    //main method for testing
    public static void main( String[] args ) {
      Binary a = new Binary(23);
      Binary b = new Binary("1110");
      System.out.println(binToDec("10110"));
    }//end main()
} //end class
