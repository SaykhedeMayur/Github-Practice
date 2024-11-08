import java.time.LocalDateTime;
import java.util.Date;

public class Demo {

	public static void main(String[] args) {
//		
//		JavaUtility jLib = new JavaUtility();
//		String startDate = jLib.getSystemDateYYYYMMDD();
//		String endDate = jLib.getRequiredDateYYYYMMDD(30);
//		
//		System.out.println(startDate);
//		System.out.println(endDate);
		

//		Date dObj = new Date();
//		System.out.println(dObj);
//		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
//		sim.format(dObj);
//		Calendar cal = sim.getCalendar();
//		cal.add(Calendar.DAY_OF_MONTH, 30);
//		String requireDate = sim.format(cal.getTime());
//		System.out.println(requireDate);
		LocalDateTime systemDate = LocalDateTime.now();		
		String timeStamp = systemDate.toString().replace(":", "_").replace("-", "_");
		System.out.println(timeStamp);

		String time = new Date().toString().replace(":", "_").replace(" ", "_");
		System.out.println(time);
	}
}
