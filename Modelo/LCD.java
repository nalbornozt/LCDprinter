package Modelo;
import javax.swing.JOptionPane;

public class LCD 
{
	// Atributos
	//El caracter que se va a imprimir cuando sea vertical
	public static final String caracterVertical  = "|";
	
	//El caracter que se va a imprimir cuando sea horizontal
	public static final String caracterHorizontal  = "-";
	//El n�mero de columnas que va a tener la matriz que se va a imprimir
	private int numeroColumnasMatriz;
	//El n�mero de filas que va a tener la matriz que se va a imprimir
	private int numeroFilasMatriz;
	//El n�mero de filas que va a tener cada d�gito
	private int numeroFilasDigito;
	//El n�mero de columnas que va a tener cada d�gito
	private int numeroColumnasDigito;
	//La matriz que va a contener los caracteres horizontales y verticales de todos los d�gitos ingresados
    private String [][] matriz;
	//El pivote indica en que columna se va a empezar a imprimir el d�gito
	private int pivoteColumna;
	//Entero que indica el tama�o de la impresi�n
	private int size;
	
	private String numeroIngresado;
	
	/**
	 * El constructor de la clase LCD, este inicializa el pivote de la columnna, 
	 * el tama�o de la impresi�n y el n�mero ingresado
	 * @param pSize el tama�o de la impresi�n
	 * @param pNumeroIngresado el n�mero a imprimir
	 */
	public LCD(int pSize, String pNumeroIngresado) 
	{
		// Pivote en la columna 0, es donde se va a empezar a escribir el primer d�gito
		pivoteColumna = 0;
		size = pSize;
		if(size <=10) 
		{
			numeroIngresado = pNumeroIngresado;
			fabricarMatriz(size, numeroIngresado.length());
			char[] arrayListNumeroIngresado = numeroIngresado.toCharArray();
			procesarNumero(arrayListNumeroIngresado);
			imprimirNumeros();
			pivoteColumna=0;
		}
	}
	
