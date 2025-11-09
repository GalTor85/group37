package MoneyTransfer.model;




import java.math.BigDecimal;

import java.sql.SQLException;
import java.util.HashMap;

//Интерфейс методов работы с таблицами
public interface TableOperations {
    void createTable() throws SQLException; // создание таблицы

    void createForeignKeys() throws SQLException; // создание связей между таблицами

    void createExtraConstraints() throws SQLException; // создание дополнительных правил для значений полей таблиц

    void addValue(long accountID, BigDecimal cash) throws SQLException;

    void updateCashByAccountNum(long accountNum, BigDecimal newCash) throws SQLException;

    public BigDecimal readValue(Long key) throws SQLException;

    public boolean isAccount(Long accountNum) throws SQLException;

    void deleteByAccountNumIfCashZero(long accountNum) throws SQLException;

    HashMap<Long, BigDecimal> readTableToHashMap() throws SQLException;

}