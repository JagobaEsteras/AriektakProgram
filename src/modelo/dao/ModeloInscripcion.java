package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Conector;
import modelo.bean.Actividad;
import modelo.bean.Inscripcion;
import modelo.bean.Usuario;

public class ModeloInscripcion extends Conector {

	  
	    public ArrayList<Inscripcion> selectAll()  {
	    	
	    	ArrayList<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
	    	
	        try {
	            PreparedStatement pst = super.conexion.prepareStatement("SELECT * FROM inscripciones INNER JOIN  usuarios on inscripciones.id_usuario = usuarios.id INNER join actividades on inscripciones.id_actividad = actividades.id");
	            ResultSet rs = pst.executeQuery();
	            
	            while (rs.next()) {
	                Inscripcion inscripcion = new Inscripcion();
	                inscripcion.setId(rs.getInt("id"));
	                
	                
	                
	                
	                Usuario usuario= new Usuario();
	                usuario.setId(rs.getInt("id_usuario"));
	                usuario.setNombreApellido(rs.getString("nombre_apellido"));
	                usuario.setDni(rs.getString("dni"));
	                usuario.setCodigo(rs.getString("codigo"));
	                inscripcion.setUsuario(usuario);
	                
	                
	                
	                Actividad actividad = new Actividad();
	               
	                actividad.setId(rs.getInt("id_actividad"));
	                actividad.setNombre(rs.getString("nombre"));
	                actividad.setDias(rs.getString("dias_semana"));
	                actividad.setFecha_inicio(rs.getDate("fecha_inicio"));
	                actividad.setHoras(rs.getInt("horas"));
	                actividad.setMaxParticipantes(rs.getInt("max_participantes"));
	                actividad.setPrecio(rs.getDouble("precio"));
	                
	                inscripcion.setActividad(actividad);
	                
	                inscripciones.add(inscripcion);
	            }
	        }
	            
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return inscripciones;
	    }
}
