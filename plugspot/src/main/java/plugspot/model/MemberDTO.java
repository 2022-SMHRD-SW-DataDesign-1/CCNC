package plugspot.model;

import java.io.File;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Getter
@AllArgsConstructor // 전체생성자
@NoArgsConstructor // 기본생성자
@RequiredArgsConstructor

public class MemberDTO {

@NonNull private String member_num;
@NonNull private String password;
private String member_type;
private String filename;
}

