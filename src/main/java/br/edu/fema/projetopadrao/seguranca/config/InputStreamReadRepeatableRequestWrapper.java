package br.edu.fema.projetopadrao.seguranca.config;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
 
public class InputStreamReadRepeatableRequestWrapper extends HttpServletRequestWrapper {
	
	private final byte[] body; 
 
	public InputStreamReadRepeatableRequestWrapper(HttpServletRequest request) throws IOException {
		super(request);
		body = InputStreamToByte(request.getInputStream());
	}
	
	private byte[] InputStreamToByte(InputStream is) throws IOException {
	   ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
	   byte[] buffer=new byte[1024];
	   int ch;
	   while ((ch = is.read(buffer)) != -1) {
		   bytestream.write(buffer,0,ch);
	   }
	   byte data[] = bytestream.toByteArray();
	   bytestream.close();
	   return data;
	 }
	
	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(getInputStream()));
	}
	
	@Override
	public ServletInputStream getInputStream() throws IOException {
		final ByteArrayInputStream bais = new ByteArrayInputStream(body);
		return new ServletInputStream() {
			
			@Override
			public int read() throws IOException {
				return bais.read();
			}

			@Override
			public boolean isFinished() {
				return false;
			}

			@Override
			public boolean isReady() {
				return false;
			}

			@Override
			public void setReadListener(ReadListener listener) {
				// TODO Auto-generated method stub
				
			}
		};
	}
 
}