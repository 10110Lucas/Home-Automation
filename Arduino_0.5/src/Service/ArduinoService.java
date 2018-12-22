package Service;

import java.util.ArrayList;

import DAO.ArduinoDAO;
import Model.Arduino;

public class ArduinoService {
	ArduinoDAO dao = new ArduinoDAO();
	
	public int criar(Arduino arduino) {
		return dao.criar(arduino);
	}
	
	public Arduino carregar(int id) {
		return dao.carregar(id);
	}
	
	public ArrayList<Arduino> lista2(){
		return dao.lista2();
	}
}
