//package part2;
//
//import java.util.Objects;
//
//class LinkedTask {
//
//    static class Node<V> {
//        public V value;
//        public Node<V> next;
//
//        public Node(V value, Node<V> next) {
//            this.value = value;
//            this.next = next;
//        }
//
//        public static void solution(Node<String> head) {
//            StringBuilder stringBuilder = new StringBuilder();
//            Node<String> node = head;
//            do {
//                if (Objects.isNull(node.next)) {
//                    stringBuilder.append(node.value);
//                    break;
//                }
//                stringBuilder.append(head.value);
//                node = node.next;
//            } while (true);
//
//            System.out.println(stringBuilder.reverse());
//        }
//    }
//
//    private static void test() {
//        Node<String> node3 = new Node<>("node3", null);
//        Node<String> node2 = new Node<>("node2", node3);
//        Node<String> node1 = new Node<>("node1", node2);
//        Node<String> node0 = new Node<>("node0", node1);
//        solution(node0);
//        /*
//        Output is:
//        node0
//        node1
//        node2
//        node3
//        */
//    }
//
//}
