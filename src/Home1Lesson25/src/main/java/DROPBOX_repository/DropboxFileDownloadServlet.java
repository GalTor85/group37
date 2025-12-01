package DROPBOX_repository;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.Metadata;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet("/dropbox-download")
public class DropboxFileDownloadServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // 1. Получаем параметры из запроса
        String filePath = request.getParameter("path");

        if (filePath == null ) {
            response.sendError(400, "Параметры path обязательны");
            return;
        }

        try {
            // 2. Инициализируем клиент Dropbox
            DbxRequestConfig config = DbxRequestConfig.newBuilder("download-app").build();
            DbxClientV2 client = new DbxClientV2(config, InitConst.ACCESS_TOKEN);

            // 3. Получаем метаданные файла (чтобы узнать имя и размер)
            Metadata metadata = client.files().getMetadata(filePath);

            if (!(metadata instanceof FileMetadata)) {
                response.sendError(400, "Указанный путь не является файлом");
                return;
            }

            FileMetadata meta = (FileMetadata) metadata;


            // 4. Настраиваем HTTP-ответ для скачивания
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + meta.getName() + "\"");
            response.setHeader("Content-Length", String.valueOf(meta.getSize()));

            // 5. Скачиваем файл и передаём в ответ
            try (InputStream is = client.files().download(filePath).getInputStream();
                 OutputStream os = response.getOutputStream()) {

                byte[] buffer = new byte[8192];
                int bytesRead;
                while ((bytesRead = is.read(buffer)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
            }

        } catch (Exception e) {
            // 6. Обрабатываем ошибки
            response.sendError(500, "Ошибка скачивания: " + e.getMessage());
        }
    }
}