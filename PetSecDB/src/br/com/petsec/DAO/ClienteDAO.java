package br.com.petsec.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.petsec.factory.ConnectionFactory;
import br.com.petsec.model.Cliente;

public class ClienteDAO {
	
	public void save(Cliente cliente) {
		
		String sql = "INSERT INTO clientes(nomeCliente,sexoCliente,dataNascimento)"+
		"VALUES(?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToSQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cliente.getNomeCliente());
			pstm.setString(2, cliente.getSexoCliente());
			pstm.setDate(3, cliente.getDataNascimento());
			
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(pstm != null) {
					pstm.close();
				}
				
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
		
		public void removeById(int id){
			 
			 String sql = "DELETE FROM clientes WHERE id = ?";
			 
			 Connection conn = null;
			 PreparedStatement pstm = null;
			 
			 try {
			 conn = ConnectionFactory.createConnectionToSQL();
			 
			 pstm = conn.prepareStatement(sql);
			 
			 pstm.setInt(1, id);
			 
			 pstm.execute();
			 
			 } catch (Exception e) {
			 
			 e.printStackTrace();
			 }finally{
			 
			 try{
			 if(pstm != null){
			 
			 pstm.close();
			 }
			 
			 if(conn != null){
			 conn.close();
			 }
			 
			 }catch(Exception e){
			 
			 e.printStackTrace();
			 }
			 }
		}
			 
			 
			 public void updateCliente(Cliente cliente){
			 
			 String sql = "UPDATE contatos SET nome = ?, idade = ?, dataCadastro = ?" +
			 " WHERE id = ?";
			 
			 Connection conn = null;
			 PreparedStatement pstm = null;
			 
			 try {
			
			 conn = ConnectionFactory.createConnectionToSQL();
			 
			 
			 pstm = conn.prepareStatement(sql);
			 
			 
			 pstm.setString(1, cliente.getNomeCliente());
			 pstm.setString(2, cliente.getSexoCliente());
			 pstm.setDate(3, cliente.getDataNascimento());
			 
			 pstm.execute();
			 
			 } catch (Exception e) {
			 
			 e.printStackTrace();
			 }finally {
			 
			 //Fecha as conexões
			 
			 try{
			 if(pstm != null){
			 
			 pstm.close();
			 }
			 
			 if(conn != null){
			 conn.close();
			 }
			 
			 }catch(Exception e){
			 
			 e.printStackTrace();
			 }
			 }
			 }
			
			 
			 public List<Cliente> getCliente(){
			 
			 String sql = "SELECT * FROM contatos";
			 
			 List<Cliente> clientes = new ArrayList<Cliente>();
			 
			 Connection conn = null;
			 PreparedStatement pstm = null;
			 ResultSet rset = null;
			 
			 try {
			 conn = ConnectionFactory.createConnectionToSQL();
			 pstm = conn.prepareStatement(sql);
			 rset = pstm.executeQuery();
			 
			 while(rset.next()){
			 
			 Cliente cliente = new Cliente();
			 
			 cliente.setNomeCliente(rset.getString("nome"));
			 cliente.setIDCliente(rset.getInt("id"));
			 cliente.setSexoCliente(rset.getString("sexo"));
			 cliente.setDataNascimento(rset.getDate("dataNascimento"));
			 clientes.add(cliente);
			 }
			 } catch (Exception e) {
			 
			 e.printStackTrace();
			 }finally{
			 
			 try{
			 
			 if(rset != null){
			 
			 rset.close();
			 }
			 
			 if(pstm != null){
			 
			 pstm.close();
			 }
			 
			 if(conn != null){
			 conn.close();
			 }
			 
			 }catch(Exception e){
			 
			 e.printStackTrace();
			 }
			 }
			 
			 return clientes;
			 }
	}
	

