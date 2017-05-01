package com.rupp.myclientmyinvoice;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.routines.EmailValidator;

import com.fasterxml.jackson.databind.ObjectMapper;


import dao.InvoicesDao;
import model.Invoices;
import model.Message;

/**
 * Servlet implementation class Login
 */
@WebServlet("/update-invoice")
public class UpdateInvoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInvoiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Message m = new Message();
		boolean valid = true; // define as no problem
		/*
		boolean valid = EmailValidator.getInstance().isValid(request.getParameter("email"));
		if(!valid){
			m.setStatus(0);
			m.setMessage("Invalid email format");
		}
		*/
		if(valid){
			//System.out.println("zzz" + request.getParameter("firstname"));
			if(request.getParameter("invclientid").isEmpty() || 
				request.getParameter("invbillfor").isEmpty() || 
				request.getParameter("invtotal").isEmpty() ||
				request.getParameter("invdate").isEmpty() ){
				valid = false;
				m.setStatus(0);
				m.setMessage("Please fill all require field");
				//System.out.println("aaa");

			}
			
		}
		
		if(valid){
			Invoices invoices = new Invoices();
			invoices.setInvClientId(request.getParameter("invclientid"));
			invoices.setInvBillFor(request.getParameter("invbillfor"));
			invoices.setInvDateFromString(request.getParameter("invdate"));
			invoices.setInvDueFromString(request.getParameter("invdue"));
			invoices.setInvTotalFromString(request.getParameter("invtotal"));
			invoices.setInvDescription(request.getParameter("invdescription"));
		
			int id = Integer.parseInt(request.getParameter("id"));
		
			InvoicesDao c = new InvoicesDao();
			if(c.update(id, invoices)){
				m.setStatus(1);
				m.setMessage("Customer is updated successfully");
			}else{
				m.setStatus(0);
				m.setMessage("Updating customer error");
			}
		}
		
		
		ObjectMapper mapper = new ObjectMapper();
        // Set response content type
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        mapper.writeValue(out, m);

	}
	

}
