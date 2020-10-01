package org.example;

import com.google.common.collect.testing.AbstractIteratorTester.KnownOrder;
import com.google.common.collect.testing.IteratorFeature;
import com.google.common.collect.testing.IteratorTester;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Test;

class IteratorTesterExampleTests {
  @Test
  void example() {
    Iterable<String> iterable =
        new Iterable<String>() {
          private final List<String> elements = Arrays.asList("a", "b", "c");

          @Override
          public Iterator<String> iterator() {
            return elements.iterator();
          }
        };

    IteratorTester<String> iteratorTester =
        new IteratorTester<String>(
            3, IteratorFeature.UNMODIFIABLE, Arrays.asList("a", "b", "c"), KnownOrder.KNOWN_ORDER) {
          @Override
          protected Iterator<String> newTargetIterator() {
            return iterable.iterator();
          }
        };

    iteratorTester.test();
  }
}
