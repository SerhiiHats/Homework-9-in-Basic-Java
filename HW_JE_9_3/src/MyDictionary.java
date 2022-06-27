import java.util.ArrayList;
import java.util.List;

/**Домашнее задание 9
 Задание 3
 Создайте проект, используя IntelliJ IDEA.
 Создайте класс MyDictionary.
 Реализуйте в простейшем приближении возможность использования его экземпляра.
 Минимально требуемый интерфейс взаимодействия с экземпляром, должен включать :
 - метод добавления пар элементов,
 - индексатор для получения значения элемента по указанному индексу
 - и свойство только для чтения
 - для получения общего количества пар элементов.
 */

public class MyDictionary<K, V> {
    private final List<Body<K, V>> list;

    public MyDictionary() {
        this.list = new ArrayList<>();
    }

    /**Метод добавления пар элементов
     */
    public void add(K key, V value){
        Body<K, V> body = new Body<>(key, value);
        list.add(body);
      //  list.add(new Body<>(key, value));
    }

    /**Метод для получения всех имеющихся пар элементов.
     */
    public List<Body<K, V>> findAll() {
        return list;
    }

    /**Метод для получения значения элемента по указанному индексу.
     */
    public String findValue(K myKey){
        for (int i = 0; i < list.size(); i++) {
            if(myKey.equals(list.get(i).getKey())) {
             return String.valueOf( list.get(i).getKey() + ", перевод: " + list.get(i).getValue());
                // return list.get(i);
                //  System.out.println(list.get(i).getKey() + " = " + list.get(i).getValue());
            }
        }
        return String.valueOf(myKey + " - к этому слову не найдено перевода в словаре");
    }

    /**Метод для получения количества имеющихся пар элементов.
     */
    public int howMachCouples() {
        return list.size();
    }

    static class Body<K,V> {
        private K key;
        private V value;

        public Body(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key +
                    ", перевод: " + value +
                    '}';
        }
    }

}
