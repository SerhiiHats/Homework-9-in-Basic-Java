public class MyClass <T> {
    public static void main(String[] args) {


    }


    @SuppressWarnings("unchecked")      // аннотация которая говорим о том что я понимаем что я делаю с down кастингом и подавляет предупреждения
public static <T> T factoryMethod() {
       // return new T();
        return (T) new Object();
    }


}
