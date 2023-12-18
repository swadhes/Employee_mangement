import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public abstract double calculatedSalay(); //abstract method

    @Override
    public String toString() { //to string method to generate
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
class fulltimeemployee extends Employee{
    private double monthlysalary;

    public fulltimeemployee(String name, int id,double monthlysalary) {
        super(name, id);
        this.monthlysalary=monthlysalary;
    }
    @Override
    public double calculatedSalay() {
        return monthlysalary;
    }
}
class parttimeemployee extends Employee{
    private int hoursworked;
    private double hourlyrate;

    public parttimeemployee(String name, int id, int hoursworked, double hourlyrate) {
        super(name, id);
        this.hoursworked = hoursworked;
        this.hourlyrate = hourlyrate;
    }

    @Override
    public double calculatedSalay() {
        return hoursworked*hourlyrate;
    }
}
class payrollsystem{
    private ArrayList <Employee> employeelist;
    public payrollsystem(){
        employeelist= new ArrayList<>();
    }
    public void addEmployee(Employee employee){
        employeelist.add(employee);

    }
    public void removeEmployee(int id){
        Employee employeeToRemove=null;
        for (Employee employee :employeelist){
            if(employee.getId()==id){
                employeeToRemove=employee;
                break;
            }
        }
        if (employeeToRemove!=null){
            employeelist.remove(employeeToRemove);
        }
    }
    public void displayemployees(){
        for (Employee employee:employeelist){
            System.out.println(employee);
        }
    }
}
public class test4 {
    public static void main(String[] args) {
        payrollsystem ob= new payrollsystem();
        fulltimeemployee emp1=new fulltimeemployee("vikas",1,22000);
        parttimeemployee emp2= new parttimeemployee("swadheen",2,40,100);

        ob.addEmployee(emp1);
        ob.addEmployee(emp2);
        System.out.println("Initial Employee details");
        ob.displayemployees();
        System.out.println("Removing the Employees");
        ob.removeEmployee(2);
        System.out.println("Remaining Employee Details");
        ob.displayemployees();
    }
}
