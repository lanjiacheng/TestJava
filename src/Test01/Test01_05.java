package Test01;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

public class Test01_05 {
	public static void main(String args[]) {
//		test01();
		test02();
	}
	
	public static void test01() {
		Long currentMillis = System.currentTimeMillis();
		Long currentSeconds = currentMillis / 1000;
		System.out.println("current millis : "+currentMillis);
		int hour = (int)(currentSeconds / (60*60)) % 24;
		int minute = (int)(currentSeconds % (60*60) / 60);
		int second = (int)(currentSeconds % (60));
		System.out.println(hour + ":" + minute + ":" + second);
		/*
		 * 事实证明，系统存储的时间戳默认是以GMT/UCT时区为标准的，如果想转换成本地时间，需要计算上时区的时间偏差。
		 */
	}
	
	//测试java8的java.time包中的类
	public static void test02() {
		Clock clock = Clock.system(ZoneId.of("Asia/Shanghai"));
		LocalDateTime localDateTime = LocalDateTime.now(clock);
		System.out.println(localDateTime);
//		System.out.println(ZoneId.getAvailableZoneIds());
//		System.out.println(localDateTime.getMinute());
//		System.out.println(localDateTime.plusHours(21));
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
		DateTimeFormatter dateTimeFormatter_str = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter dateTimeFormatter_str_2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println(localDateTime.format(dateTimeFormatter_str));
		TemporalAccessor temporalAccessor = dateTimeFormatter_str_2.parse("1998-02-17 00:00:00");
		LocalDateTime localDateTime2 = LocalDateTime.from(temporalAccessor);
		System.out.println(localDateTime2);
		/*
		 * DateTimeFormatter可以将字符串转换（parse）成时间对象，也可以将时间对象格式化（format）为字符串
		 */
	}
}
