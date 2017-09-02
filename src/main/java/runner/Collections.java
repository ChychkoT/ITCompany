package runner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import employees.administration.HrManager;

public class Collections {

	private static final Logger LOGGER = Logger.getLogger(Collections.class);
	
	public static void main(String[] args) {
		
		LOGGER.info("------Collections-----------\n");

		// ArrayList

		List<HrManager> colMan = new ArrayList<HrManager>();
		for (int i = 0; i < 5000; i++) {
			colMan.add(new HrManager("Sonya1 ", null, null, 850));

		}

		LOGGER.info("\nSize: " + colMan.size());

		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 5000; i++) {
			colMan.add(10, new HrManager("Sonya2 Ivanova ", null, null, 1050));
		}
		colMan.remove(colMan.size() / 2);

		long timeSpent = System.currentTimeMillis() - startTime;

		LOGGER.info("\nSize: " + colMan.size());

		// System.out.println(colMan);

		// LinkList

		List<HrManager> colMan2 = new LinkedList<HrManager>();
		for (int i = 0; i < 5000; i++) {
			colMan2.add(new HrManager("Sonya2 ", null, null, 1050));

		}

		LOGGER.info("\nSize: " + colMan2.size());

		long startTime2 = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			colMan2.add(10, new HrManager("Sonya2 Ivanova ", null, null, 1050));
		}
		colMan2.remove(colMan2.size() / 2);

		long timeSpent2 = System.currentTimeMillis() - startTime2;

		LOGGER.info("\nSize: " + colMan2.size());

		// System.out.println(colMan2);

		LOGGER.info("\nrun  " + timeSpent + "  milliseconds");
		LOGGER.info("\nrun Link   " + timeSpent2 + "  milliseconds");

		// HashMap

		Map<Integer, HrManager> mapmanager = new HashMap<Integer, HrManager>();
		mapmanager.put(1, new HrManager("Dima1", null, null, 1000));
		mapmanager.put(2, new HrManager("Dima2", null, null, 2000));
		mapmanager.put(3, new HrManager("Dima3", null, null, 3000));
		HrManager first = mapmanager.get(2);
		LOGGER.info(first);

		Set<Integer> keys = mapmanager.keySet();
		LOGGER.info("\nkeys " + keys);

		Collection<HrManager> values = mapmanager.values();
		LOGGER.info("\nvalues " + values);

		mapmanager.replace(1, new HrManager("Olga", null, null, 2500));
		mapmanager.remove(2);
		LOGGER.info("\nvalues " + values);

		for (Map.Entry<Integer, HrManager> item : mapmanager.entrySet()) {

			System.out.printf("Key: %s  Name: %s Salary: %s \n", item.getKey(),
					item.getValue().getName(), item.getValue().getSalary());
		}

		// TreeSet

		TreeSet<Double> tr = new TreeSet<Double>();
		tr.add(new Double(5.0));
		tr.add(new Double(8.0));
		tr.add(new Double(10.0));
		tr.add(new Double(7.0));
		tr.add(new Double(4.0));

		tr.remove(5.0);

		for (Double trs : tr) {

			LOGGER.info(trs);
		}
		
	}

}
