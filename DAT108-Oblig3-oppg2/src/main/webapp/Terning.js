class Terning{
	
#value;
	
 	roll(){
 		 this.#value = Math.floor(Math.random() * 6) + 1;
	}

 	getValue(){
		return this.#value;
	}
}