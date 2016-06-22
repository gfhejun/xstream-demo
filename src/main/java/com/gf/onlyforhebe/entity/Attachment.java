package com.gf.onlyforhebe.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Data;

@XStreamAlias(value="Attachment")//value与XML中的Tag一致（区分大小写），如果一样就可以不添加此Annotation
public @Data class Attachment {
	private String name;
	private String size;
	private String path;
}
