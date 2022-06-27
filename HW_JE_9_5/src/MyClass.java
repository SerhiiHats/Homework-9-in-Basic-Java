/**Домашнее задание 9
 Задание 5
 Создайте проект, используя IntelliJ IDEA. Создайте класс MyClass,
 содержащий статический фабричный метод - T factoryMethod(),
 который будет порождать экземпляры типа, указанного в качестве параметра типа (указателя места заполнения типом – Т).
 */

public class MyClass {
    public static void main(String[] args) {
        System.out.println("1. Test  Employee");
        MyClass.<Employee>factoryMethod(new Employee());
        System.out.println("2. Test  Animal");
        Animal d = new Animal();
        MyClass.factoryMethod(d);
    }

    public static <T> void factoryMethod(T t){
        T element = t;
        System.out.println("is a variable from " + element.getClass());
        System.out.println("Are you Animal? : " + (element instanceof Animal));
        System.out.println("Are you Employee? : " + (element instanceof Employee));
        System.out.println("Are you Object? : " + (element instanceof Object));
    }

}