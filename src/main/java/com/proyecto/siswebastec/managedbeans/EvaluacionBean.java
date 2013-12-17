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

public class EvaluacionBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<Solicitud> solicitudes, solicitudespend, solicitudespro,solicitudespropen,solicitudesfin;
	private SolicitudService solserv;
	private Solicitud selectedSol;
	private SolicitudDataModel mediumSolsModel, mediumSolsModelPro,
			mediumSolsModelFin, mediumSolsPend,mediumSolsProPend; 
	private Solicitud fija;
	private String idFija;
	/********** CALIFICACION **********/
	private String calificacion;	
	private AtencionService atenserv;
	private List<String> calificaciones;
	private String observacion;
	
	
	private String prioridad;
	private String trabajador;
	private String categoria;
	private String categoriaM;
	private String trbAten;
	private String fcierre;
	private String hcierre;
	private List<String> prinames;
	private List<String> traid;
	private List<String> categorias;
	private List<String> categoriasM;
	private List<String> nomdiags;
	private List<String> nomdiagsM;
	private PrioridadService prioridadService;
	private TrabajadorService trabajadorService;
	private AtencionService atencionService;

	/******* Diagnostico y Solucion *****/
	private String diagnostico;
	private String diagnosticoM;
	private String Solucion;
	private String nombreD;
	private String nomdiag;
	private String nomdiagM;

	public EvaluacionBean() {
		
		atenserv=new AtencionServiceImpl();
        calificaciones=atenserv.getCalificacionesNombre();		
		//System.out.println("TableBean.TableBean()");
		solicitudes = new ArrayList<Solicitud>();
		solserv = new SolicitudServiceImpl();
		solicitudespend = new ArrayList<Solicitud>();
		solicitudespend = solserv.getSolicitudesPendientes();
		solicitudespro = new ArrayList<Solicitud>();
		solicitudespro = solserv.getSolicitudesProceso();
		solicitudesfin = new ArrayList<Solicitud>();
		solicitudesfin = solserv.getSolicitudesFinalizadas();
		solicitudespropen=new ArrayList<Solicitud>();
		solicitudespropen=solserv.getSolicitudesProcesoPendientes();
		
		mediumSolsModel = new SolicitudDataModel(solicitudespend);
		mediumSolsModelPro = new SolicitudDataModel(solicitudespro);
		mediumSolsModelFin = new SolicitudDataModel(solicitudesfin);
		mediumSolsProPend=new SolicitudDataModel(solicitudespropen);
		
		
		// mediumSolsPend= new SolicitudDataModel(solicitudes);

		prioridadService = new PrioridadServiceImpl();
		trabajadorService = new TrabajadorServiceImpl();
		// prioridades = new ArrayList<>();
		// prioridades = prioridadService.getPrioridades();
		prinames = new ArrayList<>();
		traid = new ArrayList<>();
		categorias = new ArrayList<>();
		categorias = solserv.getListaCat();
		categoriasM = new ArrayList<>();
		categoriasM = solserv.getListaCat();
		prinames = prioridadService.getNombresPri();
		traid = trabajadorService.getIdTrabajadores();
		atencionService = new AtencionServiceImpl();
		trbAten = "";
		fcierre = "";
		hcierre = "";
		idFija = "";
		// categoria="";
		// fija=new Solicitud();

		// System.out.println("Holitas!");
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

		// solserv=new SolicitudServiceImpl();
		// setSolicitudespro(solserv.getSolicitudesProceso());
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
		// solserv=new SolicitudServiceImpl();
		// setSolicitudesfin(solserv.getSolicitudesFinalizadas());
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

	public List<String> getPrinames() {
		// prioridadService = new PrioridadServiceImpl();
		// setPrinames(prioridadService.getNombresPri());
		return prinames;
	}

	public void setPrinames(List<String> prinames) {
		this.prinames = prinames;
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

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getSolucion() {
		return Solucion;
	}

	public void setSolucion(String solucion) {
		Solucion = solucion;
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

	public String getNombreD() {
		return nombreD;
	}

	public void setNombreD(String nombreD) {
		this.nombreD = nombreD;
	}

	public List<String> getNomdiags() {
		return nomdiags;
	}

	public void setNomdiags(List<String> nomdiags) {
		this.nomdiags = nomdiags;
	}

	public String getNomdiag() {
		return nomdiag;
	}

	public void setNomdiag(String nomdiag) {
		this.nomdiag = nomdiag;
	}

	public String getCategoriaM() {
		return categoriaM;
	}

	public void setCategoriaM(String categoriaM) {
		this.categoriaM = categoriaM;
	}

	public List<String> getCategoriasM() {
		return categoriasM;
	}

	public void setCategoriasM(List<String> categoriasM) {
		this.categoriasM = categoriasM;
	}

	public List<String> getNomdiagsM() {
		return nomdiagsM;
	}

	public void setNomdiagsM(List<String> nomdiagsM) {
		this.nomdiagsM = nomdiagsM;
	}

	public String getNomdiagM() {
		return nomdiagM;
	}

	public void setNomdiagM(String nomdiagM) {
		this.nomdiagM = nomdiagM;
	}

	public String getDiagnosticoM() {
		return diagnosticoM;
	}

	public void setDiagnosticoM(String diagnosticoM) {
		this.diagnosticoM = diagnosticoM;
	}

	public void asignarTecnico(ActionEvent actionEvent) {
		System.out.println("TableBean.asignarTecnico()");
		Boolean error = false;
		if (fija != null) {
			Trabajador t = trabajadorService.getTrabajadorById(getTrabajador());
			Date Fecha = Calendar.getInstance().getTime();
			System.out.println("Prioridad" + getPrioridad());
			System.out.println("Hooooooola fija" + fija.getDescSolicitud());
			Prioridad p = new Prioridad();
			if ((getTrabajador() == null || getTrabajador().equals(""))
					|| (getPrioridad() == null || getPrioridad().equals(""))) {
				error = true;
			}
			if (error == false) {
				p.setNombrePrioridad(getPrioridad());

				if (getPrioridad().equals("alta")) {
					p.setIdPrioridad(1);
				}
				if (getPrioridad().equals("media")) {
					p.setIdPrioridad(2);
				}
				if (getPrioridad().equals("baja")) {
					p.setIdPrioridad(3);
				}

				Solicitud sasig = fija;
				System.out.println("Solicitud" + sasig.getDescSolicitud());
				sasig.setIdPrioridad(p);
				sasig.setIdEstado(new Estado(2, "en proceso"));
				solserv.updateSolicitud(sasig);

				// Creamos la atencion

				Atencion ate = new Atencion();
				ate.setIdSolicitud(sasig);
				ate.setFechaAtencion(Fecha);
				ate.setHoraAtencion(Fecha);
				ate.setTrabajador(t);
				atencionService.addAtencion(ate);
				fija = null;
				setIdFija("");
				limpiarPantalla();
				mensajes("info", "Atención registrada");
			} else {
				mensajes("error", "Ingresar todos los campos");
			}
		} else {
			mensajes("error", "Seleccionar una solicitud");
		}
	}

	public void handleChangeP() {
		System.out.println("evento: " + prioridad);
	}

	public void handleChangeT() {
		System.out.println("evento: " + trabajador);
	}

	public void handleChangeC() {	
		
	}

	public void handleChangeDiagM() {
		System.out.println("TableBean.handleChangeDiagM()");
		System.out.println("categoria: " + categoria);
		// setCategoria(categoria);
		// System.out.println("Diag"+getDiagnostico());
	}

	public void actualizarDiag(ActionEvent e) {

		System.out.println("actualizarDiag()");
		System.out.println("Diagnostico:" + diagnostico);
		System.out.println("Categoria:" + categoria);
		System.out.println("fija:" + fija.getIdSolicitud());
		// System.out.println(getSelectedSol().getIdSolicitud().toString());
		if (fija != null) {
			System.out.println(e.getComponent().getId());
			if (e.getComponent().getId().equals("Listo1")) {
				if (diagnostico == null || categoria == null || categoria == ""
						|| diagnostico == "") {
					mensajes("error", "Ingresar todos los campos");
				} else {
					// Solucion tmpSol=new Solucion(10000);
					// nombreD="DannyJ";
					Diagnostico diag = new Diagnostico(fija, nombreD,
							diagnostico, Calendar.getInstance().getTime());
					solserv.addDiagnostico(diag);
					System.out.println("Esta es la categoria:" + categoria);
					fija.setIdCategoria(categoriaIdentificar(categoria));
					solserv.updateSolicitud(fija);
					limpiarPantalla();
					mensajes("info", "Diagnostico Exitoso");

				}
			} else {
				if (e.getComponent().getId().equals("ListoM")) {
					if (diagnosticoM == null || categoriaM == null
							|| categoriaM == "" || diagnosticoM == ""
							|| nomdiagM == null || nomdiagM.equals("")
							|| nomdiagM.equals("Selecciona")) {
						mensajes("error", "Ingresar todos los campos");
					} else {
						// Solucion tmpSol=new Solucion(10000);
						// nombreD="DannyJ";
						Diagnostico dia = obtenerDiagnostico(getNomdiagM());
						dia.setDescrDiagnostico(diagnosticoM);
						fija.setIdCategoria(categoriaIdentificar(categoriaM));
						solserv.updateSolicitud(fija);
						solserv.updateDiagnostico(dia);
						limpiarPantalla();
						mensajes("info", "Diagnostico modificado");

					}
				}

			}
		} else {
			mensajes("error", "Seleccione una solicitud");
		}
		fija = null;
		setIdFija("");

	}

	public Categoria categoriaIdentificar(String cat) {
		Categoria cate = new Categoria();
		if (cat.equals("hardware")) {
			cate.setIdCategoria(1);
			cate.setNombreCategoria(cat);
		}
		if (cat.equals("software")) {
			cate.setIdCategoria(2);
			cate.setNombreCategoria(cat);
		}
		System.out.println("Funciona cate" + cate.getNombreCategoria());
		return cate;
	}

	public void actualizarSol(ActionEvent e) {
		System.out.println("solucionDiag()");
		if (fija != null) {
			if (Solucion == null || Solucion == "") {
				mensajes("error", "Ingresar todos los campos");
			} else {
				Solucion sol = new Solucion(Solucion, Calendar.getInstance()
						.getTime());
				solserv.addSolucion(sol);
				fija.setFechaCierre(Calendar.getInstance().getTime());
				fija.setHoraCierre(Calendar.getInstance().getTime());
				fija.setIdEstado(new Estado(3, "finalizada"));
				solserv.updateSolicitud(fija);
				Diagnostico dia = obtenerDiagnostico(getNomdiag());
				dia.setIdSolucion(sol);
				solserv.updateDiagnostico(dia);
				mensajes("info", "Solucion Exitosa");

			}
		} else {
			mensajes("error", "Seleccione una solicitud");
		}

		fija = null;
		setIdFija("");
	}

	private Diagnostico obtenerDiagnostico(String nombre) {
		String[] nbs = nombre.split("-");
		return solserv.getDiagnosticoById(Integer.parseInt(nbs[0]));
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
	
	public void actualizarSolProPend(){
		solserv = new SolicitudServiceImpl();
		setSolicitudespropen(solserv.getSolicitudesProcesoPendientes());
		setMediumSolsModelFin(new SolicitudDataModel(getSolicitudesfin()));
	}
	

	public void onTabChange(TabChangeEvent event) {
		System.out.println(event.getTab().getTitle());
		fija = null;
		actualizarSolPen();
		actualizarSolPro();
		actualizarSolFin();
		actualizarSolProPend();
		// FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab: " +
		// event.getTab().getTitle());

		// FacesContext.getCurrentInstance().addMessage(null, msg);
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

	public void validaSelPro(ActionEvent ae) {
		if(fija!=null){
		List<String> diags = solserv
				.getListaDiagnosticos(fija.getIdSolicitud());
		System.out.println("TableBean.validaSelPro()");
		if (fija == null) {
			mensajes("error", "Seleccionar una Solicitud");
		} else {
			System.out.println(fija.getIdSolicitud());
			System.out.println(ae.getComponent().getId());
			if (ae.getComponent().getId().equals("Sol")) {
				System.out.println(diags.size());
				if (diags.size() == 0) {
					mensajes("error", "Realize primero un diagnostico");
				} else {
					setNomdiags(diags);
				}
			}
			if (ae.getComponent().getId().equals("DiagModi")) {
				System.out.println(diags.size());
				if (diags.size() == 0) {
					mensajes("error", "Realize primero un diagnostico");
				} else {
					setNomdiagsM(diags);
				}
			}
		}
		}else{
			mensajes("error", "Seleccionar una Solicitud");
		}
	}

	public void limpiarPantalla() {
		setPrioridad("");
		setTrabajador("");
		setCategoria("");
		setDiagnostico("");
		setNombreD("");
		//setIdFija(null);
		//setNomdiags(null);
		//setPrinames(null);
		setSolucion("");
		//setTraid(null);
		setTrbAten("");
		//setCategorias(null);
	}
	
	/*********************************************CAMBIO*******************************************************/
	

	
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
	
	
	
	/*****************************************************EVALUACION*************************************************/
	public void grabar(ActionEvent a){
		System.out.println("EvaluacionBean.grabar()");
		atenserv=new AtencionServiceImpl();
		
		String calif=getCalificacion();
		System.out.println(calif);
		System.out.println(getObservacion());
		Date Fecha = Calendar.getInstance().getTime();
		Atencion aten=buscarAtencion(fija.getIdSolicitud());
		Evaluacion eval=new Evaluacion(observacion, Fecha, Fecha, calificacionIdentificar(getCalificacion()));
		atenserv.addEvaluacion(eval);
		aten.setIdEvaluacion(eval);
		atenserv.updateAtencion(aten);
		fija=null;
		setIdFija("");
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
	
	/*********************************VALIDACION***********************************/
	public void validaSolAten(ActionEvent ae){
		System.out.println("TableBean.validaSel()");
		//setIdFija(fija.getIdSolicitud().toString());
		System.out.println(getIdFija());
		if(fija==null){
			mensajes("error","Seleccionar una Solicitud");
		}
	}
	
	public void validaSolReac(ActionEvent ae){
		if(fija==null){
			mensajes("error","Seleccionar una Solicitud");
		}
		else{
			System.out.println("Estamos Reactivando");
		}
	}
	
	public void validaSolCancel(ActionEvent ae){
		if(fija==null){
			mensajes("error","Seleccionar una Solicitud");
		}else{
			System.out.println("Estamos Cancelando");
		}	
	}
	
	
	public void reactivar(ActionEvent ae){
		TipoSolicitud idTipo;
		Estado idEstado;
		if(fija==null){
			mensajes("error","Seleccionar una Solicitud");
		}else{
			//System.out.println("Estamos Cancelando");
			atenserv=new AtencionServiceImpl();
			idTipo=atenserv.getTipoSolicitud(2);	
			System.out.println("Esta es:"+idTipo.getNombreTipo());
			
			idEstado=atenserv.getEstado(1);	
			System.out.println("Esta es:"+idEstado.getNombreEstado());
			
			fija.setIdTipo(idTipo);
			fija.setIdEstado(idEstado);
			solserv.updateSolicitud(fija);
			mensajes("info","Solicitud Reactivada...!!!");
		}	
	}
	
	public void cancelar (ActionEvent ae){
		TipoSolicitud idTipo;
		Estado idEstado;
		if(fija==null){
			mensajes("error","Seleccionar una Solicitud");
		}else{
			//System.out.println("Estamos Cancelando");
			atenserv=new AtencionServiceImpl();
			idTipo=atenserv.getTipoSolicitud(3);	
			System.out.println("Esta es:"+idTipo.getNombreTipo());
			
			idEstado=atenserv.getEstado(3);	
			System.out.println("Esta es:"+idEstado.getNombreEstado());
			
			fija.setIdTipo(idTipo);
			fija.setIdEstado(idEstado);
			solserv.updateSolicitud(fija);
			mensajes("info","Solicitud ha sido cancelada...!!!");
		}	
	}



	

	
	
	
}
