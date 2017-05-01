package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Invoices {
	
	private int id;
	private String invclientid;
	private Date invdate;
	private Date invdue;
	private String invbillfor;
	private Double invtotal;
	private String invdescription;
	//private Date dob;
	//private Date createdDate;
	//private Date updatedDate;
	
	public Invoices() {}
	//---------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	//---------	
	public void setInvClientId(String invclientid) {
		this.invclientid = invclientid;
	}

	public String getInvClientId() {
		return invclientid;
	}
	//---------
	public void setInvDate(Date invdate) {
		this.invdate = invdate;
	}

	public Date getInvDate() {
		return invdate;
	}
	public String getInvDateToString(){
		if(this.invdate != null) return (new SimpleDateFormat("yyyy-MM-dd")).format(this.invdate);
		else return "";
	}

	public void setInvDateFromString(String invdate){
		if(invdate != null) {
			try{
				this.setInvDate((new SimpleDateFormat("yyyy-MM-dd")).parse(invdate));
			}catch(ParseException e){
				e.printStackTrace();
			}
			
		}
	}
	//---------
	public void setInvDue(Date invdue) {
		this.invdue = invdue;
	}

	public Date getInvDue() {
		return invdue;
	}
	public String getInvDueToString(){
		if(this.invdue != null) return (new SimpleDateFormat("yyyy-MM-dd")).format(this.invdue);
		else return "";
	}

	public void setInvDueFromString(String invdue){
		if(invdue != null) {
			try{
				this.setInvDue((new SimpleDateFormat("yyyy-MM-dd")).parse(invdue));
			}catch(ParseException e){
				e.printStackTrace();
			}
			
		}
	}
	//---------
	public String getInvBillFor() {
		return invbillfor;
	}
	public void setInvBillFor(String invbillfor) {
		this.invbillfor = invbillfor;
	}

	//---------
	public Double getInvTotal() {
		return invtotal;
	}

	public void setInvTotal(Double invtotal) {
		this.invtotal = invtotal;
	}
	public String getInvTotalToString(){
		if(this.invtotal != null) return (new Double(this.invtotal)).toString(); // Convert Double 2 String
		else return "";
	}

	public void setInvTotalFromString(String invtotal){
		if(invtotal != null) {
			try{
				Double a = Double.parseDouble(invtotal); // convert String to Double
				this.setInvTotal(a);
			}catch(NumberFormatException  e){
				e.printStackTrace();
			}
			
		}
	}
	//---------
	public String getInvDescription() {
		return invdescription;
	}

	public void setInvDescription(String invdescription) {
		this.invdescription = invdescription;
	}
	//---------
/* Sample	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getDobToString(){
		if(this.createdDate != null) return (new SimpleDateFormat("yyyy-MM-dd")).format(this.dob);
		else return "";
	}

	public void setDobFromString(String dob){
		if(dob != null) {
			try{
				this.setDob((new SimpleDateFormat("yyyy-MM-dd")).parse(dob));
			}catch(ParseException e){
				e.printStackTrace();
			}
			
		}
	}
 end sample */ 	
	
	public String getActionButtons(){
		return "<a data-id='"+this.id+"' class='edit' style='margin-right:10px; cursor:pointer' role='button'><i class='glyphicon glyphicon-pencil'></i></a>"
				+ "<a data-id='"+this.id+"' class='delete' style='cursor:pointer;' ><i class='glyphicon glyphicon-remove ' style='color:red'></i></a>";
	}
	

}
