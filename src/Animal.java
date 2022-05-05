import java.util.ArrayList;
import java.util.List;

public final class Animal {
/*
* Используйте конструктор, чтобы установить значения всех полей объекта.
* Нам нужно определить все параметры будущего объекта в конструкторе,
* так как после этого будет невозможно изменять поля.
*
* Обозначьте все переменные объекта ключевыми словами private и final
* private — для инкапсуляции переменных,
* final — чтобы не было возможности внутри класса случайно переопределить ссылочную переменную.
*
Не определяйте никаких setter-ов.
* По понятным причинам — объект должен быть неизменяем на протяжении всего жизненного цикла.
* Не возвращайте при запросах ссылки на изменяемые
* объекты внутри неизменяемого объекта, создавайте копию и возвращайте её.
* Предотвратите возможность для переопределения методов.
* Представьте, что это было бы разрешено.
* Тогда возможно унаследовать immutable класс и переопределить его так,
* чтобы была возможность видоизменять другие переменные в унаследованном классе,
* таким образом скрывая private-переменные родительского класса.*/
    private final String species;
    private final int age;
    private final List<String> favoriteFoods;

    public Animal(String species, int age, List<String> favoriteFoods) {
        this.species = species;
        this.age = age;
        this.favoriteFoods = new ArrayList<>(favoriteFoods);
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public List<String> getFavoriteFoods() {
        return new ArrayList<>(favoriteFoods);
    }
}