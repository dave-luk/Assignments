package cs241.A1;

public class TableAssignmentTester
{

	public static void main(String[] args)
	{
		Customer dave = new Customer("Davie Dave", Customer.Priority.VIP);
		Customer alex = new Customer("Alex", Customer.Priority.FAMILY_W_CHILDREN);
		Customer corncob = new Customer("Corncob",Customer.Priority.ADVANCE_CALL);
		Customer bernie = new Customer("Bernie",Customer.Priority.SENIOR);
		Customer erica = new Customer("Erica",Customer.Priority.DEFAULT);
		Customer ryan = new Customer("Ryan",Customer.Priority.VETERAN);
		
		TableAssignment ta =  new TableAssignment(dave, alex, corncob, bernie, erica, ryan);
		while(!ta.isEmpty())
			System.out.println(ta.next());
	}

}
