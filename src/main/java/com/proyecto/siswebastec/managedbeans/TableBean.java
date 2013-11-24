package com.proyecto.siswebastec.managedbeans;

import com.proyecto.siswebastec.services.AtencionService;
import com.proyecto.siswebastec.services.PrioridadService;
import com.proyecto.siswebastec.services.SolicitudService;
import com.proyecto.siswebastec.services.TrabajadorService;
import com.proyecto.siswebastec.servicesImpl.AtencionServiceImpl;
import com.proyecto.siswebastec.servicesImpl.PrioridadServiceImpl;
import com.proyecto.siswebastec.servicesImpl.SolicitudServiceImpl;
import com.proyecto.siswebastec.servicesImpl.TrabajadorServiceImpl;
import com.proyecto.siswebastec.bean.SolicitudDataModel;
import com.proyecto.siswebastec.model.Atencion;
import com.proyecto.siswebastec.model.Calificacion;
import com.proyecto.siswebastec.model.Categoria;
import com.proyecto.siswebastec.model.Estado;
import com.proyecto.siswebastec.model.Prioridad;
import com.proyecto.siswebastec.model.Solicitud;
import com.proyecto.siswebastec.model.Solucion;
import com.proyecto.siswebastec.model.Trabajador;
import com.proyecto.siswebastec.model.Diagnostico;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.UnselectEvent;

public class TableBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<Solicitud> solicitudes,solicitudespend,solicitudespro,solicitudesfin;
	private SolicitudService solserv;
	private Solicitud selectedSol;
	private SolicitudDataModel mediumSolsModel,mediumSolsModelPro,mediumSolsModelFin,mediumSolsPend; 
	private Solicitud fija;
	
	private String prioridad;
	private String trabajador;
	private String categoria;
