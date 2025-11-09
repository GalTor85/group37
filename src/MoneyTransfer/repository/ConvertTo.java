package MoneyTransfer.repository;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;

//Класс конвертирования внутренних данных не задействован в данной реализации в связи с изменением в формате данных программы
public class ConvertTo {
    public static HashMap<Long, BigDecimal> decimalHashMap(HashMap<String, String> map) {
        HashMap<Long, BigDecimal> result = new HashMap<>();
        if (map == null) {
            return result;
        }
        map.forEach((k, v) -> {
            // проверки входных данных
            if (k == null) {
                // пропускаем некорректные пары
                return;
            }
            String keyTrimmed = k.trim().replace("-","");
            String valueTrimmed = v.trim();
            if (keyTrimmed.isEmpty() || valueTrimmed.isEmpty()) {
                // пропускаем пустые ключи или значения
                return;
            }
            try {
                Long key = Long.parseLong(keyTrimmed);
                BigDecimal value = new BigDecimal(valueTrimmed);
                result.put(key, value);
            } catch (NumberFormatException ex) {
            }
        });
        return result;
    }



    public static HashMap<String, String> stringHashMap(HashMap<Long, BigDecimal> map) {
        HashMap<String, String> result = new HashMap<>();
        if (map == null) {
            return result;
        }
        map.forEach((k, v) -> {
            // проверки входных данных
            if (k == null) {
                // пропускаем некорректные пары
                return;
            }
            if ((k<0&&k>9_999_999_999L) || (v.compareTo(BigDecimal.ZERO)<0)) {
                // пропускаем неправильные ключи или значения
                return;
            }
            try {
                DecimalFormat formatter = new DecimalFormat("00000");
                String key = formatter.format(k/100000)+"-"+formatter.format(k%100000);
                String value = v.toString();
                result.put(key, value);
                } catch (NumberFormatException ex) {
            }
        });
        return result;
    }
}
