public class Hexadecimal implements Comparable {

    private int _decNum;
    private String _hexNum;
    private final static String HEXDIGITS = "0123456789ABCDEF";

    public Hexadecimal() {
        _decNum = 0;
        _hexNum = "0";
    }

    public Hexadecimal( int n ) {
        _decNum = n;
        _hexNum = decToHexR( n );
    }


    public String toString() {
        return (_hexNum);
    }

    // Accessor Methods
    public int getDec()
    {return _decNum;}

    public String getHex()
    {return _hexNum;}


    public static String decToHex( int n ) {
     	String ans = "";
     	for (; n > 0; n/=16) {
     	    ans = HEXDIGITS.substring(n%16, n%16 + 1) + ans;	}
     	return ans;
         }

    public static String decToHexR( int n ) {
      	if (n > 0) {
      	    return (decToHexR(n/16) + HEXDIGITS.substring(n%16, n%16 + 1) );      	}
      	else
      	    return "";}

    public static int hexToDec(String s){
        	int dec = 0;
        	for (int i = 0;i<s.length();i++){
        	    String digit=s.substring(i,i+1);
        	    int pow=(int)Math.pow(16, Math.abs(s.length()-i-1));
        	    dec+= (HEXDIGITS.indexOf(digit))*pow;}
        	return dec;}

    public static int hexToDecR(String s){
        	int dec = 0;
        	if (s.length()>=1){
        	    String digit=s.substring(0,1);
        	    int pow=(int)Math.pow(16, Math.abs(s.length()-1));
        	    dec+= (HEXDIGITS.indexOf(digit))*pow + hexToDecR(s.substring(1,s.length()));}
        	return dec;}

    public boolean equals( Object other ) {
           return (this==other || compareTo(other)==0);}

           public int compareTo( Object other ) {
          	if (other instanceof Comparable) {
          	    if (other instanceof Binary) {
          		return _decNum - ((Binary)other).getDec();}
          	    else if (other instanceof Hexadecimal) {
          		return _decNum - ((Hexadecimal)other).getDec();
          	    }
          	    else if (other instanceof Rational) {
          		    return _decNum * ((Rational)other).getD() -((Rational)other).getN();
          		}
          	    }
          	throw new ClassCastException("\ncompareTo() input not comparable\n");
              }

    public static void main( String[] args ) {

System.out.println(hexToDec("10FD"));
    }//end main()

} //end class
