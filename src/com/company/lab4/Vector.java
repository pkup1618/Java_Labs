package com.company.lab4;

import java.util.Arrays;

class Vector
{
    double[] components;

    /**
     * Конструктор, по массиву координат
     * @param components координаты
     */
    public Vector(double[] components)
    {
        this.components = components.clone();
    }

    /**
     * Конструктор, позволяющий обрезать вектор, либо расширить его нулевыми координатами
     * @param v обрезаемый или расширяемый вектор
     * @param dim размерность
     */
    public Vector(Vector v, int dim)
    {
        int lessDim = Math.min(dim, v.dimension());
        double[] result = new double[dim];

        for (int i = 0; i < lessDim; i++)
        {
            result[i] = v.components[i];
        }
        // Либо всё добавили, либо что-то осталось

        for (int i = lessDim; i < dim; i++)
        {
            result[i] = 0;
        }
        // Остальное доставили нулями

        components = result;
    }

    /**
     * Пустой конструктор (неизвестна даже размерность после создания)
     */
    public Vector() {

    }

    /**
     * Получить размерность вектора
     * @return размерность
     */
    public int dimension()
    {
        return components.length;
    }

    /**
     * Получить i-ю координату
     * @param i - номер
     * @return i-я координата
     */
    public double getComponent(int i)
    {
        return components[i];
    }

    /**
     * Метод вывода вектора на экран
     */
    public void printVector()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Вектор, размерности ").append(dimension()).append(" ");
        stringBuilder.append("[ ");
        for (double component : components)
        {
            stringBuilder.append(component).append(" ");
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    /**
     * Скалярное произведение вектора на вектор v <br>
     * (перемножаются координаты до наименьшей из размерностей векторов)
     * @param v - вектор, на который умножаем скалярно
     * @return - скалярное произведение
     */
    public double scalar(Vector v)
    {
        double result = 0;
        int minDimension = Math.min(v.dimension(), this.dimension());

        for (int i = 0; i < minDimension; i++)
        {
            result += (v.getComponent(i) * this.getComponent(i));
        }

        return result;
    }

    /**
     * Получить длину вектора
     * @return длина вектора
     */
    public double len()
    {
        return Math.sqrt(this.scalar(this));
    }

    /**
     * Умножение вектора на скаляр
     * @param factor скаляр
     * @return вектор, умноженный на скаляр
     */
    public Vector multiply(double factor)
    {
        double[] result = new double[this.dimension()];

        for (int i = 0; i < this.dimension(); i++)
        {
            result[i] = components[i] * factor;
        }

        return new Vector(result);
    }

    /**
     * Сумма векторов (вектор суммы будет минимальной из размерностей слагаемых векторов)
     * @param v вектор, который прибавляем к нашему вектору
     * @return сумма векторов
     */
    public Vector add(Vector v)
    {
        int minDim = Math.min(this.dimension(), v.dimension());
        double[] result = new double[minDim];

        for (int i = 0; i < minDim ; i++)
        {
            result[i] = this.components[i] + v.components[i];
        }

        return new Vector(result);
    }

    public Vector normalise()
    {
        return this.multiply(1/this.len());
    }

    /**
     * Разность векторов (вектор разности будет минимальной из размерностей оперируемых векторов)
     * @param v вектор, который вычитаем из нашего вектора
     * @return разность векторов
     */
    public Vector sub(Vector v)
    {
        int minDim = Math.min(this.dimension(), v.dimension());
        double[] result = new double[minDim];

        for (int i = 0; i < Math.min(this.dimension(), v.dimension()); i++)
        {
            result[i] = this.components[i] - v.components[i];
        }

        return new Vector(result);
    }

    /**
     * Проекция вектора на вектор v
     * @param v вектор
     * @return проекция
     */
    public double pr(Vector v)
    {
        return this.scalar(v) / v.len();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Vector vector = (Vector) o;

        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode()
    {
        return Arrays.hashCode(components);
    }
}