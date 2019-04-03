package com.example.demo.converter;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class JsonRequestMessageConverter  implements HttpMessageConverter<Object> {
	 private ObjectMapper mapper=new ObjectMapper();
	 
	    private List<MediaType> supportedMediaTypes= Arrays.asList(MediaType.APPLICATION_JSON);
	 
	    /**
	     * 判断转换器是否可以将输入内容转换成Java
	     * @param aClass
	     * @param mediaType
	     * @return
	     */
	    @Override
	    public boolean canRead(Class<?> aClass, MediaType mediaType) {
	        if(mediaType==null){
	            return false;
	        }
	        for(MediaType supportedMediaType : getSupportedMediaTypes()){
	            if(supportedMediaType.includes(mediaType)){
	                return true;
	            }
	        }
	        return false;
	    }
	 
	    /**
	     * 判断转换器能否将Java类型转换成指定的输出内容
	     * @param aClass
	     * @param mediaType
	     * @return
	     */
	    @Override
	    public boolean canWrite(Class<?> aClass, MediaType mediaType) {
	        if(mediaType==null || MediaType.ALL.equals(mediaType)){
	            return true;
	        }
	        for(MediaType supportedMediaType:getSupportedMediaTypes()){
	            if(supportedMediaType.includes(mediaType)){
	                return true;
	            }
	        }
	        return false;
	    }
	 
	    @Override
	    public List<MediaType> getSupportedMediaTypes() {
	        return supportedMediaTypes;
	    }
	 
	    /**
	     * 读取请求内容将其中的Json转换为Java对象
	     * @param aClass             需要转化的Java类型
	     * @param httpInputMessage   请求对象
	     * @return
	     * @throws IOException
	     * @throws HttpMessageNotReadableException
	     */
	    @Override
	    public Object read(Class<?> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
	        return mapper.readValue(httpInputMessage.getBody(),aClass);
	    }
	 
	    /**
	     * 将Java对象转化成Json返回内容
	     * @param o                     需要转化的对象
	     * @param mediaType             返回类型
	     * @param httpOutputMessage     回执对象
	     * @throws IOException
	     * @throws HttpMessageNotWritableException
	     */
	    @Override
	    public void write(Object o, MediaType mediaType, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
	        OutputStream outputStream=httpOutputMessage.getBody();
//	        outputStream.write("hello world".getBytes());
	        mapper.writeValue(outputStream,o);
	    }

}