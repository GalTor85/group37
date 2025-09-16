package Lesson8.Practic2;

public class Main {
    /**
     * 2. Абстрактный класс Employee с полями name, id, методом displayInfo() и абстрактным методом calculateSalary().
     * Наследники: SalariedEmployee(Штатный сотрудник), HourlyEmployee(Почасовой сотрудник),
     * CommissionEmployee(Комиссионный сотрудник). Добавить поля по необходимости.
     * Показать зарплату каждого сотрудника в Main.
     */
    public static void main(String[] args) {
        SalariedEmployee salariedEmployee = new SalariedEmployee();
        salariedEmployee.setName("Jane Doe");
        salariedEmployee.setId("00001");
        salariedEmployee.displayInfo();
        salariedEmployee.calculateSalary();

    }
}
