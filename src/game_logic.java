import java.util.Scanner;

public class game_logic {
    public game_logic() {
        objects.Encounters.add(new encounters(0));
        objects.Encounters.add(new encounters(1));
        // List<String> encounterInfo = new ArrayList<String>();
        // would read from file here, but I am running into trouble with depreciated
        // methods of approaching that.
        // attempting to add items to an encounter. I may just assign items to
        // characters.
        // for ( int i = 0; i < 3; i++) {
        // objects.Encounters.get(0).Items.add(objects.itemsDB.get(i));
        // }
        objects.Encounters.add(new encounters(1));
        objects.Encounters.get(0).name = "encounter 1";
        objects.Encounters.get(0).desc.add("Desc line 1");
        objects.Encounters.get(0).desc.add("Desc line 2");
        objects.Encounters.get(0).desc.add("Desc line 3");
        objects.Encounters.get(0).exits.add("North 2");
        objects.Encounters.get(0).exits.add("South 3");
        // objects.Encounters.get(0).Monsters.add(objects.monstersDB.get(0));
        // objects.Encounters.get(0).Items.add(objects.itemsDB.get(0));
    }

    public void getCommand() {
        // next 2 if statements used for combat schenarios
        if (objects.Player.inEncounter == 0) {
            newCharacter();
        }
        // if (objects.Player.inEncounter == 1) {
        // selectEquiptment();
        // }
        if (objects.Player.hp <= 0) {
            System.out.println("You died.");
            System.exit(0);
        }
        if (objects.Player.hp > 0) {
            System.out.println("You have " + objects.Player.hp + " hp.");
        }
        // add location later
        // if (objects.Player.hp > 0) {
        // System.out.println("You are in " + objects.Player.location + ".");
        // }

        System.out.println("Choose your path:");
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        // sc.close();
        // next need to parse the command string
        String[] words = command.split(" ");
        processCommand(words);
    }

    public void processCommand(String[] x) {
        // check surroundings/ stats
        if (x[0].equals("look")) {
            look(x);
        }
        // grab item
        if (x[0].equals("grab")) {
            grab(x);
        }
        // combat functionality
        // if(x[0].equals("attack")){
        // attack(x);
        // }
        // move to next encounter
        if (x[0].equals("next")) {
            next();
        }
        if (x[0].equals("fight")) {
            fight(x);
        }
        if (x[0].equals("exit")) {
            System.exit(0);
        }

    }

    public void look(String[] x) {
        if (x.length == 1) {
            for (int i = 0; i < objects.Encounters.get(0).desc.size(); i++) {
                if (objects.Encounters.get(i).number == objects.Player.inEncounter) {
                    // check encounter description
                    for (int j = 0; j < objects.Encounters.get(i).desc.size(); j++) {
                        System.out.println(objects.Encounters.get(i).desc.get(j));
                    }
                    System.out.println("You see exits:");
                    // check for exits
                    for (int k = 0; k < objects.Encounters.get(i).exits.size(); k++) {
                        System.out.println(objects.Encounters.get(i).exits.get(k));
                        String exitNameFull = objects.Encounters.get(i).exits.get(k);
                        String[] exitName = exitNameFull.split(" ");
                        System.out.println(exitName[0]);
                    }
                    // check for monsters
                    for (int l = 0; l < objects.Encounters.get(i).Monsters.size(); l++) {
                        System.out.println(objects.Encounters.get(i).Monsters.get(l).desc);
                    }
                    for (int m = 0; m < objects.Encounters.get(i).Items.size(); m++) {
                        System.out.println(objects.Encounters.get(i).Items.get(m).desc);
                    }
                    // System.out.println(objects.Encounters.get(0).desc.get(i).name);
                }
            }
        }
        if (x.length == 2) {
            if (x[1].equals("self")) {
                objects.Player.look();
                System.out.println("Your inventory contains:");
                for (int i = 0; i < objects.Player.Items.size(); i++) {
                    System.out.println(objects.Player.Items.get(i).name);
                }
            }
        }

        // if (x.length == 1) {
        // System.out.println("You look around.");
        // System.out.println(objects.Encounters.get(0).desc.get(0));
        // System.out.println(objects.Encounters.get(0).desc.get(1));
        // System.out.println(objects.Encounters.get(0).desc.get(2));
        // System.out.println("You see exits:");
        // System.out.println(objects.Encounters.get(0).exits.get(0));
        // System.out.println(objects.Encounters.get(0).exits.get(1));
        // }
        // if (x.length == 2) {
        // if (x[1].equals("exit")) {
        // System.out.println("You look at the exits.");
        // System.out.println("You see exits:");
        // System.out.println(objects.Encounters.get(0).exits.get(0));
        // System.out.println(objects.Encounters.get(0).exits.get(1));
        // }
        // }
    }

    public void grab(String[] x) {

        if (x.length == 1) {
            System.out.println("What do you want to grab?");
        }
        if (x.length == 2) {
            for (int i = 0; i < objects.itemsDB.size(); i++) {

                if (x[1].equals(objects.itemsDB.get(i).name)) {
                    if (objects.Player.species == objects.itemsDB.get(i).speciesOwner) {
                        System.out.println("You grab the " + objects.itemsDB.get(i).name + ".");
                        objects.Player.Items.add(objects.itemsDB.get(i));
                        objects.Encounters.get(0).Items.remove(i);
                        break;

                    } else {
                        System.out.println(
                                "Your Character is the wrong species to use this item. Pick a different item.");
                    }
                }
                // if (x[1].equals("hawk")) {
                // if (objects.Player.species == 3){
                // System.out.println("You grab the hawk.");
                // objects.Player.Items.add(objects.itemsDB.get(3));
                // objects.Encounters.get(0).Items.remove(0);
                // }
                // else {
                // System.out.println("You are not a Feagle.");
                // }
                // }
            }
        }
    }

