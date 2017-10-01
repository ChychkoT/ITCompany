package runner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import interfaces.IEat;
import interfaces.IGet;
import interfaces.ISleep;
import employees.administration.HrManager;
import address.Address;
import address.Country;
import employees.development.BackEnd;
import employees.development.Development;
import employees.EmployeesIT;
import exception.MyTestException;
import exception.Test;

import org.apache.log4j.Logger;


public class Main {
	
	private static final Logger LOGGER = Logger.getLogger(Main.class);

	public static void main(String[] args) throws InterruptedException {

		
		BackEnd bend1 = new BackEnd("Vasya1 ", null, new Address(Country.BELARUS, "Minsk",
				"Sovetskaya", 16), 550);
		bend1.setDate("11/11/1995");
		LOGGER.info(bend1.getEmployee());

		BackEnd bend = new BackEnd("Vasya1 ", null, new Address(Country.BELARUS, "Minsk",
				"Sovetskaya", 16), 550);
		bend.setDate("11/11/1995");
		LOGGER.info(bend.getEmployee());
		bend.develop();
		LOGGER.info("\n");

		BackEnd bend2 = new BackEnd("Vasya1 ", null, null, 550);
		BackEnd bend3 = new BackEnd("Vasya3 ", null, null, 550);

		LOGGER.info(bend.toString());

		LOGGER.info(bend.hashCode());
		LOGGER.info(bend2.hashCode());

		LOGGER.info(bend.equals(bend2));
		LOGGER.info(bend.equals(bend3));

		bend.develop(5);
		bend.develop(5, 6);

		EmployeesIT bend4 = new BackEnd("Vasya4 ", null, null, 800);
		bend4.setDate("5/01/1989");

		LOGGER.info(bend4.toString());

		((BackEnd) bend4).develop();

		Development bend8 = new BackEnd("Vasya5 ", null, null, 1000);
		((BackEnd) bend8).develop(1, 2);

		BackEnd bend5 = bend;
		LOGGER.info("\nName:" + bend5.getName());
		Development d = bend5;
		LOGGER.info("\nName:" + d.getName());
		EmployeesIT e = d;
		LOGGER.info("\nName:" + e.getName());
		EmployeesIT e2 = d;
		LOGGER.info("\nName:" + e2.getName());
		Development bend6 = (Development) e2;
		LOGGER.info("\nName:" + bend6.getName());
		BackEnd bend7 = (BackEnd) bend6;
		LOGGER.info("\nName:" + bend7.getName());

		LOGGER.info("\n\n-------------Array of objects---------------");

		HrManager manager[] = new HrManager[10];
		manager[0] = new HrManager("Dima1", null, new Address(Country.BELARUS,
				"Minsk", "Sadovaja", 25), 5600);
		manager[1] = new HrManager("Dima2", null, new Address(Country.RUSSIA,
				"Moskva", "Sadovaja", 25), 6600);
		manager[2] = new HrManager("Dima3", null, new Address(Country.LATVIA,
				"Riga", "Sadovaja", 25), 5000);
		manager[3] = new HrManager("Dima4", null, new Address(Country.POLAND,
				"Varshava", "Sadovaja", 25), 4000);
		manager[4] = new HrManager("Dima5", null, new Address(Country.BELARUS,
				"Vitebsk", "Sadovaja", 25), 2000);
		manager[5] = new HrManager("Dima6", null, new Address(Country.BELARUS,
				"Gomel", "Sadovaja", 25), 500);
		manager[6] = new HrManager("Dima7", null, new Address(Country.BELARUS,
				"Gomel", "Sadovaja", 25), 1500);
		manager[7] = new HrManager("Dima8", null, new Address(Country.BELARUS,
				"Gomel", "Sadovaja", 25), 8000);
		manager[8] = new HrManager("Dima9", null, new Address(Country.BELARUS,
				"Gomel", "Sadovaja", 25), 700);
		manager[9] = new HrManager("Dima10", null, new Address(Country.BELARUS,
				"Gomel", "Sadovaja", 25), 5900);

		for (int i = 0; i < 10; i++) {
			if (manager[i].getSalary() > 5000) {
				LOGGER.info(manager[i].toString());
				LOGGER.info("Adress: "
						+ manager[i].getAddress().getCountry() + ", "
						+ manager[i].getAddress().getCity() + ", "
						+ manager[i].getAddress().getStreet() + ", "
						+ manager[i].getAddress().getHouse());
			}
		}

		LOGGER.info("\n\n-------------Interface---------------");

		IEat bend9 = new BackEnd("Sasha ", null, null, 1550);
		bend9.eat();
		ISleep bend10 = new BackEnd("Sasha2 ", null, null, 1550);
		bend10.sleep();
		BackEnd bend11 = new BackEnd("Sasha3 ", null, null, 1550);
		bend11.eat();
		bend11.sleep();

		LOGGER.info("\n\n-------------StringUtils---------------");

		String st1 = "";
		String st2 = " ";
		String st3 = "name";
		String st4 = " name ";
		LOGGER.info(st1.isEmpty());
		LOGGER.info(st2.isEmpty());
		LOGGER.info(st3.isEmpty());
		LOGGER.info(st4.isEmpty());

		LOGGER.info("\n");

		LOGGER.info(StringUtils.isBlank(null));
		LOGGER.info(StringUtils.isBlank(""));
		LOGGER.info(StringUtils.isBlank(" "));
		LOGGER.info(StringUtils.isBlank("name"));
		LOGGER.info(StringUtils.isBlank(" name "));

		LOGGER.info("\n");

		LOGGER.info(StringUtils.isEmpty(null));
		LOGGER.info(StringUtils.isEmpty(""));
		LOGGER.info(StringUtils.isEmpty(" "));
		LOGGER.info(StringUtils.isEmpty("name"));
		LOGGER.info(StringUtils.isEmpty(" name "));

		LOGGER.info("\n\n-------------StringBilder and StringBuffer---------------");

		StringBuilder sb = new StringBuilder(bend2.getName() + ","
				+ bend3.getName() + "," + bend4.getName() + ","
				+ bend8.getName() + ".");
		LOGGER.info("1:" + sb);

		StringBuilder sb2 = new StringBuilder();
		sb2.append(bend2.getName() + ",");
		sb2.append(bend3.getName() + ",");
		sb2.append(bend4.getName() + ",");
		sb2.append(bend8.getName() + ".");
		LOGGER.info("2:" + sb2);

		sb2.append(bend2.getName() + ",").append(bend3.getName() + ",")
				.append(bend4.getName() + ",").append(bend8.getName() + ".");
		LOGGER.info("3:" + sb2);

		LOGGER.info("4:" + new StringBuffer().append(sb).append(sb2));
		LOGGER.info(sb2.length());
		LOGGER.info(sb2.delete(32, 64));


		LOGGER.info("\n\n-------------My Exception tests---------------");

		Test test = new Test();

		try {
			String hello = test.helloMessage(null);
			LOGGER.info("Example 1: " + hello);
		} catch (MyTestException ex) {

			LOGGER.error("Example 1: error message: " + ex.getMessage());
		}

		try {
			String hello = test.helloMessage(bend2.getName());
			LOGGER.info("Example 2: " + hello);
		} catch (MyTestException ex) {

			LOGGER.error("Example 2: error message: " + ex.getMessage());
		}

	
		// lambda
		LOGGER.info("\n\n---------functional interface-----------");
		
		IGet<HrManager> sup = () -> new HrManager ("Tom", null, null, 1000) ;
		Supplier<HrManager> sup2 = () -> new HrManager ("Anna", null, null, 1300) ;
		LOGGER.info(sup.get());
		LOGGER.info(sup2.get());
		
		// Stream
		LOGGER.info("\n\n----------Collections and Stream-----------");

		List<HrManager> colMananager = new ArrayList<HrManager>();

		colMananager.add(new HrManager("Tom", null, null, 1000));
		colMananager.add(new HrManager("Anna", null, null, 1300));
		colMananager.add(new HrManager("Sveta", null, null, 1250));
		colMananager.add(new HrManager("Dima", null, null, 800));
		colMananager.stream().filter(s -> s.getSalary() > 1000)
				.forEach(s -> System.out.println(s + "$"));

		LOGGER.info("\n");

		Stream<HrManager> managerStream = Stream.of(new HrManager("Tom", null,
				null, 1000), new HrManager("Anna", null, null, 1200),
				new HrManager("Sveta", null, null, 1250), new HrManager("Dima",
						null, null, 800));

		Map<Boolean, List<HrManager>> salaryManager = managerStream
				.collect(Collectors.partitioningBy(p -> p.getSalary() > 1000));

		for (Map.Entry<Boolean, List<HrManager>> item : salaryManager
				.entrySet()) {

			System.out.println(item.getKey());
			for (HrManager hrmanager : item.getValue()) {

				LOGGER.info(hrmanager.getName());
			}
			LOGGER.info("");
		}
		
	
	}

	
}
