public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();

        Employee employee = new Employee("John Doe", "Manager", "john.doe@example.com", "1234567890", 30);
        System.out.println("Employee Details:");
        System.out.println("Full Name: " + employee.getFullName());
        System.out.println("Position: " + employee.getPosition());
        System.out.println("Email: " + employee.getEmail());
        System.out.println("Phone: " + employee.getPhone());
        System.out.println("Age: " + employee.getAge());
    }
}
