package vault.supervisor.util;

import static vault.supervisor.constant.SuperNames.CHANEL_SUPERVISOR_1;
import static vault.supervisor.constant.SuperNames.CHANEL_SUPERVISOR_2;
import static vault.supervisor.constant.SuperNames.CHANEL_SUPERVISOR_3;
import static vault.supervisor.constant.SuperNames.CHANEL_SUPERVISOR_4;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * 
 * @author Wei
 *
 */
public class ChanelKeyConverter {

	/**
	 * 
	 * @param date
	 * @return String
	 * Supervisor 1 should only be notified between 0:00-5:59 UTC
	 * Supervisor 2 should only be notified between 6:00-11:59 UTC
	 * Supervisor 3 should only be notified between 12:00-17:59 UTC
	 * Supervisor 4 should only be notified between 18:00-23:59 UTC
	 */
	public static String converteDateToChanelKey(Calendar date){
		Calendar newDate = converteDateToChanelKeyUTCDate(date);
		if(newDate.get(Calendar.HOUR_OF_DAY) >= 0 
				&&newDate.get(Calendar.HOUR_OF_DAY) < 6){
			return CHANEL_SUPERVISOR_1;
		} else if(newDate.get(Calendar.HOUR_OF_DAY) >= 6
				&&newDate.get(Calendar.HOUR_OF_DAY) < 12){
			return CHANEL_SUPERVISOR_2;
		} else if(newDate.get(Calendar.HOUR_OF_DAY) >= 12 
				&&newDate.get(Calendar.HOUR_OF_DAY) < 16){
			return CHANEL_SUPERVISOR_3;
		} else {
			return CHANEL_SUPERVISOR_4;
		} 
	}
	
	/**
	 * 
	 * @param date
	 * @return
	 */
	private static Calendar converteDateToChanelKeyUTCDate(Calendar date){

		TimeZone z = date.getTimeZone();
		int offset = z.getRawOffset();
	    int offsetHrs = offset / 1000 / 60 / 60;
	    int offsetMins = offset / 1000 / 60 % 60;

	    date.add(Calendar.HOUR_OF_DAY, (-offsetHrs));
	    date.add(Calendar.MINUTE, (-offsetMins));

	    return date;
	}
}