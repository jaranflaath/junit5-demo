package no.kodehuset.junit5;

import org.junit.gen5.api.extension.BeforeAllExtensionPoint;
import org.junit.gen5.api.extension.ContainerExtensionContext;

public class TestBeforeAllExtension implements BeforeAllExtensionPoint {

    @Override
    public void beforeAll(ContainerExtensionContext context) throws Exception {

        System.out.println("Test name is " + context.getName() + "\n");
    }
}
