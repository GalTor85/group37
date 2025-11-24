import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class TimeZoneMinsk extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        resp.getWriter().println("Время в Минске: "+LocalTime.now(ZoneId.of("Europe/Minsk")).format(formatter));
    }
}
