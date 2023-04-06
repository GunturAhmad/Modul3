package Modul3;

public class MainQueue {
    private static class Queue {
        private String[] elements;
        private int front, rear, size;

        public Queue() {
            elements = new String[16];
            front = 0;
            rear = -1;
            size = 0;
        }

        public void add(String element) {
            if (size == elements.length)
                throw new IllegalStateException("Queue is full");

            rear = (rear + 1) % elements.length;
            elements[rear] = element;
            size++;
        }

        public String remove() {
            if (size == 0)
                throw new IllegalStateException("Queue is empty");

            String removedElement = elements[front];
            elements[front] = null;
            front = (front + 1) % elements.length;
            size--;
            return removedElement;
        }

        public String element() {
            if (size == 0)
                throw new IllegalStateException("Queue is empty");

            return elements[front];
        }

        public String poll() {
            if (size == 0)
                return null;

            String removedElement = elements[front];
            elements[front] = null;
            front = (front + 1) % elements.length;
            size--;
            return removedElement;
        }

        public String peek() {
            if (size == 0)
                return null;

            return elements[front];
        }
    }

    public void queueExample() {
        Queue queue = new Queue();
        queue.add("Java");
        queue.add("DotNet");
        queue.add("PHP");
        queue.add("HTML");
        System.out.println("remove: " + queue.remove());
        System.out.println("element: " + queue.element());
        System.out.println("poll: " + queue.poll());
        System.out.println("peek: " + queue.peek());
    }

    public static void main(String[] args) {
        new MainQueue().queueExample();
    }
}
