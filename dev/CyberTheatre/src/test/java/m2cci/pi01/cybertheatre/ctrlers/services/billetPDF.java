/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2cci.pi01.cybertheatre.ctrlers.services;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import m2cci.pi01.cybertheatremodel.Billet;
import m2cci.pi01.cybertheatremodel.DossierDAchat;
import m2cci.pi01.cybertheatremodel.Representation;
import m2cci.pi01.cybertheatremodel.Sieges.Siege;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.util.Matrix;

/**
 *
 * @author philemon
 */
@WebServlet(name = "billetPDF", urlPatterns = {"/billetPDF"})
public class billetPDF extends HttpServlet {

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
//
//        Spectacle s = new Spectacle(0,
//                "Le malade Imaginaire - Molière",
//                TypeDePublic.ADULTE, 50, TypeDeSpectacle.OPERA, 120,
//                "hello",
//                "");
//        Representation r = new Representation(s, LocalDate.of(2021, 04, 20), LocalTime.of(19, 0), 1);
//        Zone z = new Zone(2, Categorie.BALCON);
//        Siege siege = new Siege(26, 3, z);
        DossierDAchat d = new DossierDAchat(25, false);

        HttpSession session = request.getSession();
        ArrayList<Billet> listeBillets = (ArrayList<Billet>) session.getAttribute("billets");
//        Representation representation = (Representation) session.getAttribute("representation");
//        ArrayList<Siege> sieges = (ArrayList<Siege>) session.getAttribute("siegesSelectionnes");
//
//        ArrayList<Billet> listeBillet2 = new ArrayList<>();
//        for (Siege s : sieges) {
//            Billet billet = new Billet(s, representation, d, 555, LocalDateTime.now(), 1, true);
//            listeBillet2.add(billet);
//        }

        response.setContentType("application/pdf");
        response.addHeader("Content-disposition", "vosBillets.pdf");
        try ( OutputStream out = response.getOutputStream();  PDDocument document = new PDDocument()) {
//        PDDocument document = new PDDocument();

            ListIterator<Billet> it = listeBillets.listIterator();

            PDImageXObject pdImage = PDImageXObject.createFromFile(
                    getServletContext().getRealPath("data/images/logo.png"),
                    document);

            while (it.hasNext()) {

                PDPage page = new PDPage(PDRectangle.A4);
                document.addPage(page);
                PDPageContentStream contentStream = new PDPageContentStream(document, page);

                for (int i = 0; i < 5; i++) {
                    if (it.hasNext()) {
                        imprimerBillet(contentStream, page, pdImage, 600 - i * 150, it.next());
                    }
                }

                contentStream.close();
            }

            document.save(out);
            out.flush();
//            document.save("/home/philemon/test3.pdf");
//            document.close();
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

    public void imprimerBillet(PDPageContentStream cs, PDPage page, PDImageXObject pdImage, int posY,
            Billet b)
            throws IOException {
        cs.drawImage(pdImage, 20, posY + 100, 125, 100);

        cs.setFont(PDType1Font.HELVETICA_BOLD, 16);
        cs.beginText();
        cs.newLineAtOffset(145, posY + 185);
        cs.setNonStrokingColor(139, 0, 0);
        cs.showText(b.getRepresentation().getSpectacle().getNom());
        cs.endText();

        cs.setFont(PDType1Font.HELVETICA, 14);
        cs.setNonStrokingColor(0, 0, 0);
        cs.beginText();
        cs.newLineAtOffset(145, posY + 160);
        cs.showText("Le " + b.getRepresentation().getDateOptimised() + " - " + b.getRepresentation().getHeure() + "");
        cs.endText();

        cs.beginText();
        cs.newLineAtOffset(145, posY + 135);
        cs.showText("Siege " + b.getSiege().getNumero() + " rang " + b.getSiege().getRang() + " - Catégorie " + b.getSiege().getZone().getCategorie());
        cs.endText();

        cs.beginText();
        cs.newLineAtOffset(145, posY + 110);
        Double prix = b.getTarifReduit()
                * b.getRepresentation().getTauxReductionExceptionnelle()
                * b.getRepresentation().getSpectacle().getPrixDeBase()
                * b.getSiege().getZone().getCategorie().getCoefficientCategorie();
        String prixString = String.format("%.2f€", prix);
        cs.showText(prixString);
        cs.endText();

        cs.beginText();
        cs.newLineAtOffset(205, posY + 110);
        if (b.getTarifReduit() == 1) {
            cs.showText("Plein tarif");
        } else {
            cs.showText("Tarif reduit");
        }
        cs.endText();

        if (!b.getDossier().isAchete()) {
            cs.setFont(PDType1Font.HELVETICA, 10);
            cs.setNonStrokingColor(255, 0, 0);
            cs.beginText();
            cs.newLineAtOffset(30, posY + 92);
            cs.showText("BILLET PRÉRESERVÉ NON VALABLE POUR UNE ENTRÉE");
            cs.endText();
        }

        cs.setNonStrokingColor(0, 0, 0);

        Matrix matrix = Matrix.getRotateInstance(Math.toRadians(90), 0, 0);
        matrix.translate(0, -page.getMediaBox().getWidth());

        cs.setFont(PDType1Font.HELVETICA, 12);

        cs.beginText();
        cs.setTextMatrix(matrix);
        cs.newLineAtOffset(posY + 95, 85);
        cs.showText("Dossier numéro " + b.getDossier().getNumero());
        cs.endText();

        cs.beginText();
        cs.setTextMatrix(matrix);
        cs.newLineAtOffset(posY + 105, 70);
        cs.showText("Billet numéro " + b.getNumero());
        cs.endText();

        cs.beginText();
        cs.setTextMatrix(matrix);
        cs.newLineAtOffset(posY + 95, 55);
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        cs.showText(b.getDateAchat().format(formatDate));
        cs.endText();

        cs.setStrokingColor(255, 215, 0);
        cs.moveTo(20, posY + 210);
        cs.lineTo(550, posY + 210);
        cs.lineTo(550, posY + 90);
        cs.lineTo(20, posY + 90);
        cs.lineTo(20, posY + 210);
        cs.stroke();
    }

}
