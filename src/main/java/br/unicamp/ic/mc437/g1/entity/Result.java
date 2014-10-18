package br.unicamp.ic.mc437.g1.entity;

public class Result {
	
	private Integer id;
	
	private String uploader;
	
	private String fileContent;
	
	private String name;
	
	public Integer getId () {
		return id;
	}

	public void setId (Integer id) {
		this.id = id;
	}

	public String getUploader () {
		return uploader;
	}

	public void setUploader (String uploader) {
		this.uploader = uploader;
	}

	public String getFileContent () {
		return fileContent;
	}

	public void setFileContent (String fileContent) {
		this.fileContent = fileContent;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
