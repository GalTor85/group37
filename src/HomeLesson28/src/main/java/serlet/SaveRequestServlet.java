package serlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/save-request")
public class SaveRequestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        req.setAttribute("name", name);
        req.setAttribute("age", age);
        if (name == null || age == null || name.isEmpty() || age.isEmpty()) {
            req.setAttribute("error", "Пожалуйста, заполните все поля");
            req.getRequestDispatcher("/save-request.jsp").forward(req, resp);
            return;
        }
        req.getRequestDispatcher("/success-request.jsp").forward(req, resp);
    }
}
