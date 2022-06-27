public class MyDictionaryDemo {
    public static void main(String[] args) {
        MyDictionary<String, String> dictionary = new MyDictionary<>();
        // добавляем слова в словарь
        dictionary.add("bar", "бар");
        dictionary.add("nearby", "рядом");
        dictionary.add("want", "хочешь");
        dictionary.add("sorry", "простите");
        dictionary.add("when", "когда");
        dictionary.add("tonight", "сегодня вечером");
        dictionary.add("cafe", "кафе");
        dictionary.add("dinner", "ужин");
        dictionary.add("wine", "вино");
        dictionary.add("coffee", "кофе");
        dictionary.add("glass", "стакан");
        dictionary.add("museum", "музей");
        dictionary.add("friend", "друг");

        // получаем перевод слова по указанному индексу
        System.out.println(dictionary.findValue("dinner"));
        System.out.println(dictionary.findValue("tonight"));
        System.out.println(dictionary.findValue("cook"));               // этого слова нет в нашем словаре

        // получаем количество слов которые занесены в словарь
        System.out.println("Всего в словаре слов: " + dictionary.howMachCouples());

        // получаем получаем все слова которые занесены в словарь
        System.out.println(dictionary.findAll());

    }
}
