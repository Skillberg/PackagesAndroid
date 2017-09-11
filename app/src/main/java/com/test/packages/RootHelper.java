package com.test.packages;

import android.support.annotation.Nullable;
import android.util.Log;

import java.util.List;

import eu.chainfire.libsuperuser.Shell;

/**
 * Класс, реализующий операции, требующие Root
 */
public class RootHelper {


    /**
     * Выполняет команду и возвращает вывод в виде строки
     *
     * @param command Команда, которую нужно выполнить
     * @return Вывод из stdout
     */
    @Nullable
    private static String executeCommand(String command) {
        List<String> stdout = Shell.SU.run(command);

        if (stdout == null) {
            return null;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (String line : stdout) {
            stringBuilder.append(line).append("\n");
        }

        return stringBuilder.toString();
    }

    /**
     * Пытаемся удалить приложение, используя рут
     *
     * @param packageName Имя пакета приложения, которое нужно удалить
     * @return True если удаление прошло успешно, false — в ином случае
     */
    public static boolean uninstall(String packageName) {
        String output = executeCommand("pm uninstall " + packageName);

        if (output != null && output.contains("success")) {
            return true;
        } else {
            return false;
        }
    }

}
