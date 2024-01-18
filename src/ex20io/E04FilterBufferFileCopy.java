package ex20io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class E04FilterBufferFileCopy {
	
	public static void main(String[] args) {

		try {
			/*
			버퍼 필터 스트림을 이용한 파일 복사 프로그램 제작한다.
			먼저 파일경로를 통해 파일 입출력을 위한 스트림을 생성한다. 
			 */
			InputStream in = 
					new FileInputStream("src/ex20io/movie.gif");
			OutputStream out = 
					new FileOutputStream("src/ex20io/movie2.gif");
			
			//파일과 Java사이에서 버퍼 역할을 하는 버퍼필터스트림 생성 
			BufferedInputStream bufIn = 
					new BufferedInputStream(in);
			BufferedOutputStream bufOut = 
					new BufferedOutputStream(out);

			int copyByte = 0;
			int bData;
		 
			/*
			버퍼 필터 스트림을 통해 파일을 읽은 후 복사본을 만든다. 
			버퍼가 적용되어 있어 읽기/쓰기 속도가 매우 빠르다. 
			 */
			while(true) {
				bData = bufIn.read();				
				if(bData==-1) {
					break;
				}
				bufOut.write(bData);				
				copyByte++;
			}		
			//완료 했다면 스트림 소멸 
			bufIn.close();
			bufOut.close();
			System.out.println("복사된 파일크기:"+ (copyByte/1024) +"Kbyte");
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
