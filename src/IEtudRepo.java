package Interface;

import java.sql.SQLException;

public interface IEtudRepo {


	abstract void add(IEtudiant E) throws SQLException;

    abstract boolean Exists(int matricule) throws SQLException;

    abstract boolean Exists(String email) throws SQLException;
    
    abstract public boolean VerifEmailMat(int Mat, String Email) throws SQLException;

}