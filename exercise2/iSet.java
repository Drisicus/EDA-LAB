package exercise2;

public interface iSet<E> {

	boolean isEmpty();
	boolean belongsTo(E element);
	boolean addElement(E element);
	boolean deleteElement(E element);
	int cardinality();
	boolean equal(iSet<E> otherSet);
	boolean isSubset(iSet<E> otherSet);
	boolean isSuperset(iSet<E> otherSet);
	
	E[] toArray();
	//void show();
	
	iSet<E> union(iSet<E> otherSet);
	iSet<E> intersection(iSet<E> otherSet);
	iSet<E> difference(iSet<E> otherSet);
	
	
}//end interface 
