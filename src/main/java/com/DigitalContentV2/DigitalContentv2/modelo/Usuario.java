package com.DigitalContentV2.DigitalContentv2.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = "correo"))
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;

	@Column(name = "nombres", nullable = false, length = 150)
	private String nombres;

	@Column(name = "apellidos", nullable = false, length = 150)
	private String apellidos;

	@Column(name = "tipoDocumento", nullable = false, length = 70)
	private String tipoDocumento;

	@Column(name = "numDocumento", nullable = false)
	private Integer numDocumento;

	@Column(name = "direccion", nullable = false, length = 110)
	private String direccion;

	@ManyToOne
	@JoinColumn(name = "id_Barrio_fk")
	private Barrio id_Barrio_fk;

	@Column(name = "telefono", nullable = false)
	private Long telefono;

	@Column(name = "estado", nullable = false, length = 40)
	private String estado;

	@OneToMany(mappedBy = "id_Usuario_fk")
	private List<Pedido> pedido;

	@OneToMany(mappedBy = "id_Usuario_fk")
	private List<Entrega> entrega;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "idUsuario_fk"), inverseJoinColumns = @JoinColumn(name = "idRol_fk"))
	private Collection<Rol> roles;

	@Column(name = "contrasena", nullable = false, length = 100)
	private String contrasena;

	@Column(name = "correo", nullable = false, length = 100)
	private String correo;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Integer getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(Integer numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Barrio getId_Barrio_fk() {
		return id_Barrio_fk;
	}

	public void setId_Barrio_fk(Barrio id_Barrio_fk) {
		this.id_Barrio_fk = id_Barrio_fk;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

	public List<Entrega> getEntrega() {
		return entrega;
	}

	public void setEntrega(List<Entrega> entrega) {
		this.entrega = entrega;
	}

	public Collection<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Usuario(Integer idUsuario, String nombres, String apellidos, String tipoDocumento, Integer numDocumento,
			String direccion, Barrio id_Barrio_fk, Long telefono, String estado, Collection<Rol> roles,
			String contrasena, String correo) {
		super();
		this.idUsuario = idUsuario;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.tipoDocumento = tipoDocumento;
		this.numDocumento = numDocumento;
		this.direccion = direccion;
		this.id_Barrio_fk = id_Barrio_fk;
		this.telefono = telefono;
		this.estado = estado;
		this.roles = roles;
		this.contrasena = contrasena;
		this.correo = correo;
	}

	public Usuario(String nombres, String apellidos, String tipoDocumento, Integer numDocumento, String direccion,
			Barrio id_Barrio_fk, Long telefono, String contrasena, String correo, Collection<Rol> roles) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.tipoDocumento = tipoDocumento;
		this.numDocumento = numDocumento;
		this.direccion = direccion;
		this.id_Barrio_fk = id_Barrio_fk;
		this.telefono = telefono;
		this.contrasena = contrasena;
		this.correo = correo;
		this.roles = roles;
	}

	public Usuario() {
		super();
	}

	public Usuario(String nombres, String apellidos, String tipoDocumento, Integer numDocumento, String direccion,
			Barrio id_Barrio_fk, Long telefono, String contrasena, String correo) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.tipoDocumento = tipoDocumento;
		this.numDocumento = numDocumento;
		this.direccion = direccion;
		this.id_Barrio_fk = id_Barrio_fk;
		this.telefono = telefono;
		this.contrasena = contrasena;
		this.correo = correo;
	}
}
