public class monsters {
    String name;
    String id = "monsters";
    String desc;
    int hp;
    int attack;
    int defense;
    int speed;
    // possibly will add undead later making more extensive use of boolean interactions
    boolean alive = true;
    public void look() {
        System.out.println("You see " + name + ".");
        System.out.println(desc);
        System.out.println("hp: " + hp);
        System.out.println("speed: " + speed);
    }
}