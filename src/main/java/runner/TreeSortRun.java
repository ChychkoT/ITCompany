package runner;

import org.apache.log4j.Logger;

import treesort.TreeSort;

public class TreeSortRun {

	private static final Logger LOGGER = Logger.getLogger(TreeSortRun.class);
	
	public static void main(String[] args) {
		
		LOGGER.info("----------TreeSort-----------");

		TreeSort tree = new TreeSort(null);

		tree.insert(10);
		tree.insert(8);
		tree.insert(5);
		tree.insert(11);
		tree.insert(7);
		tree.insert(4);

		tree.printLeftToRight(tree.root);
		LOGGER.info("\n");
		tree.printRightToLeft(tree.root);
		tree.delete(10);
		LOGGER.info("\n");
		tree.printRightToLeft(tree.root);
	}

}
