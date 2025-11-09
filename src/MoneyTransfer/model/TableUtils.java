package MoneyTransfer.model;

import MoneyTransfer.repository.Logger;

import java.math.BigDecimal;
import java.sql.*;
import java.util.HashMap;

//Класс работы с таблицами БД
public class TableUtils implements TableOperations, InitConst {
    private Connection connection;  // JDBC-соединение для работы с таблицей
    private final String tableName;  //Имя таблицы


    // Получить новое соединение с БД
    public static Connection getConnection() throws SQLException {
        Logger.start("Соединение с " + DB_URL);
        return DriverManager.getConnection(DB_URL, user, password);
    }

    //Инициализация
    public TableUtils() throws SQLException, ClassNotFoundException {
        Class.forName(DB_Driver);
        //Инициализация таблиц
        Logger.start("Инициализация таблицы " + InitConst.tableName);
        this.tableName = InitConst.tableName;
        this.connection = TableUtils.getConnection();
    }

    //Инициализация для других таблиц
    public TableUtils(String tableName) throws SQLException { // Для другой таблицы передадим в конструктор её имя
        Logger.start("Инициализация таблицы " + tableName);
        if (tableName == null || !isTableNameAllowed(tableName)) {
            Logger.start("Недопустимое имя таблицы: " + tableName);
            throw new IllegalArgumentException("Недопустимое имя таблицы: " + tableName);
        }
        this.tableName = tableName;
        this.connection = TableUtils.getConnection(); // Установим соединение с СУБД для дальнейшей работы
    }


    // Создание всех таблиц и ключей между ними //в разработке ключи не создаются
    public void createTablesAndForeignKeys() throws SQLException {
        this.createTable();

        // Создание внешних ключей (связей между таблицами) //в разработке
        this.createForeignKeys();
    }

    //Здесь должен быть метод создания ключей для связи таблиц
    @Override
    public void createForeignKeys() throws SQLException {
    }

    @Override
    public void createExtraConstraints() throws SQLException {

    }

    // Вспомогательный метод для закрытия соединения
    public void close() throws SQLException {
        if (this.connection != null && !this.connection.isClosed()) {
            this.connection.close();
        }
    }

