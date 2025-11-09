package MoneyTransfer.model;

import java.time.format.DateTimeFormatter;

public interface InitConst {
    String keyOne = "1";
    String keyTwo = "2";
    String keyThree = "3";
    String filesMask = ".txt";
    String inputPath = "\\input";
    String archivePath = "\\archive";
    String dir = System.getProperty("user.dir");
    String inputPathFirstLoadTable =dir+ "\\input\\firstbase";
    String reportPath = dir +"\\report";
    String reportPathFile =dir+ "\\report\\report.txt";
    String logPath = dir + "\\log";
    String logPathFile = dir + "\\log\\log.txt";
    DateTimeFormatter localDT = DateTimeFormatter.ofPattern("ddMMyy_HHmmss");
    DateTimeFormatter logDTFormat = DateTimeFormatter.ofPattern("dd/MM/yy_HH:mm:ss");
    DateTimeFormatter repDateFormat = DateTimeFormatter.ofPattern("dd/MM/yy");
    String patternDate = "\\b\\d{2}/\\d{2}/\\d{2}";
    String inputPathAbs = dir + inputPath;
    String archivePathAbs = dir + archivePath;
    String patternMoneyAccountNumber = ("\\d{5}-\\d{5}");
    String patternOpenAnAccount = ("("+patternMoneyAccountNumber+"\\s"+"\\-?\\d+)|"+
            "("+patternMoneyAccountNumber +"\\s\\-?\\d+.\\d{2})");
    String patternTransferOperation = ("(" + patternMoneyAccountNumber +"\\s" +
            patternMoneyAccountNumber +"\\s"+"\\-?\\d+)|" +
            "("+ patternMoneyAccountNumber +"\\s"+ patternMoneyAccountNumber +
            "\\s\\-?\\d+.\\d{2})");
    String tableName = "collectionMoneyAccounts";
    String DB_Driver = "org.h2.Driver";
    String bdPathFile = dir + "\\bd\\bd";
    String DB_URL = "jdbc:h2:" + bdPathFile;
    String user = "root";
    String password = "password";

}
