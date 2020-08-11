package arrayvisitors.visitors;

public interface Element {
    /***
     * accept method for the visitor pattern
     * @param visitor
     */
    void accept(Visitor visitor);

}