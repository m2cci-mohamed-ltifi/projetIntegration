/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2cci.pi01.cybertheatre.ctrlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import m2cci.pi01.cybertheatre.DAO.ProgrammationDAO;
import m2cci.pi01.cybertheatre.DAO.UtilisateursDAO;
import java.util.ArrayList;
import java.util.List;
import m2cci.pi01.cybertheatremodel.Utilisateur;

/**
 *
 * @author Ltifi
 */
@WebServlet(name = "UtilisateurCtrl", urlPatterns = {"/UtilisateurCtrl"})
public class UtilisateurCtrl extends HttpServlet {

    @Resource(name = "jdbc/CyberTheatre")
    private DataSource bdSQL;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String nom=request.getParameter("nom");
        if ( nom==null || nom==""){
            nom=null;
        }
        List<Utilisateur> utilisateurs;
        try {
            utilisateurs = UtilisateursDAO.chargerUtilisateurs(bdSQL,nom);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new ServletException(ex.getMessage(), ex);
        }
            request.setAttribute("utilisateurs",utilisateurs);
        request.getRequestDispatcher("/WEB-INF/utilisateurs.jsp").forward(request, response);
        
        
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
