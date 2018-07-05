package com.test;

import java.io.*;
import java.net.URISyntaxException;
import java.util.*;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ShellRunner;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class StartUp {
	 
	
	 public static void generate1() {  
	       String config = StartUp.class.getClassLoader().getResource( 
	               "src/main/java/com/test/generator.xml").getFile();  
	       String[] arg = { "-configfile", config, "-overwrite" };  
	       ShellRunner.main(arg);  
	   }   
	 
	 public static void generate2()throws Exception {  
			List<String> warnings = new ArrayList<String>();
			String filePath= "src/main/java/com/test/generator.xml";
			//System.out.println("--------"+StartUp.class.getResource("generator.xml").toURI());
	        File configFile = new File(filePath);
		    ConfigurationParser cp =new ConfigurationParser(warnings);
		    Configuration config = cp.parseConfiguration(configFile);
		    DefaultShellCallback shellCallback =new DefaultShellCallback(true);
		    MyBatisGenerator myBaitsGenerator =new MyBatisGenerator(config,shellCallback,warnings);
		    myBaitsGenerator.generate(null);
		    System.out.println(warnings);
	   }   

	public static void main(String[] args) throws Exception {
		generate2();
		
	}

}
