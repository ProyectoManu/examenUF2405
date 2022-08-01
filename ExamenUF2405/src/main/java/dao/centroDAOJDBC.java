package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Departamento;
import utilidades.ConexionBD;



public class centroDAOJDBC implements centroDAO {
	
	private ConexionBD conexion;
	private Statement consulta = null;
	private PreparedStatement consultaPreparada = null;
	private ResultSet resultado = null;
	
	public CentroDAOJDBC() {
		conexion = new ConexionBD();
	}
	
	@Override
	public List<Centro> getCentros() {
		List<Centro> listaCentros = new ArrayList<DCentro>();
		Connection con = conexion.getConexion();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from centros");
			while (resultado.next()) {
				int cod_centro = resultado.getInt("cod_centro");
				String nombre = resultado.getString("nombre");
				String direccion = resultado.getString("direccion");
				
				Centro emp = new Centro(cod_centro, nombre, direccion);
				
				

				listaCentros.add(emp);
			}
			System.out.println("A�adidos todos los centros: ");
			System.out.println(listaCentros);
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre centros: "+e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}

	
		return listaCentros;

		@Override
		public int insertarCentro(Centro centro) {
			Connection con = conexion.getConexion();
			int resultado=0;
			
			try {
				consultaPreparada = con.prepareStatement("INSERT INTO Departamentos "
						+ "VALUES (?,?,?)");
				
				consultaPreparada.setInt(1, centro.getCod_centro());
				consultaPreparada.setInt(2, centro.getNombre());
				consultaPreparada.setString(3, centro.getDireccion());
				
				resultado=consultaPreparada.executeUpdate();
				System.out.println("Centro insertado: ");
				System.out.println(centro);

			} catch (SQLException e) {
				System.out.println("Error al realizar la inserci�n del centro: " + centro
			        +e.getMessage());
			} finally {
				try {
					consulta.close();
					conexion.desconectar();
				} catch (SQLException e) {
					System.out.println("Error al liberar recursos: "+e.getMessage());
				} catch (Exception e) {
					
				}
			}
			return resultado;
		}

		@Override
		public int actualizarCentro(Centro centro) {
			Connection con = conexion.getConexion();
			int resultado=0;
			
			try {
				consultaPreparada = con.prepareStatement("UPDATE centros\r\n"
						
						+ "    nombre=?, \r\n"
						+ "    direccion=?, \r\n"
						+ "WHERE cod_centro=?");
						
				

				consultaPreparada.setInt(1, centro.getCod_centro());
				consultaPreparada.setString(2, centro.getNombre());
				consultaPreparada.setString(3, centro.getDireccion());
				resultado=consultaPreparada.executeUpdate();
				
				
				
				System.out.println("Centro actualizado: ");
				System.out.println(centro);

			} catch (SQLException e) {
				System.out.println("Error al realizar la actualizacion del centro: "+consultaPreparada
						+e.getMessage());
			} finally {
				try {
					consulta.close();
					conexion.desconectar();
				} catch (SQLException e) {
					System.out.println("Error al liberar recursos: "+e.getMessage());
				} catch (Exception e) {
					
				}
			}
			return resultado;
		}
	@Override
	public int eliminarCentro(int cod_centro) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("DELETE FROM Centros\r\n"
					+ "WHERE cod_centro = ?");
			
			consultaPreparada.setInt(1, cod_centro);
			resultado=consultaPreparada.executeUpdate();
			System.out.println("Departamento borrado correctamente: "+cod_centro);

		} catch (SQLException e) {
			System.out.println("Error al realizar el borrado de Departamento: "+e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
	}

}
