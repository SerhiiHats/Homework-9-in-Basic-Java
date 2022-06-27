public class Employee {
    private String name;
    private String major;
    private int age;
    private int salary;

    public Employee(String name, String major, int age, int salary) {
        this.name = name;
        this.major = major;
        this.age = age;
        this.salary = salary;
    }
    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "{name: " + name +
                ", major=" + major +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
