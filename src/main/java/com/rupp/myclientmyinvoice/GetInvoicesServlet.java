package com.rupp.myclientmyinvoice;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;


import dao.InvoicesDao;
import model.BootstrapTableInvoicesFormatter;
import model.Invoices;
import model.Message;

/**
 * Servlet implementation class Login
 */
@WebServlet("/getInvoices")
public class GetInvoicesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetInvoicesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* RatanaSOTH : TEST
		 * To test session
		 * 
		HttpServletRequest req = (HttpServletRequest)request;
	    HttpServletResponse resp = (HttpServletResponse)response;
	    String requestPath = req.getRequestURI();
		HttpSession session = req.getSession(true);
		
		Message m = new Message();
		m.setMessage("Hello getInvoices : ");
		
		ObjectMapper mapper = new ObjectMapper();
        // Set response content type
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        mapper.writeValue(out, m);
        
        */

		InvoicesDao c = new InvoicesDao();
		Integer offset = Integer.parseInt(request.getParameter("offset"));
		Integer limit = Integer.parseInt(request.getParameter("limit"));
		String search = request.getParameter("search");
		List<Invoices> invoices = c.getAll(limit, offset, search);
        try {
            ObjectMapper mapper = new ObjectMapper();
            BootstrapTableInvoicesFormatter bsInvoicesMapper = new BootstrapTableInvoicesFormatter();
            bsInvoicesMapper.setTotal(c.getFoundRows());
            bsInvoicesMapper.setRows(invoices);
            // Set response content type
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            mapper.writeValue(out, bsInvoicesMapper);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("something is wrong with server " + e.getMessage());
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	

}
