package com.proyecto.siswebastec.managedbeans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;

//import com.proyecto.siswebastec.DAO.EvaluacionDAO;
import com.proyecto.siswebastec.bean.SolicitudDataModel;
import com.proyecto.siswebastec.model.Atencion;
import com.proyecto.siswebastec.model.Calificacion;
import com.proyecto.siswebastec.model.Categoria;
import com.proyecto.siswebastec.model.Diagnostico;
import com.proyecto.siswebastec.model.Estado;
import com.proyecto.siswebastec.model.Evaluacion;
import com.proyecto.siswebastec.model.Prioridad;
import com.proyecto.siswebastec.model.Solicitud;
import com.proyecto.siswebastec.model.Solucion;
import com.proyecto.siswebastec.model.TipoSolicitud;
import com.proyecto.siswebastec.model.Trabajador;
import com.proyecto.siswebastec.services.AtencionService;
import com.proyecto.siswebastec.services.PrioridadService;
import com.proyecto.siswebastec.services.SolicitudService;
import com.proyecto.siswebastec.services.TrabajadorService;
import com.proyecto.siswebastec.servicesImpl.AtencionServiceImpl;
import com.proyecto.siswebastec.servicesImpl.PrioridadServiceImpl;
import com.proyecto.siswebastec.servicesImpl.SolicitudServiceImpl;
import com.proyecto.siswebastec.servicesImpl.TrabajadorServiceImpl;

