package Exercise9;

public class StackString<Character> extends Stack {
	
	char myArray[];
	
	public StackString (String inputString){
		
		//Hacemos un array de Character que va a contener a todo el string y va a guardar en cada posicion un caracter
		myArray = inputString.toCharArray();
		
		
	}//end constructor
	
	public boolean Result(){
		for(int a =0; a<myArray.length; a++){

			if( myArray[a] == '[' || myArray[a] == '{' || myArray[a] == '(' ){

				this.push(myArray[a]);
				

			}//end if
			else if(  myArray[a] == ']' || myArray[a] == '}' || myArray[a] == ')' )  {
				
//if( this.top().toString().equals("(")  || this.top().toString().equals("{") || this.top().toString().equals("[") ){
				if( (this.top().equals('(') && myArray[a] == ')')  || (this.top().equals('{') && myArray[a] == '}') || (this.top().equals('[') && myArray[a] == ']')  ){

					this.pop();
					
				}else{
					return false;
				}

			}

		}//end for

		return true;		
	}//End method
	
	
}
