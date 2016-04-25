package pe.com.peru.inka.service.util;

public class Producto {

	private Long id;
	private String nombre;
	private double precio;
	private String atributo;
	private String estado;
	private Long sucursalId;
	private String tipoProductoId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Long getSucursalId() {
		return sucursalId;
	}

	public void setSucursalId(Long sucursalId) {
		this.sucursalId = sucursalId;
	}

	public String getTipoProductoId() {
		return tipoProductoId;
	}

	public void setTipoProductoId(String tipoProductoId) {
		this.tipoProductoId = tipoProductoId;
	}

}
