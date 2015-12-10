public class Rational implements Comparable{
    // Instance Variables
    private int _n;
    private int _d;

    // Constructors
    public Rational()
    {_n = 0;
      _d = 1;    }

    public Rational(int n, int d)
    {
        this();
        if (d != 0)
        {
            _n = n;
            _d = d;
        }
        else
            System.out.println("Invalid. Fraction set to 0 / 1");
    }

    // Accessor Methods
    public int getN()
    { return _n; }

    public int getD()
    {  return _d; }

    // Override toString() Method
    public String toString()
    {
        return (  _n + " / " + _d);
    }

    // Float Value Method
    public double floatValue()
    {return (1.0*_n / _d);
    }

    // Multiply Method
    public void multiply(Rational fraction)
    {
        _n *= fraction.getN();
        _d *= fraction.getD();
    }

    // Divide Method
    public void divide(Rational fraction)
    {
        if ( fraction.getN() != 0 )
        {
            _n *= fraction.getD();
            _d *= fraction.getN();
        }
        else
            System.out.println("Divide by Zero error.");
    }

    public void add(Rational fraction)
    {
          _n = ( ( _n * fraction.getD() ) + ( fraction.getN() * _d ) );
          _d = ( _d * fraction.getD() );
    }

    public void subtract(Rational fraction)
    {
            _n = ( ( _n * fraction.getD() ) - ( fraction.getN() * _d ) );
            _d = ( _d * fraction.getD() );
    }

    // Reduce Method
    public void reduce()
    {
      int n = gcd();
        if ( n != 1 )
        {    _n /= n;
            _d /= n;  }
    }


    public int gcd()
    {
				return gcd(_n, _d);
    }


    public static int gcd( int a, int b )
    {
        while ( b != 0 ) {
            int tmp = b;
            b = a % b;
            a = tmp;  }
        return a;
				/*alt (same algo, recursively):
					if ( b == 0 )
					return a;
					else
					return gcder( b, a % b );
				*/
    }


    // Compare To Method

    public int compareTo( Object other ) {
     if (other instanceof Comparable) {
         if (other instanceof Binary) {
       return (int)floatValue() - ((Binary)other).getDec();}
         else if (other instanceof Hexadecimal) {
       return (int)floatValue() - ((Hexadecimal)other).getDec();
         }
         else if (other instanceof Rational) {
           return (_n * ((Rational)other).getD()) -(_d*((Rational)other).getN());
       }
         }
     throw new ClassCastException("\ncompareTo() input not comparable\n");
       }

// Equals Method
public boolean equals(Object other){return ( (this == other) || (compareTo(other)==0));}

    public static void main(String[] args){
      Rational r = new Rational(-1,3);
    //  Tile s = new Tile("hi");
Rational s = new Rational(-2,6);
System.out.println(r.equals(s));
    }
}
