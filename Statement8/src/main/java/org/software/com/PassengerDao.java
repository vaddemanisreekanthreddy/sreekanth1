package org.software.com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class PassengerDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	 public int savePassenger(PassengerDetails passenger) {
	        String sql = "INSERT INTO PassengerDetails (Passenger_name, Passenger_dob, Passenger_phone, Passenger_email) VALUES (?, ?, ?, ?)";
	        
	        return jdbcTemplate.update(sql, 
	            passenger.getPassengerName(),
	            new java.sql.Date(passenger.getPassengerDob().getTime()), // Convert java.util.Date to java.sql.Date
	            passenger.getPassengerPhone(),
	            passenger.getPassengerEmail());
	    }

	public int updatePassenger(PassengerDetails passenger) {
		String xyz = "update PassengerDetails set name=' " + passenger.getPassengerName() + " ',Passenger_dob=' "
				+ passenger.getPassengerDob() + " ',Passenger_phone=' " + passenger.getPassengerPhone()
				+ " ',Passenger_email=' " + passenger.getPassengerPhone() + " ' where id=' "
				+ passenger.getPassengerId() + " ' ";
		return jdbcTemplate.update(xyz);
	}

	public int deletePassenger(PassengerDetails passenger) {
		String xyz = "delete from PassengerDetails where id=" + passenger.getPassengerId() + ";
		return jdbcTemplate.update(xyz);
	}

	public List<PassengerDetails> finaAllPassenger() {
		return jdbcTemplate.query("select * from PassengerDetails", new RowMapper<PassengerDetails>() {
			public PassengerDetails mapRow(ResultSet rs, int rownumber) throws SQLException {
				PassengerDetails passenger = new PassengerDetails();
				passenger.setPassengerId(rs.getInt(1));
				passenger.setPassengerName(rs.getString(2));
				passenger.setPassengerDob((rs.getDate(1)));
				passenger.setPassengerPhone(rs.getString(4));
				passenger.setPassengerEmail(rs.getString(5));
				System.out.println("The row numbers " + rownumber);
				return passenger;
			}
		});
	}
	
	
	public PassengerDetails findById(int id) {
        String sql = "SELECT * FROM PassengerDetails WHERE Passenger_id = ?";
        
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<PassengerDetails>() {
            public PassengerDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
                PassengerDetails passenger = new PassengerDetails();
                passenger.setPassengerId(rs.getInt("Passenger_id"));
                passenger.setPassengerName(rs.getString("Passenger_name"));
                passenger.setPassengerDob(rs.getDate("Passenger_dob"));
                passenger.setPassengerPhone(rs.getString("Passenger_phone"));
                passenger.setPassengerEmail(rs.getString("Passenger_email"));
                return passenger;
            }
        });
    }

//	public PassengerDetails findById(int id) {
//		String xyz="select * from PassengerDetails where id=' "+id+" ' ";
//		return jdbcTemplate.	
//		return null;
//	}

}
