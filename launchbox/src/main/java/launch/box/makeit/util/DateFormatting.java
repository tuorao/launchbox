/*
* 작성일 : 2015. 6. 8.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatting {

	public String setSort(int userSrl){
		SimpleDateFormat format = new SimpleDateFormat("ssSSS", Locale.KOREA);
		Date date = new Date();
		String dateToString = format.format(date);
		return userSrl+"."+dateToString;
	}
}
