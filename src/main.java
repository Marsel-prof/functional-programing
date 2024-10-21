import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class main {
    // create new class to explain the functional programing
    static class Person{ //? we made it static because we will use it inside static class(main class)
        private final String name; //* here we create constant variable because it will not change
        private final Gender gender;
        private final int age;
        //& create constructor to set name and gender from user
        public Person(String name, Gender gender,int age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

    }
    public static void main(String[] args) {
        // now we will create list of person
        List<Person> people = List.of( //% list.of => used to create objects from class in declaration time
                new Person("John", Gender.MALE,23),
                new Person("Jane", Gender.FEMALE,14),
                new Person("Jack", Gender.MALE,25),
                new Person("Jill", Gender.FEMALE,29)
        );
        //Streams => it's a tools to process data in parallel and it's work on array, list, and set (collections)
        //? how use the stream?
        people.stream().filter(person -> person.age > 18)//will return people how larger than 18 only
                .forEach(person -> System.out.println(person.name));

        System.out.println("======================================");

       var result = people.stream().filter(person -> person.age > 18).toList(); //=> it's used to convert stream to list

        people.stream().filter(person -> person.age > 18).collect(Collectors.toList());//=> it's used to convert stream to list in another way

        for (Person person : result) {
            System.out.println(person.name);// will print them in normal way
        }
        /*//? now if we want to separate the male and female persons in normal way
        List<Person> females = new ArrayList<>();
        for (Person person : people) { //& faster for loop (automatically loop )
            if(Gender.FEMALE.equals(person.gender)){
                females.add(person);
            }
        }
        for (Person female : females) {
            System.out.println(female.name);
        }
        //*========================IN FUNCTIONAL PROGRAMING =============================*/
       /* people.stream()//=> it's sequence of elements that processing in parallel
                //? how i can use filter ? => write filter ( lambda )
                //what is a lambda ? => it's as arrow function
                .filter(person -> Gender.FEMALE.equals(person.gender))//& Gender.FEMALE.equals(person.gender) => is lambda arrow function
                //? under some conditions and it's return a new list
                  .forEach(person -> System.out.println(person.name));//& it's a method to loop on data
        //% الفرق بين الطريقتين انو الطريقة الثانية اقل استهلاك للميموري بالاضافةانها بتنفذ العملية بشكل اسرع
        //% واسهل في الكتابة بحيث تختصر كود كثير بسطرين فقط*/
        /*Predicate<Person> femalePredicate = person -> Gender.FEMALE.equals(person.gender);// the predicate is a function that return a boolean value
        // and it's used to define a condition or a rule
        people.stream()
                .filter(femalePredicate) // inside filter i write a predicate
                .forEach(person -> System.out.println(person.name));
        //& if i want to return a new list from stream i will do this :
        List<Person> femalesFromStream = people.stream()
                .filter(femalePredicate)
                .collect(Collectors.toList());//=> it's used to accumulate the results of the stream into a collection.
        //%or .collect(Collectors.toCollection(ArrayList::new)) => or any type of collections (like list, map,etc.)
        //&-------------------------------------function-----------------------------------
        System.out.println(incrementNum(5));// in normal way to increment number
        System.out.println(Incremental.apply(5));// in functional programing way to increment number
        System.out.println(BiIncremental.apply(5,2));// in functional programing way to increment two numbers
      //&-------------------------------------consumer-----------------------------------
        printNameConsumer.accept(new Person("John", Gender.MALE));// in functional programing way to print name
        printName(new Person("John", Gender.MALE));// in normal way to print names
        //&-------------------------------------predicate-----------------------------------
        System.out.println(isEven(5)); // normal way
        System.out.println(isEvenFun);// the predicate implement test method
        //&-------------------------------------supplier-----------------------------------
        System.out.println(getUrl());
        System.out.println(getUrlSupplier.get());//& implement get method */
    }
   /* //&-------------------------------------supplier-----------------------------------
    static Supplier<String> getUrlSupplier = () -> "https://www.google.com/";// function that return value and don't take any arguments
    public static String getUrl(){return "https://www.google.com/";}// normal way to return value without arguments
   //&-------------------------------------predicate-----------------------------------
    static Predicate<Integer> isEvenFun = num -> num % 2 == 0; // as we say it is return a boolean value
    public static Boolean isEven(int num){
        return num % 2 == 0;
    }
    public static void printName(Person person){ //% normal way to create a function that print name of person
        System.out.println(person.name);
    }
    //&-------------------------------------consumer-----------------------------------
    //& in functional programing way to print name of person
    static Consumer<Person> printNameConsumer = person -> System.out.println(person.name);//take one argument and dont return anything
    // is as a void function and implement method called accept

    //&-------------------------------------function-----------------------------------
    static Function<Integer,Integer> Incremental = num -> num+1;//# take one argument and return value
    //# هو عبارة عن implementation لفنكشن اسمه apply
    //&-------------------------------------BiFunction-----------------------------------
    static BiFunction<Integer,Integer,Integer> BiIncremental = (num1,num2) -> num1+num2;//& take two argument and return value
    public static int  incrementNum(int num){
        return num+1;
    }*/
}

enum Gender{ // عبارة عن تعريف نوع جديد من البيانات ولكن يكون عبارة عن ثوابت
    // يعني على سبيل المثال اشهر السنة ثابتة لا تتغير نوع الجنس اسماء الفصول وهكذا
    MALE, FEMALE
}



























