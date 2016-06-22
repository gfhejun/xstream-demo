package com.gf.onlyforhebe.converter;

import java.util.ArrayList;
import java.util.List;

import com.gf.onlyforhebe.entity.Attachment;
import com.gf.onlyforhebe.entity.Item;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * 自定义转换器
 * @author onlyforhebe
 *
 */
public class ItemConverter implements Converter {

	public boolean canConvert(Class type) {
		return type.equals(Item.class);
	}

	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		//将对象转换成XML
	}

	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		Item item = new Item();
		//通过属性名获取属性值
		item.setId(reader.getAttribute("id"));
		item.setType(reader.getAttribute("type"));
		item.setDescription(reader.getAttribute("description"));

		//获取Tag之间的值
		item.setContent(reader.getValue());

		List<Attachment> attachmentList = new ArrayList<>();

		while (reader.hasMoreChildren()){
			//进入Children Tag
			reader.moveDown();

			//判断属性值个数来区别是Link还是Attachment
			if (reader.getAttributeCount() > 0){
				Attachment attachment = new Attachment();
				attachment.setSize(reader.getAttribute("size"));
				attachment.setName(reader.getAttribute("name"));
				attachment.setPath(reader.getValue());
				attachmentList.add(attachment);
			}else{
				item.setLink(reader.getValue());
			}

			//返回Parent Tag
			reader.moveUp();
		}
		item.setAttachmentList(attachmentList);

		return item;
	}

}
