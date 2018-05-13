package JUnit;
import Modelo.LCD;
import junit.framework.TestCase;

public class TestLCD extends TestCase
{
	private LCD lcd;
	
	// Métodos que inicializan escenarios de casos de prueba
	/**
	 * Se inicializa el escenario cuando el tamaño es 1 y el número a imprimir es 1234567890
	 */
	public void setupEscenario1() 
	{
		lcd = new LCD(1,"1234567890");
	}
	/**
	 * Se inicializa el escenario cuando el tamaño es 10 y el número a imprimir es 1234567890
	 */
	public void setupEscenario2() 
	{
		lcd = new LCD(10,"1234567890");	
	}
	/**
	 * Se inicializa el escenario cuando el tamaño es 11 y el número a imprimir es 1234567890
	 */
	public void setupEscenario3() 
	{
		lcd = new LCD(11,"1234567890");
	}
	
	//Se realizan las pruebas
	 public void testFabricarMatriz() 
	 {
		 setupEscenario1();
		 assertEquals(3,lcd.getNumeroColumnasDigito());
		 assertEquals(5,lcd.getNumeroFilasDigito());
		 assertEquals(39,lcd.getNumeroColumnasMatriz());
		 assertEquals(5,lcd.getNumeroFilasMatriz());
		 
		 setupEscenario2();
		 assertEquals(12,lcd.getNumeroColumnasDigito());
		 assertEquals(23,lcd.getNumeroFilasDigito());
		 assertEquals(129,lcd.getNumeroColumnasMatriz());
		 assertEquals(23,lcd.getNumeroFilasMatriz());
		 
		 setupEscenario3();
		 assertEquals(0,lcd.getNumeroColumnasDigito());
		 assertEquals(0,lcd.getNumeroFilasDigito());
		 assertEquals(0,lcd.getNumeroColumnasMatriz());
		 assertEquals(0,lcd.getNumeroFilasMatriz());
		 
	 }
}
