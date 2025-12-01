package DROPBOX_repository;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

import java.io.InputStream;
public class DropboxUpload {
    /**
     * Загружает данные из потока в Dropbox.
     *
     * @param inputStream   поток с данными для загрузки (не должен быть закрыт вызывающей стороной)
     * @param dropboxPath путь в Dropbox, куда сохранить файл (например, "/photos/image.jpg")
     * @param accessToken токен доступа к Dropbox
     * @return           метаданные загруженного файла
     * @throws Exception при ошибках сети, авторизации или ввода-вывода
     */
    public static FileMetadata uploadFromStream(
            InputStream inputStream,
            String dropboxPath,
            String accessToken) throws Exception {
        // 1. Настройка клиента Dropbox
        DbxRequestConfig config = DbxRequestConfig.newBuilder("book_server_tms").build();
        DbxClientV2 client = new DbxClientV2(config, accessToken);

        // 2. Загрузка из потока
        try (inputStream) { // Автоматическое закрытие потока по выходу из try-with-resources
            FileMetadata metadata = client.files()
                    .uploadBuilder(dropboxPath)
                    .uploadAndFinish(inputStream);

            System.out.println("Uploaded: " + metadata.getPathLower());
            return metadata;
        }
    }
}