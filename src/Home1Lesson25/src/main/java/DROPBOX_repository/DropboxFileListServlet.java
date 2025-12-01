package DROPBOX_repository;


import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/book")
public class DropboxFileListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            DbxRequestConfig config = DbxRequestConfig.newBuilder("file-list-app")
                    .withUserLocale("ru_RU")
                    .build();
            DbxClientV2 client = new DbxClientV2(config, InitConst.ACCESS_TOKEN);

            List<FileMetadata> files = listPdfAndTxtFiles(client);


            renderFileList(response, files);

        } catch (Exception e) {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(
                    "<h3>Ошибка: " + e.getMessage() + "</h3>" +
                            "<p><a href=\"?access_token=" + InitConst.ACCESS_TOKEN + "\">Назад</a></p>"
            );
        }
    }

    private List<FileMetadata> listPdfAndTxtFiles(DbxClientV2 client) throws Exception {
        List<FileMetadata> result = new ArrayList<>();

        // 1. Получаем строитель запроса (ListFolderBuilder)
        // 2. Вызываем .start() для выполнения запроса → получаем ListFolderResult
        ListFolderResult resultPage = client.files().listFolder(InitConst.PATH_DROPBOX);
        do {
            for (Metadata metadata : resultPage.getEntries()) {
                if (metadata instanceof FileMetadata) {
                    String nameLower = metadata.getName().toLowerCase();
                    if (nameLower.endsWith(".txt") || nameLower.endsWith(".pdf")) {
                        result.add((FileMetadata) metadata);
                    }
                }
            }
            if (!resultPage.getHasMore()) break;
            // Для следующей страницы используем курсор
            resultPage = client.files().listFolderContinue(resultPage.getCursor());

        } while (true);

        return result;
    }

    private void renderFileList(HttpServletResponse response,
                                List<FileMetadata> files) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        StringBuilder html = new StringBuilder();
        html.append(""
                + "<!DOCTYPE html>\n"
                + "<html lang=\"ru\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <title>Файлы Dropbox (.txt, .pdf)</title>\n"
                + "    <style>\n"
                + "        body { font-family: Arial, sans-serif; margin: 20px; }\n"
                + "        table { width: 100%; border-collapse: collapse; margin-top: 20px; }\n"
                + "        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }\n"
                + "        th { background-color: #f2f2f2; font-weight: bold; }\n"
                + "        .download-link {\n"
                + "            color: #007ee5;\n"
                + "            text-decoration: none;\n"
                + "        }\n"
                + "        .download-link:hover { text-decoration: underline; }\n"
                + "        .header { color: #333; }\n"
                + "    </style>\n"
                + "</head>\n"
                + "<body>\n"
                + "    <h2 class=\"header\">Файлы .txt и .pdf в Dropbox</h2>\n"
                + "    <table>\n"
                + "        <thead>\n"
                + "            <tr>\n"
                + "                <th>Имя файла</th>\n"
                + "                <th>Размер</th>\n"
                + "                <th>Изменено</th>\n"
                + "                <th>Действие</th>\n"
                + "            </tr>\n"
                + "        </thead>\n"
                + "        <tbody>\n");

        for (FileMetadata file : files) {
            String fileName = file.getName();
            long size = file.getSize();
            String modified = file.getClientModified().toString();
            String path = file.getPathLower();
            html.append("            <tr>\n")
                    .append("                <td>").append(fileName).append("</td>\n")
                    .append("                <td>").append(formatSize(size)).append("</td>\n")
                    .append("                <td>").append(modified).append("</td>\n")
                    .append("                <td>\n")
                    .append("                    <a class=\"download-link\"\n")
                    .append("                       href=\"/dropbox-download?path=")
                    .append(path)
                    .append("&access_token=")
                    .append(InitConst.ACCESS_TOKEN)
                    .append("\">Скачать</a>\n")
                    .append("                </td>\n")
                    .append("            </tr>\n");
        }

        html.append("        </tbody>\n"
                + "    </table>\n"
                + "</body>\n"
                + "</html>");

        response.getWriter().write(html.toString());
    }

    private String formatSize(long size) {
        if (size < 1024) return size + " Б";
        if (size < 1024 * 1024) return String.format("%.1f КБ", size / 1024.0);
        return String.format("%.1f МБ", size / (1024.0 * 1024));
    }
}