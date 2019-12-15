package comm.example;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Display {
	public static void main(String[] args) {
		try {
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		Customer theCustomer=context.getBean("customer",Customer.class);
		System.out.println(theCustomer);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
