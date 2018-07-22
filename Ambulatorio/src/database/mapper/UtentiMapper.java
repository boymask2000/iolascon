package database.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import beans.Utente;

public interface UtentiMapper {
	final String SELECT_ALL = "SELECT * FROM utenti";
	final String DELETE = "DELETE FROM utenti WHERE ID = #{id}";
	final String SELECT_BY_ID = "SELECT * FROM utenti WHERE ID = #{id}";
	
	final String SELECT_ADMINS = "SELECT * FROM utenti where admin='Y'";
	
	final String UPDATE = "UPDATE utenti SET"
		
			+ " user = #{user},"
			+ " password = #{password},"
			+ " email = #{email},"
			+ " attivo = #{attivo},"
			+ " admin = #{admin},"
			+ " note = #{note}"
			
			+ " WHERE ID = #{id}";
	

	final String SEARCH = "SELECT * FROM utenti WHERE "
	+ " user = #{user} AND"
	+ " password = #{password}";
	

	final String INSERT = "INSERT INTO utenti (user ," 
						+ " password ," 
			+" email ," 
			+" attivo ," 
			+" admin," 
			+" note  ) "
			+ ""
			+ "VALUES (#{user}, #{password}, #{email},"+
	" #{attivo}, #{admin}, #{note} )";
	
	@Select(SELECT_ALL)
	@Results(value = {
		@Result(property="id", column="ID"),
		@Result(property="user", column="user"),
		@Result(property="password", column="password"),
		@Result(property="email", column="email"),
		@Result(property="admin", column="admin"),
		@Result(property="note", column="note")
	})
	public List<Utente> selectAll();
	
	@Update(UPDATE)
	public void update(Utente contact);
	
	@Insert(INSERT)
	public void insert(Utente contact);
	
	@Select(SEARCH)
	public Utente search(Utente contact);
	
	@Select(DELETE)
	public Utente delete(Utente contact);
	
	@Select(SELECT_ADMINS)
	@Results(value = {
			@Result(property="id", column="ID"),
			@Result(property="user", column="user"),
			@Result(property="password", column="password"),
			@Result(property="email", column="email"),
			@Result(property="admin", column="admin"),
			@Result(property="note", column="note")
		})
	public List<Utente>  getAdmins();
}
