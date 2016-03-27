package com.bemach.aep.cdi_unit;

import java.util.Set;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;

import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;

public class LoginMainTest {
	private CdiContainer cdiContainer;
    private Login loginBean;

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    public void initBeanManager() {
        // this will give you a CdiContainer for Weld or OWB, depending on the jar you added
        cdiContainer = CdiContainerLoader.getCdiContainer();

        // now we gonna boot the CDI container. This will trigger the classpath scan, etc
        cdiContainer.boot();

        BeanManager beanManager = cdiContainer.getBeanManager();

        Set<Bean<?>> beans = beanManager.getBeans(Login.class);
        Bean<?> bean = beanManager.resolve(beans);

        loginBean = (Login) beanManager.getReference(bean, Login.class, beanManager.createCreationalContext(bean));
    }

    public void closeBeanManager() {
        cdiContainer.shutdown();
    }
    
    public static void main (String[] args) {
    	LoginMainTest main = new LoginMainTest();
    	main.initBeanManager();
    	System.out.println("Testing ....");
    	main.closeBeanManager();
    }
}
