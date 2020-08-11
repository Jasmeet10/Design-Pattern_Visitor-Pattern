package arrayvisitors.visitors;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayList;

/***
 * visitor interface
 */
public interface Visitor {

    void visitMyArray(MyArray a);
    void visitMyArrayList(MyArrayList al);
}