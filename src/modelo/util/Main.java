package modelo.util;

import java.util.ArrayList;

import modelo.bean.Actividad;
import modelo.dao.ModeloActividad;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ModeloActividad mActividad = new ModeloActividad();
		ArrayList<Actividad> ACTIVIDADES = mActividad.selectAll();
		System.out.println(ACTIVIDADES);
		
	}

}
