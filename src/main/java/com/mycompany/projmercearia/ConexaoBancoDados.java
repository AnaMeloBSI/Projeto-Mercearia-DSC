import java.sql.*;


public class ConexaoBancoDados {


private final String URL =
"jdbc:mysql://localhost:3306/mercearia";

private final String USER="root";

private final String PASS="";


public Connection obterConexao(){

try{

return DriverManager.getConnection(
URL,USER,PASS);

}catch(Exception e){

System.out.println(e.getMessage());

}

return null;

}



public boolean fecharConexao(Connection c){

try{

c.close();

return true;

}catch(Exception e){

return false;
}


}


}
