package modelo.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.bean.Actividad;
import java.util.ArrayList;
import modelo.Conector;

public class ModeloActividad extends Conector
{
    public ArrayList<Actividad> selectAll() {
    	
         ArrayList<Actividad> actividades = new ArrayList<Actividad>();
         
        try {
             PreparedStatement pst = super.conexion.prepareStatement("select * from actividades");
             ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Actividad actividad = new Actividad();
                actividad.setId(rs.getInt("id"));
                actividad.setNombre(rs.getString("nombre"));
                actividad.setDias(rs.getString("dias_semana"));
                actividad.setFecha_inicio(rs.getDate("fecha_inicio"));
                actividad.setHoras(rs.getInt("horas"));
                actividad.setMaxParticipantes(rs.getInt("max_participantes"));
                actividad.setPrecio(rs.getDouble("precio"));
                actividades.add(actividad);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return actividades;
    }
    
    public ArrayList<Actividad> buscar(String parte) {
         ArrayList<Actividad> actividades = new ArrayList<Actividad>();
        try {
            PreparedStatement pst = super.conexion.prepareStatement("select * from actividades where nombre like ?");
            
            pst.setString(1, "%" + parte + "%");
            
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
            	
                 Actividad actividad = new Actividad();
                
                actividad.setId(rs.getInt("id"));
                actividad.setNombre(rs.getString("nombre"));
                actividad.setDias(rs.getString("dias_semana"));
                actividad.setFecha_inicio(rs.getDate("fecha_inicio"));
                actividad.setHoras(rs.getInt("horas"));
                actividad.setMaxParticipantes(rs.getInt("max_participantes"));
                actividad.setPrecio(rs.getDouble("precio"));
                actividades.add(actividad);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return actividades;
    }
    
    public ArrayList<Actividad> selectAllConInscripciones() {
		ArrayList<Actividad> actividades = new ArrayList<Actividad>();
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from actividades");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Actividad actividad = new Actividad();
				actividad.setId(rs.getInt("id"));
				actividad.setNombre(rs.getString("nombre"));
				actividad.setDias(rs.getString("dias_semana"));
				actividad.setFecha_inicio(rs.getDate("fecha_inicio"));
				actividad.setHoras(rs.getInt("horas"));
				actividad.setMaxParticipantes(rs.getInt("max_participantes"));
				actividad.setPrecio(rs.getDouble("precio"));
				
				PreparedStatement Preparendst = super.conexion.prepareStatement("select usuarios from in");
				
				
				
				//consegir los usuarios inscritos con el id de actividad
				//anadirlos al arrayList de inscripciones
				//anadirlos a la actividad

				actividades.add(actividad);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actividades;
	}
    }
