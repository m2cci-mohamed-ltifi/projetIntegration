/* 
    Author     : M2CCI 2021 projet d'intégration groupe 01
 */

package m2cci.pi01.cybertheatre.ctrlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import m2cci.pi01.cybertheatre.DAO.AjoutSpectacleDAO;
import m2cci.pi01.cybertheatremodel.Spectacle;
import m2cci.pi01.cybertheatremodel.TypeDePublic;
import m2cci.pi01.cybertheatremodel.TypeDeSpectacle;


@WebServlet(name = "AjoutSpectacleCtrl", urlPatterns = {"/AjoutSpectacleCtrl"})
public class AjoutSpectacleCtrl extends HttpServlet {

    @Resource(name = "jdbc/CyberTheatre")
    private DataSource bdSQL;

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
        String nomSpectacle = request.getParameter("nomSpectacle");
        String typeSpectacle = request.getParameter("typeSpectacle");
        String publicCible = request.getParameter("publicCible");
        String prixBase = request.getParameter("prixBase");
        String duree = request.getParameter("dureeSpectacle");
        String image = request.getParameter("imageSpectacle");
        String description = request.getParameter("descriptionSpectacle");
        String oneManShow = request.getParameter("oneManShow");
        String orchestre = request.getParameter("orchestre");
        
        //String validationAjoutSpectacle = request.getParameter("validationAjoutSpectacle");
        Spectacle spectacle = new Spectacle(500, 
                nomSpectacle, 
                TypeDePublic.valueOf(publicCible), 
                Double.parseDouble(prixBase), 
                TypeDeSpectacle.valueOf(typeSpectacle), 
                Integer.parseInt(duree), 
                description, 
                image);
        
        try {
            /* TODO output your page here. You may use following sample code. */
            AjoutSpectacleDAO.ajouterSpectacle(bdSQL, spectacle);
            request.setAttribute("spectacle", spectacle);
            request.getRequestDispatcher("/WEB-INF/ajoutGerant.jsp").forward(request, response);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new ServletException(ex.getMessage(), ex);
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