	/**
	 * Este m�todo es el encargado de leer todos los n�meros del arreglo pArray y ubicarlos en la matriz 
	 * @param pArray Arreglo que contiene los n�meros que se van a imprimir
	 */
	public void procesarNumero(char[] pArray) 
	{
		for (int i=0 ;i<pArray.length;i++) 
		{
			char actual = pArray[i];
			// Si el n�mero es igual a 0, entonces se imprimen las secciones 1,2,3,4,5 y 6
			if(actual == '0') 
			{
				imprimirSeccion(1);
				imprimirSeccion(2);
				imprimirSeccion(3);
				imprimirSeccion(4);
				imprimirSeccion(5);
				imprimirSeccion(6);
			}
			// Si el n�mero es igual a 1, entonces se imprimen las secciones 1 y 6
			if(actual == '1') 
			{
				imprimirSeccion(1);
				imprimirSeccion(6);
			}
			// Si el n�mero es igual a 2, entonces se imprimen las secciones 2,3,4,5,6 y 7
			else if (actual == '2') 
			{
				imprimirSeccion(2);
				imprimirSeccion(3);
				imprimirSeccion(7);
				imprimirSeccion(6);
				imprimirSeccion(5);
			}
			// Si el n�mero es igual a 3, entonces se imprimen las secciones 2,3,4,5 y 7
			else if (actual == '3') 
			{
				imprimirSeccion(2);
				imprimirSeccion(3);
				imprimirSeccion(7);
				imprimirSeccion(4);
				imprimirSeccion(5);
			}
			// Si el n�mero es igual a 4, entonces se imprimen las secciones 1,3,4 y 7
			else if (actual == '4') 
			{
				imprimirSeccion(1);
				imprimirSeccion(7);
				imprimirSeccion(3);
				imprimirSeccion(4);
			}
			// Si el n�mero es igual a 5, entonces se imprimen las secciones 1,2,4,5 y 7
			else if (actual == '5') 
			{
				imprimirSeccion(2);
				imprimirSeccion(1);
				imprimirSeccion(7);
				imprimirSeccion(4);
				imprimirSeccion(5);
			}
			// Si el n�mero es igual a 6, entonces se imprimen las secciones 1,2,4,5,6 y 7
			else if (actual == '6') 
			{
				imprimirSeccion(2);
				imprimirSeccion(1);
				imprimirSeccion(7);
				imprimirSeccion(4);
				imprimirSeccion(5);
				imprimirSeccion(6);
			}
			// Si el n�mero es igual a 7, entonces se imprimen las secciones 2,3 y 4
			else if (actual == '7') 
			{
				imprimirSeccion(2);
				imprimirSeccion(3);
				imprimirSeccion(4);
			}
			// Si el n�mero es igual a 8, entonces se imprimen las secciones 1,2,3,4,5,6 y 7
			else if (actual == '8') 
			{
				imprimirSeccion(1);
				imprimirSeccion(2);
				imprimirSeccion(3);
				imprimirSeccion(4);
				imprimirSeccion(5);
				imprimirSeccion(6);
				imprimirSeccion(7);
			}
			// Si el n�mero es igual a 9, entonces se imprimen las secciones 1,2,3,4,5 y 7
			else if (actual == '9') 
			{
				imprimirSeccion(1);
				imprimirSeccion(2);
				imprimirSeccion(3);
				imprimirSeccion(4);
				imprimirSeccion(5);
				imprimirSeccion(7);
			}
			// se aumenta el pivote, el n�mero de columnas + 1 , el 1 representa el espacio en blanco entre dos n�meros
			pivoteColumna = pivoteColumna + numeroColumnasDigito+1;
		}
	}
	/**
	 * Este m�todo fabrica la matriz que se va a imprimir, se calculan las filas y columnas por d�gito.
	 * En base a los valores anteriores se calcula el tama�o de la matriz que va a contener los n�meros
	 * @param pSize El tama�o a imprimir.
	 * @param pTamanoNumero El n�mero de d�gitos que contiene el n�mero a imprimir.
	 */
	public void fabricarMatriz(int pSize,int pTamanoNumero) 
	{
		// Calcula el n�mero de filas por d�gito
		this.numeroFilasDigito = (pSize*2) + 3; 
		// Calcula el n�mero de columnas por d�gito
		this.numeroColumnasDigito = pSize + 2;
		// Calcula el n�mero total de filas de la matriz a imprimir
		this.numeroFilasMatriz = this.numeroFilasDigito;
		// Calcula el n�mero total de columnas de la matriz a imprimir
		this.numeroColumnasMatriz =  (this.numeroColumnasDigito * pTamanoNumero) + pTamanoNumero - 1;
		
		this.matriz = new String [numeroFilasMatriz][numeroColumnasMatriz];
		
		for (int i = 0; i<numeroFilasMatriz;i++) 
		{
			for (int j = 0; j<numeroColumnasMatriz;j++) 
			{
				matriz[i][j]= " ";
			}
		}	
	}
	/**
	 * Este es el m�todo que ubica los caracteres "-" y "|" dependiendo de la seccion
	 * @param pSeccion Representa la secci�n que se va a imprimir
	 * Cada n�mero representa una secci�n, ej: la secci�n 1 es la parte superior, la 7 la parte del medio y la 5 la parte inferior.
	 *  (2)--
	 * (1)|  |(3)
	 *    |  |
	 *  (7)--
	 * (6)|  |(4)
	 *    |  |
	 *  (5)--
	 */
	public void imprimirSeccion(int pSeccion) 
	{
		// Se calcula el n�mero de filas que hay por secci�n
		int numeroFilasPorSeccion = (int) Math.floor(numeroFilasDigito/2);
		// Se calcula el n�mero de columnas que hay por secci�n
		int numeroColumnasPorSeccion = (int) Math.floor(numeroColumnasDigito/2);
		// imprime la secci�n 1
		if(pSeccion == 1) 
		{
			for(int i=1;i<numeroFilasPorSeccion;i++) 
			{
				matriz[i][pivoteColumna]=caracterVertical;				
			}
		}
		// imprime la secci�n 2
		else if(pSeccion == 2) 
		{
			for(int i=pivoteColumna+1;i<( pivoteColumna + numeroColumnasDigito -1);i++) 
			{
				matriz[0][i]=caracterHorizontal;	
			}
		}
		// imprime la secci�n 3
		else if(pSeccion == 3) 
		{
			for(int i=1;i<numeroFilasPorSeccion;i++) 
			{
				matriz[i][pivoteColumna+(numeroColumnasDigito-1)]=caracterVertical;				
			}
		}
		// imprime la secci�n 4
		else if(pSeccion == 4) 
		{
			for(int i=numeroFilasPorSeccion+1;i<(numeroFilasPorSeccion*2);i++) 
			{
				matriz[i][pivoteColumna+(numeroColumnasDigito-1)]=caracterVertical;				
			}
		}
		// imprime la secci�n 5
		else if(pSeccion == 5) 
		{
			for(int i=pivoteColumna+1;i<(pivoteColumna + numeroColumnasDigito -1);i++) 
			{
				matriz[numeroFilasMatriz-1][i]=caracterHorizontal;	
			}
		}
		// imprime la secci�n 6
		else if(pSeccion == 6) 
		{
			for(int i=numeroFilasPorSeccion+1;i<(numeroFilasPorSeccion*2);i++) 
			{
				matriz[i][pivoteColumna]=caracterVertical;				
			}
		}
		// imprime la secci�n 7
		else if(pSeccion == 7) 
		{
			for(int i=pivoteColumna+1;i<(pivoteColumna + numeroColumnasDigito -1);i++) 
			{
				matriz[(int) Math.floor(numeroFilasDigito/2)][i]=caracterHorizontal;	
			}
		}
	}
	/**
	 * Este m�todo se encarga de imprimir la matriz con los n�meros
	 */
	public void imprimirNumeros()
	{
		for (int i = 0; i<numeroFilasMatriz;i++) 
		{
			for (int j = 0; j<numeroColumnasMatriz;j++) 
			{
				System.out.print(matriz[i][j]);
			}
			System.out.println(" ");
		}	
	}
	
