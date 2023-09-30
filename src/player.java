// import java.util.List;

import java.util.ArrayList;

public class player {
    String name;
    int hp;
    int speed;
    int inEncounter;
    int attack;
    int defense;
    int species;
    ArrayList<items> Items = new ArrayList<items>();
    // ArrayList<items> inventory = new ArrayList<items>();
    // String inventory;
    // used to allow player to check their stats
    public void look() {
        System.out.println("hp: " + hp);
        System.out.println("speed: " + speed);
        System.out.println("attack: " + attack);
        System.out.println("defense: " + defense);
    }
}