    // Активизация соединения с СУБД, если оно не активно.
    void reopenConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = TableUtils.getConnection();
        }
    }

    //Валидатор имени таблицы
    private boolean isTableNameAllowed(String tableName) {
        if (tableName == null) return false;
        // Разрешаем только латинские буквы, цифры и знак подчеркивания
        return tableName.matches("[A-Za-z0-9_]+");
    }

    //Метод создания таблицы
    @Override
    public void createTable() throws SQLException {
        Logger.start("Создание таблицы " + tableName);
        // Проверка имени таблицы
        if (!isTableNameAllowed(tableName)) {
            Logger.start("Недопустимое имя таблицы: " + tableName);
            throw new SQLException("Недопустимое имя таблицы: " + tableName);
        }
        //Переоткрытие если соединение закрылось
        reopenConnection();
        // Встраиваем имя таблицы в DDL.
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
                + "accountNum BIGINT PRIMARY KEY, "
                + "cash DECIMAL(16, 2) DEFAULT 0 NOT NULL"
                + ")";
        // Выполнение DDL
        try (java.sql.Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        }
        Logger.start("Создание таблицы " + tableName + " успешно завершено");
    }

    //Метод добавление в таблицу через PreparedStatement для безопасности соединений
    @Override
    public void addValue(long accountNum, BigDecimal cash) throws SQLException {
        Logger.start("Создание счета " + accountNum);
        //Переоткрыть
        reopenConnection();
        String sql = "INSERT INTO " + tableName + " (accountNum, cash) VALUES (?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, accountNum);
            ps.setBigDecimal(2, cash);
            ps.executeUpdate();
        }
        Logger.start("Создание счета " + accountNum + " успешно завершено");
    }

    //Метод обновления данных в таблице
    @Override
    public void updateCashByAccountNum(long accountNum, BigDecimal newCash) throws SQLException {
        Logger.start("Обновление данных " + accountNum);
        //Переподключение
        reopenConnection();
        String sql = "UPDATE " + tableName + " SET cash = ? WHERE accountNum = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setBigDecimal(1, newCash);
            ps.setLong(2, accountNum);
            int affectedRows = ps.executeUpdate();
            // Опционально: проверить, нашлась ли запись
            if (affectedRows == 0) {
                // Запись не найдена
                Logger.start("Запись " + accountNum + "не найдена ");
                throw new SQLException("Запись " + accountNum + "не найдена ");
            }
        }
        Logger.start("Обновление данных " + accountNum + " успешно завершено");
    }

    // Удаление записи по ключу accountNum с обязательной проверкой,
    // что поле cash равно 0.
    @Override
    public void deleteByAccountNumIfCashZero(long accountNum) throws SQLException {
        Logger.start("Удаление " + accountNum);
        //Переподключение
        reopenConnection();
        String sql = "DELETE FROM " + tableName + " WHERE accountNum = ? AND cash = 0";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, accountNum);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                // Ничего не удалено: либо записи с таким accountNum не существует,
                // либо cash не равен 0.
                Logger.start("Ничего не удалено: либо записи с таким " + accountNum + " не существует");
                throw new SQLException("No row deleted: either accountNum = " + accountNum + " does not exist or cash != 0.");
            }
        }
        Logger.start("Удаление " + accountNum + " успешно завершено");
    }

    //Возвращает HashMap из значений таблицы: ключ = accountNum (Long), значение = cash (BigDecimal).
    //Таблица читается только по существующим столбцам accountNum и cash.
    @Override
    public HashMap<Long, BigDecimal> readTableToHashMap() throws SQLException {
        Logger.start("Начало чтения таблицы " + tableName);
        if (!isTableNameAllowed(tableName)) {
            throw new IllegalArgumentException("Недопустимое имя таблицы: " + tableName);
        }
        //Переподключение
        reopenConnection();
        String sql = "SELECT accountNum, cash FROM " + tableName;
        HashMap<Long, BigDecimal> resultMap = new HashMap<>();
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                long accountNum = rs.getLong("accountNum");
                BigDecimal cash = rs.getBigDecimal("cash");
                resultMap.put(accountNum, cash);
            }
        }
        Logger.start("Чтение таблицы " + tableName + " завершено успешно");
        return resultMap;
    }

    //Метод проверяет наличие счёта в базе данных
    @Override
    public boolean isAccount(Long accountNum) throws SQLException {
        // Проверяем допустимость имени таблицы перед использованием в SQL
        Logger.start("Метод проверки имени таблицы запущен ");
        if (!isTableNameAllowed(tableName)) {
            Logger.start("Недопустимое имя таблицы: " + tableName + " в методе ");
            throw new IllegalArgumentException("Недопустимое имя таблицы: " + tableName);
        }
        reopenConnection();
        String sql = "SELECT 1 FROM " + tableName + " WHERE accountNum = ? LIMIT 1";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, accountNum);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // если есть хоть одна строка, значит запись найдена
            }
        }
    }

    //Метод чтения данных из таблицы по ключу(номер счёта)
    @Override
    public BigDecimal readValue(Long key) throws SQLException {
        Logger.start("Запуск чтения по ключу " + key);
        if (!isTableNameAllowed(tableName)) {
            Logger.start("Недопустимое имя таблицы: " + tableName);
            throw new IllegalArgumentException("Недопустимое имя таблицы: " + tableName);
        }
        reopenConnection();
        // Безопасная передача параметра через PreparedStatement
        String sql = "SELECT accountNum, cash FROM " + tableName + " WHERE accountNum = ?";
        BigDecimal result = new BigDecimal("0.00");

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, key);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    BigDecimal cash = rs.getBigDecimal("cash");
                    result = result.add(cash);
                }
            }
        }
        Logger.start("Операция чтения по ключу " + key + " завершена успешно");
        return result;
    }

    //Метод проверки наличия таблицы в БД
    public static boolean tableExistsInfo(Connection conn, String schema, String tableName) throws SQLException {
        String sql = "SELECT 1 FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = ? AND TABLE_NAME = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, schema);
            ps.setString(2, tableName);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
}

