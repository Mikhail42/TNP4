package servlets;

import entities.TextUpdateTask;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Mikhail
 */
@WebServlet(name = "XMLServlet", urlPatterns = {"/result.xml"})
public class XMLServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        TextUpdateTask task = (TextUpdateTask) session.getAttribute("task");
        try {
            /* TODO output your page here. You may use following sample code. */
            JAXBContext jc = JAXBContext.newInstance(TextUpdateTask.class);
            Marshaller m = jc.createMarshaller();            
            m.marshal(task, out);
        } catch (JAXBException e) {
            out.print(e.toString());
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
