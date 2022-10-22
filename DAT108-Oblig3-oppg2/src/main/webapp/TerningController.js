class TerningController {
	
 	#dice
 	#rootElement
 	/**
	 * @param {String} rootId
	 * 
	 */
		
   		constructor(rootElement) {
			this.#rootElement = rootElement;
			const dicebutton = this.#rootElement.querySelector("*[data-dicebutton]");
			if(dicebutton){
				
				this.#dice = new Terning();
				dicebutton.addEventListener("click",this.#rollDice.bind(this));
			}
			else{
				console.error("ingen knapp");
			}
		}
		
		#rollDice(){
			this.#dice.roll();
			const element = this.#rootElement.querySelector("*[data-diceoutput]");
			if(element){
				element.innerText = this.#dice.getValue();
			}else{
				console.error("ingen value");
			}
		}
	}
	
	function init() {
		new TerningController(document.getElementById("root"));
	} 
	
	document.addEventListener("DOMContentLoaded",init);