
class PairInts {
    private int first;
    private int second;

    public PairInts( int f, int s ) {
        first = f;
        second = s;
    }

    public int getFirst() { return first; }
    public int getSecond() { return second; }
    public void setFirst( int f ) { first = f; }
    public void setSecond( int s ) { second = s; }
    public String toString( ) { return String.format( "(%d,%d)", first, second ); }
}
