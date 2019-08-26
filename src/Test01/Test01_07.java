package Test01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class Test01_07 {
	public static void main(String[] args) throws IOException, InterruptedException {
//		testFile();
//		testIO();
//		testReadAndWriter();
//		testNIO();
//		testByteBuffer();
//		testAsynchronousIO();
//		testURL();
	}

	// 测试经典File
	static void testFile() throws IOException {
		File homedir = new File("E:\\testIO1");
		System.out.println(homedir.exists());
//		File f = new File(homedir, "app.config");
//		System.out.println(f.exists());
//		if (f.exists() && f.isFile() && f.canRead()) {
//			System.out.println("in if");
//			File configdir = new File(homedir, ".configdir");
//			configdir.mkdir();
//			f.renameTo(new File(configdir, ".config"));
//		}
		File file1 = new File(homedir, "dir1");
		System.out.println(file1.exists());
		System.out.println(file1.mkdirs());
		System.out.println(file1.getParent());
		System.out.println(file1.getPath());
		System.out.println(file1.getName());
		System.out.println(file1.isAbsolute());
		System.out.println(new File("tmep").isAbsolute());
		System.out.println(new File("tmep").getAbsolutePath());
		System.out.println(file1.getCanonicalPath());
		System.out.println(file1.toURI());
		System.out.println(file1.toURL());
		File dir2 = new File("E:\\testIO2");
		System.out.println(dir2.list());
		System.out.println(file1.getTotalSpace() / (1024 * 1024 * 1024));
		System.out.println(file1.getFreeSpace() / (1024 * 1024 * 1024));
		System.out.println(file1.getUsableSpace() / (1024 * 1024 * 1024));
		System.out.println(file1.compareTo(homedir));
	}

	// 测试经典IO
	static void testIO() {
//		try (InputStream is = new FileInputStream("E://testIO/test1.txt")) {
//			byte[] buf = new byte[1024];
//			int len, count = 0;
//			while ((len = is.read(buf)) > 0) {
//				for (int i = 0; i < len; i++)
//					if (buf[i] == 97)
//						count++;
//			}
//			System.out.println("a's count is : " + count);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		try(InputStream is = new FileInputStream("E://testIO/test1.txt");OutputStream os = new FileOutputStream("E://testIO/test2.txt")){
//			byte[] buf = new byte[10];
//			int len;
//			while((len = is.read(buf)) > 0) {
//				os.write(buf, 0, len);
//			}
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//		try {
//			OutputStream os = new FileOutputStream("E://testIO/test2.txt"); // 一创建，内容将被清空，父目录不存在，报错
//			OutputStream os2 = new FileOutputStream("E://testIO/test2.txt");
//			os.write(65);
//			os2.write(66);				//可以通过对个对象对一个文件进行写操作。
////			Thread.sleep(10000);
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try (InputStream is = new BufferedInputStream(new FileInputStream("E://testIO/test1.txt"), 2)) {
//			System.out.println(is.available());
			System.out.println((char) is.read());
			is.mark(19); // 标记当前的pos，重置后会从这个pos开始，这pos的值是相对的，但是表示整个流中的位置是绝对的
			byte[] buf = new byte[3];
			is.read(buf);
			System.out.println(buf.length);
			System.out.println((char) is.read());
			System.out.println(is.skip(3));
			System.out.println((char) is.read());
			is.reset(); // 重置数据流到上一个mark的地方，重新读取。这个功能是通过缓冲区（一个数组）来实现的，当需要读取更多数据又不能丢掉mark地方
						// 的数据时，就会将缓冲区数组增大。
			System.out.println((char) is.read());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		try (OutputStream os = new BufferedOutputStream(new FileOutputStream("E://testIO/test2.txt"))) {
//			os.write(new byte[] { 65, 66, 67, 68 });
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	// 测试Read和Writer
	static void testReadAndWriter() {
//		try (BufferedReader in = new BufferedReader(new FileReader("E://testIO/test1.txt"))) {
//			String line;
//			while ((line = in.readLine()) != null) {
//				System.out.println(line);
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//				PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("E://testIO/test2.txt")))) {
//			String line;
//			while ((line = br.readLine()) != null) {
//				bw.write(line);
//				bw.flush();
//				pw.println(line);
//				pw.flush();
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try (Reader reader = new InputStreamReader(System.in)) {		//in的读取是堵塞的，有数据就读，没有就等待
//			char c;
//			while ((c = (char) reader.read()) != 'x') {					//这个会读取回车符
//				System.out.print(c);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			String line;
			while (!(line = reader.readLine()).equals("exit")) {
				System.out.print(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void testNIO() {
//		File inputFile = new File("E://testIO/test1.txt");
//		try(InputStream in = new FileInputStream(inputFile)){
//			Path target = Paths.get("E://testIO/test3.txt");
//			in.read();
//			Files.copy(in, target);
//			System.out.println(in.read());
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		Path file1 = Paths.get("E://testIO/test2.txt");
		try (BufferedWriter bw = Files.newBufferedWriter(file1, StandardCharsets.UTF_8, StandardOpenOption.WRITE)) {
			bw.write("00");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 测试Buffer
	static void testByteBuffer() throws InterruptedException {
		// 创建和操作ByteBuffer
//		ByteBuffer b = ByteBuffer.allocateDirect(1024);
//		b.mark();
//		b.putChar('a');
//		b.put((byte) 10);
//		b.reset();
//		System.out.println(b.getChar());
//		System.out.println(b.get());

		// 测试headByteBuffer和DirectByteBuffer的内存分配
//		Thread.sleep(10000);
//		ByteBuffer b1 = ByteBuffer.allocate(1024 * 1024 * 50);			//创建字节缓冲区是在堆中开辟的内存
//		ByteBuffer b2 = ByteBuffer.allocateDirect(1024 * 1024 * 50);
//		Thread.sleep(10000);
//		b2 = null;
//		System.gc();		//gc操作也会回收NIO的内存空间
//		Thread.sleep(10000);
//		try (FileInputStream fis = new FileInputStream("E://testIO/test1.txt");
//				FileOutputStream fos = new FileOutputStream("E://testIO/test2.txt")) {
//			ByteBuffer bf = ByteBuffer.allocateDirect(1024);
//			FileChannel fchan = fis.getChannel();
//			FileChannel fchan2 = fos.getChannel();
//			fchan.read(bf);
//			bf.clear();
//			fchan2.write(bf);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try (RandomAccessFile raf = new RandomAccessFile(new File("E://testIO/test1.txt"), "rw");
//				FileChannel fc = raf.getChannel()) {			//这样得到的channel是可读写的
//			MappedByteBuffer mbf = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size());		//因此这样可以map出一个可读写的buffer
//			byte[] b = new byte[(int) fc.size()];
//			mbf.get(b);
//			mbf.position(0);
//			for (byte b0 : b) {
//				System.out.println((char) b0);
//				mbf.put((byte) 65);			//这样放入，会直接同步到文件中。
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try (FileInputStream fis = new FileInputStream("E://testIO/test1.txt"); FileChannel fc = fis.getChannel()) {	//这样得到的channel是只读的
//			MappedByteBuffer mbf = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size());			//因此这样读写模式获取映射buffer是会报错的
//			byte[] b = new byte[(int) fc.size()];
//			mbf.get(b);
//			mbf.position(0);
//			for (byte b0 : b) {
//				System.out.println((char) b0);
//				mbf.put((byte) 65); // 这样放入，会直接同步到文件中。
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	// 测试异步IO
	static void testAsynchronousIO() {
		try (AsynchronousFileChannel afc = AsynchronousFileChannel.open(Paths.get("E:/文件/H5_某比赛/作品.rar"))) {
			ByteBuffer buf = ByteBuffer.allocateDirect((int) afc.size());
			afc.read(buf, 0, null, new CompletionHandler<Integer, Object>() {

				@Override
				public void completed(Integer result, Object attachment) {
					// TODO Auto-generated method stub
					System.out.println("ok");
				}

				@Override
				public void failed(Throwable exc, Object attachment) {
					// TODO Auto-generated method stub
					System.out.println("on ok");
				}
			});
//			Future<Integer> resoult = afc.read(buf, 0);
//			System.out.println(!resoult.isDone());
//			while (!resoult.isDone()) {
//				System.out.println("some thing is running !");
//			}
//			System.out.println("some thing is running !");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void testURL() {
		URL url = null;
		try {
			url = new URL("http://www.baidu.com");
			String rwaData = "wd=java";
			String encodedData = URLEncoder.encode(rwaData, "ASCII");
			String contentType = "application/x-www-form-urlencoded";

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setInstanceFollowRedirects(false);
			conn.setRequestProperty("Content-Type", contentType);
			conn.setRequestProperty("Content-Length", String.valueOf(encodedData.length()));
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
//			conn.getContentType();
			//conn.setRequestMethod("POST");				//设置不能放在获取之后，一旦获取连接信息，就会开启通讯，不能再设置连接信息，只能获取
			OutputStream os = conn.getOutputStream();
			os.write(encodedData.getBytes());

			try (InputStream in = conn.getInputStream()) {
				Files.copy(in, Paths.get("E:/testIO/output3.html"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try (InputStream is = url.openStream()) {
//			Files.copy(is, Paths.get("E://testIO/output.html"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
}
