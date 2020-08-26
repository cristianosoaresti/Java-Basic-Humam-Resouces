package humanResources.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import humanResources.entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Department department;
	private List<HourContract> contracts = new ArrayList<HourContract>();
	
	public Worker() {
	}
	
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}

	public double income(Integer year, Integer month) {
		double sum = baseSalary;
		//instance of calendar to use along this function
		Calendar calendar = Calendar.getInstance();
		for(HourContract i : contracts) {
			//set on calendar instance the date inside the object
			calendar.setTime(i.getDate());
			//set the value of the year inside the calendar
			int c_year = calendar.get(Calendar.YEAR);
			//set the value of the month (plus 1, because the month starts with zero) inside the calendar
			int c_month = 1 + calendar.get(Calendar.MONTH);
			if (year == c_year && month == c_month) {
				sum += i.totalValue();
			}
		}
		return sum;
	}
}