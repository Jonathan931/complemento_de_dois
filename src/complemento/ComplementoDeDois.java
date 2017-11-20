package complemento;

public class ComplementoDeDois {

	private String entrada;
	private String saida;
	
	public ComplementoDeDois(String entrada) {
		super();
		this.entrada = entrada;
	}
	
	public String getSaida() {
		return saida;
	}

	public String getEntrada() {
		return entrada;
	}
	
	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}
	
	
	public void calculaBinarioDecimal (){
		int tamanho       = entrada.length()-1;
		String auxiliaSinal = new Character( entrada.charAt(0)).toString();
		int negativo      = 0;
		int positivo      = 0;
		int saida         = 0;
		//calcula negativo
		if (auxiliaSinal.equals("1")){
			negativo =   -1 * (int) Math.pow(2, tamanho);
		}
		//calcula positivo
		int potencia  = tamanho - 1;
		for (int i = 1; i <= tamanho ; i++){
			int numero = Integer.parseInt(new Character( entrada.charAt(i)).toString());
			positivo += numero * Math.pow(2, potencia);
			potencia --;
		}
		int resultado = negativo + positivo ;
		this.saida = Integer.toString(resultado);
		
		
	}

	
    /*Converte Binario para Decimal*/
    public void calculaDecimalBinario(){
        int valor1 = Integer.parseInt(entrada.replace("-", ""));
        String aux = "" ;
        while (valor1 >= 2){
            int resto = valor1 % 2;
            valor1 = valor1 / 2;
            aux += Integer.toString(resto); 

        }
        aux += Integer.toString(valor1) ;
        aux += "0";
        
        aux = new StringBuilder(aux).reverse().toString();
        
        String auxliarMudaBin="";
        for (int i =0 ; i < aux.length() ; i ++){
        	auxliarMudaBin += aux.charAt(i) == '1' ? '0' : '1';
        }  
        String saidaPos = aux;
        if (entrada.charAt(0) == '-'){
        	saidaPos = somaBinario(auxliarMudaBin); 

        }
        saida = saidaPos;
    }
    
    /* faz a soma binaria */
    public String somaBinario(String num1){  
        String num2 ="";
        for (int i = 0; i < num1.length()-1; i++ ){
       	 num2+= "0";
        }
        num2 += "1";
        int tamanho = num1.length()-1;
        int resto = 0;
        int i = tamanho ;
        StringBuilder resultado = new StringBuilder();
        int resultadoN;
        while ( i >= 0 ){
            resultadoN = Integer.parseInt((new Character(num1.charAt(i)).toString())) +  Integer.parseInt((new Character(num2.charAt(i)).toString())) + resto;
            resto = 0;
            if (resultadoN == 2){
                resultado.append('0');
                resto = 1; 
            }else if( resultadoN == 3 ){
                resultado.append('1');
                resto = 1;
            }else{
                resultado.append(Integer.toString(resultadoN));
            }
            
            if ((i-1) == -1 && resto == 1){
                resultado.append('1');
            }
            i--;
         }
    	  return resultado.reverse().toString();
    }
	

	
}
