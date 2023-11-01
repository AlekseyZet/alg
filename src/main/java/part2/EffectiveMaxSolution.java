package part2;

import java.io.*;

public class EffectiveMaxSolution {
    private static final String INPUT = "input.txt";
    private static final String OUTPUT = "output.txt";

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT));
             BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT))) {
            final char PUSH = 'u';
            final char POP = 'o';
            Stack stack = new Stack();
            String line = reader.readLine();
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                String[] command = line.split(" ");
                if (command[0].charAt(1) == PUSH) {
                    stack.push(Integer.valueOf(command[1]));
                }
                else if (command[0].charAt(1) == POP) {
                    if (stack.effectiveMaxStack == null) {
                        stringBuilder.append("error").append("\r\n");
                        continue;
                    }
                    stack.pop();
                } else {
                    if (stack.effectiveMaxStack == null) {
                        stringBuilder.append("None").append("\r\n");
                        continue;
                    }
                    stringBuilder.append(stack.getMax()).append("\r\n");
                }
            }

            writer.write(stringBuilder.toString());

        } catch (Exception e) {
        }
    }

    public static class Stack {
        int size = 0;
        private EffectiveMaxStack effectiveMaxStack;

        public void push(Integer value) {
            size++;
            if (effectiveMaxStack == null) {
                effectiveMaxStack = new EffectiveMaxStack();
                effectiveMaxStack.setValue(value);
                effectiveMaxStack.setMaxValue(value);
                return;
            }

            EffectiveMaxStack newEffectiveMaxStack = new EffectiveMaxStack();
            Integer maxValue = value > effectiveMaxStack.getMaxValue() ? value : effectiveMaxStack.getMaxValue();
            newEffectiveMaxStack.setMaxValue(maxValue);
            newEffectiveMaxStack.setValue(value);
            newEffectiveMaxStack.setPrevious(effectiveMaxStack);
            effectiveMaxStack = newEffectiveMaxStack;
        }

        public Integer pop() {
            if (effectiveMaxStack != null) {
                Integer value = effectiveMaxStack.getValue();
                effectiveMaxStack = effectiveMaxStack.previous;
                return value;
            }

            return null;
        }

        public Integer getMax() {
            if (effectiveMaxStack != null) {
                return effectiveMaxStack.maxValue;
            }

            return null;
        }
    }

    public static class EffectiveMaxStack {
        private Integer maxValue;
        private Integer value;
        private EffectiveMaxStack previous;

        public Integer getMaxValue() {
            return maxValue;
        }

        public void setMaxValue(Integer maxValue) {
            this.maxValue = maxValue;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public EffectiveMaxStack getPrevious() {
            return previous;
        }

        public void setPrevious(EffectiveMaxStack previous) {
            this.previous = previous;
        }
    }
}
