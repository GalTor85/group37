package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
/**
 * Задача 2:
 * Создать сервлет который на вход принимает возраст, а в ответе возвращает
 * информацию, совершеннолетний или нет.
 */
@WebServlet("/chekAge")
public class ChekAge extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int age = Integer.parseInt(req.getParameter("age"));
        if (age >= 18) {
            resp.getWriter().write("Добро пожаловать вы прошли проверку");
        } else {
            resp.getWriter().write("Вы не прошли проверку");
        }
    }
}
