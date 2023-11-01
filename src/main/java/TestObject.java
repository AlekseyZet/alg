import java.util.*;

public class TestObject {

    public static void main(String[] args) {
        List<TestClass> list = new ArrayList<>();
        for (int i = 0; i < 100000001; i++) {
            TestClass testClass = new TestClass(i, i + 1);
            list.add(testClass);
        }

        Comparator<TestClass> comparing = Comparator.comparing(TestClass::getKey);
        TreeMap<TestClass, Integer> testClassTreeMap = new TreeMap<>(comparing);
        for (TestClass testClass : list) {
            testClassTreeMap.put(testClass, testClass.value);
        }

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000001; i++) {
            boolean b = testClassTreeMap.containsKey(new TestClass(100000000, 100000001));
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    public static class TestClass {
        private Integer key;
        private Integer value;

        public TestClass(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public void setKey(Integer key) {
            this.key = key;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }
    }
}
