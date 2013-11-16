package com.proyecto.siswebastec.prueba;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

public class CreateProduct implements Serializable{

		public void cancelAddBrand(ActionEvent e){
			//RequestContext.getCurrentInstance().addCallbackParam("success", true);
			
			
		}
		
		public void cancelAddProductCategory(ActionEvent e){
			//RequestContext.getCurrentInstance().addCallbackParam("success", true);
			
		}
		
		public String createNew(){
			
			System.out.println("HOLAAAAA...!!!");
			RequestContext.getCurrentInstance().addCallbackParam("success", true);
			/*if (pnlOne is visible) {
			    RequestContext.getCurrentInstance().addCallbackParam("pnlone", true); 
			}
			if (pnlTwo is visible) {
			    RequestContext.getCurrentInstance().addCallbackParam("pnltwo", true); 
			}RequestContext.getCurrentInstance().*/
			
			
			return "";
		}
}
