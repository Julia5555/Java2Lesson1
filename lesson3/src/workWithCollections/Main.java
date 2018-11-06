package workWithCollections;

import java.util.*;

public class Main {

    public static String[] generationText(){
        String text = "В коде выше создан массив arr имеющий длину 4, при необходимости его расширения до 10 элементов, мы создаем новый массив arr_new длиной 10, после чего с помощью метода System.arraycopy() копируем все элементы из arr в arr_new, и в конце концов в arr записываем ссылку на новый массив. В результате arr изменил свой размер с 4 до 10. Было бы удобно, если существовал класс, который бы мог выполнять эту работу автоматически по необходимости";
        text = text.replaceAll("[^a-zA-Zа-яА-Я_()]", " ");
        String[] arayStrings = text.split("\\s+");
        return arayStrings;

    }

    public static void searchOfDoubles(){
        String[] strings = generationText();

        Map<String,Integer> stringsMap = new HashMap<>();
        for (String element: strings) {
            element = element.toLowerCase();
            if (stringsMap.keySet().contains(element)) {
                Integer value = stringsMap.get(element)+1;
                stringsMap.put(element,value);
            }else{
                stringsMap.put(element,1);
            }
        }

        Iterator iterator = stringsMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry)iterator.next();
            System.out.println("Слово \""+pair.getKey()+ "\" встречается "+pair.getValue());
        }
    }

    public static void createPhoneBook(){
        Map<String,List<String>> map = new HashMap<>();
        map.put("Депп", Arrays.asList("89124534657","34928475643"));
        map.put("Круз", Arrays.asList("44544444554","34928545643"));
        map.put("Питт", Arrays.asList("43434343433","44444556677"));

        PhoneBook phoneBook = new PhoneBook(map);
        System.out.println("Все данные телефонной книги");
        phoneBook.printAllPhones();

        System.out.println("Добавление телефона в справочник");
        phoneBook.addPhone("Афлек","59485757575");

        phoneBook.getPhones("Круз");

        System.out.println("Все данные телефонной книги");
        phoneBook.printAllPhones();
    }

    public static void main(String[] args) {
        searchOfDoubles();
        createPhoneBook();
    }
}
