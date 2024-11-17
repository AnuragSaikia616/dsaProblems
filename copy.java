/**
 * copy
 */
public class copy {
  public static class Person {
    int age;
    String name;

    public void show() {
      System.out.println("Name:" + this.name + " Age:" + this.age);
    }

    public Person(int age, String name) {
      this.age = age;
      this.name = name;
    }

    public Person(Person p) {
      this.age = p.age;
      this.name = p.name;
    }

  }

  public static void main(String[] args) throws CloneNotSupportedException {
    Person p1 = new Person(22, "Anurag");
    Person p2 = new Person(p1);
    p2.name = "Sintu";
    p1.show();
    p2.show();

  }
}
