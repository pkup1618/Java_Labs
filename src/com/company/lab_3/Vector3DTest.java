package com.company.lab_3;


import java.util.Scanner;

class Vector3DTest
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String[] strings = sc.nextLine().split(" ");
        Vector3D a = new Vector3D(
                Integer.parseInt(strings[0]),
                Integer.parseInt(strings[1]),
                Integer.parseInt(strings[2])
        );

        strings = sc.nextLine().split(" ");
        Vector3D b = new Vector3D(
                Integer.parseInt(strings[0]),
                Integer.parseInt(strings[1]),
                Integer.parseInt(strings[2])
        );

        strings = sc.nextLine().split(" ");
        Vector3D c = new Vector3D(
                Integer.parseInt(strings[0]),
                Integer.parseInt(strings[1]),
                Integer.parseInt(strings[2])
        );

        Segment segment = new Segment(a, b);

        System.out.println(segment.len());
        System.out.println(segment.distanceTo(c));

    }

}