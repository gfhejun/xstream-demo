package com.gf.onlyforhebe.entity;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import lombok.Data;

@XStreamAlias(value="Items")
public @Data class Items {
	@XStreamImplicit //去除List最外层的标签，直接显示里面的<Item></Item>
	private List<Item> items;

	public void print(Items i){
		items = i.getItems();
		for (Item item : items){
			StringBuilder sb = new StringBuilder();
			String type = item.getType();
			sb.append("item id=");
			sb.append(item.getId());
			sb.append(";type=");
			sb.append(type);
			sb.append(";description=");
			sb.append(item.getDescription());
			if (type.equals("content")){
				sb.append(";item content=");
				sb.append(item.getContent());
			}else{
				sb.append(";item link=");
				sb.append(item.getLink());
				List<Attachment> list = item.getAttachmentList();
				for (Attachment attachment : list){
					sb.append(";attachment name=" + attachment.getName());
					sb.append(";size=" + attachment.getSize());
					sb.append(";path=" + attachment.getPath());
				}
			}
			System.out.println(sb.toString());
		}
	}
}
