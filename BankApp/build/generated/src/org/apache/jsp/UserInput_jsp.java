package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class UserInput_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function validateAge(){\n");
      out.write("                var a;\n");
      out.write("                a=document.DataForm.agetb.value;\n");
      out.write("                if(a>=125){\n");
      out.write("                    alert(\"Age must be below 100\")\n");
      out.write("                }\n");
      out.write("                if(isNaN(a)){\n");
      out.write("                    alert(\"Age must be a number!\");\n");
      out.write("                }\n");
      out.write("                if(a<0){\n");
      out.write("                    alert(\"Age must be above 0!\");\n");
      out.write("                }\n");
      out.write("                if(a===\"\"){\n");
      out.write("                    alert(\"You must enter a value for Age!\");\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            function validateSalary() {\n");
      out.write("                var s;\n");
      out.write("                s=document.DataForm.saltb.value;\n");
      out.write("                if(s>=200000){\n");
      out.write("                    alert(\"Salary must be less than 200,000!\");\n");
      out.write("                }\n");
      out.write("                if(isNaN(s)){\n");
      out.write("                    alert(\"Salary must be a number!\");\n");
      out.write("                }\n");
      out.write("                if(s<0){\n");
      out.write("                    alert(\"Salary must be above 0!\");\n");
      out.write("                }\n");
      out.write("                if(s===\"\"){\n");
      out.write("                    alert(\"You must enter a value for Salary!\");\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <title>User Input</title>\n");
      out.write("    </head>\n");
      out.write("    <form name=\"DataForm\">\n");
      out.write("        <h1>User Input</h1>\n");
      out.write("        <table width=\"150px\" border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Age</th>\n");
      out.write("                <th><input type=\"text\" name=\"agetb\" onBlur=\"validateAge()\" /></th>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <th>Salary</th>\n");
      out.write("                <th><input type=\"text\" name=\"saltb\" onBlur=\"validateSalary()\" /></th>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        <button type=\"button\" style=\"height:25px;width:80px\" name=\"sendbtn\">Send</button>\n");
      out.write("        &nbsp;\n");
      out.write("        <button type=\"button\" style=\"height:25px;width:80px\" name=\"clearbtn\">Clear</button>\n");
      out.write("    </form>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
