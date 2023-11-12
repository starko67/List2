package Spisok2;
// Класс, представляющий элемент списка
class Node {
    String data; // Данные элемента (строка)
    Node prev;   // Ссылка на предыдущий элемент
    Node next;   // Ссылка на следующий элемент

    // Конструктор для создания элемента списка с заданными данными
    Node(String data) {
        this.data = new String(data); // Создаем копию строки в динамической памяти
        this.prev = null;              // Изначально предыдущий элемент не указан
        this.next = null;              // Изначально следующий элемент не указан
    }
}

// Класс, представляющий двусвязный список
class DoublyLinkedList {
    Node head; // Начало списка
    Node tail; // Конец списка

    // Конструктор для создания пустого списка
    DoublyLinkedList() {
        head = null;
        tail = null;
    }

    // Функция добавления элемента в конец списка
    void addNode(String data) {
        Node newNode = new Node(data); // Создаем новый элемент списка
        if (head == null) {
            // Если список пуст, новый элемент становится началом и концом списка
            head = newNode;
            tail = newNode;
        } else {
            // Иначе добавляем новый элемент в конец списка
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        sortList(); // Упорядочиваем список после вставки
    }

    // Функция сортировки списка по возрастанию
    void sortList() {
        if (head == null) {
            return;
        }

        Node current = head;

        // Проходим по списку
        while (current.next != null) {
            // Если текущая строка больше следующей, меняем их местами
            if (current.data.compareTo(current.next.data) > 0) {
                String temp = current.data;
                current.data = current.next.data;
                current.next.data = temp;
            }

            current = current.next; // Переходим к следующему элементу
        }
    }

    // Функция вывода списка на экран
    void displayList() {
        Node current = head;
        // Проходим по списку и выводим данные каждого элемента
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// Главный класс приложения
public class DoublyLinkedListInsert {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList(); // Создаем новый список

        // Добавляем строки в список
        list.addNode("Apple");
        list.addNode("Orange");
        list.addNode("Banana");

        System.out.println("Исходный список:");
        list.displayList(); // Выводим исходный список на экран
    }
}