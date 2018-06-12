
public class Verificador {
	
	String expression;
	String input;
	
	/**
	 * Função recursiva de analise 
	 * @param idxExp ponto de inicio da verificacao da expressao
	 * @param idxInput ponto de inicio da verificassao da frase a ser analisada
	 * @return true em caso de sucesso, false, em caso de erro encontrado
	 */
	private boolean find(int idxExp, int idxInput) {
		//Se estiver no fim da expressao...
		if(this.expression.charAt(idxExp) == '!') {
			if(this.input.charAt(idxInput) != '!') {//se nao tiver terminado de ler a input
				return false;
			}
			return true;
		}
		if(this.expression.charAt(idxExp+1) != '*') {//Caso do caracter simples
			if((this.expression.charAt(idxExp) == '.' && this.input.charAt(idxInput) != '!') || this.expression.charAt(idxExp) == this.input.charAt(idxInput)) {
				return find(idxExp+1, idxInput+1); //vai dar find no proximo e se deu volta true
			} else {
				return false;
			}
		} else { //caso tenhamos um loop
			int i = 0;
			while(!find(idxExp +2, idxInput+i)) { //Enquanto nao validar a funcao find, ou seja, comecar o find do proximo indice e averigua se esta de acordo com a regra de repetição
				if(this.input.charAt(idxInput+i) == '!') { //Se chegar ao fim sem validar, da errado
					return false;
				}
				if(this.expression.charAt(idxExp) == '.' || this.expression.charAt(idxExp) == this.input.charAt(idxInput + i)) { //verifica se ta aceitandoa proxima posicao caso ainda nao tenha encontrado quem deseja
					i++;
				} else {
					return false;
				}
			}
			return true;
		}
		
	}
	
	/**
	 * Função de verificação, que analisa se uma imput esta de acordo com as regras da expression
	 * @param input String a ser analisada
	 * @param expression Expressão de verificação da string
	 * @return true em caso de sucesso, false em caso de erro encontrado 
	 */
	public boolean verify(String input, String expression) {
		this.expression = expression + "!";
		this.input = input + "!";
		
		if (find(0,0)) {
			System.out.println("True");
			return true;
		} else {
			System.out.println("False");
			return false;
		}
		
	}

	public static void main(String[] args) {
		Verificador ver = new Verificador();
		ver.verify("aaaabaab", "a.*a*ab");
	}
}