	//setters y getters
	public int getNumeroColumnasMatriz() {
		return numeroColumnasMatriz;
	}
	public void setNumeroColumnasMatriz(int numeroColumnasMatriz) {
		this.numeroColumnasMatriz = numeroColumnasMatriz;
	}
	public int getNumeroFilasMatriz() {
		return numeroFilasMatriz;
	}
	public void setNumeroFilasMatriz(int numeroFilasMatriz) {
		this.numeroFilasMatriz = numeroFilasMatriz;
	}
	public int getNumeroFilasDigito() {
		return numeroFilasDigito;
	}
	public void setNumeroFilasDigito(int numeroFilasDigito) {
		this.numeroFilasDigito = numeroFilasDigito;
	}
	public int getNumeroColumnasDigito() {
		return numeroColumnasDigito;
	}
	public void setNumeroColumnasDigito(int numeroColumnasDigito) {
		this.numeroColumnasDigito = numeroColumnasDigito;
	}
	public String[][] getMatriz() {
		return matriz;
	}
	public void setMatriz(String[][] matriz) {
		this.matriz = matriz;
	}
	public int getPivoteColumna() {
		return pivoteColumna;
	}
	public void setPivoteColumna(int pivoteColumna) {
		this.pivoteColumna = pivoteColumna;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getNumeroIngresado() {
		return numeroIngresado;
	}
	public void setNumeroIngresado(String numeroIngresado) {
		this.numeroIngresado = numeroIngresado;
	}
	
}
