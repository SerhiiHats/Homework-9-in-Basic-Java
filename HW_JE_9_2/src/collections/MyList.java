package collections;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Домашнее задание 9
 * Задание 2
 * Создайте проект, используя IntelliJ IDEA.
 * Создайте класс collections.MyList.
 * Реализуйте в простейшем приближении возможность использования его экземпляра аналогично экземпляру класса List.
 * Минимально требуемый интерфейс взаимодействия с экземпляром, должен включать:
 * - add(T element) : метод добавления элемента,
 * - get(int index) : метод (индексатор) для получения значения элемента по указанному индексу
 * - toString() : метод (и свойство только) для чтения
 * - fillingSize() : метод для получения общего количества элементов
 * (УСЛОЖНИЛ ЗАДАЧУ РЕАЛИЗАЦИЕЙ ДОПОЛНИТЕЛЬНЫХ МЕТОДОВ:)
 * - collections.MyList(int userSize) : метод создания collections.MyList с пользовательским размером, пользователь сам задает размер будующего collections.MyList (по дефолту = 10)
 * - toSeeAll() : метод показывающий реальное состояние collections.MyList полностью под капотом
 * - addElementAtIndex(int index, T element) : метод добавления элемента в конкретное место по индексу
 * - getFirstElement() : метод получения первого елемента в collections.MyList,
 * - getLastElement() : метод получения последнего елемента в collections.MyList,
 * - set(int index, T element) : метод редактирования записи по индексу в collections.MyList,
 * - contains(T element) : метод проверки на содержания елемента в collections.MyList,
 * - isEmpty() : метод проверки на пустоту в collections.MyList
 * - clear() : метод удаления всех елементов в collections.MyList
 * - deleteElementAtIndex(int index) : метод удаления элемента в конкретном месте по индексу,
 * - addAll(T... element) : метод добавления сразу всех елементов в collections.MyList,
 */

public class MyList<T> {

    private static final int DEFAULT_SIZE = 10;
    private Object[] arr;  // private T [] arr = new T[SIZE] - так не работает;
    private int cursor = 0;

    /**
     * Конструктор по дефолту collections.MyList с размерность = 10.
     */
    public MyList() {
        arr = new Object[DEFAULT_SIZE];
        //this(DEFAULT_SIZE);
    }

    /**
     * Конструктор создания collections.MyList с пользовательским размером
     */
    public MyList(int userSize) {
        if (userSize <= 0) {
            throw new IllegalArgumentException();
        } else {
            arr = new Object[userSize];
        }
    }

    /**
     * Метод показывающий содержимое collections.MyList.
     */
    @Override
    public String toString() {
        if (cursor == 0) {
            return "[]";
        }
        int iMax = cursor - 1;
        StringBuilder strbild = new StringBuilder();
        strbild.append('[');
        for (int i = 0; ; i++) {
            strbild.append(arr[i]);
            if (i == iMax) {
                strbild.append(']');
                return strbild.toString();
            }
            strbild.append(", ");
        }
    }

    /**
     * Метод показывающий реальное состояние collections.MyList полностью под капотом.
     */
    public String toSeeAll() {
        return "collections.MyList{" +
                "arr=" + Arrays.toString(arr) +
                ", cursor=" + cursor + ", lenght=" + arr.length +
                '}';
    }

    /**
     * Метод добавления элемента в collections.MyList, а именно в его конец.
     * В случае если collections.MyList заполнен более чем на 75%, вызывается метод resizeArray().
     */
    public void add(T element) {
        if (arr.length * 0.75 < cursor) {
            resizeArray();                           // вызываем метод увеличения размера массива
        }
        arr[cursor] = element;
        cursor++;
    }

    /**
     * Метод увеличения размера collections.MyList в 2 раза от заполненого значения
     */
    private void resizeArray() {
        Object[] tempArr = new Object[cursor * 2];                     // создаем новый массив с размерность х2 от имеющегося заполненого
        System.arraycopy(arr, 0, tempArr, 0, arr.length); //cursor // копируем в новый массив с увеличеной размерность старый массив с меньшей размерностью
        arr = tempArr;                                              // присваиваем ссылке на старый массив - новый массив
    }

