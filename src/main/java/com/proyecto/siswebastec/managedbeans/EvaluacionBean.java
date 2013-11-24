package com.proyecto.siswebastec.managedbeans;

import java.io.Serializable;	
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;











import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;


//import com.proyecto.siswebastec.DAO.EvaluacionDAO;
import com.proyecto.siswebastec.bean.SolicitudDataModel;
import com.proyecto.siswebastec.model.Atencion;
import com.proyecto.siswebastec.model.Calificacion;
import com.proyecto.siswebastec.model.Evaluacion;
import com.proyecto.siswebastec.model.Solicitud;
import com.proyecto.siswebastec.services.AtencionService;
import com.proyecto.siswebastec.services.SolicitudService;
import com.proyecto.siswebastec.servicesImpl.AtencionServiceImpl;
import com.proyecto.siswebastec.servicesImpl.SolicitudServiceImpl;

public class EvaluacionBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<Solicitud> solicitudes,solicitudespend,solicitudespro,solicitudesfin;
	private SolicitudService solserv;
	private SolicitudDataModel mediumSolsModel,mediumSolsModelPro,mediumSolsModelFin,mediumSolsPend; 
	
	private Solicitud selectedSol;
	private String calificacion;
	
	private AtencionService atenserv;
	private List<String> calificaciones;
	private String observacion;
	
	/***temp***/
	private Solicitud fija;
	
	public EvaluacionBean(){
		atenserv=new AtencionServiceImpl();
		calificaciones=atenserv.getCalificacionesNombre();
		
		setSolicitudes(new ArrayList<Solicitud>());
		solserv=new SolicitudServiceImpl();
		solicitudespend=new ArrayList<Solicitud>();
		solicitudespend = solserv.getSolicitudesPendientes();
		solicitudespro=new ArrayList<Solicitud>();
		solicitudespro = solserv.getSolicitudesProceso();
		solicitudesfin=new ArrayList<Solicitud>();
		solicitudesfin=solserv.getSolicitudesFinalizadas();
		mediumSolsModel= new SolicitudDataModel(solicitudespend);
		mediumSolsModelPro=new SolicitudDataModel(solicitudespro);
		mediumSolsModelFin=new SolicitudDataModel(solicitudesfin);
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}

	public List<String> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(List<String> calificaciones) {
		this.calificaciones = calificaciones;
	}
	
	public List<Solicitud> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(List<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}
	
	public List<Solicitud> getSolicitudespend() {
		System.out.println("TableBean.getSolicitudespend()");
		//solserv=new SolicitudServiceImpl();
		//setSolicitudespend(solserv.getSolicitudesPendientes());		
		return this.solicitudespend;
	}

	public void setSolicitudespend(List<Solicitud> solicitudespend) {
		System.out.println("TableBean.setSolicitudespend()");
		this.solicitudespend = solicitudespend;
	}

	public List<Solicitud> getSolicitudespro() {
		System.out.println("TableBean.getSolicitudespro()");
		
		//solserv=new SolicitudServiceImpl();
		//setSolicitudespro(solserv.getSolicitudesProceso());
		return solicitudespro;
	}

	public void setSolicitudespro(List<Solicitud> solicitudespro) {
		System.out.println("TableBean.setSolicitudespro()");
		this.solicitudespro = solicitudespro;
	}

	public List<Solicitud> getSolicitudesfin() {
		System.out.println("TableBean.getSolicitudesfin()");
		//solserv=new SolicitudServiceImpl();
		//setSolicitudesfin(solserv.getSolicitudesFinalizadas());
		return solicitudesfin;
	}
	public void setSolicitudesfin(List<Solicitud> solicitudesfin) {
		System.out.println("TableBean.setSolicitudesfin()");
		this.solicitudesfin = solicitudesfin;
	}
	
	/************************************************************************************/
	
	public SolicitudDataModel getMediumSolsModelFin() {
		return mediumSolsModelFin;
	}
	public void setMediumSolsModelFin(SolicitudDataModel mediumSolsModelFin) {
		this.mediumSolsModelFin = mediumSolsModelFin;
	}
	
	public void setMediumSolsModelPro(SolicitudDataModel mediumSolsModelPro) {
		this.mediumSolsModelPro = mediumSolsModelPro;
	}
	public SolicitudDataModel getMediumSolsModelPro() {
		return mediumSolsModelPro;
	}
	
	public SolicitudDataModel getMediumSolsModel() {
		System.out.println("TableBean.getMediumSolsModel()");
		return mediumSolsModel;	}

	public void setMediumSolsModel(SolicitudDataModel mediumSolsModel) {
		System.out.println("TableBean.setMediumSolsModel()");
		this.mediumSolsModel = mediumSolsModel;
	}
	
	public SolicitudDataModel getMediumSolsPend() {
		return mediumSolsPend;
	}

	public void setMediumSolsPend(SolicitudDataModel mediumSolsPend) {
		this.mediumSolsPend = mediumSolsPend;
	}
	
	/****************************************************************************************/
	public Solicitud getSelectedSol() {
		return selectedSol;
	}

	public void setSelectedSol(Solicitud selectedSol) {
		this.selectedSol = selectedSol;
	}

	public Solicitud getFija() {
		return fija;
	}

	public void setFija(Solicitud fija) {
		this.fija = fija;
	}
	
	/****************************************************************************************/
	public void actualizarSolPen(){
		solserv = new SolicitudServiceImpl();
		setSolicitudespend(solserv.getSolicitudesPendientes());
		setMediumSolsModel(new SolicitudDataModel(getSolicitudespend()));
	}
	
	public void actualizarSolPro(){
		solserv = new SolicitudServiceImpl();
		setSolicitudespro(solserv.getSolicitudesProceso());
		setMediumSolsModelPro(new SolicitudDataModel(getSolicitudespro()));
	}
	
	public void actualizarSolFin(){
		solserv = new SolicitudServiceImpl();
		setSolicitudesfin(solserv.getSolicitudesFinalizadas());
		setMediumSolsModelFin(new SolicitudDataModel(getSolicitudesfin()));
	}
	
	public void onTabChange(TabChangeEvent event) {
        System.out.println(event.getTab().getTitle());
        actualizarSolPen();
		actualizarSolPro();
		actualizarSolFin();
		//FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " + event.getTab().getTitle());

        //FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void onRowSelect(SelectEvent event) {
		System.out.println("TableBean.onRowSelect()");
		System.out.println(event.getObject());
		fija = (Solicitud) event.getObject();
		setSelectedSol(fija);
		  
    }  
	
	public void grabar(ActionEvent a){
		System.out.println("EvaluacionBean.grabar()");
		atenserv=new AtencionServiceImpl();
		
		String calif=getCalificacion();
		System.out.println(calif);
		System.out.println(getObservacion());
		Date Fecha = Calendar.getInstance().getTime();
		Atencion aten=buscarAtencion(fija.getIdSolicitud());
		//Calificacion cal=new Calificacion();
		Evaluacion eval=new Evaluacion(observacion, Fecha, Fecha,aten, calificacionIdentificar(getCalificacion()));
		atenserv.addEvaluacion(eval);
		aten.setIdEvaluacion(eval);
		atenserv.updateAtencion(aten);
	}
	
	public Calificacion calificacionIdentificar(String cal){
		Calificacion cali=new Calificacion();
		 if(cal.equals("Excelente")){cali.setIdCalificacion(5);cali.setNombreCalificacion(cal);}
		 if(cal.equals("Bueno")){cali.setIdCalificacion(4);cali.setNombreCalificacion(cal);}
		 if(cal.equals("Regular")){cali.setIdCalificacion(3);cali.setNombreCalificacion(cal);}
		 if(cal.equals("Pesima")){cali.setIdCalificacion(2);cali.setNombreCalificacion(cal);}
		 if(cal.equals("Mala")){cali.setIdCalificacion(1);cali.setNombreCalificacion(cal);}

		return cali;
	}
	
	public Atencion buscarAtencion(int IdSol){
		Atencion aten=new Atencion();
		atenserv=new AtencionServiceImpl();
		aten=atenserv.getAtencionByIdSol(IdSol);		
		return aten;
	}

	

	
	
	
}
