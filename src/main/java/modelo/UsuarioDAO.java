package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class UsuarioDAO {

Conexion con=new Conexion();
Connection cnn=con.conexiondb();
PreparedStatement ps;

public boolean insertarusuario(UsuarioDTO us) {
	int x;
	boolean dat=false;
	try {
		ps=cnn.prepareStatement("INSERT INTO usuarios (nomusu,clave,rol,estado) VALUES(?,?,?,?)");
		//ps.setInt(1, us.getDocumento());
		ps.setString(1, us.getNomusuario());
		ps.setString(2, us.getClave());
		ps.setString(3, us.getRol());
		ps.setString(4, us.getEstado());
		x=ps.executeUpdate();
		if(x>0) {
			dat=true;
		}
		
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, "Error al insertar"+e);
		
	}
	
	return dat;
}
	
	
	
}
