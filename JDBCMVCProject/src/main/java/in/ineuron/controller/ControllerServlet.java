package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dto.Student;
import in.ineuron.factory.StudentServiceFactory;
import in.ineuron.service.IStudentService;

@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqURI = request.getRequestURI();
		System.out.println(reqURI);
		RequestDispatcher rd = null;
		IStudentService studentService = StudentServiceFactory.getStudentService();
		String status = null;
//		Student student = null;
//		int sid;
		if(reqURI.endsWith("layout")) {
			rd = request.getRequestDispatcher("../layout.html");
			rd.forward(request, response);
		}
		
		if(reqURI.endsWith("addForm")) {
				String sage= request.getParameter("sage");
				String sname= request.getParameter("sname");
				String saddress= request.getParameter("saddress");
				Student student = new Student();
				student.setSage(sage);
				student.setSname(sname);
				student.setSaddress(saddress);
				status = studentService.save(student);
				
				if(status.equalsIgnoreCase("success")) {
					
					rd = request.getRequestDispatcher("../addsuccess.html");
					rd.forward(request, response);
				}
				
				else if(status.equalsIgnoreCase("failure")){
					
					rd = request.getRequestDispatcher("../addfail.html");
					rd.forward(request, response);
				}
		}
		
		if(reqURI.endsWith("searchForm")) {
			Integer sid= Integer.parseInt(request.getParameter("sid"));
			Student student = studentService.findById(sid);
			System.out.println(student.getSid());
			
			if(student.getSname()!=null) {
				
//				rd = request.getRequestDispatcher("../searchsuccess.html");
//				rd.forward(request, response);
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<h1 style='color:black; text-align:center;'>Student Data"+"</h1>");
				out.println("<table align='center', border=1>");
				
				out.println("<tr><th>Id</th><th>Age</th><th>Name</th><th>Address</th></tr>");
				out.println("<tr><td>"+student.getSid()+"</td><td>"+student.getSage()+"</td><td>"+student.getSname()+"</td><td>"+student.getSaddress()+"</td></tr>");
			    out.println("</table>");
			}
			
			else {
				
				rd = request.getRequestDispatcher("/searchfail.html");
				rd.forward(request, response);
			}
			
//			System.out.println(student);
//			System.out.println(sid);
		}
		
		
		
		if(reqURI.endsWith("deleteForm")) {
			String id = request.getParameter("sid");
			int sid = Integer.parseInt(id);
			status = studentService.deleteById(sid);
			
			if(status.equalsIgnoreCase("success")) {
				
				rd = request.getRequestDispatcher("../deletesuccess.html");
				rd.forward(request, response);
			}
			
			else if(status.equalsIgnoreCase("failure")){
				
				rd = request.getRequestDispatcher("../deletefail.html");
				rd.forward(request, response);
			}
			
			else if(status.equalsIgnoreCase("notFound")) {
				rd = request.getRequestDispatcher("../notFound.html");
				rd.forward(request, response);
			}
		}
		
		
		if(reqURI.endsWith("editForm")) {
			String id= request.getParameter("sid");
			int sid = Integer.parseInt(id);
			System.out.println(sid);
			Student student = studentService.findById(sid);
			if(student.getSname()!=null) {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<h1 style='color:black; text-align:center;'>Update data"+"</h1>");
				
				out.println("<form action='./controller/updateForm' method='post'>");
				out.println("<table align='center'");
				
				
				out.println("<tr><th>ID</th><td>"+student.getSid()+"</td></tr>");
				out.println("<input type ='hidden' name='sid' value='"+student.getSid()+"'/>");
				out.println("<tr><th>Age</th><td><input type='text' name='sage' value="+student.getSage()+" />"+"</td></tr>");
				out.println("<tr><th>Age</th><td><input type='text' name='sname' value="+student.getSname()+" />"+"</td></tr>");
				out.println("<tr><th>Age</th><td><input type='text' name='saddress' value="+student.getSaddress()+" />"+"</td></tr>");
				out.println("<tr><th></th><td><input type='submit' value='Update'/> </td></tr>");
				
			    out.println("</table>");
			    
			    out.println("</form>");
				
			}
			else {
				rd = request.getRequestDispatcher("../notFound.html");
				rd.forward(request, response);
			}
		}
		
		
		if(reqURI.endsWith("updateForm")) {
			
			Integer sid = Integer.parseInt(request.getParameter("sid"));
			String sage = request.getParameter("sage");
			String sname = request.getParameter("sname");
			String saddress = request.getParameter("saddress");
			Student student = new Student();
			student.setSid(sid);
			student.setSage(sage);
			student.setSname(sname);
			student.setSaddress(saddress);
			status = studentService.updateById(student);
			
			if(status.equalsIgnoreCase("success")) {
				
				rd = request.getRequestDispatcher("../updatesuccess.html");
				rd.forward(request, response);
			}

//			else if(status.equalsIgnoreCase("failure")){
//				
//				rd = request.getRequestDispatcher("../updatefail.html");
//				rd.forward(request, response);
//			}

			

		}
		
		
	}
}

