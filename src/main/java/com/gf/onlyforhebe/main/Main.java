package com.gf.onlyforhebe.main;

import com.gf.onlyforhebe.converter.ItemConverter;
import com.gf.onlyforhebe.entity.Items;
import com.thoughtworks.xstream.XStream;

public class Main {
	public static void main(String[] args){
		//测试XML
		StringBuilder xml = new StringBuilder();
		xml.append("<Items>")
		.append("<Item id='item1' description='item with content' type='content'>")
		.append("This is content.")
		.append("</Item>")
		.append("<Item id='item2' description='item with attachment' type='attachment'>")
		.append("<Link>https://onlyforhebe.github.com</Link>")
		.append("<Attachment name='a' size='200k'>")
		.append("/attachment/a.doc")
		.append("</Attachment>")
		.append("<Attachment name='b' size='300k'>")
		.append("/attachment/b.doc")
		.append("</Attachment>")
		.append("</Item>")
		.append("</Items>");

		XStream xstream = new XStream();
		xstream.registerConverter(new ItemConverter());//注册
		xstream.processAnnotations(Items.class);//使Annotation生效
		Items items = (Items)xstream.fromXML(xml.toString());
		items.print(items);
	}
}
