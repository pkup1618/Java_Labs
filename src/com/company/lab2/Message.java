package com.company.lab2;

class Message
{
    String str;

    public Message()
    {
        // Ничего не нужно писать для инициализации пустой строки
    }

    public Message(String str)
    {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Класс Message с сообщением '" + str + "'";
    }

    //todo почему StringBuilder лучше?
    public String reverse()
    {
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();

        for(int i = (length - 1); i >= 0; i--)
        {
            stringBuilder.append(str.charAt(i));
        }

        return stringBuilder.toString();
    }

    public int countWords()
    {

        return str.split(" ").length;
    }

    public int count(char ch)
    {
        int index = str.indexOf(ch);
        int count = 0;

        while (index != -1) {
            count++;
            index = str.indexOf(ch, index + 1);
        }

        return count;
    }

    //todo потренироваться писать регулярные выражения
    //todo найти что-нибудь, чтобы легко их генерировать
    public String number()
    {
        int index = str.indexOf("№");

        if (index == -1) {
            return "В строке нет номера";
        }

        return str.substring(index).replaceAll("[^0-9]", "");

    }

    //todo посмотреть самые новые методы обработки строк
    public String replaceSubstring(String sold, String snew)
    {
        StringBuilder stringBuilder = new StringBuilder();

        int iOld = 0;
        int iNew = str.indexOf(sold);

        while (iNew != -1) {
            stringBuilder.append(str, iOld, iNew);
            stringBuilder.append(snew);

            iOld = iNew + sold.length();
            iNew = str.indexOf(sold, iOld);
        }

        stringBuilder.append(str, iOld, str.length());

        return stringBuilder.toString();
    }
}
