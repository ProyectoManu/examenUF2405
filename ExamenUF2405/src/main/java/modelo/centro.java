package modelo;

import java.util.Objects;

public class centro {
		
	private int codCentro;
	private String nombre;
	private String direccion;
	
	public centro() {
		super();
		
		
	}

	public centro(int codCentro, String nombre, String direccion) {
		super();
		this.codCentro = codCentro;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public int getCodCentro() {
		return codCentro;
	}

	public void setCodCentro(int codCentro) {
		this.codCentro = codCentro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codCentro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		centro other = (centro) obj;
		return codCentro == other.codCentro;
	}
	
	
	
}