    public void next() {
        objects.Player.inEncounter++;
    }

    public void newCharacter() {
        System.out.println("Your about to start a quest to find what you need. What is your name?");
        // program breaks if Scanner is closed early, so this does not work well yet.
        Scanner sc = new Scanner(System.in);
        objects.Player.name = sc.nextLine();

        System.out.println("Welcome " + objects.Player.name + ".");
        objects.Player.hp = 10;
        objects.Player.speed = 3;
        objects.Player.attack = 1;
        objects.Player.defense = 1;
        System.out.println("You have " + objects.Player.hp + " hp, and " + objects.Player.speed + " speed.");
        System.out
                .println("You have " + objects.Player.attack + " attack, and " + objects.Player.defense + " defense.");
        System.out.println("Would you like to play as a 1: Wizard, 2: Dwarf, or 3: Feagle?");
        // sc.close();

        // add descriptions of character traits asociated and equiptment options.
        Scanner sc2 = new Scanner(System.in);

        objects.Player.species = sc2.nextInt();
        // need to swap this for an enum equivelant, or make a list of classes.
        System.out.println("You have selected " + objects.Player.species + ".");

        // check species against speciesOwner value in itemsDB to assign item. to
        // character then print the item and check player inventory.
        for (items item : objects.itemsDB) {
            if (item.speciesOwner == objects.Player.species) {
                System.out.println("As a " + objects.Player.species + " you get a " + item.name + ".");
                objects.Player.Items.add(item);
                look(("look self").split(" "));
                objects.Player.attack = objects.Player.attack + item.attack;
                objects.Player.defense = objects.Player.defense + item.defense;
                objects.Player.speed = objects.Player.speed + item.speed;
            }
        }
        // sc2.close();

        // enter encounter 1 select equiptment
        // objects.Player.inEncounter = 1;
        next();
        // look(look);

        // objects.Player.inEncounter = 1;
    }

    // The following method will be used to select equiptment in room 1 unless I
    // dicide to send them to room 1 were equiptment will be waiting. I may need to
    // cut the look command down to make this program in time.
    // not using this method due to time constraints.
    public void selectEquiptment() {
        System.out.println(
                "Now we know who you are lets get you some equiptment: You enter the room and see some stuff. Only some items will work for you.");
        // either enter encounter 1 or pick/give equiptment here depending on timescale.
        for (int i = 0; i < objects.Encounters.get(1).Items.size(); i++) {
            System.out.println(objects.Encounters.get(1).Items.get(i).name);
            System.out.println(objects.Encounters.get(1).Items.get(i).desc);
        }
        System.out.println("What do you want to grab?");
        // encounters(1) = objects.Encounters.get(0);
        Scanner sc = new Scanner(System.in);
        grab(sc.nextLine().split(" "));

    }

    public void fight(String[] x) {
        if (x.length == 1) {
            System.out.println("What do you want to fight?");

            // Scanner sc = new Scanner(System.in);
            // String askMonster = sc.nextLine();
            // for (monsters monster : objects.monstersDB) {
                // if (askMonster == monster.id) {
                     objects.monstersDB.get(1).look();
                    System.out.println("You attack the " + objects.monstersDB.get(1).name + ".");
                    // combat(monster);
                    // add loop to allow player to attack until monster is dead or player is dead.
                    int loopCount = 0;
                    while (objects.Player.hp > 0 && objects.monstersDB.get(1).hp > 0) {

                        if (objects.Player.speed <= objects.monstersDB.get(1).speed) {
                            objects.monstersDB.get(1).hp = objects.monstersDB.get(1).hp - (objects.Player.attack - objects.monstersDB.get(1).defense);
                            objects.Player.hp = objects.Player.hp - (objects.monstersDB.get(1).attack - objects.Player.defense);
                        }
                        System.out.println("You have " + objects.Player.hp + " hp.");
                        System.out.println("The " + objects.monstersDB.get(1).name + " has " + objects.monstersDB.get(1).hp + " hp.");
                        // reduce monster hp
                        if (objects.Player.speed <= objects.monstersDB.get(1).speed) {
                            objects.monstersDB.get(1).hp = objects.monstersDB.get(1).hp - (objects.Player.attack - objects.monstersDB.get(1).defense);
                            if (loopCount % 2 == 0) {
                                objects.Player.hp = objects.Player.hp - (objects.monstersDB.get(1).attack - objects.Player.defense);
                            }
                            System.out.println("You have " + objects.Player.hp + " hp.");
                            System.out.println("The " + objects.monstersDB.get(1).name + " has " + objects.monstersDB.get(1).hp + " hp.");
                        }

                        if (objects.monstersDB.get(1).hp <= 0) {
                            System.out.println("You killed the " + objects.monstersDB.get(1).name + ".");
                            break;
                        }
                        if (objects.Player.hp <= 0) {
                            System.out.println("You died.");
                            System.exit(0);
                        }
                        loopCount++;
                    // }
                // }

                // else {
                //     System.out.println("just type 1 word to fight then follow prompts");
                // }
                // public void combat(String x) {
                // for (monsters monster : objects.monstersDB) {
                // if (x == monster.id) {
                // Object cMonster = monster;
                // }
                // }

            }

            // public monsters returnMonster(String[] x) {
            // if x.length == 1 {
            // for (monsters monster : objects.monstersDB) {
            // if (x == monster.id) {
            // return monster;
            // // Object cMonster = monster;
            // }
            // }
            // }

            //
        }
    }
}