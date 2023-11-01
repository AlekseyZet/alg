package part2;

    import java.io.BufferedReader;
    import java.io.BufferedWriter;
    import java.io.FileReader;
    import java.io.FileWriter;
    import java.util.StringTokenizer;


    public class MyQueueSized {
        private static final String INPUT = "input.txt";
        private static final String OUTPUT = "output.txt";

        public static void main(String[] args) {
            try (BufferedReader reader = new BufferedReader(new FileReader(INPUT));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT))) {
                int commandsNumber = Integer.parseInt(reader.readLine());
                int size = Integer.parseInt(reader.readLine());
                Queue queue = new Queue(size);
                StringBuilder stringBulder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    StringTokenizer command = new StringTokenizer(line, " ");
                    String nextToken = command.nextToken();
                    if ("push".equals(nextToken)) {
                        Integer value = queue.push(Integer.parseInt(command.nextToken()));
                        if (value == null) {
                            stringBulder.append("error").append("\r\n");
                            continue;
                        }
                    } else if ("pop".equals(nextToken)) {
                        Integer value = queue.pop();
                        if (value == null) {
                            stringBulder.append("None").append("\r\n");
                            continue;
                        }
                        stringBulder.append(value).append("\r\n");
                    } else if ("peek".equals(nextToken)) {
                        Integer value = queue.getFirstValue();
                        if (value == null) {
                            stringBulder.append("None").append("\r\n");
                            continue;
                        }
                        stringBulder.append(value).append("\r\n");
                    } else {
                        stringBulder.append(queue.getSize()).append("\r\n");
                    }
                    continue;
                }

                writer.write(stringBulder.toString().trim());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public static class Queue {
            private int size;
            private int tail;
            private int head;
            private Integer firstValue;
            private int[] data;


            public Queue(int dataSize) {
                size = 0;
                tail = 0;
                head = 0;
                data = new int[dataSize];
            }

            public Integer push(int value) {
                if (size == data.length) {
                    return null;
                } else if (tail == head && size == 0) {
                    firstValue = value;
                }

                size++;
                data[tail++ % (data.length)] = value;
                return value;
            }

            public Integer pop() {
                if (size == 0) {
                    return null;
                } else if (--size > 0) {
                    int nextValue = (head + 1) % data.length;
                    firstValue = data[nextValue];
                } else if (size == 0) {
                    firstValue = null;
                }

                return data[head++ % (data.length)];
            }

            public Integer getFirstValue() {
                if (firstValue != null) {
                    return firstValue;
                }

                return null;
            }

            public int getSize() {
                return size;
            }
        }
    }
