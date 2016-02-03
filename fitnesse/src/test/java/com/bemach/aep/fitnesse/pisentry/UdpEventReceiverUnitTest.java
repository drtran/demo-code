package com.bemach.aep.fitnesse.pisentry;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UdpEventReceiverUnitTest {
	@Inject	
	private PiSentryReceiverTest target;
	
	@Before
	public void setUp() {
		initBeanManager();
	}
	
	@After
	public void tearDown() {
		cdiContainer.shutdown();	
	}
	
	private CdiContainer cdiContainer;
	
	@Test
	public void should_receive_a_fault_message(){
		target.data = "";
		target.process();
		assertTrue(true);
	}
	
	public void initBeanManager() {
        // this will give you a CdiContainer for Weld or OWB, depending on the jar you added
        cdiContainer = CdiContainerLoader.getCdiContainer();

        // now we gonna boot the CDI container. This will trigger the classpath scan, etc
        cdiContainer.boot();

        BeanManager beanManager = cdiContainer.getBeanManager();

        Set<Bean<?>> beans = beanManager.getBeans(PiSentryReceiverTest.class);
        Bean<?> bean = beanManager.resolve(beans);

        target = (PiSentryReceiverTest) beanManager.getReference(bean, PiSentryReceiverTest.class, beanManager.createCreationalContext(bean));
    }
}
