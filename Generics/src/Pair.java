public class Pair<T, P> {
    private T first;
    private P second;

    public Pair( T f, P s ) {
        first = f;
        second = s;
    }

    public T getFirst() { return first; }
    public P getSecond() { return second; }
    public void setFirst( T f ) { first = f; }
    public void setSecond( P s ) { second = s; }
    public String toString( ) { return "(" + first + ", " + second + ")"; }
}
