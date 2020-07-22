package servlet;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Useritem;
import dao.userdao;
@SuppressWarnings("serial")
public class Userservlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		
	req.setCharacterEncoding("utf-8");

	String method = req.getParameter("method");
	System.out.println(method);
	if(method.equals("login"))

	{
		
	try {

		login(req, resp);

		} catch (Exception e) {

		// TODO �Զ����ɵ� catch ��

		e.printStackTrace();

		} 
	}

	}
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException
	{
		
		req.setCharacterEncoding("utf-8");


			
		try {
	
			Search(req, resp);
	
			} catch (Exception e) {
	
			// TODO �Զ����ɵ� catch ��
	
			e.printStackTrace();
	
			} 
		

	}
	protected void Search(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException, ClassNotFoundException, SQLException

	{
		Useritem user=new Useritem();
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("major");
		List<Useritem> newsList=userdao.searchInfo(username);
		req.setAttribute("newsList", newsList);
		req.getRequestDispatcher("/show.jsp").forward(req, resp);
	
	}
	protected void login(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException

	{
		Useritem user=new Useritem();
	req.setCharacterEncoding("utf-8");
	String username = req.getParameter("username1");
	String password = req.getParameter("password1");//��ȡ�û�������
	String flag1=req.getParameter("gate");
	user.setPassword(password);
	user.setUserName(username);
	int f=Integer.parseInt(flag1);
	int flag = userdao.islogin(user,f );

	if(flag==1)

	{
	System.out.println("");	
	System.out.println("�û���"+username+" ���룺"+password);
	System.out.println("��¼�ɹ���");
	req.setAttribute("user", user);
	req.getRequestDispatcher("/index.jsp").forward(req, resp);
	//resp.sendRedirect(req.getContextPath()+"/index.jsp");//��¼�ɹ���ת��������

	}else if(flag==2)
	{
		System.out.println("");	
		System.out.println("��¼ʧ�ܣ�");
		PrintWriter out=resp.getWriter();
		out.print("<script language='javascript' charset='utf-8'>alert('Containing illegal characters');window.location.href='/loginsqlEx/login.jsp';</script>"); 
	}else

	{
	System.out.println("");	
	System.out.println("�û���"+username+" ���룺"+password);
	System.out.println("��¼ʧ�ܣ�");
	PrintWriter out=resp.getWriter();
	out.print("<script language='javascript' charset='utf-8'>alert('logon failure��');window.location.href='/loginsqlEx/login.jsp';</script>"); 
	
	//resp.sendRedirect(req.getContextPath()+"/login.jsp");

	}

	}


}
	
