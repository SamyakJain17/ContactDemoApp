package com.ankit.demo.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.ankit.demo.entity.Contact;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggerAdvice {

	@AfterReturning(pointcut = "execution(* *.ContactService.save*(..))", returning = "entity")
	public void logMethodCall(JoinPoint jp, Object entity) throws Throwable {
		Contact contact = (Contact) entity;
		log.info("Contact : "+ contact.getFullName() +" is created successfully. ");
	}

}
