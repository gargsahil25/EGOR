package com.egor.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.egor.service.PlannerService;

public class CreatePlanAction {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-services.xml");
	private PlannerService plannerService;
	
	// Populated by user
	private String planParam;
	
	public String createPlan() {
		
		// Set the Planner Service
		setPlannerService(ctx.getBean("plannerService", PlannerService.class));
		
		// Debugging
		System.out.println("CreatePlanAction.createPlan called with planParam: " + getPlanParam());
		
		getPlannerService().createPlan();		
		
		// Debugging
		System.out.println("Planner service returned void");
		
		return "success";
	}
	
	public String createInstantPlan() {
		
		// Set the Planner Service
		setPlannerService(ctx.getBean("plannerService", PlannerService.class));
		
		// Debugging
		System.out.println("CreatePlanAction.createInstantPlan called with planParam: " + getPlanParam());
		
		getPlannerService().createPlan();		
		
		// Debugging
		System.out.println("Planner service returned void");
		
		return "success";
	}

	public PlannerService getPlannerService() {
		return plannerService;
	}

	public void setPlannerService(PlannerService plannerService) {
		this.plannerService = plannerService;
	}

	public String getPlanParam() {
		return planParam;
	}

	public void setPlanParam(String planParam) {
		this.planParam = planParam;
	}
	
}