//    private List<Prioridad> prioridades;  
    private List<String> prinames;
    private List<String> traid;
    private List<String> categorias;
    private PrioridadService prioridadService;
    private TrabajadorService trabajadorService;
    private AtencionService atencionService;
    
    /*******Diagnostico y Solucion*****/
    private String Diagnostico;
    private String Solucion;

	public TableBean(){
		System.out.println("TableBean.TableBean()");
		solicitudes=new ArrayList<Solicitud>();
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
		//mediumSolsPend= new SolicitudDataModel(solicitudes);
		
		
		prioridadService = new PrioridadServiceImpl();
    	trabajadorService = new TrabajadorServiceImpl();
  //  	prioridades = new ArrayList<>();
  //  	prioridades = prioridadService.getPrioridades();
    	prinames = new ArrayList<>();
    	traid = new ArrayList<>();
    	categorias=new ArrayList<>();
    	categorias=solserv.getListaCat();
    	prinames = prioridadService.getNombresPri();
    	traid = trabajadorService.getIdTrabajadores();
    	atencionService = new AtencionServiceImpl();
		
//		System.out.println("Holitas!");
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
		//solserv=new SolicitudServiceImpl();
		//setSolicitudesfin(solserv.getSolicitudesFinalizadas());
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
		  
    }       
    
    public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public List<String> getPrinames() {		
		//prioridadService = new PrioridadServiceImpl();
		//setPrinames(prioridadService.getNombresPri());
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
		return Diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		Diagnostico = diagnostico;
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
	
	public void asignarTecnico(ActionEvent actionEvent){
		System.out.println("TableBean.asignarTecnico()");
		Boolean error = false;
		if(fija!=null){
			Trabajador t = trabajadorService.getTrabajadorById(getTrabajador());
			Date Fecha = Calendar.getInstance().getTime();
			System.out.println("Prioridad"+getPrioridad());
			System.out.println("Hooooooola fija"+ fija.getDescSolicitud());
			Prioridad p = new Prioridad();
			if((getTrabajador()==null||getTrabajador().equals(""))
					|| (getPrioridad()==null || getPrioridad().equals(""))){
				error=true;
			}
			if(error==false){
				p.setNombrePrioridad(getPrioridad());
				
				if(getPrioridad().equals("alta")){
					p.setIdPrioridad(1);			
				}
				if(getPrioridad().equals("media")){
					p.setIdPrioridad(2);			
				}
				if(getPrioridad().equals("baja")){
					p.setIdPrioridad(3);			
				}
				
				Solicitud sasig = fija;
				System.out.println("Solicitud"+sasig.getDescSolicitud());
				sasig.setIdPrioridad(p);		
				sasig.setIdEstado(new Estado(2,"en proceso"));
				solserv.updateSolicitud(sasig);
				
				//Creamos la atencion
				
				Atencion ate = new Atencion();
				ate.setIdSolicitud(sasig);
				ate.setFechaAtencion(Fecha);
				ate.setHoraAtencion(Fecha);
				ate.setTrabajador(t);
				atencionService.addAtencion(ate);
				mensajes("info","Atenci�n registrada");
			}else{
				mensajes("error","Ingresar todos los campos");
			}
		}else{
			mensajes("error","Seleccionar una solicitud");
		}
	}
	
	public void handleChangeP() {  
		System.out.println("evento: "+prioridad);
    }
	
	public void handleChangeT() {  
		System.out.println("evento: "+trabajador);
    }
	
	public void handleChangeC(){
		System.out.println("evento: "+categoria);
	}
	
	public void actualizarDiag(ActionEvent e){
		System.out.println("actualizarDiag()");
		System.out.println(Diagnostico);
		System.out.println(categoria);
		System.out.println("fija:" + fija.getIdSolicitud());
	//	System.out.println(getSelectedSol().getIdSolicitud().toString());
		Diagnostico diag=new Diagnostico(fija,Diagnostico, Calendar.getInstance().getTime());
		solserv.addDiagnostico(diag);
		fija.setIdCategoria(categoriaIdentificar(categoria));;
	}
	
	public Categoria categoriaIdentificar(String cat){
		Categoria cate=new Categoria();
		 if(cate.equals("hardware")){cate.setIdCategoria(1);cate.setNombreCategoria(cat);}
		 if(cate.equals("software")){cate.setIdCategoria(2);cate.setNombreCategoria(cat);}
		 
		return cate;
	}
	
	public void actualizarSol(ActionEvent e){
		System.out.println("solucionDiag()");
		Solucion sol= new Solucion(fija, Solucion, Calendar.getInstance().getTime());
		solserv.addSolucion(sol);
		fija.setFechaCierre(Calendar.getInstance().getTime());
		fija.setHoraCierre(Calendar.getInstance().getTime());
		fija.setIdEstado(new Estado(3, "finalizada"));
		solserv.updateSolicitud(fija);
	}
	
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
	
	public void mensajes(String tipo, String msj){
		FacesContext context = FacesContext.getCurrentInstance();  
		FacesMessage msg = null;		
		if(tipo.equals("error")){
			msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msj, "");
			//FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		if(tipo.equals("info")){
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, msj, "");
			//FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		System.out.println("Context"+context.toString());
		context.addMessage(null,msg);
	}
	
	public void validaSel(ActionEvent ae){
		if(fija==null){
			mensajes("error","Seleccionar una Solicitud");
		}
	}
	
	public void validaSelPro(ActionEvent ae){
		System.out.println("TableBean.validaSelPro()");
		if(fija==null){			
			mensajes("error","Seleccionar una Solicitud");
		}else{
			System.out.println(fija.getIdSolicitud());
			System.out.println(ae.getComponent().getId());
			if(ae.getComponent().getId()=="Sol"){
				if(fija.getDiagnosticoList().size()==0){
					mensajes("error","Realize primero un diagnostico");
				}
			}
			if(ae.getComponent().getId()=="Diag"){
				
			}
		}
	}
	
}
