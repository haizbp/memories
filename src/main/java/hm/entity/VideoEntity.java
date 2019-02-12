package hm.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import hm.model.VideoModel;

@Entity
@Table(name = "video")
public class VideoEntity {

	@Id
	private String id;
	private String title;
	private String description;
	private String url;
	private Integer view;
	private Integer rate;
	private Timestamp createTime = new Timestamp(new Date().getTime());

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getView() {
		return view;
	}

	public void setView(Integer view) {
		this.view = view;
	}

	public Integer getRate() {
		return rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public static VideoEntity toEntity(VideoModel model) {
		VideoEntity entity = new VideoEntity();

		entity.setId(model.getId());
		entity.setDescription(model.getDescription());
		entity.setTitle(model.getTitle());
		entity.setUrl(model.getUrl());
		entity.setView(model.getView());
		entity.setRate(model.getRate());

		return entity;
	}
}
