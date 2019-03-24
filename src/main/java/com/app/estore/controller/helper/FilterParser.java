package com.app.estore.controller.helper;

/**
 * Parser to get filter values from the below filter String
 * 
 * For Eg. Department=1,2,;Category=1,2,3,;Size=1,2,;Color=6,7,8,;
 * 
 * @author Siva
 *
 */
public class FilterParser {

	private String filter = null;
	private int[] departments;
	private int[] categories;
	private String attributeCsv = "";

	public FilterParser(String filter) {
		this.filter = filter;
	}

	public void parse() {
		String[] splittedStringWithSemiColon = splitWithSemiColon();
		for (String splittedString : splittedStringWithSemiColon) {
			if (splittedString.contains("Department")) {
				fillDepartmentIds(splittedString);
			} else if (splittedString.contains("Category")) {
				fillCategoryIds(splittedString);
			} else if (splittedString.contains("Size") || splittedString.contains("Color")) {
				fillAttributeValueIds(splittedString);
			}
		}
	}

	private String[] splitWithSemiColon() {
		String[] splittedString = null;
		if (filter != null) {
			splittedString = filter.split(";");
		}
		return splittedString;
	}

	private void fillDepartmentIds(String filter) {
		if (filter != null) {
			String idCsv = filter.substring(filter.indexOf("=") + 1);
			String[] ids = idCsv.split(",");
			departments = new int[ids.length];
			int i = 0;
			for (String departmentId : ids) {
				if(departmentId.length() >0) {
					departments[i++] = Integer.parseInt(departmentId);
				}
			}
		}
	}

	private void fillCategoryIds(String filter) {
		if (filter != null) {
			String idCsv = filter.substring(filter.indexOf("=") + 1);
			String[] ids = idCsv.split(",");
			categories = new int[ids.length];
			int i = 0;
			for (String categoryId : ids) {
				if(categoryId.length() >0) {
					categories[i++] = Integer.parseInt(categoryId);
				}
			}
		}
	}

	private void fillAttributeValueIds(String filter) {
		if (filter != null) {
			attributeCsv += filter.substring(filter.indexOf("=") + 1);
		}
	}

	public int[] getDepartments() {
		return departments;
	}

	public int[] getCategories() {
		return categories;
	}

	public String getAttributeCsv() {
		return attributeCsv;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		if (departments != null) {
			buffer.append("Department =");
			for (int i : departments) {
				buffer.append(" " + i);
			}
			buffer.append("\n");
		}
		if (categories != null) {
			buffer.append("Categories =");
			for (int i : categories) {
				buffer.append(" " + i);
			}
			buffer.append("\n");
		}

		if (attributeCsv.length() > 0) {
			buffer.append("Attributes = ").append(attributeCsv).append("\n");
		}
		return buffer.toString();
	}

	public static void main(String[] args) {
		FilterParser parser1 = new FilterParser("Department=1,2,;Category=1,2,3,;Size=1,2,;Color=6,7,8,;");
		FilterParser parser2 = new FilterParser("Department=1,;Category=;Size=;Color=;");
		parser1.parse();
		parser2.parse();
		System.out.println(parser1.toString());
		System.out.println(parser2.toString());
	}
}
