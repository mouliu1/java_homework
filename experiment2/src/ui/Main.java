package ui;

import java.util.Scanner;

/**
 * @author 86134
 */
public class Main {
    public int playerBlood = 30;
    public int[][] entourage = new int[7][2];
    public int countSu = 0;
    public Main() {
    }

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        play();
    }

    /**
     *召唤随从
     */
    public void summon() {
        int pos = sc.nextInt();
        int att = sc.nextInt();
        int health = sc.nextInt();
        int index = pos - 1;
        /*
         生命值不为0即当前位置已经被占用
         */
        if (entourage[index][1] != 0) {
            move(index, 1);
            give(att, health, index);
        } else {
            give(att, health, index);
        }
        countSu++;
    }

    /**
     *给随从赋值
     */
    private void give(int att, int health, int index) {
        entourage[index][0] = att;
        entourage[index][1] = health;
    }

    /**
     *移动随从位置
     */
    public void move(int index, int flag) {
        int f1 = 6;
        int f2 = 2;
        //flag为1向右移动   flag为2向左移动
        if (flag == 1) {
            //向右移动
            for (int i = f1; i > index; i--) {
                entourage[i][0] = entourage[i - 1][0];
                entourage[i][1] = entourage[i - 1][1];
            }
        } else if (flag == f2) {
            //向左移动
            for (int i = index; i < f1; i++) {
                entourage[i][0] = entourage[i + 1][0];
                entourage[i][1] = entourage[i + 1][1];
            }
        }
    }

    /**
     *攻击
     */
    public void attack(Main p2) {
        int attacker = sc.nextInt();
        int defender = sc.nextInt();
        //判断攻击的是英雄还是随从
        if (defender == 0) {
            p2.playerBlood -= this.entourage[attacker - 1][0];
            return;
        } else {
            this.entourage[attacker - 1][1] -= p2.entourage[defender - 1][0];
            p2.entourage[defender - 1][1] -= this.entourage[attacker - 1][0];
        }
        //如果随从死亡，进行移位操作
        if (this.entourage[attacker - 1][1] <= 0) {
            move(attacker - 1, 2);
            this.countSu--;
        }
        if (p2.entourage[defender - 1][1] <= 0) {
            p2.move(defender - 1, 2);
            p2.countSu--;
        }
    }

    /**
     *游戏入口
     */
    public static void play() {
        Main player1 = new Main();
        Main player2 = new Main();

        int n = sc.nextInt();
        //设置变量turn切换回合
        int turn = 1;
        for (int i = 0; i < n; i++) {
            String option = sc.next();
            switch (option) {
                case "summon":
                    if (turn % 2 == 1) {
                        player1.summon();
                    } else {
                        player2.summon();
                    }
                    break;
                case "attack":
                    if (turn % 2 == 1) {
                        player1.attack(player2);
                    } else {
                        player2.attack(player1);
                    }
                    break;
                case "end":
                    turn++;
                    break;
                default:
                    break;
            }
        }
        int res = result(player1, player2);
        System.out.println(res);
        System.out.println(player1.playerBlood);
        System.out.print(player1.countSu);
        for (int i = 0; i < player1.countSu; i++) {
            System.out.print(" "+player1.entourage[i][1]);
        }
        System.out.println();
        System.out.println(player2.playerBlood);
        System.out.print(player2.countSu);
        for (int i = 0; i < player2.countSu; i++) {
            System.out.print(" "+player2.entourage[i][1]);
        }

    }

    /**
     *获取游戏结果
     */
    private static int result(Main p1, Main p2) {
        int flag;
        if (p1.playerBlood > 0 && p2.playerBlood > 0) {
            flag = 0;
        } else if (p1.playerBlood <= 0) {
            flag = -1;
        } else {
            flag = 1;
        }
        return flag;
    }
}
