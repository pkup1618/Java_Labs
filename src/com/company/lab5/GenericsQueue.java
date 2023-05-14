package com.company.lab5;

public class GenericsQueue<T>
{
    private ObjectBox head = null;
    private ObjectBox tail = null;
    private int size = 0;

    public void push(T obj)
    {
        ObjectBox ob = new ObjectBox();
        ob.setObject(obj);

        if (head == null)
        {
            head = ob;
        }
        else
        {
            tail.setNext(ob);
        }

        tail = ob;
        size++;
    }

    public T pull()
    {
        if (size == 0)
        {
            return null;
        }

        T obj = head.getObject();
        head = head.getNext();

        if (head == null)
        {
            tail = null;
        }

        size--;

        return obj;
    }

    public T get(int index)
    {
        if(size == 0 || index >= size || index < 0)
        {
            return null;
        }

        ObjectBox current = head;
        int pos = 0;

        while(pos < index)
        {
            current = current.getNext();
            pos++;
        }

        return current.getObject();
    }

    public int size()
    {
        return size;
    }

    private class ObjectBox
    {
        private T object;
        private ObjectBox next;

        public T getObject()
        {
            return object;
        }

        public void setObject(T object)
        {
            this.object = object;
        }

        public ObjectBox getNext()
        {
            return next;
        }

        public void setNext(ObjectBox next)
        {
            this.next = next;
        }
    }
}