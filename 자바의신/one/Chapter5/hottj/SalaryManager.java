package one.Chapter5;

public class SalaryManager{
    
    public double getMonthlySalary(int yearlySalary){
        double myTax = calculateTax(yearlySalary/12.0);
        double myNationalPension = calculateNationalPension(yearlySalary/12.0);
        double myHealthInsurance= calculateHealthInsurance(yearlySalary/12.0);
        double allMyTax = myTax + myNationalPension + myHealthInsurance;
        return yearlySalary/12.0-allMyTax;
    }

    public double calculateTax(double monthSalary){
        return monthSalary * 0.125;
    }

    public double calculateNationalPension(double monthSalary){
        return monthSalary * 0.081;
    }

    public double calculateHealthInsurance(double monthSalary){
        return monthSalary * 0.135;
    }
    public static void main(String[] args) {
        SalaryManager salaryManager = new SalaryManager();
        double money = salaryManager.getMonthlySalary(20000000);
        System.out.println(money);
    }
}