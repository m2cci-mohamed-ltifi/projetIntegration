/*
Permet d'insérer les billets achetés dans la base de données
 */
package m2cci.pi01.cybertheatre.ctrlers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import m2cci.pi01.cybertheatre.DAO.ReserverDAO;
import m2cci.pi01.cybertheatremodel.Billet;
import m2cci.pi01.cybertheatremodel.Representation;
import m2cci.pi01.cybertheatremodel.Sieges.Siege;


@WebServlet(name = "ReserverCtrl", urlPatterns = {"/ReserverCtrl"})
public class ReserverCtrl extends HttpServlet {

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

        String stringAcheter = request.getParameter("acheter");
        String[] stringTarifsReduits = request.getParameterValues("tarifsReduits[]");

        Double[] tarifsReduits = new Double[stringTarifsReduits.length];
        for (int i = 0; i < stringTarifsReduits.length; i++) {
            if (stringTarifsReduits[i].equals("etudiant")) {
                tarifsReduits[i] = (double)0.8;
            } else if (stringTarifsReduits[i].equals("famille_nombreuse")) {
                tarifsReduits[i] = (double)0.8;
            } else if (stringTarifsReduits[i].equals("militaire")) {
                tarifsReduits[i] = (double)0.8;
            } else if (stringTarifsReduits[i].equals("senior")) {
                tarifsReduits[i] = (double)0.8;
            } else {
                tarifsReduits[i] = (double)1.0;
            }
        }

        
        Boolean acheter = stringAcheter.equals("true");
        

        HttpSession session = request.getSession();
        Representation representation = (Representation) session.getAttribute("representation");
        ArrayList<Siege> siegesSelectionnes = (ArrayList<Siege>) session.getAttribute("siegesSelectionnes");
        
        if(siegesSelectionnes.size() != tarifsReduits.length) {
            throw new ServletException("Problème : il n'y a pas autant de tarif que de sieges");
        }

        try {
            ArrayList<Billet> billets = ReserverDAO.reserverPlaces(bdSQL, acheter, representation, siegesSelectionnes, tarifsReduits);

            session.setAttribute("billets", billets);
            request.setAttribute("billets", billets);
            request.setAttribute("achete", acheter);
            request.getRequestDispatcher("/WEB-INF/validation_reservation.jsp").forward(request, response);

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
