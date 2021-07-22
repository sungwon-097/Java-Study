package one.Chapter05.sungwon;

public class SalaryManager {

    public double getMonthlySalary(int yearlySalary){
        double monthlySalary=yearlySalary/12.0;
        double Tax=calculateTax(monthlySalary);
        double NationalPension=calculateNationalPension(monthlySalary);
        double HealthInsurance=calculateHealthInsurance(monthlySalary);
        monthlySalary-=(Tax+NationalPension+HealthInsurance);
        return monthlySalary;
    }
    public double calculateTax(double monthlySalary){
        System.out.println(monthlySalary*0.125);
        return monthlySalary*0.125;
    }
    public double calculateNationalPension(double monthlySalary){
        System.out.println(monthlySalary*0.081);
        return monthlySalary*0.081;
    }
    public double calculateHealthInsurance(double monthlySalary){
        System.out.println(monthlySalary*0.135);
        return monthlySalary*0.135;
    }
    public static void main(String[] args){
        int yearlySalary=20000000;
        SalaryManager salaryManager=new SalaryManager();
        System.out.println(salaryManager.getMonthlySalary(yearlySalary));
    }
}
