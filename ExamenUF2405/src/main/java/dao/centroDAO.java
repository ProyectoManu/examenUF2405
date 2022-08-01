package dao;

import java.util.List;

public interface centroDAO {

	List<Centro> getCentro();
	Centro getCentro(int cod_centro);
	int eliminarCentro(int cod_centro);
}
