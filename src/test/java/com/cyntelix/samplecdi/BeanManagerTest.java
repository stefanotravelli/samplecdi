package com.cyntelix.samplecdi;

import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import static org.junit.Assert.*;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class BeanManagerTest
{
   @Deployment
   public static Archive<?> createTestArchive()
   {
      return ShrinkWrap.create(JavaArchive.class)
         .addPackage(HelloWorld.class.getPackage())
         .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
   }

   @Inject BeanManager beanManager;

   @Inject HelloWorld helloWorld;

   @Test
   public void testCdiBootstrap()
   {
      assertNotNull("Bean manager not null", beanManager);
      assertFalse("Beans empty", beanManager.getBeans(BeanManager.class).isEmpty());
      assertEquals("Hello, World!", helloWorld.getText());
   }
}
