package com.bemach.aep.fitnesse.pisentry;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;

import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;

public class Main {
	public static void main(String[] args) {

        System.out.println("\n\n>>> Executing : " + Main.class.toString() + " <<<\n");

        // this will give you a CdiContainer for Weld or OWB, depending on the jar you added
        CdiContainer cdiContainer = CdiContainerLoader.getCdiContainer();

        // now we gonna boot the CDI container. This will trigger the classpath scan, etc
        cdiContainer.boot();

        BeanManager beanManager = cdiContainer.getBeanManager();

        Set<Bean<?>> beans = beanManager.getBeans(PiSentryReceiverTest.class);
        Bean<?> bean = beanManager.resolve(beans);

        PiSentryReceiverTest target = (PiSentryReceiverTest) beanManager.getReference(bean, PiSentryReceiverTest.class, beanManager.createCreationalContext(bean));


        target.data = "ZONE57:FAULT:57.BUTTONA";
		target.process();
		assertTrue(true);

        // finally we gonna stop the container
        cdiContainer.shutdown();

    }
}
