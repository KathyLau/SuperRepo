public class SuperArray  {

    private Comparable[] _data;
		private int _lastPos;//position of last meaningful value
		private int _size;//size of this instance of SuperArray

    public SuperArray() {
    _data = new Comparable[10];
    _lastPos=-1;
    _size = 0; }

    public String toString() {
    String retS="[";
    for (int i=0; i<_size;i++){retS+=_data[i]+ ",";}
    if (retS.length()>1){retS=retS.substring(0, retS.length()-1);}
    retS+="]";
    return retS;}

    private void expand() {
    Comparable[] _data2=new Comparable[_data.length*2];
    for (int i =0; i < _data.length; i++){_data2[i]=_data[i];}
      _data=_data2;}

    public Comparable get( int index ) {return _data[index];}

    public Comparable set( int index, Comparable newVal ) {
      Comparable temp = _data[index];
      _data[index]=newVal;
      return temp;}

  public void add( Comparable val ) {add_at_index(_size, val);}
    //inserts an item at index
  public void add_at_index( int index, Comparable newVal ) {
       if(index>_size){System.out.println("Error");}
       else{
         if (_size+1>_data.length) {expand();}
         Comparable temp = newVal;
         for (int i=_size;i>=index;i--){temp=set(index, temp);}
        _size++;
        _lastPos++;}}

  //removes the item at index
  //shifts elements left to fill in newly-empted slot
  public void remove( int index ) {
   if (index<_size ){
     for (int i=index;i<_lastPos;i++){_data[i]=_data[i+1];}
    _size--;
    _lastPos--;}}

  //return number of meaningful items in _data
  public int size() {return _size;}

 public int linSearch(Comparable target){
	for (int i = 0; i < _size; i++){
    if (target.equals( get(i) )) return i;}
	return -1;}

//MORE EFFICIENT SEARCH FOR SORTED ARRAYS
public int sortSearch(Comparable target){
  int low = 0; int hi = _lastPos; int index = (low+hi)/2;
  while (low < hi ){
    if (get(index).equals(target)){return index;}
    else if (target.compareTo(get(index))<0){hi = index-1;}
    else //if (target.compareTo(get(index))>0)
    {low=index+1;}
  index=(low+hi)/2;}
  if (hi >low){return -1;}
return index;}

    public boolean isSorted(){
	for (int i = 1; i < _size; i++){
    if ( _data[i].compareTo(_data[i-1]) < 0 )
    return false;}
	return true;}


    public static void main( String[] args ) {
           System.out.println("Testing constructors...");
           SuperArray  a = new SuperArray();
     	Binary b = new Binary(20);
     	Hexadecimal h1 = new Hexadecimal(21);
     	Hexadecimal h2 = new Hexadecimal(17);
     	Rational r1 = new Rational(50,2);
     	Rational r2 = new Rational(38,2);
     	Rational r3 = new Rational(44,2);
     	a.add(h2);
     	a.add(r2);
     	a.add(b);
     	a.add(h1);
     	a.add(r3);
     	a.add(r1);
     	System.out.println(a);
     	//System.out.println(a.linSearch(b));
     	//System.out.println(a.linSearch(r3));
     	if (!(a.isSorted())){
     	System.out.println(a.linsearch(b));}
     	else{System.out.println(a.sortSearch(b));}
       }//end main

}//end class
