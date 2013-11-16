package com.proyecto.siswebastec.bean;

import java.util.List;

import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.proyecto.siswebastec.model.Solicitud;

public class SolicitudDataModel extends ListDataModel<Solicitud> implements SelectableDataModel<Solicitud> {  

    public SolicitudDataModel() {
    }

    public SolicitudDataModel(List<Solicitud> data) {
        super(data);
    }
    
    @Override
    public Solicitud getRowData(String rowKey) {
    	System.out.println("SolicitudDataModel.getRowData()");
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data
        System.out.println("RowKey:"+rowKey);
        List<Solicitud> solicitudes = (List<Solicitud>) getWrappedData();
        Solicitud sol = null;
        for(int i=0;i<solicitudes.size();i++){        	
        	//System.out.println("solicitudes: "+sol.getIdSolicitante());
        	//System.out.println("solicitudes: "+solicitudes.size());
        	if(solicitudes.get(i).getIdSolicitud().toString().equals(rowKey)){
        		sol = solicitudes.get(i);
        		System.out.println("Hola");
        		System.out.println(sol.getDescSolicitud());
        		//return sol;
        	}
        }
        /*for(Solicitud sol : solicitudes) {        	
        	if(sol.getIdSolicitud().equals(rowKey))
                return sol;
        }*/
        
        return sol;
    }

    @Override
    public Object getRowKey(Solicitud sol) {
    	System.out.println("SolicitudDataModel.getRowKey()");
        return sol.getIdSolicitud();
    }
}