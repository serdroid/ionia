This is a sample project for payara issue.
Observer method of @Initialized(ApplicationScoped.class) that uses @PersistenceContext fails.

I have developed a code that observing CDI event, initalization of javax.enterprise.context.ApplicationScoped class. That code deals with persistence context and load some data from database. I am getting this exception while calling this method.

```
  Exception during lifecycle processing
org.glassfish.deployment.common.DeploymentException: CDI deployment failure:Exception attempting to inject Env-Prop: info.serdroid.ionia.CountryDao/entityManager@Field-Injectable Resource. Class name = info.serdroid.ionia.CountryDao Field name=entityManager@java.lang.String@@@ into class info.serdroid.ionia.CountryDao: Lookup failed for 'java:comp/env/info.serdroid.ionia.CountryDao/entityManager' in SerialContext[myEnv={java.naming.factory.initial=com.sun.enterprise.naming.impl.SerialInitContextFactory, java.naming.factory.url.pkgs=com.sun.enterprise.naming, java.naming.factory.state=com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl} -- Exception attempting to inject Env-Prop: info.serdroid.ionia.CountryDao/entityManager@Field-Injectable Resource. Class name = info.serdroid.ionia.CountryDao Field name=entityManager@java.lang.String@@@ into class info.serdroid.ionia.CountryDao: Lookup failed for 'java:comp/env/info.serdroid.ionia.CountryDao/entityManager' in SerialContext[myEnv={java.naming.factory.initial=com.sun.enterprise.naming.impl.SerialInitContextFactory, java.naming.factory.url.pkgs=com.sun.enterprise.naming, java.naming.factory.state=com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl}
	at org.glassfish.weld.services.InjectionServicesImpl.aroundInject(InjectionServicesImpl.java:194)
	at org.jboss.weld.injection.InjectionContextImpl.run(InjectionContextImpl.java:46)
```

Both payara and payara-micro behave same. I am evaluating Payara for a while and I think it is pretty good. I am currently using wildfly and trying to move some projects to payara. This sample code works fine on wildfly. I tried on wildfly versions 10.1.0.Final, 12.0.0.Final, 13.0.0.Final. Wildfly fires this event after ServletContext initialization completed. I guess payara fires event before persistence context initialization.
I have developed a version based on javax.ejb.Startup and that works fine. You could evaluate this version on ejb branch.

Is this a bug or do I misuse this feature?

To run sample app you should link payara-micro-5.183.jar into project root folder. Run the application with run.sh

