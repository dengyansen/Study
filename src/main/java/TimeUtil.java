import java.sql.Time;
import java.util.TimeZone;

public class TimeUtil {
	public static void main(String[] args) {
//		z.g
		for(String timeZone: TimeZone.getAvailableIDs()){
			System.out.println(timeZone);
			System.out.println("-----");
			System.out.println(TimeZone.getTimeZone(timeZone));
		}
//		System.out.println(TimeZone.getAvailableIDs());
	}
}
