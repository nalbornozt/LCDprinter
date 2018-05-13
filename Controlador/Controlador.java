package Controlador;

import javax.swing.JOptionPane;

import Modelo.LCD;

public class Controlador 
{
	private LCD lcd;
	/**
	 * Se inicializa el controlador y la clase lcd, pidiendo el tamaño de la impresión y el número a imprimir,
	 * son ingrezados por el usuario mediante in dialogo.
	 */
	public Controlador() 
	{
		int size = 0;
		String numeroIngresado = " ";
		do
		{
			// Ventana que pide el tamaño de la impresión y el número a imprimir
			String ingresado = JOptionPane.showInputDialog("Ingrese el tamaño de la impresión y el número a imprimir");
			// Verifica que la cadena ingresada contenga una coma
			if(!ingresado.contains(",")) 
			{
				//Si no contiene coma muestra un mensaje de error
				JOptionPane.showMessageDialog(null,"El formato ingresado es incorrecto","Error",JOptionPane.ERROR_MESSAGE);
			}
			else 
			{
				try 
				{
					// Se divide la cadena igresada en 2 usando la coma ","
					String [] input = ingresado.split(",");
					size = Integer.parseInt(input[0]);
					numeroIngresado = input[1];
					if(size<=10) 
					{
						lcd = new LCD(size,numeroIngresado);
					}
					else 
					{
						JOptionPane.showMessageDialog(null,"El tamaño ingresado es superior a 10","Error",JOptionPane.ERROR_MESSAGE);

					}
				}
				catch(NumberFormatException e) 
				{
					JOptionPane.showMessageDialog(null,"Por favor ingrese números","Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		}while(size != 0 && !numeroIngresado.equals("0")); 

	}
	
	public static void main(String[] args) 
	{
		Controlador controlador = new Controlador();
	}
}