public class EvaluacionBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Solicitud> solicitudes, solicitudespend, solicitudespro,
			solicitudespropen, solicitudesfin;
	private SolicitudService solserv;
	private Solicitud selectedSol;
	private SolicitudDataModel mediumSolsModel, mediumSolsModelPro,
			mediumSolsModelFin, mediumSolsPend, mediumSolsProPend;
	private Solicitud fija;
	private String idFija;
	private String evaluacion;
	/********** CALIFICACION **********/
	private String calificacion;
	private AtencionService atenserv;
	private List<String> calificaciones;
	private String observacion;

	private String prioridad;
	private String trabajador;
	private String categoria;
	private String trbAten;
	private String fcierre;
	private String hcierre;
	private List<String> traid;
	private List<String> categorias;
	private TrabajadorService trabajadorService;
	private AtencionService atencionService;

	public EvaluacionBean() {

		atenserv = new AtencionServiceImpl();
		calificaciones = atenserv.getCalificacionesNombre();
		// System.out.println("TableBean.TableBean()");
		solicitudes = new ArrayList<Solicitud>();
		solserv = new SolicitudServiceImpl();
		solicitudespend = new ArrayList<Solicitud>();
		solicitudespend = solserv.getSolicitudesPendientes();
		solicitudespro = new ArrayList<Solicitud>();
		solicitudespro = solserv.getSolicitudesProceso();
		solicitudesfin = new ArrayList<Solicitud>();
		solicitudesfin = solserv.getSolicitudesFinalizadas();
		solicitudespropen = new ArrayList<Solicitud>();
		solicitudespropen = solserv.getSolicitudesProcesoPendientes();

		mediumSolsModel = new SolicitudDataModel(solicitudespend);
		mediumSolsModelPro = new SolicitudDataModel(solicitudespro);
		mediumSolsModelFin = new SolicitudDataModel(solicitudesfin);
		mediumSolsProPend = new SolicitudDataModel(solicitudespropen);
		trabajadorService = new TrabajadorServiceImpl();
		traid = new ArrayList<>();
		categorias = new ArrayList<>();
		categorias = solserv.getListaCat();
		traid = trabajadorService.getIdTrabajadores();
		atencionService = new AtencionServiceImpl();
		trbAten = "";
		fcierre = "";
		hcierre = "";
		idFija = "";
		evaluacion = "";
		
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

	public List<Solicitud> getSolicitudespend() {
		System.out.println("TableBean.getSolicitudespend()");
		// solserv=new SolicitudServiceImpl();
		// setSolicitudespend(solserv.getSolicitudesPendientes());
		return this.solicitudespend;
	}

	public void setSolicitudespend(List<Solicitud> solicitudespend) {
		System.out.println("TableBean.setSolicitudespend()");
		this.solicitudespend = solicitudespend;
	}

	public List<Solicitud> getSolicitudespro() {
		System.out.println("TableBean.getSolicitudespro()");
		return solicitudespro;
	}

	public SolicitudDataModel getMediumSolsModelPro() {
		return mediumSolsModelPro;
	}

	public void setMediumSolsModelPro(SolicitudDataModel mediumSolsModelPro) {
		this.mediumSolsModelPro = mediumSolsModelPro;
	}

	public void setSolicitudespro(List<Solicitud> solicitudespro) {
		System.out.println("TableBean.setSolicitudespro()");
		this.solicitudespro = solicitudespro;
	}

	public List<Solicitud> getSolicitudesfin() {
		System.out.println("TableBean.getSolicitudesfin()");
		return solicitudesfin;
	}

	public void setSolicitudesfin(List<Solicitud> solicitudesfin) {
		System.out.println("TableBean.setSolicitudesfin()");
		this.solicitudesfin = solicitudesfin;
	}

	public List<Solicitud> getSolicitudes() {
		System.out.println("TableBean.getSolicitudes()");
		return solicitudes;
	}

	public void setSolicitudes(List<Solicitud> solicitudes) {
		System.out.println("TableBean.setSolicitudes()");
		this.solicitudes = solicitudes;
	}

	public SolicitudService getSolserv() {
		System.out.println("TableBean.getSolserv()");
		return solserv;
	}

	public void setSolserv(SolicitudService solserv) {
		System.out.println("TableBean.setSolserv()");
		this.solserv = solserv;
	}

	public Solicitud getSelectedSol() {
		System.out.println("TableBean.getSelectedSol()");
		return selectedSol;
	}

	public void setSelectedSol(Solicitud selectedSol) {
		System.out.println("TableBean.setSelectedSol()");
		this.selectedSol = selectedSol;
	}

	public SolicitudDataModel getMediumSolsModel() {
		System.out.println("TableBean.getMediumSolsModel()");
		return mediumSolsModel;
	}

	public SolicitudDataModel getMediumSolsModelFin() {
		return mediumSolsModelFin;
	}

	public void setMediumSolsModelFin(SolicitudDataModel mediumSolsModelFin) {
		this.mediumSolsModelFin = mediumSolsModelFin;
	}

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

	public void onRowSelect(SelectEvent event) {
		System.out.println("TableBean.onRowSelect()");
		System.out.println(event.getObject());
		fija = (Solicitud) event.getObject();
		setSelectedSol(fija);
		System.out.println(fija.getIdSolicitud().toString());
		setIdFija(fija.getIdSolicitud().toString());

	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(String trabajador) {
		this.trabajador = trabajador;
	}

	public List<String> getTraid() {
		return traid;
	}

	public void setTraid(List<String> traid) {
		this.traid = traid;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<String> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}

	public String getFcierre() {
		return fcierre;
	}

	public void setFcierre(String fcierre) {
		this.fcierre = fcierre;
	}

	public String getHcierre() {
		return hcierre;
	}

	public void setHcierre(String hcierre) {
		this.hcierre = hcierre;
	}

	public String getTrbAten() {
		if (getSelectedSol() != null) {
			if (getSelectedSol().getIdEstado().getIdEstado() != 1) {
				Atencion ate = atencionService
						.getAtencionByIdSol(getSelectedSol().getIdSolicitud());
				System.out.println("Seleccionada" + getSelectedSol());
				System.out.println("Atencion" + ate);
				setTrbAten(ate.getTrabajador().getTrabajadorPK()
						.getIdTrabajador());
				if (getSelectedSol().getIdEstado().getIdEstado() == 2) {
					setFcierre("-");
					setHcierre("-");
				} else {
					SimpleDateFormat sdff = new SimpleDateFormat("dd/MM/yyyy");
					SimpleDateFormat sdfh = new SimpleDateFormat("h:mm a");
					setFcierre(sdff.format(getSelectedSol().getFechaCierre()));
					setHcierre(sdfh.format(getSelectedSol().getHoraCierre()));
				}
			} else {
				setTrbAten("-");
				Categoria catTemp = new Categoria();
				catTemp.setNombreCategoria("-");
				getSelectedSol().setIdCategoria(catTemp);
				Prioridad priTemp = new Prioridad();
				priTemp.setNombrePrioridad("-");
				getSelectedSol().setIdPrioridad(priTemp);
				setFcierre("-");
				setHcierre("-");
			}
		}
		return trbAten;
	}

	public void setTrbAten(String trbAten) {
		this.trbAten = trbAten;
	}

	public String getIdFija() {
		if (fija != null) {
			setIdFija(fija.getIdSolicitud().toString());
		}
		return idFija;
	}

	public void setIdFija(String idFija) {
		this.idFija = idFija;
	}

	public String getEvaluacion() {
		
			Atencion at = atencionService.getAtencionByIdSol(fija.getIdSolicitud());
			
			if(at!=null){
				if(at.getIdEvaluacion()!=null){
					setEvaluacion("Si");
				}else{
					setEvaluacion("No");
				}
			}else{
				setEvaluacion("No");
			}
		
		return evaluacion;
	}

	public void setEvaluacion(String evaluacion) {
		this.evaluacion = evaluacion;
	}


	public void handleChangeP() {
		System.out.println("evento: " + prioridad);
	}

	public void handleChangeT() {
		System.out.println("evento: " + trabajador);
	}

	public void handleChangeC() {

	}

	public void actualizarSolPen() {
		solserv = new SolicitudServiceImpl();
		setSolicitudespend(solserv.getSolicitudesPendientes());
		setMediumSolsModel(new SolicitudDataModel(getSolicitudespend()));
	}

	public void actualizarSolPro() {
		solserv = new SolicitudServiceImpl();
		setSolicitudespro(solserv.getSolicitudesProceso());
		setMediumSolsModelPro(new SolicitudDataModel(getSolicitudespro()));
	}

	public void actualizarSolFin() {
		solserv = new SolicitudServiceImpl();
		setSolicitudesfin(solserv.getSolicitudesFinalizadas());
		setMediumSolsModelFin(new SolicitudDataModel(getSolicitudesfin()));
	}

	public void actualizarSolProPend() {
		solserv = new SolicitudServiceImpl();
		setSolicitudespropen(solserv.getSolicitudesProcesoPendientes());
		setMediumSolsProPend(new SolicitudDataModel(getSolicitudespropen()));
	}

	public void onTabChange(TabChangeEvent event) {
		System.out.println(event.getTab().getTitle());
		fija = null;
		actualizarSolicitudes();
		// FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " +
		// event.getTab().getTitle());

		// FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void actualizarSolicitudes() {
		actualizarSolPen();
		actualizarSolPro();
		actualizarSolFin();
		actualizarSolProPend();
	}

	public void mensajes(String tipo, String msj) {
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg = null;
		if (tipo.equals("error")) {
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msj, "");
			// FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		if (tipo.equals("info")) {
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, msj, "");
			// FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		System.out.println("Context" + context.toString());
		context.addMessage(null, msg);
	}

	public void validaSel(ActionEvent ae) {
		System.out.println("TableBean.validaSel()");
		// setIdFija(fija.getIdSolicitud().toString());
		System.out.println(getIdFija());
		if (fija == null) {
			mensajes("error", "Seleccionar una Solicitud");
		}
	}

	public void limpiarPantalla() {
		setPrioridad("");
		setTrabajador("");
		setCategoria("");
		setTrbAten("");
		setCalificacion("");
		setObservacion("");
	}

	/********************************************* CAMBIO *******************************************************/

	public List<Solicitud> getSolicitudespropen() {
		System.out.println("TableBean.getSolicitudespropend()");
		return solicitudespropen;
	}

	public void setSolicitudespropen(List<Solicitud> solicitudespropen) {
		System.out.println("TableBean.setSolicitudespropend()");
		this.solicitudespropen = solicitudespropen;
	}

	/************************************************************************************/

	public SolicitudDataModel getMediumSolsProPend() {
		return mediumSolsProPend;
	}

	public void setMediumSolsProPend(SolicitudDataModel mediumSolsProPend) {
		this.mediumSolsProPend = mediumSolsProPend;
	}

	/****************************************************************************************/

	public Solicitud getFija() {
		return fija;
	}

	public void setFija(Solicitud fija) {
		this.fija = fija;
	}

	/****************************************************************************************/

	/***************************************************** EVALUACION *************************************************/
	public void grabar(ActionEvent a) {
		System.out.println("EvaluacionBean.grabar()");
		atenserv = new AtencionServiceImpl();
		if (fija != null) {
			String calif = getCalificacion();
			System.out.println(calif);
			System.out.println(getObservacion());
			Date Fecha = Calendar.getInstance().getTime();
			Atencion aten = buscarAtencion(fija.getIdSolicitud());
			if(aten!=null){
				if(aten.getIdEvaluacion()==null){
					Evaluacion eval = new Evaluacion(observacion, Fecha, Fecha,
							calificacionIdentificar(getCalificacion()));
					atenserv.addEvaluacion(eval);
					aten.setIdEvaluacion(eval);
					atenserv.updateAtencion(aten);					
					fija = null;
					setIdFija("");
					limpiarPantalla();
					actualizarSolicitudes();
					mensajes("info", "Evaluacion exitosa");
				}else{
					mensajes("error","Solicitud ya evaluada");
				}
				
			}else{
				mensajes("error", "No existe una Atencion");
			}
			
		} else {
			mensajes("error", "Seleccionar una solicitud");
		}
	}

	public Calificacion calificacionIdentificar(String cal) {
		Calificacion cali = new Calificacion();
		if (cal.equals("Excelente")) {
			cali.setIdCalificacion(5);
			cali.setNombreCalificacion(cal);
		}
		if (cal.equals("Bueno")) {
			cali.setIdCalificacion(4);
			cali.setNombreCalificacion(cal);
		}
		if (cal.equals("Regular")) {
			cali.setIdCalificacion(3);
			cali.setNombreCalificacion(cal);
		}
		if (cal.equals("Pesima")) {
			cali.setIdCalificacion(2);
			cali.setNombreCalificacion(cal);
		}
		if (cal.equals("Mala")) {
			cali.setIdCalificacion(1);
			cali.setNombreCalificacion(cal);
		}

		return cali;
	}

	public Atencion buscarAtencion(int IdSol) {
		//Obtiene la ultimma atencion registrada para la Solicitud
		Atencion aten = new Atencion();
		atenserv = new AtencionServiceImpl();
		aten = atenserv.getAtencionByIdSol(IdSol);
		return aten;
	}

	/********************************* VALIDACION ***********************************/
	public void validaSolAten(ActionEvent ae) {
		System.out.println("TableBean.validaSel()");
		// setIdFija(fija.getIdSolicitud().toString());
		System.out.println(getIdFija());
		if (fija == null) {
			mensajes("error", "Seleccionar una Solicitud");
		}
	}

	public void validaSolReac(ActionEvent ae) {
		if (fija == null) {
			mensajes("error", "Seleccionar una Solicitud");
		} else {
			System.out.println("Estamos Reactivando");
		}
	}

	public void validaSolCancel(ActionEvent ae) {
		if (fija == null) {
			mensajes("error", "Seleccionar una Solicitud");
		} else {
			System.out.println("Estamos Cancelando");
		}
	}

	public void reactivar(ActionEvent ae) {
		TipoSolicitud idTipo;
		Estado idEstado;
		if (fija == null) {
			mensajes("error", "Seleccionar una Solicitud");
		} else {
			// System.out.println("Estamos Cancelando");
			atenserv = new AtencionServiceImpl();
			idTipo = atenserv.getTipoSolicitud(2);
			System.out.println("Esta es:" + idTipo.getNombreTipo());

			idEstado = atenserv.getEstado(1);
			System.out.println("Esta es:" + idEstado.getNombreEstado());

			fija.setIdTipo(idTipo);
			fija.setIdEstado(idEstado);
			solserv.updateSolicitud(fija);
			limpiarPantalla();
			actualizarSolicitudes();
			mensajes("info", "Solicitud Reactivada...!!!");
		}
	}

	public void cancelar(ActionEvent ae) {
		TipoSolicitud idTipo;
		Estado idEstado;
		if (fija == null) {
			mensajes("error", "Seleccionar una Solicitud");
		} else {
			// System.out.println("Estamos Cancelando");
			atenserv = new AtencionServiceImpl();
			idTipo = atenserv.getTipoSolicitud(3);
			System.out.println("Esta es:" + idTipo.getNombreTipo());

			idEstado = atenserv.getEstado(3);
			System.out.println("Esta es:" + idEstado.getNombreEstado());

			fija.setIdTipo(idTipo);
			fija.setIdEstado(idEstado);
			solserv.updateSolicitud(fija);
			limpiarPantalla();
			actualizarSolicitudes();
			mensajes("info", "Solicitud ha sido cancelada...!!!");
		}
	}

}
