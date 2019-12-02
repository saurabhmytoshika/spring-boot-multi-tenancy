package com.mytoshika.service.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mytoshika.service.EmployeeService;
import com.mytoshika.util.TenantContext;

@Aspect
@Component
public class EmployeeServiceAspect {

  private final Logger log = LoggerFactory.getLogger(this.getClass());

  // only applicable to employee service
  @Before("execution(* com.example.service.EmployeeService.*(..)) && !execution(* com.example.service.EmployeeService.run(..)) && target(employeeService)")
  public void aroundExecution(JoinPoint pjp, EmployeeService employeeService) throws Throwable {
    org.hibernate.Filter filter = employeeService.entityManager.unwrap(Session.class).enableFilter("orgnizationFilter");
    filter.setParameter("orgnizationId", TenantContext.getCurrentTenant());
    filter.validate();
  }
}
