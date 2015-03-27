package exercise2;

public class Set<E> implements iSet<E> {
	
	E[] elements; //this is an array with the elements of the type <E> 
	int nextToAdd;
	
	
	//Constructor
	public Set(int arraySize ){
		
		if( arraySize <= 0 ) return; //it stops the constructor. Because its nothing
		
		this.elements = (E[]) new Object[arraySize];
		this.nextToAdd = 0;
		
	}//End constructor
	
	
	@Override
	public boolean isEmpty() {
		
		return (this.nextToAdd == 0)?true:false;	
		//ESto es equivalente a 
		/*
		 * if (this.nextToAdd == 0){
		 * return true;
		 * }else{
		 * return false;
		 * }
		 * 
		 * */
	}

	@Override
	public boolean belongsTo(E element) {
		
		for(int a = 0; a <this.nextToAdd; a ++){
			if(element.equals(this.elements[a])){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean addElement(E element) {
		
		if(this.nextToAdd == elements.length || this.belongsTo(element) ) {
			return false;
		}
		this.elements[nextToAdd] = element;
		this.nextToAdd++;
		return true;
	}

	@Override
	public boolean deleteElement(E element) {
	
		int i = 0;
		boolean deleted = false;
		
				
		while ( i<this.nextToAdd && deleted == false){
			
			if(element.equals(this.elements[i])){
			
			
			//hemos encontrado la posicion en la que coincide nuestro elemento	
				for(int j = i; j < nextToAdd-1; j++){
					//vamos desde la posicion que nos interesa hasta la que tenemos disponible para añadir -1 para que no nos pasemos de bound
					this.elements[j] = this.elements[j+1]; //vamos pasando hacia atrás los elementos
					System.out.println(this.elements[j]);
				}//end for
				
				this.nextToAdd--;
				deleted =true;
			}else{
				i++;
			}
			
			
			
		}//end while

		return deleted;
		//return false;
	}

	@Override
	public int cardinality() {
		//devuelve el numero de elementos en el set
		return this.nextToAdd;
	}

	@Override
	public boolean equal(iSet<E> otherSet) {
		
		//comprobamos primero si los dos set tienen las mismas dimensiones
		if(otherSet.cardinality() != this.cardinality()){
			return false;
		}
		
		//ahora comprobamos con un loop si todos los elementos de uno pertenecen a los elementos de otro
		for(int a = 0; a<this.nextToAdd; a++){
			
			//si el elemento actual del array elements NO se encuentra en el set otherSet, salta el false, los sets son diferentes
			if( otherSet.belongsTo(this.elements[a]) == false){
				return false;
			}
			
		}
		
		return true;
	}

	@Override
	public boolean isSubset(iSet<E> otherSet) {
		//en este caso no comprobamos que la longitud de los dos sets sea la misma. 
		//Partimos de uqe este
		
		for(int a = 0; a<this.nextToAdd; a++){
			//si el elemento actual del array elements NO se encuentra en el set otherSet, return false
			if( otherSet.belongsTo(this.elements[a]) == false){
				return false;
			}
		}
		
		
		return true;
	}

	@Override
	public boolean isSuperset(iSet<E> otherSet) {
		
		return otherSet.isSubset(this);
	}

	@Override
	public iSet<E> union(iSet<E> otherSet) {
		
		E[] array = otherSet.toArray();
		
		
		Set<E> newSet = new Set<E>(this.elements.length + array.length); //creamos un nuevo elemento Set que va a tener un length igual al de los dos set previos
		
		//loop para añadir todos los elementos del current set
		for(int a = 0; a<this.nextToAdd; a++){
			newSet.addElement(this.elements[a]);
		}
		
		//loop para añadir todos los elementos del array que viene del otherSet
		for(int a =0; a<array.length; a++){
			newSet.addElement(array[a]);
		}
		return newSet;
		
	}
	public void TESTING(){
		System.out.println("J");
	}
	public E[] toArray(){
		E[] array = (E[]) new Object[this.nextToAdd];
		for(int i=0; i<this.nextToAdd; i++){
			array[i] = this.elements[i];
		}
		return array;
	}

	@Override
	public iSet<E> intersection(iSet<E> otherSet) {
		
		iSet<E> newSet = new Set<E>(this.elements.length);
		
		for(int a = 0; a<this.nextToAdd; a++){
			newSet.addElement(this.elements[a]);
		}
		return newSet;
	}

	@Override
	public iSet<E> difference(iSet<E> otherSet) {

		Set<E> newSet = new Set<E>(this.elements.length);
		
		//Con este loop miramos si los elementos de this.elements pertenecen tambien a otherSet. Si es asi lo guardamos en newSet
		for(int a = 0; a<this.nextToAdd; a++){
			if(otherSet.belongsTo(this.elements[a])){
				newSet.addElement(this.elements[a]);
			}
		}
		
		return newSet;
	}

	
	public void show(){
		
		for(int a=0; a<this.nextToAdd; a++) {
			
			System.out.print(this.elements[a] + " ");
			
		}
		System.out.println();
		
	}
	
	
	
}//End class
