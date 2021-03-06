package com.rupp.myclientmyinvoice;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.InvoicesDao;
import model.Message;

/**
 * Servlet implementation class Login
 */
@WebServlet("/delete-invoices")
public class DeleteInvoicesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteInvoicesServlet() {
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
		int id = Integer.parseInt(request.getParameter("id"));
		Message m = new Message();
		InvoicesDao c = new InvoicesDao();
		if(c.delete(id)){
			m.setStatus(1);
			m.setMessage("Customer is deleted successfully");
		}else{
			m.setStatus(0);
			m.setMessage("Deleting customer error");
		}
		
		ObjectMapper mapper = new ObjectMapper();
        // Set response content type
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        mapper.writeValue(out, m);

	}
	

}
