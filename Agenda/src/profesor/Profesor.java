package profesor;

import java.util.Objects;

public class Profesor {
	public Profesor(String dni, String nombre, double salario, boolean fijo) {
		super();
		Dni = dni;
		this.nombre = nombre;
		this.salario = salario;
		this.fijo = fijo;
	}
	public Profesor() {
		// TODO Esbozo de constructor generado automáticamente
	}
	String Dni;
	public String getDni() {
		return Dni;
	}
	public void setDni(String dni) {
		Dni = dni;
	}
	String nombre;
	double salario;
	boolean fijo;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public boolean isFijo() {
		return fijo;
	}
	public void setFijo(boolean fijo) {
		this.fijo = fijo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Dni, fijo, nombre, salario);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		return Objects.equals(Dni, other.Dni) && fijo == other.fijo && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(salario) == Double.doubleToLongBits(other.salario);
	}
	@Override
	public String toString() {
		return "Profesor [Dni=" + Dni + ", nombre=" + nombre + ", salario=" + salario + ", fijo=" + fijo + ", getDni()="
				+ getDni() + ", getNombre()=" + getNombre() + ", getSalario()=" + getSalario() + ", isFijo()="
				+ isFijo() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}

}
