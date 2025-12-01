package monitoring_servlet;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Написать приложение, которое при запуске будет сообщать в консоль что оно
 * работает. На любой запрос в консоли должна отображаться запись со временем этого
 * запроса.
 * Создать 2 эндпоинта:
 * /book - который будет скачивать с сервера клиенту любую книгу.
 * /load-book - который позволит загружать свои книги на сервер.
 */

@WebListener
public class AppMonitorListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.printf("[%s] App context initialized %n",
                LocalDateTime.now().format(formatter));

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.printf("[%s] App context destroyed %n",
                LocalDateTime.now().format(formatter));
    }
}
