package one.Chapter16_FINAL.sungwon.c.middle;

public class CalculateSalary {
    public static void main(String[] args){
        CalculateSalary cals=new CalculateSalary();
        cals.CalculateSalaries();
    }
    public long getSalaryIncrease(Employee employee){
        switch(employee.getType()){
            case(1): return employee.getSalary()+employee.getSalary()*(-95)/100;
            case(2): return employee.getSalary()+employee.getSalary()*10/100;
            case(3): return employee.getSalary()+employee.getSalary()*20/100;
            case(4): return employee.getSalary()+employee.getSalary()*30/100;
            case(5): return employee.getSalary()+employee.getSalary()*100/100;
            default:
        }
        return 0;
    }
    public void CalculateSalaries(){
        Employee[] employee=new Employee[5];
        CalculateSalary cals=new CalculateSalary();
        employee[0]=new Employee("LeeDaeRi", 1 , 1000000000);
        employee[1]=new Employee("KimManager", 2, 100000000);
        employee[2]=new Employee("WhangDesign", 3, 70000000);
        employee[3]=new Employee("ParkArchi", 4, 80000000);
        employee[4]=new Employee("LeeDevelop", 5, 60000000);
        for(Employee data:employee)
            System.out.println(data+"\t=\t"+cals.getSalaryIncrease(data));
    }
}