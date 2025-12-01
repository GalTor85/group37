package DROPBOX_repository;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 10)
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            IOException {
        try {
            DropboxUpload.uploadFromStream(
                    request.getPart("file").getInputStream(),
                    "/book_server_tms/" + request.getPart("file").getSubmittedFileName(),
                    InitConst.ACCESS_TOKEN
            );
            response.getWriter().print("The file uploaded successfully :)");
        } catch (Exception e) {
            response.getWriter().print("Something wrong :(");
        }
    }
}