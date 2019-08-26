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
		 * ��ʵ֤����ϵͳ�洢��ʱ���Ĭ������GMT/UCTʱ��Ϊ��׼�ģ������ת���ɱ���ʱ�䣬��Ҫ������ʱ����ʱ��ƫ�
		 */
	}
	
	//����java8��java.time���е���
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
		 * DateTimeFormatter���Խ��ַ���ת����parse����ʱ�����Ҳ���Խ�ʱ������ʽ����format��Ϊ�ַ���
		 */
	}
}
