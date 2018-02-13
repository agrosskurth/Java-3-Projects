package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Business.AppointmentList;
import Business.Appointment;
import Business.Patient;

public final class PatientHome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <title>Patient Home</title>\n");
      out.write("      <style>\n");
      out.write("      /* NOTE: The styles were added inline because Prefixfree needs access to your styles and they must be inlined if they are on local disk! */\n");
      out.write("      @import url(http://fonts.googleapis.com/css?family=Open+Sans+Condensed:700);\n");
      out.write("body {\n");
      out.write("  background: #999;\n");
      out.write("  padding: 40px;\n");
      out.write("  font-family: \"Open Sans Condensed\", sans-serif;\n");
      out.write("}\n");
      out.write("\n");
      out.write("#bg {\n");
      out.write("  position: fixed;\n");
      out.write("  left: 0;\n");
      out.write("  top: 0;\n");
      out.write("  width: 100%;\n");
      out.write("  height: 100%;\n");
      out.write("  background: url(\"css/office.jpg\") no-repeat center center fixed;\n");
      out.write("  background-size: cover;\n");
      out.write("  -webkit-filter: blur(5px);    \n");
      out.write("}\n");
      out.write("\n");
      out.write("form {\n");
      out.write("  position: relative;\n");
      out.write("  width: 250px;\n");
      out.write("  margin: 0 auto;\n");
      out.write("  background: rgba(130,130,130,.3);\n");
      out.write("  padding: 20px 22px;\n");
      out.write("  border: 1px solid;\n");
      out.write("  border-top-color: rgba(255,255,255,.4);\n");
      out.write("  border-left-color: rgba(255,255,255,.4);\n");
      out.write("  border-bottom-color: rgba(60,60,60,.4);\n");
      out.write("  border-right-color: rgba(60,60,60,.4);\n");
      out.write("}\n");
      out.write("\n");
      out.write("form input, form button {\n");
      out.write("  width: 212px;\n");
      out.write("  border: 1px solid;\n");
      out.write("  border-bottom-color: rgba(255,255,255,.5);\n");
      out.write("  border-right-color: rgba(60,60,60,.35);\n");
      out.write("  border-top-color: rgba(60,60,60,.35);\n");
      out.write("  border-left-color: rgba(80,80,80,.45);\n");
      out.write("  background-color: rgba(0,0,0,.2);\n");
      out.write("  background-repeat: no-repeat;\n");
      out.write("  padding: 8px 24px 8px 10px;\n");
      out.write("  font: bold .875em/1.25em \"Open Sans Condensed\", sans-serif;\n");
      out.write("  letter-spacing: .075em;\n");
      out.write("  color: #fff;\n");
      out.write("  text-shadow: 0 1px 0 rgba(0,0,0,.1);\n");
      out.write("  margin-bottom: 19px;\n");
      out.write("}\n");
      out.write("\n");
      out.write("form input:focus { background-color: rgba(0,0,0,.4); }\n");
      out.write("\n");
      out.write("::-webkit-input-placeholder { color: #ccc; text-transform: uppercase; }\n");
      out.write("::-moz-placeholder { color: #ccc; text-transform: uppercase; }\n");
      out.write(":-ms-input-placeholder { color: #ccc; text-transform: uppercase; }\n");
      out.write("\n");
      out.write("form button[type=submit] {\n");
      out.write("  width: 248px;\n");
      out.write("  margin-bottom: 0;\n");
      out.write("  color: #3f898a;\n");
      out.write("  letter-spacing: .05em;\n");
      out.write("  text-shadow: 0 1px 0 #133d3e;\n");
      out.write("  text-transform: uppercase;\n");
      out.write("  background: #225556;\n");
      out.write("  border-top-color: #9fb5b5;\n");
      out.write("  border-left-color: #608586;\n");
      out.write("  border-bottom-color: #1b4849;\n");
      out.write("  border-right-color: #1e4d4e;\n");
      out.write("  cursor: pointer;\n");
      out.write("}\n");
      out.write("    </style>\n");
      out.write("\n");
      out.write("  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js\"></script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("  ");

        Patient p1;
        p1 = (Patient)session.getAttribute("p1");
        
        AppointmentList apps = p1.getAppointmentList();
        int count = apps.getCount();
  
      out.write("\n");
      out.write("  <div id=\"bg\"></div>\n");
      out.write("<form action=\"PatientInfoChangeServlet\">\n");
      out.write("    <table>\n");
      out.write("        <tr>\n");
      out.write("            <th></th>\n");
      out.write("        </tr>\n");
      out.write("    </table>\n");
      out.write("</form>\n");
      out.write("  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
