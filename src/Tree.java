import java.util.Stack;

public class Tree {
    private Node rootNode;

    public Tree() {
        rootNode = null;
    }

    public Node getNodeByValue(int value) {
        Node currentNode = rootNode;
        while (currentNode.getValue() != value){
            if(value < currentNode.getValue()) {
                currentNode = currentNode.getLeftChild();
            }
            else {
                currentNode = currentNode.getRightChild();
            }
            if (currentNode == null)
                return null;
        }
        return currentNode;
    }

    public void insertNode(int value) {
        Node newNode = new Node(value);

        if (rootNode == null)
            rootNode = newNode;
        else {
            Node currentNode = rootNode;
            Node parentNode;

            while(true) {
                parentNode = currentNode;
                if(value == currentNode.getValue())
                    return;
                else if (value < currentNode.getValue()) {
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null){
                        parentNode.setLeftChild(newNode);
                        return;
                    }
                }
                else {
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null){
                        parentNode.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    public boolean deleteNode(int value) {
        Node currentNode = rootNode;
        Node parentNode = rootNode;
        boolean isLeftChild = true;

        while(currentNode.getValue() != value) {
            parentNode = currentNode;
            if (value < currentNode.getValue()) {
                isLeftChild = true;
                currentNode = currentNode.getLeftChild();
            }
            else {
                isLeftChild = false;
                currentNode = currentNode.getRightChild();
            }
            if (currentNode == null)
                return false; //node not found
        }

        if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
            if (currentNode == rootNode)
                rootNode = null;
            else if (isLeftChild)
                parentNode.setLeftChild(null);
            else
                parentNode.setRightChild(null);
        } else if (currentNode.getRightChild() == null) {
            if (currentNode == rootNode)
                rootNode = currentNode.getLeftChild();
            else if (isLeftChild)
                parentNode.setLeftChild(currentNode.getLeftChild());
            else
                parentNode.setRightChild(currentNode.getLeftChild());
        } else if (currentNode.getLeftChild() == null) {
            if (currentNode == rootNode)
                rootNode = currentNode.getLeftChild();
            else if (isLeftChild)
                parentNode.setLeftChild(currentNode.getRightChild());
            else
                parentNode.setRightChild(currentNode.getRightChild());
        } else {
            Node heir = getHeir(currentNode);
            if (currentNode == rootNode)
                rootNode = heir;
            else if (isLeftChild)
                parentNode.setLeftChild(heir);
            else
                parentNode.setRightChild(heir);
        }
        return true;
    }

    private Node getHeir(Node node) {
        Node parentNode = node;
        Node heirNode = node;
        Node currentNode = node.getRightChild(); // ѕереход к правому потомку
        while (currentNode != null) // ѕока остаютс€ левые потомки
        {
            parentNode = heirNode;// потомка задаЄм как текущий узел
            heirNode = currentNode;
            currentNode = currentNode.getLeftChild(); // переход к левому потомку
        }
        // ≈сли преемник не €вл€етс€
        if (heirNode != node.getRightChild()) // правым потомком,
        { // создать св€зи между узлами
            parentNode.setLeftChild(heirNode.getRightChild());
            heirNode.setRightChild(node.getRightChild());
        }
        return heirNode;// возвращаем приемника
    }

    public void printTree() { // метод дл€ вывода дерева в консоль
        Stack globalStack = new Stack(); // общий стек дл€ значений дерева
        globalStack.push(rootNode);
        int gaps = 32; // начальное значение рассто€ни€ между элементами
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);// черта дл€ указани€ начала нового дерева
        while (isRowEmpty == false) {
            Stack localStack = new Stack(); // локальный стек дл€ задани€ потомков элемента
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) { // покуда в общем стеке есть элементы
                Node temp = (Node) globalStack.pop(); // берем следующий, при этом удал€€ его из стека
                if (temp != null) {
                    System.out.print(temp.getValue()); // выводим его значение в консоли
                    localStack.push(temp.getLeftChild()); // соохран€ем в локальный стек, наследники текущего элемента
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null ||
                            temp.getRightChild() != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень рассто€ние между элементами каждый раз уменьшаетс€
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
    }
}
