/*Необходимо написать программу, которая будет записывать текстовые данные, введенные с экрана, в файл .txt.
Запись ввести в файл до тех пор, пока не будет введена команда стоп в консоли.
Пользователь при тестировании программы по правилу черного ящика должен понимать, какой принцип остановки записи в файл он должен подать.*/

import java.io.*;
import java.util.Scanner;

public class Task_17 {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String your_text;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите текст для записи в файл.\nЧтобы остановить ввод, введите слово 'стоп' ");

        try (FileWriter writer = new FileWriter("D://text_file.txt"))
        {
            do {
                System.out.print("Ваш текст: ");
                your_text = reader.readLine();

                if (your_text.compareTo("стоп") == 0) break;

                your_text = your_text + "\r\n";
                writer.write(your_text);
            } while (your_text.compareTo("стоп") != 0);
        } catch (IOException exc) {
            System.out.println("Произошла ошибка: " + exc);
        }
    }
}