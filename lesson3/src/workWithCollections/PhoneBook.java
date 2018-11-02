package workWithCollections;

import java.util.*;
import java.util.stream.Collectors;

public class PhoneBook{
    private Map<String, List<String>> mapElements;

    public PhoneBook(Map<String, List<String>> mapElements) {
        this.mapElements = sortByKeys(mapElements);
    }

    public void addPhone(String name, String phone) {
        if (name == null || phone == null) {
            System.out.println("Фамилия или номер указаны не верно");
            return;
        }
        List<String> phoneList = mapElements.get(name);
        if(phoneList == null){
            phoneList = new ArrayList<>();
        }
        phoneList.add(phone);
        mapElements.put(name, phoneList);
        mapElements = sortByKeys(mapElements);
        System.out.println("Добавлен новый контакт: ");
        this.printPhones(name);
    }

    public List<String> getPhones(String name) {
        if (name == null) {
            System.out.println("Нет контакта с Фамилия " + name);
            return null;
        }
        List<String> phoneList = mapElements.get(name);
        if (phoneList.isEmpty()) {
            System.out.println("Нет телефонов у контакта " + name);
            return null;
        }
        System.out.println("Информация о контакте: ");
        this.printPhones(name);
        return phoneList;
    }

    public void printAllPhones(){
        this.printPhones(null);
    }

    private void printPhones(String name) {
        Iterator iterator = mapElements.entrySet().iterator();
        for (Map.Entry<String, List<String>> elements : mapElements.entrySet()) {
            if(name != null && !elements.getKey().equals(name)){
                    continue;
            }
            String indexesToString = elements.getValue().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            System.out.println("Фамилия: " + elements.getKey() + ", номера телефонов: " + indexesToString);

        }
    }

    private Map<String,List<String>> sortByKeys(Map<String,List<String>> map){
        List<String> keys = new LinkedList<String>(map.keySet());
        Collections.sort(keys, new Comparator<String>() {
            @Override
            public int compare(String first, String second) {
                return first.compareTo(second);
            }
        });

        LinkedHashMap<String,List<String>> sortedMap = new LinkedHashMap<String,List<String>>();
        for(String key: keys){
            sortedMap.put(key, map.get(key));
        }

        return sortedMap;
    }
}
