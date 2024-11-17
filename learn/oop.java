public class oop {

  public static class User {
    private int id;
    private String name;

    public User(String name, int id) {
      this.name = name;
      this.id = id;
    }

    public void Hello() {
      System.out.println("Hello!");
    }
  }

  public static class Employee extends User {
    private int Deptid;

    public Employee(int deptid, int id, String name) {
      super(name, id);
      this.Deptid = deptid;
    }

    @Override
    public void Hello() {
      System.out.println("Helli i am employee!! from dept:" + Deptid);
    }
  }

  public static void main(String[] args) {
    User v = new User("rahul", 02);
    User u = new Employee(101, 1, "Anurag");
    v.Hello();
    u.Hello();
  }
}