    /**
     * Метод для получения значения элемента в collections.MyList по указанному индексу.
     */
    @SuppressWarnings("unchecked")          // говорим о том что понимаем что делаем с down кастингом
    public T get(int index) {             //Object
        if (index >= cursor || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return (T) arr[index];        //arr[index]
        }
    }

    /**
     * Метод для получения общего количества элементов в collections.MyList которые заполнены.
     */
    public int fillingSize() {
        return cursor;
    }

    /**
     * Метод добавления элемента в collections.MyList в конкретное место по индексу
     */
    public void addElementAtIndex(int index, T element) {
//        Objects.checkIndex(index,cursor + 1);           // метод выкидывает IndexOutOfBoundsException() если индекс Юзера больше имеющегося или меньше 0
        if (index > cursor || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            Object[] tempArr = new Object[arr.length + 1];                         //создаем новый массив с размерность +1 от старого
            System.arraycopy(arr, 0, tempArr, 0, index);         // копируем в новый массив часть старого по указаный индекс
            tempArr[index] = element;                                         // присваиваем вставляемый елемент новому массиву под указаным индексом
            System.arraycopy(arr, index, tempArr, index + 1, arr.length - index);   // копируем в новый массив вторую часть старого массива с указаного индекса
            arr = tempArr;                                                   // присваиваем ссылке на старый массив - новый массив
//            resizeArray();                                                   // тоже можно пременить но код , что не закоментирован более понятен для меня
//            System.arraycopy(arr, index, arr, index +1, arr.length - index); // cursor- index
//            arr[index] = element;
            cursor++;
        }
    }

    /**
     * Метод получения первого елемента в collections.MyList,
     */
    @SuppressWarnings("unchecked")                       // говорим о том что понимаем что делаем с down кастингом
    public T getFirstElement() {             //Object
        if (cursor == 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return (T) arr[0];               //arr[0]
        }
    }

    /**
     * Метод получения последнего елемента в collections.MyList,
     */
   @SuppressWarnings("unchecked")                        // говорим о том что понимаем что делаем с down кастингом
    public T getLastElement() {             //Object
        if (cursor == 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            // return get(cursor-1);
            return (T) arr[cursor - 1];        //arr[index-1]
        }
    }

    /**
     * Метод редактирования по индексу в collections.MyList,
     */
    public void set(int index, T element) {
        //        Objects.checkIndex(index,cursor);           // метод выкидывает IndexOutOfBoundsException() если индекс Юзера больше имеющегося или меньше 0
        if (index > cursor || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            arr[index] = element;
        }
    }

    /**
     * Метод проверки содержания елемента в collections.MyList,
     */
    public boolean contains(T element) {
        for (int i = 0; i < cursor; i++) {
            if (element.equals(arr[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Метод проверки на пустоту в collections.MyList
     */
    public boolean isEmpty() {
        return cursor == 0;
    }

    /**
     * - метод удаления всех елементов в collections.MyList
     */
    public void clear() {
        arr = new Object[DEFAULT_SIZE];
        cursor = 0;
    }

    /**
     * Метод удаления элемента в конкретном месте по индексу
     */
    public void deleteElementAtIndex(int index) {
        //        Objects.checkIndex(index,cursor);           // метод выкидывает IndexOutOfBoundsException() если индекс Юзера больше имеющегося или меньше 0
        if (index >= cursor || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            Object[] tempArr = new Object[arr.length - 1];                         //создаем новый массив с размерность в = -1 от старого
            System.arraycopy(arr, 0, tempArr, 0, index);         // копируем в новый массив часть старого по указаный индекс
            System.arraycopy(arr, index + 1, tempArr, index, (arr.length - index - 1));   // копируем в новый массив вторую часть старого массива пропуская указанный индекс
            arr = tempArr;                                                   // присваиваем ссылке на старый массив - новый массив
//            System.arraycopy(arr, index + 1, arr, index, arr.length - index - 1); // cursor - index - 1
            cursor--;
        }
    }

    /**
     * Метод добавления сразу всех елементов в collections.MyList.
     */
    public void addAll(T... element) {
        for (T e : element) {
            add(e);
        }
    }

}
