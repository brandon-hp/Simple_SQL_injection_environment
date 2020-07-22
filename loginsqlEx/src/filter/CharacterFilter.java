package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class CharacterFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter��ʼ��");

    }
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    	  HttpServletRequest req=(HttpServletRequest)servletRequest;
          HttpServletResponse resp=(HttpServletResponse)servletResponse;
           //����������������
          Enumeration params = req.getParameterNames();
          String sql = "";
          while (params.hasMoreElements()) {
              String name = params.nextElement().toString();
              String[] value = req.getParameterValues(name);
              for (int i = 0; i < value.length; i++) {
                  sql = sql + value[i];
              }
          }
         
      	String flag1=req.getParameter("gate");
      	int f=0;
      	if(flag1!=null)
    	f=Integer.parseInt(flag1);
          if (f==5&&Checksql(sql)) {
        		System.out.println("");	
        		System.out.println("��¼ʧ�ܣ�");
        		PrintWriter out=resp.getWriter();
        		out.print("<script language='javascript' charset='utf-8'>alert('Containing illegal characters');window.location.href='/loginsqlEx/login.jsp';</script>"); 
        		
          } 
         filterChain.doFilter(servletRequest,servletResponse);
        
    }
    protected static boolean Checksql(String sql) {
        //ת����Сд
    	sql = sql.toLowerCase();
        String badStr = "'|and|exec|execute|insert|select|delete|update|count|drop|*|%|chr|mid|master|truncate|" +
                "char|declare|sitename|net user|xp_cmdshell|;|or|-|+|,|like'|and|exec|execute|insert|create|drop|" +
                "table|from|grant|use|group_concat|column_name|" +
                "information_schema.columns|table_schema|union|where|select|delete|update|order|by|count|*|" +
                "chr|mid|master|truncate|char|declare|or|;|-|--|+|,|like|//|/|%|#";
        String[] badStrs = badStr.split("\\|");
        for (int i = 0; i < badStrs.length; i++) {
            if (sql.indexOf(badStrs[i]) >= 0) {
                return true;
            }
        }
        return false;
    }
    //���٣�web�������رյ�ʱ�򣬹��˻�����
    public void destroy() {
        System.out.println("CharacterEncodingFilter����");
    }
}