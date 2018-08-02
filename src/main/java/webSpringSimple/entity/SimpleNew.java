package webSpringSimple.entity;

public class SimpleNew {

    private long id;

    private String imagePath;

    private String title;
    
    private String content;
    
//    @JsonIgnore
//    private String level;

    public SimpleNew() {
    }

    public SimpleNew(long id, String imagePath, String title, String content) {
        this.id = id;
        this.imagePath = imagePath;
        this.title = title;
        this.content = content;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "SimpleNew [id=" + id + ", imagePath=" + imagePath + ", title=" + title + ", content=" + content + "]";
	}

        
}
