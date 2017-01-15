package rpg;

import color.colour;
import java.util.InputMismatchException;
import java.util.Scanner;
//import javax.swing.JOptionPane;
import model.EvilBox;
import model.RpgHero;
//import org.fusesource.jansi.AnsiConsole;
import util.FileUtil;
import util.RpgUtil;

public class Kejahatan {

    private static RpgHero hero;

    public static void main(String[] args) throws InterruptedException {
        //AnsiConsole.systemInstall();
        int choose = 0;
        Scanner entry = new Scanner(System.in);
        RpgUtil.clearScreen();
        System.out.println(colour.ANSI_BLUE +"                                      ");
        System.out.println(colour.ANSI_BLUE +"      *                  *       *    ");
        System.out.println(colour.ANSI_BLUE +"     * *                 *       *    ");
        System.out.println(colour.ANSI_BLUE +"    *   *                *       *    ");
        System.out.println(colour.ANSI_BLUE +"   * * * *     * * * *   * * * * *    ");
        System.out.println(colour.ANSI_BLUE +"  *       *    *     *   *       *    ");
        System.out.println(colour.ANSI_BLUE +" *         *   *     *   *       *    ");
        System.out.println(colour.ANSI_BLUE +"*           *  *     *   *       *    ");
        System.out.println(colour.ANSI_BLUE +"                                       ");
        int ulang = 1;
        do {
            System.out.println(colour.ANSI_BG_BLUE + colour.ANSI_WHITE + "============================|");
            System.out.println(colour.ANSI_BG_BLUE + colour.ANSI_WHITE + "|  Kejahatan dimalam hari   |");
            System.out.println(colour.ANSI_BG_BLUE + colour.ANSI_WHITE + "|---------------------------|");
            System.out.println(colour.ANSI_BG_BLUE + colour.ANSI_WHITE + "|  1. Mulai                 |");
            System.out.println(colour.ANSI_BG_BLUE + colour.ANSI_WHITE + "|  2. Load Game             |");
            System.out.println(colour.ANSI_BG_BLUE + colour.ANSI_WHITE + "|  3. About                 |");
            System.out.println(colour.ANSI_BG_BLUE + colour.ANSI_WHITE + "|  4. Kabur                 |");
            System.out.println(colour.ANSI_BG_BLUE + colour.ANSI_WHITE + "|___________________________|");
            do {
                Scanner n = new Scanner(System.in);
                try {

                    System.out.print(colour.ANSI_BG_WHITE + colour.ANSI_BLUE + "^_^ Silakan dipilih: ");
                    choose = n.nextInt();
                    if (choose < 1 || choose > 4) {
                        throw new IllegalArgumentException(colour.ANSI_BG_RED + colour.ANSI_WHITE + "Input 1-4");
                    }

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getLocalizedMessage());
                } catch (InputMismatchException e) {
                    System.out.println(colour.ANSI_BG_RED + colour.ANSI_WHITE + "Pilih yang benar ya [1]-[4]");
                }
            } while (choose != 1 && choose != 2 && choose != 3 && choose != 4);
            if (choose == 1) {
                System.out.print(colour.ANSI_BG_WHITE + colour.ANSI_BLUE + "^_^ Siapa anda? : ");
                String name = entry.next();
                RpgUtil.clearScreen();
                int day = 0;
                hero = new RpgHero(name, 0.0, 500, day);

                // go to main screen & start play the game            
                playgame();
            } else if (choose == 2) { // load game
                FileUtil futil = new FileUtil();
                String s1 = futil.openReadFile("rpg.txt");
                System.out.println(s1);
                String name = "";
                double exps = 0;
                int gold = 500;
                int day = 0;

                while (futil.getReadScanner().hasNext()) {
                    // read line per line, split line by comma delimiter
                    String[] readLine = futil.getReadScanner().next().split(",");

                    // printout per line
                    name = readLine[0];
                    exps = Double.parseDouble(readLine[1]);
                    gold = Integer.parseInt(readLine[2]);
                    day = Integer.parseInt(readLine[3]);
                    System.out.println("Reading...");
                }
                // close opening read file
                String s3 = futil.closeReadFile();
                System.out.println(s3);
                System.out.println("Game loaded . . .\n");
                // create object hero, load name & experience
                hero = new RpgHero(name, exps, gold, day);
                // go to main screen & start play the game
                playgame();
            } else if (choose == 3) {
                System.out.println("");
                about();
            } else if (choose == 4) {
                System.out.println("byee");
                System.exit(0);
            }
        } while (ulang == 1);
    }

    private static void playgame() {
        RpgUtil.clearScreen();
        Scanner entry = new Scanner(System.in);
        int menu = 0;
        hero.printHeroStatus();
        System.out.println(colour.ANSI_BG_BLUE + colour.ANSI_WHITE + "|==========================|");
        System.out.println(colour.ANSI_BG_BLUE + colour.ANSI_WHITE + "|   Pilih Menu             |");
        System.out.println(colour.ANSI_BG_BLUE + colour.ANSI_WHITE + "|=========================+|");
        System.out.println(colour.ANSI_BG_BLUE + colour.ANSI_WHITE + "|  1. Keluar di malam hari |");
        System.out.println(colour.ANSI_BG_BLUE + colour.ANSI_WHITE + "|  2. Tidur                |");
        System.out.println(colour.ANSI_BG_BLUE + colour.ANSI_WHITE + "|  3. Toko                 |");
        System.out.println(colour.ANSI_BG_BLUE + colour.ANSI_WHITE + "|  4. Simpan Game          |");
        System.out.println(colour.ANSI_BG_BLUE + colour.ANSI_WHITE + "|  5. Keluar               |");
        System.out.println(colour.ANSI_BG_BLUE + colour.ANSI_WHITE + "|==========================|");
        while (menu != 1 && menu != 2 && menu != 3 && menu != 4 && menu != 5) {
            try {
                Scanner n = new Scanner(System.in);
                System.out.print(colour.ANSI_BG_WHITE + colour.ANSI_BLUE + "^_^  Silakan dipilih: ");
                menu = n.nextInt();
                if (menu < 1 || menu > 5) {
                    throw new IllegalArgumentException(colour.ANSI_BG_RED + colour.ANSI_WHITE + " Input 1-5");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getLocalizedMessage());
            } catch (InputMismatchException e) {
                System.out.println(colour.ANSI_BG_RED + colour.ANSI_WHITE + "Pilih yang benar ya [1]-[5]");
            }
        }
        if (menu == 1) {
            battle();
        } else if (menu == 2) {
            rest();
        } else if (menu == 3) {
            shop();
        } else if (menu == 4) {
            savegame();
        } else if (menu == 5) {
            System.out.println("Kembali ke main menu");
        }
    }

    private static void battle() {
        RpgUtil.clearScreen();
        Scanner entry = new Scanner(System.in);
        hero.printHeroStatus();
        System.out.println(colour.ANSI_BG_YELLOW + colour.ANSI_BLACK + "???????????????????????????????");
        System.out.println(colour.ANSI_BG_YELLOW + colour.ANSI_BLACK + "?    Anda ketemu musuh :      ?");
        System.out.println(colour.ANSI_BG_YELLOW + colour.ANSI_BLACK + "???????????????????????????????");
        System.out.println(colour.ANSI_BG_YELLOW + colour.ANSI_BLACK + "?   1. Maling Lv 1-5          ?");
        System.out.println(colour.ANSI_BG_YELLOW + colour.ANSI_BLACK + "?   2. Psikopat Lv 5-10       ?");
        System.out.println(colour.ANSI_BG_YELLOW + colour.ANSI_BLACK + "?   3. Tukang Begal Lv 10-20  ?");
        System.out.println(colour.ANSI_BG_YELLOW + colour.ANSI_BLACK + "?   4. Teroris Lv 20-30       ?");
        System.out.println(colour.ANSI_BG_YELLOW + colour.ANSI_BLACK + "?   5. Kabur dulu             ?");
        System.out.println(colour.ANSI_BG_YELLOW + colour.ANSI_BLACK + "???????????????????????????????");
        String a = "";
        int min = 0;
        int max = 0;
        int questOption = 0;
        while (questOption != 1 && questOption != 2 && questOption != 3 && questOption != 4 && questOption != 5) {
            try {
                Scanner n = new Scanner(System.in);
                System.out.print(colour.ANSI_BG_WHITE + colour.ANSI_YELLOW + ">>>Pilih Lawan : ");
                questOption = n.nextInt();
                if (questOption < 1 || questOption > 5) {
                    throw new IllegalArgumentException(colour.ANSI_BG_RED + colour.ANSI_WHITE + " Input 1-5");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getLocalizedMessage());
            } catch (InputMismatchException e) {
                System.out.println(colour.ANSI_BG_RED + colour.ANSI_WHITE + "Pilih yang benar ya [1]-[5]");
            }
        }
        if (questOption == 1) {
            a = "Maling";
            min = 200;
            max = 600;
        } else if (questOption == 2) {
            a = "Psikopat";
            min = 700;
            max = 1100;
        } else if (questOption == 3) {
            a = "Tukang Begal";
            min = 1200;
            max = 2200;
        } else if (questOption == 4) {
            a = "Teroris";
            min = 2300;
            max = 3500;
        } else if (questOption == 5) {
            playgame();
        } else {
            System.out.print(colour.ANSI_BG_RED + colour.ANSI_WHITE + "Tolong yang benar ya [1-5] :");
        }
        EvilBox evil = new EvilBox(a, RpgUtil.randDouble(min, max));
        boolean endBattle = false;
        evil.printEvilStatus();
        int menu = 0;
        while (endBattle == false) {
            System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + ">>>>>>>><<<<<<<<");
            System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + ">>>> BATTLE <<<<");;
            System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + ">>>>>>>><<<<<<<<");
            System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + "     1. Hit     ");
            System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + "    2. Magic    ");
            System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + "    3. Kabur    ");
            while (menu != 1 && menu != 2 && menu != 3) {
                try {
                    Scanner n = new Scanner(System.in);
                    System.out.print(colour.ANSI_BG_WHITE + colour.ANSI_RED + "   Aksi anda?   ");
                    menu = n.nextInt();
                    if (menu < 1 || menu > 3) {
                        throw new IllegalArgumentException(colour.ANSI_BG_RED + colour.ANSI_WHITE + " Input 1-3");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getLocalizedMessage());
                } catch (InputMismatchException e) {
                    System.out.println(colour.ANSI_BG_RED + colour.ANSI_WHITE + "Pilih yang benar ya [1]-[3]");
                }
            }

            if (menu == 1) {
                evil.hitToEvil(a, hero.getAttack());
                if (evil.getHp() <= 0) {
                    System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_BLUE + "Win......!!!!");
                    hero.addGold(RpgUtil.randInt(min, max / 2));
                    hero.addExperience(RpgUtil.randDouble(min, max / 2));
                    hero.addDay();
                    playgame();
                    endBattle = true;
                }
                hero.hitToHero(evil.getAttack());
                if (hero.getHp() <= 0) {
                    System.out.println(colour.ANSI_BG_RED + colour.ANSI_WHITE + "Game Over!!!");
                    endBattle = true;
                }
            } else if (menu == 2) {
                System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_PURPLE + " 1.Heal 25% (cost: 25%mp)");
                System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_PURPLE + "        Akan datang      ");
                System.out.print(colour.ANSI_BG_WHITE + colour.ANSI_PURPLE + "     Aksi Magic Anda :   ");
                int skill = entry.nextInt();
                if (skill == 1) {
                    //validitas skill 1
                    Double m = new Double(hero.getHp() / 4);
                    int mana = m.intValue();
                    if (hero.getMp() >= mana) {
                        hero.minMp(hero.getMp() / 4);
                        hero.addHp(mana);
                        hero.printHeroStatus();
                    } else if (hero.getMp() < mana) {
                        System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + "Kurang MANA!!");
                    } else if (hero.getHp() == (hero.getLevel() * 100)) {
                        System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + "Darah anda masih banyak");
                    }
                }
            } else if (menu == 3) {
                hero.addDay();
                System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_GREEN + "Kaboooor...!");
                endBattle = true;
                playgame();
            }
        }
    }

    private static void rest() {
        hero.addDay();
        hero.rest();
        playgame();
    }

    private static void shop() {
        hero.printHeroStatus();
        Scanner entry = new Scanner(System.in);
        System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + "|===================================================================================================|");
        System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + "|                                Toko untuk melawan Boss   !!!                                      |");
        System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + "|===================================================================================================|");
        System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + "| 1. Pertarungan terakhir Boss for 50.000 Gold (PS: Boss tahan magic dan tak bisa kabur dari boss ) |");
        System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + "| 2. Kembali ke rumah                                                                               |");
        System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + "|===================================================================================================|");
        System.out.print(colour.ANSI_BG_WHITE + colour.ANSI_RED + "| Silakan Dibeli : ");
        int shop = entry.nextInt();
        if (hero.getGold() >= 500000) {
            hero.newGold(hero.getGold());
            System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_YELLOW + "Current Gold : " + hero.getGold());
            if (shop == 1) {
                EvilBox boss = new EvilBox(hero.getExperience());
                boolean endBattle = false;
                boss.printEvilStatus();
                String a = "";
                while (endBattle == false) {
                    System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + ">>>>>>>><<<<<<<<");
                    System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + ">>>> BATTLE <<<<");;
                    System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + ">>>>>>>><<<<<<<<");
                    System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + "     1. Hit     ");
                    System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + "     2. Kabur   ");
                    System.out.print(colour.ANSI_BG_WHITE + colour.ANSI_RED + " Aksi anda? ");
                    int n = entry.nextInt();
                    if (n == 1) {
                        boss.hitToEvil(a, hero.getAttack());
                        if (boss.getHp() <= 0) {
                            hero.addDay();
                            endBattle = true;
                            System.out.println(colour.ANSI_BG_BLUE + colour.ANSI_WHITE + "Selamat anda menang dari yang impossible");
                        }
                        hero.hitToHero(boss.getAttack());
                        if (hero.getHp() <= 0) {
                            System.out.println(colour.ANSI_BG_RED + colour.ANSI_WHITE + "Game Over!!!");
                            endBattle = true;
                        }
                    } else if (n == 2) {
                        System.out.println(colour.ANSI_BG_PURPLE + colour.ANSI_WHITE + "Tak dapat lari dari Boss");
                        endBattle = true;
                    }
                }

            }
        } else if (hero.getGold() < 500) {
            System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_YELLOW + "Simpan Duit Dulu la");
            playgame();
        } else if (shop == 2) {
            playgame();
        }

    }

    private static void about() {
        System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + "|==========================================|");
        System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + "|                 About US                 |");
        System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + "|==========================================|");
        System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + "|   Henry (26411) : Founder of Microsoft   |");
        System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + "|   Albert (22803) : Founder of Samsung    |");
        System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_RED + "|==========================================|");
        System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_GREEN + "            Asal mula ide RPG !              ");
        System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_GREEN + "Suatu hari si albert dan si henry sedang berjalan dari lippo mall menuju aryaduta ,    ");
        System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_GREEN + "ditengah perjalanan si albert melihat seorang bocah cilik sedang bermain game pokemon ,");
        System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_GREEN + "dan dari situlah , albert dan henry memiliki visi untuk membangun sebuah perusahaan    ");
        System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_GREEN + "Role Playing Games ( RPG ) , dan mereka memulai langkah mereka dengan membuat game dari");
        System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_GREEN + "java netbeans yang mereka beri nama 'A&H First Project'.                               ");
    }

    private static void savegame() {
        FileUtil futil = new FileUtil();

        // open existing file
        String s1 = futil.openWriteFile("rpg.txt");
        System.out.println(s1);

        // define text formatting
        String txtFormat = "%s,%f,%d,%d";

        // add record 1
        String heroname = hero.getName();
        double exps = hero.getExperience();
        int gold = hero.getGold();
        int day = hero.getDay();
        String s2 = futil.addWriteRecord(txtFormat, heroname, exps, gold, day);
        System.out.println(s2);
        // close opening file
        String s4 = futil.closeWriteFile();
        System.out.println(s4);
        System.out.println(colour.ANSI_BG_WHITE + colour.ANSI_GREEN + "Game save!");
    }

}
