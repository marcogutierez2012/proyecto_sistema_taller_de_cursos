/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.1
 * Generated at: 2024-06-22 17:36:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<title>Logueo - Taller de Cursos</title>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\">\r\n");
      out.write("<link rel=\"stylesheet\"  href=\"Estilos/Index.css\">\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.6.0.js\"></script>\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@11\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<form id=\"form-login\" action=\"ControladorLogueo\" method=\"post\">\r\n");
      out.write("\t<div align=\"center\"><img src=\"img/usuario.png\" alt=\"usuario\"></div><br>\r\n");
      out.write("  <h1><span>Iniciar</span> Sesion</h1>\r\n");
      out.write("  <input name=\"usuario\" id=\"usuario\" placeholder=\"usuario\" type=\"text\"/>\r\n");
      out.write("  <input name=\"password\" id=\"password\" placeholder=\"password\" type=\"password\"/>\r\n");
      out.write("  <button type=\"submit\" class=\"btn btn-info\"><i class=\"fas fa-paper-plane\"></i> Iniciar Sesion</button>\r\n");
      out.write("  <div class=\"mt-2\" align=\"center\"><label>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mensaje}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</label></div>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<!-- <script>\r\n");
      out.write("    $(document).ready(function() {\r\n");
      out.write("        var mensaje = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mensaje}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("';\r\n");
      out.write("        var successMessage = '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${successMessage}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("';\r\n");
      out.write("\r\n");
      out.write("        if (mensaje !== '') {\r\n");
      out.write("            Swal.fire({\r\n");
      out.write("                title: 'Error',\r\n");
      out.write("                text: mensaje,\r\n");
      out.write("                icon: 'error',\r\n");
      out.write("                confirmButtonColor: '#3085d6',\r\n");
      out.write("                confirmButtonText: 'Aceptar'\r\n");
      out.write("            });\r\n");
      out.write("        } else if (successMessage !== '') {\r\n");
      out.write("            Swal.fire({\r\n");
      out.write("                title: 'Éxito',\r\n");
      out.write("                text: successMessage,\r\n");
      out.write("                icon: 'success',\r\n");
      out.write("                confirmButtonColor: '#3085d6',\r\n");
      out.write("                confirmButtonText: 'Aceptar'\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("</script> -->\r\n");
      out.write('\r');
      out.write('\n');
 if (request.getAttribute("mensaje") != null && !request.getAttribute("mensaje").toString().isEmpty()) { 
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        Swal.fire({\r\n");
      out.write("            title: 'Error',\r\n");
      out.write("            text: '");
      out.print( request.getAttribute("mensaje").toString() );
      out.write("',\r\n");
      out.write("            icon: 'error',\r\n");
      out.write("            confirmButtonColor: '#3085d6',\r\n");
      out.write("            confirmButtonText: 'Aceptar'\r\n");
      out.write("        });\r\n");
      out.write("    </script>\r\n");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
