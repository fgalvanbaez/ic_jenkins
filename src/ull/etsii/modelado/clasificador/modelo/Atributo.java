package ull.etsii.modelado.clasificador.modelo;

/**
 * Clase utilizada para almacenar todos los atributos de una muestra.
 * @author José Oliver Martínez Novo
 *
 */
public class Atributo
{
	private String mTitulo;
	private Double mMinValue;
	private Double mMaxValue;
	private Double mPeso;
	private Double mMedia;
	private Double mDesviacionTipica;
	private Double mSumaDesviacionTipica;
	private Double mValue;
	
	/**
	 * Constructor que crea una instancia de la clase asignandole un valor.
	 * @param value (Double) Representa el valor del atributo.
	 */
	public Atributo(double value)
	{
		this(null, value);
	}
	
	/**
	 * Constructor que crea una instancia de la clase asignandole titulo y valor.
	 * @param titulo (String) Cadena que representa el nombre del atributo.
	 * @param value (Double) Representa el valor del atributo.
	 */
	public Atributo(String titulo, double value)
	{
		this.setTitulo(titulo);
		this.setPeso(1D);
		this.setValue(value);
	}

	/**
	 * Establece el título del atributo.
	 * @param titulo (String) Cadena que representa el titulo del atributo.
	 */
	public void setTitulo(String titulo) 
	{
		this.mTitulo = titulo;
	}

	/**
	 * Obtiene el título del atributo.
	 * @return (String) Cadena que representa el titulo del atributo.
	 */
	public String getTitulo() 
	{
		return mTitulo;
	}

	/**
	 * Establece el valor mínimo que toma el atributo en el conjunto de muestras.
	 * @param (Double) minValue  Representa el valor mínimo a establecer.
	 */
	public void setMinValue(Double minValue) 
	{
		this.mMinValue = minValue;
	}

	/**
	 * Obtiene el valor mínimo que toma el atributo en el conjunto de muestras.
	 * @return (Double) Valor mínimo del atributo
	 */
	public Double getMinValue() 
	{
		return mMinValue;
	}

	/**
	 * Establece el valor máximo que toma el atributo en el conjunto de muestras.
	 * @param (Double) maxValue Representa el valor máximo a establecer.
	 */
	public void setMaxValue(Double maxValue)
	{
		this.mMaxValue = maxValue;
	}

	/**
	 * @param mPeso the mPeso to set
	 */
	public void setPeso(Double mPeso) {
		this.mPeso = mPeso;
	}

	/**
	 * @return the mPeso
	 */
	public Double getPeso() {
		return mPeso;
	}

	/**
	 * Obtiene el valor máximo que toma el atributo en el conjunto de muestras.
	 * @return (Double) Valor máximo del atributo
	 */
	public Double getMaxValue()
	{
		return mMaxValue;
	}

	/**
	 * @param mMedia the mMedia to set
	 */
	public void setMedia(Double mMedia) {
		this.mMedia = mMedia;
	}

	/**
	 * @return the mMedia
	 */
	public Double getMedia() {
		return mMedia;
	}

	/**
	 * @param mDesviacionTipica the mDesviacionTipica to set
	 */
	public void setDesviacionTipica(Double mDesviacionTipica) 
	{
		this.mDesviacionTipica = mDesviacionTipica;
	}

	/**
	 * @return the mDesviacionTipica
	 */
	public Double getDesviacionTipica() 
	{
		return mDesviacionTipica;
	}

	/**
	 * @param mSumaDesviacionTipica the mSumaDesviacionTipica to set
	 */
	public void setSumaDesviacionTipica(Double mSumaDesviacionTipica) {
		this.mSumaDesviacionTipica = mSumaDesviacionTipica;
	}

	/**
	 * @return the mSumaDesviacionTipica
	 */
	public Double getSumaDesviacionTipica() {
		return mSumaDesviacionTipica;
	}

	/**
	 * Establece el valor del atributo.
	 * @param value (Double) Valor del atributo que se va a establecer.
	 */
	public void setValue(Double value) 
	{
		this.mValue = value;
	}

	/**
	 * Obtiene el valor del atributo.
	 * @return (Double) Valor del atributo.
	 */
	public Double getValue() 
	{
		return mValue;
	}
	
	/**
	 * Función que normaliza el valor atributo en un rango entre 0 y 1 en función
	 * de los valores máximo y mínimo que tenga el atributo.
	 * @return (Atributo) Instancia actual normalizada.
	 */
	public Atributo normalizar()
	{
		if((this.getMinValue() != null) && (this.getMaxValue() != null))
		{
			this.setValue((this.getValue() - this.getMinValue()) / (this.getMaxValue() - this.getMinValue()));
			mIsNormalizado = true;
			mIsEstandarizado = false;
		}
		return this;
	}
	
	/**
	 * Normaliza la desviación tipica del atributo en un rango 0-1.
	 * @param minValue valor minimo
	 * @param maxValue valor maximo
	 * @return this
	 */
	public Atributo normalizarDesviacionTipica(Double minValue, Double maxValue)
	{
		if(this.getDesviacionTipica() != null)
		{
			this.setDesviacionTipica((this.getDesviacionTipica() - minValue) / (maxValue - minValue));					
		}
		return this;
	}
	
	/**
	 * Estandariza el valor del atributo
	 * @return this estandarizazo
	 */
	public Atributo estandarizar()
	{
		if((this.getMedia() != null) && (this.getDesviacionTipica() != null))
		{
			this.setValue((this.getValue() - this.getMedia())/this.getDesviacionTipica());
			mIsNormalizado = false;
			mIsEstandarizado = true;
		}
		return this;
	}
	
	/**
	 * Obtiene el valor real del atributo que tenía antes de haber sido normalizado.
	 * @return (Double) Valor del atributo antes de ser normalizado.
	 */

	@Override
	public String toString()
	{

		return this.getTitulo() + ":\t" + this.getValue();
	}
	
}
