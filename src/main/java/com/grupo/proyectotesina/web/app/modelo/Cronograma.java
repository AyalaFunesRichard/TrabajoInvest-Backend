package com.grupo.proyectotesina.web.app.modelo;

import java.io.Serializable;

/********CRONOGRAMA****************************************************************************
 * @author Luis Muñoz Guerra 																*
 * @since 20/10/2021	  																	*
 * @version 1.0																				*	
*********************************************************************************************/
public class Cronograma implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private String Id_Cronograma;
	private String Nombre_Tarea;
	private String Actividades_Previa;
	private String Responsable;
	private String Fecha_Inicio;
	private String Fecha_Fin;
	private String Completado;
	private String Estado;
	private String Semaforo;
	private String Duracion;
	private String Presupuesto;

	public Cronograma() {
		
		super();
	}
	
	public Cronograma(String id_Cronograma, String nombre_Tarea, String actividades_Previa, String responsable,
			String fecha_Inicio, String fecha_Fin, String completado, String estado, String semaforo,
			String duracion, String presupuesto) {
		super();
		this.Id_Cronograma = id_Cronograma;
		this.Nombre_Tarea = nombre_Tarea;
		this.Actividades_Previa = actividades_Previa;
		this.Responsable = responsable;
		this.Fecha_Inicio = fecha_Inicio;
		this.Fecha_Fin = fecha_Fin;
		this.Completado = completado;
		this.Estado = estado;
		this.Semaforo = semaforo;
		this.Duracion = duracion;
		this.Presupuesto = presupuesto;
	}


	public String getId_Cronograma() {
		return Id_Cronograma;
	}
	public void setId_Cronograma(String id_Cronograma) {
		Id_Cronograma = id_Cronograma;
	}
	public String getNombre_Tarea() {
		return Nombre_Tarea;
	}
	public void setNombre_Tarea(String nombre_Tarea) {
		Nombre_Tarea = nombre_Tarea;
	}
	public String getActividades_Previa() {
		return Actividades_Previa;
	}
	public void setActividades_Previa(String actividades_Previa) {
		Actividades_Previa = actividades_Previa;
	}
	public String getResponsable() {
		return Responsable;
	}
	public void setResponsable(String responsable) {
		Responsable = responsable;
	}
	public String getFecha_Inicio() {
		return Fecha_Inicio;
	}
	public void setFecha_Inicio(String fecha_Inicio) {
		Fecha_Inicio = fecha_Inicio;
	}
	public String getFecha_Fin() {
		return Fecha_Fin;
	}
	public void setFecha_Fin(String fecha_Fin) {
		Fecha_Fin = fecha_Fin;
	}
	public String getCompletado() {
		return Completado;
	}
	public void setCompletado(String completado) {
		Completado = completado;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getSemaforo() {
		return Semaforo;
	}
	public void setSemaforo(String semaforo) {
		Semaforo = semaforo;
	}
	public String getDuracion() {
		return Duracion;
	}
	public void setDuracion(String duracion) {
		Duracion = duracion;
	}

	public String getPresupuesto() {
		return Presupuesto;
	}

	public void setPresupuesto(String presupuesto) {
		Presupuesto = presupuesto;
	}
	
	
	
}
