package exercise2;

public class exercise2 {
	
	public static void main (String []args){
		
		Set<Character> cto1 = new Set<Character>(10);
		cto1.addElement('a');
		cto1.addElement('b');
		cto1.addElement('c');
		cto1.addElement('d');
		
		cto1.show();
				
		//cto1.deleteElement('c');
		cto1.show();
		
		if(cto1.belongsTo('d')){System.out.println("True");};
		
		Set<Character> cto2 = new Set<Character>(10);
		cto2.addElement('a');
		cto2.addElement('b');
		cto2.addElement('c');
		cto2.show();
		Set<Character> cto3 =(Set<Character>)( cto1.union(cto2) );
		cto3.show();
		
		System.out.println(cto2.isSubset(cto1));
		
		
		
	}//end main
	
	
	

}//end class
