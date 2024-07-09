package com.company.lab5;

import java.io.*;

public class ReadAFile
{
    public static void main(String[] args)
    {
        GenericsQueue<String> queue = new GenericsQueue<>();

        try
        {
            File myFile = new File("in.txt");
            FileReader fileReader = new FileReader(myFile);

            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;

            while ((line = reader.readLine()) != null)
            {
                queue.push(line);
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt"));

            String current;

            while(queue.size() > 0)
            {
                current = queue.pull();

                String allNumbers = current.replaceAll("[^0-9]", "");
                String allWithoutNumbers = current.replaceAll("[0-9]", "");

                writer.write(allWithoutNumbers + allNumbers);
                writer.newLine();
            }
            writer.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
