package main.java.ull.etsii.modelado.clasificador.herramientas;

import main.java.ull.etsii.modelado.clasificador.modelo.Muestra;

/**
 * Clase que implenta el algoritmo de ordenaci�n QuickSort dise�ada
 * para la ordenaci�n de objetos de la clase Muestra.
 * @author Jos� Oliver Mart�nez Novo
 */
public class QSort 
{
	private Muestra[] m_Elementos;
	
	/**
	 * Contructor de la clase QSort que crea una instancia estableciendo los elementos a ordenar.
	 * @param elementos (Muestra[]) Array de objetos de la clase Muestra que se van a ordenar.
	 */
	public QSort(Muestra[] elementos)
	{
		this.setElementos(elementos);
	}

	/**
	 * Establece los elementos de la lista que se van a ordenar.
	 * @param elementos (Muestra[]) Array de muestras que se van a ordenar.
	 */
	public void setElementos(Muestra[] elementos) 
	{
		this.m_Elementos = elementos;
	}

	/**
	 * Obtiene los elementos de la lista. Estar�n ordenados si previamente
	 * se ha invocado a la funci�n QSort.ordenar().
	 * @return (Muestra[]) Array de muestras de la lista que contiene la clase.
	 */
	public Muestra[] getElementos() 
	{
		return m_Elementos;
	}
	
	/**
	 * @see void quickSort(int ini, int fin)
	 */
	public Muestra[] ordenar()
	{
		quickSort(0, m_Elementos.length - 1);
		return this.getElementos();
	}
	
	/**
	 * Algoritmo de ordenaci�n QuickSort basado en la ordenaci�n recursiva
	 * haciendo uso de un pivote. El Array se divide en dos usando dicho
	 * pivote y se intercambian los valores de una a la otra seg�n 
	 * sean estos mayores o menores que el pivote. Primero se ordenan los listas
	 * valores menores al pivote y despu�s los valores mayores.
	 * @param v (Muestra[]) Array de muestras que se desea ordenar.
	 * @param ini (int) Posici�n de inicio del vector. 
	 * @param fin (int) Posicion final del vector.
	 */
	private void quickSort(int ini, int fin)
	{
		int i = ini, f = fin;
		Muestra pivote = m_Elementos[ini], mTemp = null;
		while(i < f)
		{
			while((i <= fin) && (m_Elementos[i].isMenorOrIgual(pivote)))
			{
				i++;
			}
			while(m_Elementos[f].isMayor(pivote))
			{
				f--;
			}
			if(i < f)
			{
				mTemp = m_Elementos[i];
				m_Elementos[i] = m_Elementos[f];
				m_Elementos[f] = mTemp;
			}
		}
		mTemp = m_Elementos[f];
		m_Elementos[f] = m_Elementos[ini];
		m_Elementos[ini] = mTemp;
		if(ini < f-1)
		{
			quickSort(ini, f-1);
		}
		if(i < fin)
		{
			quickSort(i, fin);
		}
	}
	
}















