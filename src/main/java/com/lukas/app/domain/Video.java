package com.lukas.app.domain;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class Video {

	private Integer id;
	
	@NotBlank(message = "タイトルは必要")
	@Size(max = 50, message = "タイトル50文字以内")
	private String title;
	
	@Size(max = 255, message = "説明は、255文字以内")
	private String description;
	
	@Size(max = 30, message = "ジャンルは、30文字以内")
	private String genre;
	
	@Size(max = 50, message = "監督名は、50文字以内")
	private String director;
	
	@Size(max = 100, message = "出演者は、100文字以内")
	private String cast; 
	
	@Min(value = 1900, message = "公開年は、1900年以降")
	@Max(value = 2100, message = "公開年は、2100年以前")
	private Integer release;
	
	@NotNull(message = "上映時間は、必要")
	@Positive(message = "上映時間は、正の数")
	private Integer duration;
	
	@DecimalMin(value = "0.0", message = "評価は、0以上")
	@DecimalMax(value = "10.0", message = "評価は、10以下")
	private Float rating;
	
	@Size(max = 50, message = "Urlは、50文字以内")
	private String thumbnailUrl;
	
	@Size(max = 50, message = "Urlは、50文字以内")
	private String videoUrl;
}
