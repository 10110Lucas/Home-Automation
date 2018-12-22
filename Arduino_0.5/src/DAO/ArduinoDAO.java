package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.ConnectionFactory;
import Model.Arduino;

public class ArduinoDAO {
	
	public int criar(Arduino arduino) {
		String sqlInsert = "INSERT INTO arduino(dia, consumo, tempoDeUso, luminosidade, potenciaConsumida) "
									  +"VALUES (?, ?, ?, ?, ?)";		
		try (Connection conn = ConnectionFactory.connection();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, arduino.getData());
			stm.setDouble(2, arduino.getConsumo());
			stm.setString(3, arduino.getTempoDeUso());
			stm.setInt   (4, arduino.getLuminosidade());
			stm.setDouble(5, arduino.getPotencia());
			stm.execute();			
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					arduino.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arduino.getId();
	}
	
	public Arduino carregar(int id) {
		Arduino arduino = new Arduino();
		arduino.setId(id);
		String sql = "SELECT * FROM arduino WHERE arduino.id = ?";		
		try(Connection conn = ConnectionFactory.connection();
				PreparedStatement ps = conn.prepareStatement(sql);){
			ps.setInt(1, arduino.getId());			
			try(ResultSet rs = ps.executeQuery();){				
				if(rs.next()) {
					arduino.setData(rs.getString("dia"));
					arduino.setConsumo(rs.getDouble("consumo"));
					arduino.setTempoDeUso(rs.getString("tempoDeUso"));
					arduino.setLuminosidade(rs.getInt("luminosidade"));
					arduino.setPotencia(rs.getDouble("potencia"));
				}else {
					arduino.setId(-1);
					arduino.setData(null);
					arduino.setConsumo(-1);
					arduino.setTempoDeUso(null);
					arduino.setLuminosidade(-1);
					arduino.setPotencia(-1);
				}				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}catch(SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return arduino;
	}
	
	public ArrayList<Arduino> lista2(){
		Arduino arduino;
		ArrayList<Arduino> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, dia, luminosidade, potenciaConsumida, tempoDeUso FROM arduino";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.connection();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					arduino = new Arduino();
					arduino.setId(rs.getInt("id"));
					arduino.setData(rs.getString("dia"));
					arduino.setLuminosidade(rs.getInt("luminosidade"));
					arduino.setPotencia(rs.getDouble("potenciaConsumida"));
					arduino.setTempoDeUso(rs.getString("tempoDeUso"));
					lista.add(arduino);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
}
