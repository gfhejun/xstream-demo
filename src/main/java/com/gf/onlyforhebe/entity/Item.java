package com.gf.onlyforhebe.entity;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Data;

@XStreamAlias(value = "Item")
public @Data class Item {
	//由于采用的是自定义Converter的方式，因此不需要添加任何XStream的Annotation
	private String id;
	private String type;//表示Item是内容形式还是附件形式
	private String description;
	private String content;//表示XML Tag之间的值
	private String link;
	private List<Attachment> attachmentList;
}
