package io.ib67.util;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static final String[] MINECRAFT_LEGACY = new String[]{
            "&1", "&2", "&3", "&4", "&5", "&6", "&7", "&8", "&9", "&a", "&b", "&c", "&d", "&e", "&f", "&m", "&n", "&l","&r"
    };

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println(messUp(scanner.nextLine()));
        }
    }

    private static String randomColor() {
        return MINECRAFT_LEGACY[ThreadLocalRandom.current().nextInt(MINECRAFT_LEGACY.length)];
    }

    private static String messUp(String str) {
        var arr = str.toCharArray();
        var sb = new StringBuilder();
        var random = ThreadLocalRandom.current();
        var currentColor = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '\\' && arr.length > i + 1 && arr[i + 1] == 'n') {
                i = i + 2;
                System.out.println(arr[i]);
                sb.append("\n");
                continue;
            }

            if (random.nextInt() > 70) {
                currentColor = randomColor();
            }
            if (random.nextInt() > 40) {
                sb.append(currentColor);
            }
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}