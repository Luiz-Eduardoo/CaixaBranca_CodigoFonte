package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
	/*1*/public Connection conectarBD() { 
		/*2*/Connection conn = null;
	/*3*/	try {
		
				//Conexão feita da maneira errada errada
		/*4*/	Class.forName("com.mysql.Driver.Manager").newInstance();
		/*4*/	String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
		/*4*/	conn = DriverManager.getConnection(url);
	/*5*/} /*6*/ catch (Exception e){  }/*7*/ // catch esta vazio sem fazer nenhuma exceção
		return conn; /*8*/
		} /*9*/
	public String nome="";
	public boolean result = false;
	/*10*/public boolean verificarusuario(String login, String senha) {
	String sql = "";
	/*11*/Connection conn = conectarBD();
		// INSTRUÇÃO SQL
	// falta um espaco no final de usuarios ou no inicio de where para que possa ser feito a pesquisa do login (igual esta na linha de senha)
	sql += "select nome from Usuarios";
	sql += "where login = " + "'" + login + "'";
	sql += " and  senha = " + "'" + senha + "';"; 
	/*12*/try {
		
		/*13*/Statement st = conn.createStatement();
		/*13*/ResultSet rs = st.executeQuery(sql);
			/*14*/if(rs.next()) {
				/*15*/result = true;
				/*15*/nome = rs.getString("nome");}/*16*/
			/*17*/}	/*18*/catch (Exception e) {   }/*19*/ // catch vazio 
			return result; /*20*/
			}/*21*/
		}// fim da class
