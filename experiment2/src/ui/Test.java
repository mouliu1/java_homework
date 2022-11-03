package ui;

import java.util.Scanner;

public class Test {
    /*public static void main(String[] args) {
        play();
    }

    //游戏入口
    public static void play() {
        Scanner sc = new Scanner(System.in);
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
    }*/
}
