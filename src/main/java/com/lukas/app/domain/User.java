package com.lukas.app.domain;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private Integer id;
	
	@NotNull(message="ユーザーI名は必須です")
	@NotBlank(message="ユーザー名は空白にできません")
	@Size(min=3,max=20,message="ユーザー名は3から20文字を入力してください")
	@Pattern(regexp="^[a-zA-Z0-9_-]+$",message="ユーザー名は英数字、アンダースコア、ハイフンのみ利用できます")
	private String username;
	
	@NotNull(message="メールアドレスは必須です")
	@NotBlank(message="メールアドレスは空白にできません")
	@Email(message="有効なメールアドレスを入力してください")
	@Size(max=100,message="メールアドレスは100文字以下を入力してください")
	@Pattern(regexp="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message="メールアドレスの形式が無効です")
	private String email;
	
	@NotNull(message="パスワードは必須です")
	@NotBlank(message="パスワードは空白にできません")
	@Size(min=6,max=12,message="パスワードは6から12文字以下を入力してください")
	private String password;
	
	private Role role;
	private LocalDateTime created;
	private LocalDateTime lastLogin;

}
