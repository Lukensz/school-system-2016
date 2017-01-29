package edu.wi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import edu.wi.entity.User;
import edu.wi.entity.Uczen;
import edu.wi.entity.Rodzic;
import edu.wi.entity.Nauczyciel;
import edu.wi.entity.Administrator;

public class UzytkownikDAO {

	public JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void set(Administrator administrator) {
		String sql = "INSERT INTO User (imie, nazwisko, login, password, email, uprawnienia) VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, administrator.getImie(), administrator.getNazwisko(), administrator.getLogin(), administrator.getPassword(), administrator.getEmail(), administrator.getUprawnienia());
	}
	public void set(Nauczyciel nauczyciel) {
		String sql = "INSERT INTO User (imie, nazwisko, login, password, email) VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, nauczyciel.getImie(), nauczyciel.getNazwisko(), nauczyciel.getLogin(), nauczyciel.getPassword(), nauczyciel.getEmail());
	}
	public void set(Uczen uczen) {
		String sql = "INSERT INTO User (imie, nazwisko, login, password, email, klasa) VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, uczen.getImie(), uczen.getNazwisko(), uczen.getLogin(), uczen.getPassword(), uczen.getEmail(), uczen.getKlasa());
	}
	public void set(Rodzic rodzic) {
		String sql = "INSERT INTO User (imie, nazwisko, login, password, email, telefon) VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, rodzic.getImie(), rodzic.getNazwisko(), rodzic.getLogin(), rodzic.getPassword(), rodzic.getEmail(), rodzic.getTelefon());
	}
	
	public void edit(User user) {
		if(user.getImie() != null) {
			String sql = "UPDATE User SET imie = ? WHERE id = ?";
			jdbcTemplate.update(sql, user.getImie(), user.getId());
		}
		
		if(user.getNazwisko() != null) {
			String sql = "UPDATE User SET nazwisko = ? WHERE id = ?";
			jdbcTemplate.update(sql, user.getNazwisko(), user.getId());
		}
	}
	
	public List<User> getAll() {
		String sql = "SELECT imie, nazwisko, login, email FROM User";
		
		List<User> users = jdbcTemplate.query(
			    sql,
			    new RowMapper<User>() {
			        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			        	User user = new User();
			        	user.setImie(rs.getString(1));
			        	user.setNazwisko(rs.getString(2));
			        	user.setLogin(rs.getString(3));
			            user.setEmail(rs.getString(4));
			        	
			            return user;
			        }
			    });
		return users;
	}
	
	public User get(int id) {
		String sql = "SELECT imie, nazwisko, login, email FROM User WHERE id = ?";
		
		User user = jdbcTemplate.queryForObject(sql, new Object[] { id }, User.class);
		
		return user;
		
	}
	
	public void delete(int id) {
		jdbcTemplate.update("DELETE FROM users WHERE id = ?", new Object[] { id });
	}

	
}
