/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Business.Patient;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andrew
 */
@WebServlet(urlPatterns = {"/PatientInfoChangeServlet"})
public class PatientInfoChangeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            System.out.println("PatientInfoChangeServlet running... ");
            String pid = request.getParameter("pid");
            String pwd = request.getParameter("pwd");
            String pfn = request.getParameter("pfn");
            String pln = request.getParameter("pln");
            String adr = request.getParameter("adr");
            String ema = request.getParameter("ema");
            String ins = request.getParameter("ins");
            
            Patient p1 = new Patient();
            p1.updateDB(pid, pwd, pfn, pln, adr, ema, ins);
            p1.display();
            
            HttpSession ses1 = request.getSession();
            ses1.setAttribute("p1", p1);
            
            RequestDispatcher rd = request.getRequestDispatcher("/InfoChangeSuccess.jsp");
            rd.forward(request, response);
        }
        catch(Exception e)
        {
            RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
