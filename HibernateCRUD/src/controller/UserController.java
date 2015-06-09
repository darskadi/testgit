package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.InsertVo;
import dao.InsertDaoImpl;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag = request.getParameter("flag");

		InsertVo insertVo = new InsertVo();
		InsertDaoImpl insertDaoImpl = new InsertDaoImpl();
		
		HttpSession httpSession = request.getSession();
		
		if(flag.equals("view"))
		{

			
			List user = new ArrayList(); 
			
			user = insertDaoImpl.view(insertVo);
			
			
			httpSession.setAttribute("user", user);
			
			System.out.println(user.size());
			
			response.sendRedirect("View.jsp");
			
		}
		if(flag.equals("delete"))
		{
			String id = request.getParameter("id");
			
			insertVo.setId(Integer.parseInt(id));
			insertDaoImpl.delete(insertVo);
			
			httpSession.setAttribute("delete", "delete");
			
			response.sendRedirect("UserController?flag=view");
			
		}
		if(flag.equals("edit"))
		{
			String id = request.getParameter("id");
			
			insertVo.setId(Integer.parseInt(id));
			
			List edituser = new ArrayList();
			
			edituser = insertDaoImpl.search(insertVo);
			
			httpSession.setAttribute("edituser", edituser);
			
			response.sendRedirect("Edit.jsp");
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag = request.getParameter("flag");

		InsertDaoImpl insertDaoImpl = new InsertDaoImpl();
		InsertVo insertVo = new InsertVo();
		
		HttpSession httpSession = request.getSession();
		

		
		if(flag.equals("add"))
		{
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		
		
		
		insertVo.setFname(fname);
		insertVo.setLname(lname);
		insertVo.setUname(uname);
		insertVo.setPwd(pwd);
		
		insertDaoImpl.insert(insertVo);
		httpSession.setAttribute("insert", "Data Inserted Sucessfully");
		
		response.sendRedirect("UserController?flag=view");
		}
		
		if(flag.equals("update"))
		{
			String id = request.getParameter("id");
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String uname = request.getParameter("uname");
			String pwd = request.getParameter("pwd");			
			
			
			insertVo.setId(Integer.parseInt(id));	
			insertVo.setFname(fname);
			insertVo.setLname(lname);
			insertVo.setUname(uname);
			insertVo.setPwd(pwd);
			
			insertDaoImpl.update(insertVo);	
			httpSession.setAttribute("update", "Data Updated Sucessfully");
			
			response.sendRedirect("UserController?flag=view");
		
		}
		
		
	}

}

