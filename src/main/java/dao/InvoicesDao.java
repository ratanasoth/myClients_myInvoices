package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import model.Customer;
import model.Invoices;
import util.DBCP2DataSourceUtils;

public class InvoicesDao {

	private static JdbcTemplate jdbcTemplate = new JdbcTemplate(DBCP2DataSourceUtils.getDataSource());

	public InvoicesDao() {}
	
	
	//ACTION: DETAIL by ID
	public Invoices getById(Integer id) throws SQLException {
		if (id == null) {
			return null;
		}
		Invoices invoices = null;
		String sql = "SELECT * FROM tbl_invoices WHERE inv_id = ?";
		System.out.println(sql);
        invoices = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                new InvoicesMapper());
        System.out.println(invoices);
		return invoices;
	}
	
	// ACTION : GET All
	public List<Invoices> getAll(int limit, int offset, String search){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT SQL_CALC_FOUND_ROWS "
				+ "t.* FROM tbl_invoices t ");
		/*
		if(search != "" && search != null){
			// fitler by phone number or email address
			sql.append("WHERE cus_phoneNumber LIKE '%" + search + "%'" );
			sql.append(" OR cus_email_address LIKE '%" + search + "%'" );
		}
		*/
		sql.append(" ORDER BY inv_id DESC LIMIT " + offset + ", " + limit );
		System.out.println(sql.toString());
		return jdbcTemplate.query( sql.toString(), new InvoicesMapper());
	}
	
	public int getFoundRows(){
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM tbl_invoices", Integer.class);
	}
	
	// ACTION : DELETE
	public boolean delete(Integer id){
		if(id == null) return false;
		if(jdbcTemplate.update( "DELETE FROM tbl_invoices WHERE inv_id = ?", Integer.valueOf(id)) > 0) return true;
		else return false;
	}
	
	// ACTION: INSERT
	public boolean insert(Invoices invoices) {
		int inserted = jdbcTemplate.update(
		        "INSERT INTO "
		        + "tbl_invoices"
		        + "("
		        + "inv_client_id, "
		        + "inv_date, "
		        + "inv_due, "
		        + "inv_bill_for, "
		        + "inv_total, "
		        + "inv_description "
		        + ") "
		        + "values(?, ?, ?, ?, ?, ?)",
		        invoices.getInvClientId(), 
		        invoices.getInvDate(), 
		        invoices.getInvDue(), 
		        invoices.getInvBillFor(), 
		        invoices.getInvTotal(),
		        invoices.getInvDescription()
		);	
		
		if(inserted > 0) return true;
		else return false;
	}
	
	// ACTION: UPDATE
	public boolean update(final int id, Invoices invoices) {
		int updated = jdbcTemplate.update(
		        "UPDATE  "
		        + "tbl_invoices SET "
		        + "inv_client_id = ?, "
		        + "inv_date = ?, "
		        + "inv_due = ?, "
		        + "inv_bill_for = ?, "
		        + "inv_total = ?, "
		        + "inv_description = ? "
		        + "WHERE inv_id = ?",
		        invoices.getInvClientId(), 
		        invoices.getInvDateToString(), 
		        invoices.getInvDueToString(), 
		        invoices.getInvBillFor(), 
		        invoices.getInvTotal(),
		        invoices.getInvDescription(),
		        id
		);
		if(updated > 0) return true;
		else return false;
	}



} // End class
  final class InvoicesMapper implements RowMapper<Invoices> {

	public Invoices mapRow(ResultSet rs, int rowNum) throws SQLException {
		Invoices invoices = new Invoices();
		invoices.setId(rs.getInt("inv_id"));
		invoices.setInvClientId(rs.getString("inv_client_id"));
		invoices.setInvDateFromString(rs.getString("inv_date"));
		invoices.setInvDueFromString(rs.getString("inv_due"));
		invoices.setInvBillFor(rs.getString("inv_bill_for"));
		invoices.setInvTotalFromString(rs.getString("inv_total"));
		invoices.setInvDescription(rs.getString("inv_description"));
		

		return invoices;
	}
}