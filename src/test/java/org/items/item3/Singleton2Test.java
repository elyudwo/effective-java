package org.items.item3;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.function.Supplier;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Singleton2Test {

    @Test
    void supplierTest() {
        Supplier<Singleton2> supplier = Singleton2::getInstance;
        Singleton2 instance = supplier.get();

        assertThat(instance).isInstanceOf(Singleton2.class);
    }

    @Test
    void Serializable() {
        Singleton2 serialization = Singleton2.getInstance();
        Singleton2 deserialization;

        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
            out.writeObject(serialization);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))) {
            deserialization = (Singleton2) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        assertTrue(serialization == deserialization);
    }

}