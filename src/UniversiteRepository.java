package Class; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Interface.IJournal;
import Interface.IUnivRepo;
import Abstract.AbstractFactory;

public class UniversiteRepository implements IUnivRepo {
	
	private IJournal journal;

	public UniversiteRepository(IJournal comp) {
		this.journal = comp;
	}

	@Override
	
	public Universite GetById(int universityId) throws SQLException {
		
		Connection connect=DBConnection.getConn();
		
		Statement stmt = connect.createStatement();
		AfficheDateClass.setSender("UniversiteRepository");
		journal.outPut_Msg("LogBD : d�but recherche de id universit� dans la base de donn�e");
		
		String sql = "select * from universite where id_universite="+ universityId;
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();	
		TypePackage p=TypePackage.valueOf(rs.getString(3));
		Universite u = new Universite (rs.getInt(1),rs.getString(2),p);
			
		journal.outPut_Msg("LogBD : universit� r�cup�r�e");
		
		connect.close();
		return u;	
	
		}	
	
	@Override
	public int GetNbrLivre(int IdUniv) throws SQLException {
		Universite univ= GetById(IdUniv);
		AbstractFactory turbo = new Type();
		Package pack = turbo.getPackage(univ.getPack());

		return pack.getNbrLivreAutorise();
	}
	@Override
	public int NbrBonus(int IdUniv) throws SQLException{

		Universite univ= GetById(IdUniv);
		AbstractFactory turbo = new Type();
		Package pack = turbo.getPackage(univ.getPack());

		return pack.getNbrLivreBonus();
	}
}
