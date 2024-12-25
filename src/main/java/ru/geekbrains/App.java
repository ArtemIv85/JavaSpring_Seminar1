package ru.geekbrains;

import com.google.gson.Gson;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Урок 1. Системы сборки Maven и Gradle для разработки Java приложений
 * Создать проект с использованием Maven или Gradle, добавить в него несколько зависимостей и написать код,
 * использующий эти зависимости.
 * Задание:
 * 1. Создайте новый Maven или Gradle проект, следуя инструкциям из блока 1 или блока 2.
 * 2. Добавьте зависимости org.apache.commons:commons-lang3:3.12.0 и com.google.code.gson:gson:2.8.6.
 * 3. Создайте класс Person с полями firstName, lastName и age.
 * 4. Используйте библиотеку commons-lang3 для генерации методов toString, equals и hashCode.
 * 5. Используйте библиотеку gson для сериализации и десериализации объектов класса Person в формат JSON.
 */


public class App 
{
    public static void main( String[] args )
    {

        Person person1 = new Person(25,"Artem","Ivanov");
        Person person2 = new Person(25,"Artem","Ivanov");
        Person person3 = new Person(49,"Maxim","Ivanov");


        System.out.println(person1.toString());
        System.out.println("HashCode: "+person1.hashCode());
        System.out.println(person2.toString());
        System.out.println("HashCode: "+person2.hashCode());
        System.out.println(person3.toString());
        System.out.println("HashCode: "+person3.hashCode());

        System.out.printf("Сравнение %s и %s = %s \n",person1.getFirstName(),person3.getFirstName(),person1.equals(person3));

        System.out.println("\n Работа с Json");
        Gson gson = new Gson();
        String strgson1 = gson.toJson(person1);
        System.out.println(strgson1);
        Person perjson = gson.fromJson(strgson1, Person.class);
        System.out.println(perjson.toString());
        System.out.printf("Сравнение %s и %s после серелизации и десерилизации = %s \n",person1.getFirstName(),perjson.getFirstName(),person1.equals(perjson));

        /**
         * Дополнительная работа
         */
        System.out.println("\n Выполнение серелизации и десерелизации коллекции");
        List<Person> personList = new ArrayList<Person>();
         personList.add(person1);
         personList.add(person2);
         personList.add(person3);
         personList.add(perjson);
         String personListJson = gson.toJson(personList); //серелизация списка
        System.out.println("Json строка с колекцией");
        System.out.println(personListJson);

        Type type = new TypeToken<List<Person>>(){}.getType();
        List<Person> personList1 = gson.fromJson(personListJson,type);
        System.out.println("Десериализованная колекция из Json");
        System.out.println(personList1.toString());

        System.out.printf("Сравнение %s и %s после серелизации и десерилизации колекции = %s \n",
               person1.getFirstName(),personList1.get(0).getFirstName(),person1.equals(personList1.get(0)));



    }

}
