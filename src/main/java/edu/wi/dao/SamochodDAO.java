package edu.wi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import edu.wi.entity.Samochod;

public class SamochodDAO {
	
	public JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insert(Samochod samochod) {
		String sql = "INSERT INTO Samochod (marka, model) VALUES (?, ?)";
		jdbcTemplate.update(sql, samochod.getMarka(), samochod.getModel());
	}
	
	public List<Samochod> findByModel() {
		String sql = "SELECT marka, model FROM Samochod";
		
		List<Samochod> cars = jdbcTemplate.query(
			    sql,
			    new RowMapper<Samochod>() {
			        public Samochod mapRow(ResultSet rs, int rowNum) throws SQLException {
			            Samochod c = new Samochod();
			            c.setMarka(rs.getString(1));
			            c.setModel(rs.getString(2));
			            
			            return c;
			        }
			    });
		return cars;
	}
}
