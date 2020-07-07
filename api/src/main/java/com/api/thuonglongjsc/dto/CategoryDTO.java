package com.api.thuonglongjsc.dto;

public class CategoryDTO {
	private String id;
	private String name;
	private String type;

	public CategoryDTO() {
		super();
	}

	public CategoryDTO(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public CategoryDTO(String id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "CategoryDTO [id=" + id + ", name=" + name + ", type=" + type + "]";
	}

}
