package Model;
import java.io.Serializable;
public class Arduino implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String data;
	private double consumo;
	private String tempoDeUso;
	private int luminosidade;
	private double potencia;
	
	public Arduino(){}

	public Arduino(int id, String data, double consumo, String tempoDeUso, int luminosidade, double potencia) {
		this.id = id;
		this.data = data;
		this.consumo = consumo;
		this.tempoDeUso = tempoDeUso;
		this.luminosidade = luminosidade;
		this.potencia = potencia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getConsumo() {
		return consumo;
	}

	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}

	public String getTempoDeUso() {
		return tempoDeUso;
	}

	public void setTempoDeUso(String tempoDeUso) {
		this.tempoDeUso = tempoDeUso;
	}

	public int getLuminosidade() {
		return luminosidade;
	}

	public void setLuminosidade(int luminosidade) {
		this.luminosidade = luminosidade;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Arduino [id=" + id + ", data=" + data + ", consumo=" + consumo + ", tempoDeUso=" + tempoDeUso
				+ ", luminosidade=" + luminosidade + ", potencia=" + potencia + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(consumo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + id;
		result = prime * result + luminosidade;
		temp = Double.doubleToLongBits(potencia);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tempoDeUso == null) ? 0 : tempoDeUso.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arduino other = (Arduino) obj;
		if (Double.doubleToLongBits(consumo) != Double.doubleToLongBits(other.consumo))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id != other.id)
			return false;
		if (luminosidade != other.luminosidade)
			return false;
		if (Double.doubleToLongBits(potencia) != Double.doubleToLongBits(other.potencia))
			return false;
		if (tempoDeUso == null) {
			if (other.tempoDeUso != null)
				return false;
		} else if (!tempoDeUso.equals(other.tempoDeUso))
			return false;
		return true;
	};
}