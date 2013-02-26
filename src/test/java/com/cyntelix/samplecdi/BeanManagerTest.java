package com.cyntelix.samplecdi;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class BeanManagerTest {
    @Inject
    BeanManager beanManager;
    @Inject
    HelloWorld helloWorld;

    @Deployment
    public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(HelloWorld.class.getPackage())
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testCdiBootstrap() {
        assertNotNull("Bean manager not null", beanManager);
        assertFalse("Beans empty", beanManager.getBeans(BeanManager.class).isEmpty());
    }
}
