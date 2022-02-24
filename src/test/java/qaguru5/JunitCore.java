package qaguru5;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JunitCore {

    public static void main(String[] args) throws Exception {
        // lookup classes with annotation @Test
        // here we go with class SimpleTest.class

        Class clazz = SimpleTest.class;
        // run all methods with @BeforeEach
        for (Method method : clazz.getDeclaredMethods()) {
            BeforeEach methodAnnotation = method.getAnnotation(BeforeEach.class);
            if (methodAnnotation != null) {
                // run method with @BeforeEach
                try {
                    method.invoke(clazz.getConstructor().newInstance());
                } catch (InvocationTargetException e) {
                    if (e.getCause() instanceof AssertionError) {
                        System.out.println("Test failed: " + method.getName());
                        continue;
                    } else {
                        System.out.println("Test broken: " + method.getName());
                        continue;
                    }
                }
                System.out.println("Test passed: " + method.getName());
            }
        }
        // run all methods with @AfterEach
        for (Method method : clazz.getDeclaredMethods()) {
            AfterEach methodAnnotation = method.getAnnotation(AfterEach.class);
            if (methodAnnotation != null) {
                // run method with @AfterEach
                try {
                    method.invoke(clazz.getConstructor().newInstance());
                } catch (InvocationTargetException e) {
                    if (e.getCause() instanceof AssertionError) {
                        System.out.println("Test failed: " + method.getName());
                        continue;
                    } else {
                        System.out.println("Test broken: " + method.getName());
                        continue;
                    }
                }
                System.out.println("Test passed: " + method.getName());
            }
        }
        // run all methods with @BeforeAll
        for (Method method : clazz.getDeclaredMethods()) {
            BeforeAll methodAnnotation = method.getAnnotation(BeforeAll.class);
            if (methodAnnotation != null) {
                // run method with @BeforeAll
                try {
                    method.invoke(clazz.getConstructor().newInstance());
                } catch (InvocationTargetException e) {
                    if (e.getCause() instanceof AssertionError) {
                        System.out.println("Test failed: " + method.getName());
                        continue;
                    } else {
                        System.out.println("Test broken: " + method.getName());
                        continue;
                    }
                }
                System.out.println("Test passed: " + method.getName());
            }
        }
        // run all methods with @AfterAll
        for (Method method : clazz.getDeclaredMethods()) {
            AfterAll methodAnnotation = method.getAnnotation(AfterAll.class);
            if (methodAnnotation != null) {
                // run method with @AfterAll
                try {
                    method.invoke(clazz.getConstructor().newInstance());
                } catch (InvocationTargetException e) {
                    if (e.getCause() instanceof AssertionError) {
                        System.out.println("Test failed: " + method.getName());
                        continue;
                    } else {
                        System.out.println("Test broken: " + method.getName());
                        continue;
                    }
                }
                System.out.println("Test passed: " + method.getName());
            }
        }

    }
}
