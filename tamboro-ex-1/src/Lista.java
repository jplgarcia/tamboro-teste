
public class Lista {

	private No inicio = new No();
	private No fim = inicio;
	
	Lista() {
		inicio.valor = 0;
		for (int i = 1; i < 40; i++) {
			addNo(i);
		}
	}
	
	class No
	{
		public int valor;
		public No proximo;
	}
	
	/**
	 * Cria um nó na lista
	 * @param valor
	 */
	public void addNo(int valor) {
		No novo = new No();
		novo.valor = valor;
		fim.proximo = novo;
		fim = novo;
	}
	
	/**
	 * Percorre a lista até a metade retornando o valor do elemento do meio
	 * @return o valor do elemento do meio da lista
	 */
	public int getElemntoDoMeio(){
	    No longo = inicio; //No de avanca de par em par e alcança o fim da lista
	    No curto = inicio; //No que avanca de 1 em 1 e conterá elemento do meio

	    while(longo != null && longo.proximo != null)
	    {
	        longo = longo.proximo.proximo;
	        curto = curto.proximo;
	    }

	    return curto.valor;
	}
	
	public static void main(String[] args) {
		Lista lista = new Lista();
		int elementoMedio = lista.getElemntoDoMeio();
		System.out.println("Elemento do meio: " + elementoMedio);
	}
	
}
