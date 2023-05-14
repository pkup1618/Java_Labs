package com.company.lab4;

public class Main {

    public static void main(String[] args)
    {
        Vector2D vector2D = new Vector2D(1,2);
        vector2D.printVector();
    }

    public static Vector2D task1(Vector2D P, Vector2D n, Vector2D S)
    {
        Vector normalisedN = n.normalise();

        double prLen = P.sub(S).pr(normalisedN);
        Vector simPoint = S.add(normalisedN.multiply(prLen * 2));

        return new Vector2D(simPoint.getComponent(0), simPoint.getComponent(1));
    }

    public static Vector2D task2(Vector2D P, Vector2D n, Vector2D A, Vector2D B)
    {
        Vector normalisedN = n.normalise();

        double prLen = P.sub(A).pr(normalisedN);
        Vector pr = normalisedN.multiply(prLen);

        Vector A1 = A.add(normalisedN.multiply(prLen * 2));
        Vector BA1 = B.sub(A1);

        double scalar = (prLen * prLen) / pr.multiply(-1).scalar(BA1);

        Vector A1X = BA1.multiply(scalar);
        Vector answer = A1.add(A1X);

        return new Vector2D(answer.getComponent(0), answer.getComponent(1));


    }

}
